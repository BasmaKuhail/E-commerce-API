package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.Category;
import e_commerce.api.e_commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }
    public Optional<Category> getCategory(Long id){
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public void removeCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public Category updateCategory(Category category){
        if(categoryRepository.existsById(category.getId()))
            return categoryRepository.save(category);
        return null;
    }
}
