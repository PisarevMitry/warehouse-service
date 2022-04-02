package liga.store.warehouseservice.core.controller;

import liga.store.warehouseservice.core.service.AccountingProductService;
import liga.store.warehouseservice.core.service.ProductService;
import liga.store.warehouseservice.core.service.ShippedProductService;
import liga.store.warehouseservice.dto.AccountingProductDto;
import liga.store.warehouseservice.dto.ProductDto;
import liga.store.warehouseservice.dto.ShippedProductDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * Контроллер для управления данными об изменении баланса товаров на складе (данные связаны с товарными накладными)
 */
@Validated
@RestController
public class ShippedProductController {

    private final ShippedProductService shippedProductService;
    private final AccountingProductService accountingProductService;
    private final ProductService productService;

    public ShippedProductController(ShippedProductService shippedProductService, AccountingProductService accountingProductService, ProductService productService) {
        this.shippedProductService = shippedProductService;
        this.accountingProductService = accountingProductService;
        this.productService = productService;
    }

    @GetMapping("/shipped-product/get")
    List<ShippedProductDto> getAllShippedProductList() {
        return shippedProductService.findAll();
    }

    @GetMapping("/shipped-product/get/item")
    ShippedProductDto getShippedProductById(@RequestParam Long shippedProductId) {
        return shippedProductService.findById(shippedProductId);
    }

    @GetMapping("/shipped-product/get/list")
    List<ShippedProductDto> getShippedProductByListId(@RequestParam List<Long> shippedProductListId) {
        return shippedProductService.findByListId(shippedProductListId);
    }

    @PostMapping("/admin/shipped-product/save/item")
    void saveShippedProduct(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        shippedProductService.insert(shippedProductDto);
    }

    @PostMapping("/admin/shipped-product/save/list")
    void saveShippedProductList(@RequestBody @Valid List<ShippedProductDto> shippedProductDtoList) {
        shippedProductService.insertAll(shippedProductDtoList);
    }

    @PatchMapping("/admin/shipped-product/update/item")
    void updateShippedProduct(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        shippedProductService.updateById(shippedProductDto);
    }

    @DeleteMapping("/owner/shipped-product/delete/item")
    void deleteShippedProduct(@RequestParam Long shippedProductId) {
        shippedProductService.deleteById(shippedProductId);
    }

    /**
     * ToDo доработать логику для создания товара, которого нет в номенклатуре
     *
     * Метод для приема товара со склада
     * @param shippedProductDto информация о приеме
     */
    @PostMapping("/admin/shipped-product/save/receiveGood/item")
    Boolean receiveGood(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        if (Objects.equals(shippedProductDto.getReceiver(), "warehouse")) {
            AccountingProductDto accountingProductDto = accountingProductService.findByProductId(shippedProductDto.getProductId());
            ProductDto productDto = productService.findById(shippedProductDto.getProductId());
            if (productDto != null) {
                if (accountingProductDto != null) {
                    if (shippedProductService.insert(shippedProductDto)) {
                        accountingProductDto.setAmount(accountingProductDto.getAmount() + shippedProductDto.getAmountDifference());
                        return accountingProductService.updateById(accountingProductDto);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Метод для отгрузки товара со склада
     * @param shippedProductDto информация о отгрузке
     */
    @PostMapping("/user/shipped-product/save/shipGood/item")
    Boolean shipGood(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        if (!(Objects.equals(shippedProductDto.getReceiver(), "warehouse"))) {
            AccountingProductDto accountingProductDto = accountingProductService.findByProductId(shippedProductDto.getProductId());
            if (accountingProductDto != null) {
                if (shippedProductService.insert(shippedProductDto)) {
                    accountingProductDto.setAmount(accountingProductDto.getAmount() - shippedProductDto.getAmountDifference());
                    return accountingProductService.updateById(accountingProductDto);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}