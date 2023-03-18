package com.example.codingbat.Controller;

import com.example.codingbat.Dto.CategoryDto;
import com.example.codingbat.Entity.Category;
import com.example.codingbat.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }
    @PostMapping
    public ResponseEntity<Result> postCategory(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.postCategory(categoryDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putCategory(@PathVariable Integer id,@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.putCategory(id,categoryDto);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id)  {
        Result result = categoryService.deleteCategory(id);
        if (result.getActive()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(204).body(result);
    }

}
