package com.expenses.tracker.expensetrackerapi.service.impl;
import com.expenses.tracker.expensetrackerapi.exception.ResourceNotFoundException;
import com.expenses.tracker.expensetrackerapi.mapper.EntityMapper;
import com.expenses.tracker.expensetrackerapi.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl<T,ID,RequestDto,ResponseDto> implements BaseService<T,ID,RequestDto,ResponseDto> {

    protected final JpaRepository<T,ID> repository;
    protected final EntityMapper<T,RequestDto,ResponseDto> entityMapper;

    public BaseServiceImpl(JpaRepository<T, ID> repository,  EntityMapper<T, RequestDto, ResponseDto> entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public ResponseDto findById(ID id) {
        return entityMapper.toResponseDto(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), "ID", (Long) id)));
    }

    @Override
    public List<ResponseDto> findAll() {
        return repository.findAll().stream().map(entityMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDto save(RequestDto dto) {
        T entity = entityMapper.toEntity(dto);
        preSave(entity,dto);
        return entityMapper.toResponseDto(repository.save(entity));
    }
    protected void preSave(T entity, RequestDto dto) {
        // Default implementation does nothing; can be overridden in subclasses
    }

    @Override
    public ResponseDto update(ID id, RequestDto dto) {
        T existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), "ID", (Long) id));
        updateEntity(existingEntity, dto);
        return entityMapper.toResponseDto(repository.save(existingEntity));
    }

    @Override
    public void delete(ID id) {
            if(!repository.existsById(id)) throw new RuntimeException("Record not found");
            repository.deleteById(id);
    }
    protected abstract void updateEntity(T existingEntity, RequestDto requestDto);
    // Utility method to get entity name dynamically
    private String getEntityName() {
        return repository.getClass().getSimpleName();
    }
}
