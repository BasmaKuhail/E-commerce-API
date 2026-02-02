package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.*;
import e_commerce.api.e_commerce.repository.BrandRepository;
import e_commerce.api.e_commerce.repository.ProductRepository;
import e_commerce.api.e_commerce.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private TagRepository tagRepository;

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

    private List<Review> findReviewsForProduct(List<Review> reviews, Long pId){
        List<Review> filteredReviews = new ArrayList<>();

        for(Review r: reviews){
            if(r.getProduct().getId() == pId){
                filteredReviews.add(r);
            }
        }
        return filteredReviews;
    }

    public List<Review> findReviewsForProduct (Long productId){
        Optional<Product> p = productRepository.findById(productId);
        return findReviewsForProduct(p.get().getReviews(), productId);
    }

    public Product assignTagsToProduct(Long pId, List<Long> tIds){
        Product p = productRepository.findProductById(pId);

        Set<Tag> tags = new HashSet<>(tagRepository.findAllById(tIds));

        p.setTags(tags);
        return p;
    }
//    public List<Product> searchProducts(ProductFilter productFilter, Pageable pageable){
//        return productRepository.searchProducts(productFilter, pageable);
//    }

}
