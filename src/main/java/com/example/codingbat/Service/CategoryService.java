package com.example.codingbat.Service;

import com.example.codingbat.Controller.Result;
import com.example.codingbat.Dto.CategoryDto;
import com.example.codingbat.Entity.Category;
import com.example.codingbat.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public Result postCategory(CategoryDto categoryDto) {
        if (!categoryRepository.existsByName(categoryDto.getName())) {
            Category category = new Category();
            category.setName(categoryDto.getName());
            categoryRepository.save(category);
            return new Result("Category saqlandi",true);
        }
        return new Result("Bunday category mavjud",false);
    }

    public Result putCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(categoryDto.getName());
            categoryRepository.save(category);
            return new Result("Ozgardi",true);
        }
        return new Result("Bunday category topilmadi",false);
    }

    public Result deleteCategory(Integer id) {
        try {
            if (categoryRepository.existsById(id)) {
                categoryRepository.deleteById(id);
                return new Result("delete category",true);
            }
        } catch (Exception e) {
            return new Result("Error",false);
        }
        return new Result("Category topilmadi",false);
    }
}
