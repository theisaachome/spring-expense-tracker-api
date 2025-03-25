package com.expenses.tracker.expensetrackerapi.mapper;

import com.expenses.tracker.expensetrackerapi.dto.request.TenantRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.response.TenantResponseDTO;
import com.expenses.tracker.expensetrackerapi.entity.Tenant;
import org.springframework.stereotype.Component;

@Component
public class TenantMapper implements EntityMapper<Tenant, TenantRequestDTO, TenantResponseDTO>{

    @Override
    public Tenant toEntity(TenantRequestDTO dto) {
        Tenant tenant = new Tenant();
        tenant.setFullname(dto.fullname());
        tenant.setEmail(dto.email());
        tenant.setPhone(dto.phone());
        tenant.setEmergencyContactPhone(dto.emergencyContactPhone());
        return tenant;
    }

    @Override
    public TenantResponseDTO toResponseDto(Tenant entity) {
        return new TenantResponseDTO(entity.getId(),
                entity.getFullname(),
                "Created new Tenant successfully",
                200);
    }
}
