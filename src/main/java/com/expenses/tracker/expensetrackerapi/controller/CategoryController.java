package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.dto.request.CategoryRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.CategoryResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Category;
import com.expenses.tracker.expensetrackerapi.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController extends AbstractController <Category,Long, CategoryRequestDto, CategoryResponseDto>{
    public CategoryController(CategoryService service) {
        super(service);
    }
}
