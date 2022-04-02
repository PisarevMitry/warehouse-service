package liga.store.warehouseservice.core.controller;

import liga.store.warehouseservice.core.service.ProductService;
import liga.store.warehouseservice.dto.ProductDto;
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

/**
 * Контроллер для управления данными о товарах
 */
@Validated
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/get")
    List<ProductDto> getAllProductList() {
        return productService.findAll();
    }

    @GetMapping("/product/get/item")
    ProductDto getProductById(@RequestParam Long productId) {
        return productService.findById(productId);
    }

    @GetMapping("/product/get/list")
    List<ProductDto> getProductByListId(@RequestParam List<Long> productListId) {
        return productService.findByListId(productListId);
    }

    @PostMapping("/owner/product/save/item")
    Boolean saveProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.insert(productDto);
    }

    @PostMapping("/owner/product/save/list")
    Boolean saveProductList(@RequestBody @Valid List<ProductDto> productDtoList) {
        return productService.insertAll(productDtoList);
    }

    @PatchMapping("/admin/product/update/item")
    Boolean updateProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.updateById(productDto);
    }

    @DeleteMapping("/owner/product/delete/item")
    Boolean deleteProduct(@RequestParam Long productId) {
        return productService.deleteById(productId);
    }


    /*@GetMapping("/get/{option}")
    List<ProductDto> getProductByOption(@PathVariable JSONObject option) {
        return productService.findByListOption(option);
    }*/


}
