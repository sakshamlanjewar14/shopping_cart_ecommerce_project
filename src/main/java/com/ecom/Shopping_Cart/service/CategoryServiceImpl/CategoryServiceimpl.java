package com.ecom.Shopping_Cart.service.CategoryServiceImpl;

import com.ecom.Shopping_Cart.model.Category;
import com.ecom.Shopping_Cart.repository.CategoryRepository;
import com.ecom.Shopping_Cart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceimpl implements CategoryService {

@Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean existCategory(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public List<Category> getAllCategory() {
            return categoryRepository.findAll();
    }
}
