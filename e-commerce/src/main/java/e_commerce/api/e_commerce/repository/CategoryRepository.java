package e_commerce.api.e_commerce.repository;

import e_commerce.api.e_commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{
    public Category findCategoryById(Long categoryId);
}
