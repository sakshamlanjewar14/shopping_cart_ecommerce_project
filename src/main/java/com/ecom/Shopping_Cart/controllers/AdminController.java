package com.ecom.Shopping_Cart.controllers;

import com.ecom.Shopping_Cart.model.Category;
import com.ecom.Shopping_Cart.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import static org.thymeleaf.util.ObjectUtils.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/loadAddProduct")
    public String loadAddProduct(){
        return "admin/add_product";
    }

    @GetMapping("/category")
    public String category(){
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file, HttpSession session){
        //Multipart is the datatype of file
        String imageName = file !=null ? file.getOriginalFilename(): "default.jpg";
        //Setting the image
        category.setImageName(imageName);
        //For get the category
        Boolean existCategory = categoryService.existCategory(category.getName());
        //Checking category is exist or not
        if(existCategory){
            session.setAttribute("errorMsg","Category Name Already Exists");
        }
        else {
            Category saveCategory = categoryService.saveCategory(category);
            // Checking null values
            if(ObjectUtils.isEmpty(saveCategory)){
                session.setAttribute("errorMsg","Not Saved  ! Internal Server Error");
            }else {
                session.setAttribute("successMsg", "Saved Successfully");
            }
        }
        return "redirect:/admin/category";
    }
}
