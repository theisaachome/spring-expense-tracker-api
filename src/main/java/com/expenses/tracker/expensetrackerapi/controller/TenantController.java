package com.expenses.tracker.expensetrackerapi.controller;
import com.expenses.tracker.expensetrackerapi.dto.request.TenantRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.response.TenantResponseDTO;
import com.expenses.tracker.expensetrackerapi.entity.Tenant;
import com.expenses.tracker.expensetrackerapi.service.TenantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tenants")
public class TenantController extends  AbstractController <Tenant,Long,TenantRequestDTO,TenantResponseDTO>{
    public TenantController(TenantService tenantService) {
        super(tenantService);
    }
}
