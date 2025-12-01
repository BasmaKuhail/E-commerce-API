package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return  productRepository.findAll();
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

    public void updateProduct(Product product){
        if(productRepository.existsById(product.getId()))
            productRepository.save(product);
    }

    public List<Product> findProductByCategoryAndBrandAndTag(String categoryName, String brandName, String tagName){
        return productRepository.findByCategoryNameAndBrandNameAndTagsName(categoryName, brandName, tagName);
    }

}
