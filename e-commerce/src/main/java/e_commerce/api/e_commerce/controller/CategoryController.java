package e_commerce.api.e_commerce.controller;

import e_commerce.api.e_commerce.model.Category;
import e_commerce.api.e_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping("/categories")
    public Page<Category> getCategories(@PageableDefault(page = 0, size = 10)  Pageable pageable){
        return categoryService.getAllCategories(pageable);
    }

    @PostMapping("/addCategory")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity removeCategory(@PathVariable Long categoryId){
        categoryService.removeCategory(categoryId);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }
}
