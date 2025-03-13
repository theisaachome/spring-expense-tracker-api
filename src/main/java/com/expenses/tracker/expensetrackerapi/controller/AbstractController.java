package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T,ID,RequestDto,ResponseDto> {
    protected final BaseService<T,ID,RequestDto,ResponseDto> baseService;

    public AbstractController(BaseService<T, ID, RequestDto, ResponseDto> baseService) {
        this.baseService = baseService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody RequestDto requestDto) {
        return  ResponseEntity.ok(baseService.save(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable("id" )ID id, @RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(baseService.update(id,requestDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable ID id) {
        return ResponseEntity.ok(baseService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAll() {
        return ResponseEntity.ok(baseService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        baseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
