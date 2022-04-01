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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для управления данными в таблице "Остаток товаров на складе"
 */
@Validated
@RestController
@RequestMapping("/accounting-product")
public class AccountingProductController {

    private final AccountingProductService accountingProductService;

    private final ProductService productService;

    public AccountingProductController(AccountingProductService accountingProductService, ProductService productService) {
        this.accountingProductService = accountingProductService;
        this.productService = productService;
    }

    @GetMapping("/get")
    List<AccountingProductDto> getAllAccountingProductList() {
        return accountingProductService.findAll();
    }

    @GetMapping("/get/item")
    AccountingProductDto getAccountingProductById(@RequestParam Long accountingProductId) {
        return accountingProductService.findById(accountingProductId);
    }

    @GetMapping("/get/list")
    List<AccountingProductDto> getAccountingProductByListId(@RequestParam List<Long> accountingProductListId) {
        return accountingProductService.findByListId(accountingProductListId);
    }

    @PostMapping("/save/item")
    void saveAccountingProduct(@RequestBody @Valid AccountingProductDto accountingProductDto) {

        ProductDto productDto = productService.findById(accountingProductDto.getProductId());
        if (productDto != null) {
            accountingProductService.insert(accountingProductDto);
        }
    }

    @PostMapping("/save/list")
    void saveAccountingProductList(@RequestBody @Valid List<AccountingProductDto> accountingProductDtoList) {

        accountingProductService.insertAll(accountingProductDtoList);
    }

    @PatchMapping("/update/item")
    void updateAccountingProduct(@RequestBody @Valid AccountingProductDto accountingProductDto) {
        ProductDto productDto = productService.findById(accountingProductDto.getProductId());
        if (productDto != null) {
            accountingProductService.updateById(accountingProductDto);
        }
    }

    @DeleteMapping("/delete/item/type=byid")
    void deleteAccountingProduct(@RequestParam Long accountingProductId) {
        accountingProductService.deleteById(accountingProductId);
    }


    /**
     * Метод для поиска товара по номенклатуре
     * @param productId номенклатура товара
     * @return Данные о цене и количестве товара
     */
    @GetMapping("/get/item/type=byproduct/{productId}")
    AccountingProductDto getAccountingProductByProductId(@PathVariable Long productId) {
        return accountingProductService.findByProductId(productId);
    }

    /**
     * Метод для изменения количества товаров
     * @param productId номенклатура товара
     * @param amountDifference изменение количества товара
     */
    @PatchMapping("/update/amount/item")
    void updateAmountAccountingProductByProductId(@RequestBody Long productId, @RequestParam Integer amountDifference) {
        AccountingProductDto accountingProductDto = getAccountingProductByProductId(productId);
        if (accountingProductDto != null) {
            accountingProductDto.setAmount(accountingProductDto.getAmount() + amountDifference);
            accountingProductService.updateById(accountingProductDto);
        }
    }

    /**
     * Метод для изменения цены товара
     * @param productId номенклатура товара
     * @param newPrice новая цена на товар
     */
    @PatchMapping("/update/price/item")
    void updatePriceAccountingProductByProductId(@RequestBody Long productId, @RequestParam Integer newPrice) {
        AccountingProductDto accountingProductDto = getAccountingProductByProductId(productId);
        if (accountingProductDto != null) {
            accountingProductDto.setPrice(newPrice);
            accountingProductService.updateById(accountingProductDto);
        }
    }

    /**
     * Метод для удаления товара
     * @param productId номенклатура товара
     */
    @DeleteMapping("/delete/item/type=byproduct")
    void deleteAccountingProductByProductId(@RequestBody Long productId) {
        AccountingProductDto accountingProductDto = getAccountingProductByProductId(productId);
        if (accountingProductDto != null) {
            deleteAccountingProduct(accountingProductDto.getId());
        }
    }
}

