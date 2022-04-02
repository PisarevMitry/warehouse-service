package liga.store.warehouseservice.core.controller;

import liga.store.warehouseservice.core.service.AccountingProductService;
import liga.store.warehouseservice.core.service.ProductService;
import liga.store.warehouseservice.dto.AccountingProductDto;
import liga.store.warehouseservice.dto.ProductDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для управления данными о товарах на складе
 */
@Validated
@RestController
public class AccountingProductController {

    private final AccountingProductService accountingProductService;

    private final ProductService productService;

    public AccountingProductController(AccountingProductService accountingProductService, ProductService productService) {
        this.accountingProductService = accountingProductService;
        this.productService = productService;
    }

    @GetMapping("/accounting-product/get")
    List<AccountingProductDto> getAllAccountingProductList() {
        return accountingProductService.findAll();
    }

    @GetMapping("/accounting-product/get/item")
    AccountingProductDto getAccountingProductById(@RequestParam Long AccountingProductId) {
        return accountingProductService.findById(AccountingProductId);
    }

    @GetMapping("/accounting-product/get/list")
    List<AccountingProductDto> getAccountingProductByListId(@RequestParam List<Long> accountingProductListId) {
        return accountingProductService.findByListId(accountingProductListId);
    }

    @PostMapping("/admin/accounting-product/save/item")
    Boolean saveAccountingProduct(@RequestBody @Valid AccountingProductDto accountingProductDto) {

        ProductDto productDto = productService.findById(accountingProductDto.getProductId());
        if (productDto != null) {
            return accountingProductService.insert(accountingProductDto);
        } else {
            return false;
        }
    }

    @PostMapping("/admin/accounting-product/save/list")
    Boolean saveAccountingProductList(@RequestBody @Valid List<AccountingProductDto> accountingProductDtoList) {
        return accountingProductService.insertAll(accountingProductDtoList);
    }

    @PatchMapping("/admin/accounting-product/update/item")
    Boolean updateAccountingProduct(@RequestBody @Valid AccountingProductDto accountingProductDto) {
        ProductDto productDto = productService.findById(accountingProductDto.getProductId());
        if (productDto != null) {
            return accountingProductService.updateById(accountingProductDto);
        } else {
            return false;
        }
    }

    @DeleteMapping("/admin/accounting-product/delete/item/type=byid")
    Boolean deleteAccountingProduct(@RequestParam Long accountingProductId) {
        return accountingProductService.deleteById(accountingProductId);
    }

    /**
     * Метод для поиска товара по номенклатуре
     * @param productId номенклатура товара
     * @return Данные о цене и количестве товара
     */
    @GetMapping("/accounting-product/get/item/type=byproduct/{productId}")
    AccountingProductDto getAccountingProductByProductId(@PathVariable Long productId) {
        return accountingProductService.findByProductId(productId);
    }

    /**
     * Метод для изменения количества товаров
     * @param productId номенклатура товара
     * @param amountDifference изменение количества товара
     */
    @PatchMapping("/admin/accounting-product/update/amount/item")
    Boolean updateAmountAccountingProductByProductId(@RequestBody Long productId, @RequestParam Integer amountDifference) {
        AccountingProductDto accountingProductDto = getAccountingProductByProductId(productId);
        if (accountingProductDto != null) {
            accountingProductDto.setAmount(accountingProductDto.getAmount() + amountDifference);
            return accountingProductService.updateById(accountingProductDto);
        } else {
            return false;
        }
    }

    /**
     * Метод для изменения цены товара
     * @param productId номенклатура товара
     * @param newPrice новая цена на товар
     */
    @PatchMapping("/admin/accounting-product/update/price/item")
    Boolean updatePriceAccountingProductByProductId(@RequestBody Long productId, @RequestParam Integer newPrice) {
        AccountingProductDto accountingProductDto = getAccountingProductByProductId(productId);
        if (accountingProductDto != null) {
            accountingProductDto.setPrice(newPrice);
            return accountingProductService.updateById(accountingProductDto);
        } else {
            return false;
        }
    }

    /**
     * Метод для удаления товара
     * @param productId номенклатура товара
     */
    @DeleteMapping("/admin/accounting-product/delete/item/type=byproduct")
    Boolean deleteAccountingProductByProductId(@RequestBody Long productId) {
        AccountingProductDto accountingProductDto = getAccountingProductByProductId(productId);
        if (accountingProductDto != null) {
            return deleteAccountingProduct(accountingProductDto.getId());
        } else {
            return false;
        }
    }
}

