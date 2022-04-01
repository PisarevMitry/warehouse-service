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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Validated
@RestController
@RequestMapping("/shipped-product")
public class ShippedProductController {


    private final ShippedProductService shippedProductService;
    private final AccountingProductService accountingProductService;
    private final ProductService productService;
    private final AccountingProductController accountingProductController;

    public ShippedProductController(ShippedProductService shippedProductService, AccountingProductService accountingProductService, ProductService productService,
            AccountingProductController accountingProductController) {
        this.shippedProductService = shippedProductService;
        this.accountingProductService = accountingProductService;
        this.productService = productService;
        this.accountingProductController = accountingProductController;
    }

    @GetMapping("/get")
    List<ShippedProductDto> getAllShippedProductList() {
        return shippedProductService.findAll();
    }

    @GetMapping("/get/item")
    ShippedProductDto getShippedProductById(@RequestParam Long shippedProductId) {
        return shippedProductService.findById(shippedProductId);
    }

    @GetMapping("/get/list")
    List<ShippedProductDto> getShippedProductByListId(@RequestParam List<Long> shippedProductListId) {
        return shippedProductService.findByListId(shippedProductListId);
    }

    @PostMapping("/save/item")
    void saveShippedProduct(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        shippedProductService.insert(shippedProductDto);
    }

    @PostMapping("/save/list")
    void saveShippedProductList(@RequestBody @Valid List<ShippedProductDto> shippedProductDtoList) {
        shippedProductService.insertAll(shippedProductDtoList);
    }

    @PatchMapping("/update/item")
    void updateShippedProduct(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        shippedProductService.updateById(shippedProductDto);
    }

    @DeleteMapping("/delete/item")
    void deleteNewShippedProduct(@RequestParam Long shippedProductId) {
        shippedProductService.deleteById(shippedProductId);
    }

    /**
     * ToDo доработать логику для создания товара, которого нет в номенклатуре
     *
     * Метод для приема товара со склада
     * @param shippedProductDto информация о приеме
     */
    @PostMapping("/save/receiveGood/item")
    boolean receiveGood(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        if (Objects.equals(shippedProductDto.getReceiver(), "warehouse")) {
            AccountingProductDto accountingProductDto = accountingProductService.findByProductId(shippedProductDto.getProductId());
            ProductDto productDto = productService.findById(shippedProductDto.getProductId());
            if (productDto != null) {
                if (accountingProductDto != null) {
                    shippedProductService.insert(shippedProductDto);
                    accountingProductController.updateAmountAccountingProductByProductId(shippedProductDto.getProductId(), shippedProductDto.getAmountDifference());
                } else {
                    accountingProductService.insert(new AccountingProductDto(null, shippedProductDto.getProductId(), 0, 0));
                    shippedProductService.insert(shippedProductDto);
                    accountingProductController.updateAmountAccountingProductByProductId(shippedProductDto.getProductId(), shippedProductDto.getAmountDifference());
                }
                return true;
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
    @PostMapping("/save/shipGood/item")
    void shipGood(@RequestBody @Valid ShippedProductDto shippedProductDto) {
        if (!(Objects.equals(shippedProductDto.getReceiver(), "warehouse"))) {
            AccountingProductDto accountingProductDto = accountingProductService.findByProductId(shippedProductDto.getProductId());
            if (accountingProductDto != null) {
                if (accountingProductDto.getAmount() >= shippedProductDto.getAmountDifference()) {
                    shippedProductService.insert(shippedProductDto);
                    accountingProductController.updateAmountAccountingProductByProductId(shippedProductDto.getProductId(), -(shippedProductDto.getAmountDifference()));
                }
            }
        }
    }
}