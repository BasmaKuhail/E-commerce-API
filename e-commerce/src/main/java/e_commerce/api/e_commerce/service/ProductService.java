package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.Brand;
import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.model.ProductFilter;
import e_commerce.api.e_commerce.repository.BrandRepository;
import e_commerce.api.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    // apply pagination to fetch a subset of products at a time
    public Page<Product> getAllProducts(Pageable pageable){
        return  productRepository.findAll(pageable);
    }

    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }

    public void removeProductById(Long id){
        productRepository.deleteById(id);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        System.out.println(product.getId());
        if(productRepository.existsById(product.getId()))
            return productRepository.save(product);
        return null;
    }

//    public List<Product> searchProducts(ProductFilter productFilter, Pageable pageable){
//        return productRepository.searchProducts(productFilter, pageable);
//    }

}
