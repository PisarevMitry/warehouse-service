package liga.store.warehouseservice.core.controller;

import liga.store.warehouseservice.core.service.ProductService;
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

@Validated
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get")
    List<ProductDto> getAllProductList() {
        return productService.findAll();
    }

    @GetMapping("/get/id={productId}")
    ProductDto getProductById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @GetMapping("/get/list")
    List<ProductDto> getProductByListId(@RequestParam List<Long> productListId) {
        return productService.findByListId(productListId);
    }

    @PostMapping("/save")
    void saveProduct(@RequestBody @Valid ProductDto productDto) {
        productService.insert(productDto);
    }

    @PostMapping("/save/list")
    void saveProductList(@RequestBody @Valid List<ProductDto> productDtoList) {
        productService.insertAll(productDtoList);
    }

    @PatchMapping("/update")
    void updateProduct(@RequestBody @Valid ProductDto productDto) {
        productService.updateById(productDto);
    }

    @DeleteMapping("/delete/id={productId}")
    void deleteProduct(@PathVariable Long productId) {
        productService.deleteById(productId);
    }


    /*@GetMapping("/get/{option}")
    List<ProductDto> getProductByOption(@PathVariable JSONObject option) {
        return productService.findByListOption(option);
    }*/
}
