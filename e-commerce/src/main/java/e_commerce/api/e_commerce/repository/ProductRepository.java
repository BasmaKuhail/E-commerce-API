package e_commerce.api.e_commerce.repository;

import e_commerce.api.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategoryNameAndBrandNameAndTagsName(String category, String brand, String tag);
}
