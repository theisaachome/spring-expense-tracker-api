package com.expenses.tracker.expensetrackerapi.service;
import com.expenses.tracker.expensetrackerapi.dto.request.CategoryRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.CategoryResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Category;
import com.expenses.tracker.expensetrackerapi.exception.ResourceNotFoundException;
import com.expenses.tracker.expensetrackerapi.mapper.CategoryMapper;
import com.expenses.tracker.expensetrackerapi.repository.CategoryRepository;
import com.expenses.tracker.expensetrackerapi.repository.UserRepo;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseServiceImpl<Category, Long, CategoryRequestDto,CategoryResponseDto> {

    private final UserRepo userRepo;
    public CategoryService(CategoryRepository repository, CategoryMapper categoryMapper, UserRepo userRepo) {
        super(repository,categoryMapper);
        this.userRepo=userRepo;
    }

    @Override
    protected void preSave(Category entity, CategoryRequestDto dto) {
        var user =userRepo.findById(dto.userId())
                .orElseThrow(()->new ResourceNotFoundException("User","ID",dto.userId()));
        entity.setUser(user);
    }

    @Override
    protected void updateEntity(Category existingEntity, CategoryRequestDto dto) {
        existingEntity.setName(dto.name());
        existingEntity.setDescription(dto.description());
    }
}
