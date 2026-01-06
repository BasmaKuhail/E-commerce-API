package e_commerce.api.e_commerce.controller;

import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;

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
}
