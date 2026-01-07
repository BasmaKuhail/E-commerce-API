package e_commerce.api.e_commerce.controller;

import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    public record ProductDto(
            Long id,
            String productName,
            double basePrice,
            boolean isAvailable,
            String slug
    ) {}

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Page<ProductDto> getProducts(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return productService.getAllProducts(pageable)
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getProductName(),
                        p.getBasePrice(),
                        p.isAvailable(),
                        p.getSlug()
                ));
    }

    @GetMapping( "/product/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
        System.out.println(productId);
        return productService.findProductById(productId)
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getProductName(),
                        p.getBasePrice(),
                        p.isAvailable(),
                        p.getSlug()
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteProductById(@PathVariable Long productId){
        productService.removeProductById(productId);
        return ResponseEntity.accepted().build();
    }

//    @PostMapping("/addProduct")
//    public ResponseEntity<Product> addProduct(@RequestBody Product product){
//        return new ResponseEntity<>(productService.createProduct(product).);
//    }
}
