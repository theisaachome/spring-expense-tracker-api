package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.TenantRequestDTO;
import com.expenses.tracker.expensetrackerapi.dto.response.TenantResponseDTO;
import com.expenses.tracker.expensetrackerapi.entity.Address;
import com.expenses.tracker.expensetrackerapi.entity.Tenant;
import com.expenses.tracker.expensetrackerapi.exception.ResourceNotFoundException;
import com.expenses.tracker.expensetrackerapi.mapper.TenantMapper;
import com.expenses.tracker.expensetrackerapi.repository.AddressRepository;
import com.expenses.tracker.expensetrackerapi.repository.BedRepository;
import com.expenses.tracker.expensetrackerapi.repository.TenantRepository;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TenantService extends BaseServiceImpl<Tenant,Long, TenantRequestDTO, TenantResponseDTO> {
    private final TenantRepository tenantRepository;
    private final BedRepository bedRepository;
    private final AddressRepository addressRepository;

    public TenantService(TenantRepository tenantRepository,TenantMapper tenantMapper,BedRepository bedRepository,
    AddressRepository addressRepository) {
        super(tenantRepository,tenantMapper);
        this.tenantRepository = tenantRepository;
        this.bedRepository = bedRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    protected void preSave(Tenant entity, TenantRequestDTO dto) {
        var address = new Address();
//        address.setTenant(entity);
        address.setAddress1(dto.address1());
        address.setAddress2(dto.address2());
        address.setCity(dto.city());
        address.setState(dto.state());
        addressRepository.save(address);
        entity.setAddress(address);

//        var bed = bedRepository.findById(dto.bedId().longValue())
//                .orElseThrow(()->new ResourceNotFoundException("Bed", "id", dto.bedId().longValue()));
//        entity.setBed(bed);

        super.save(dto);
    }

    @Override
    protected void updateEntity(Tenant existingEntity, TenantRequestDTO tenantRequestDTO) {

    }
}
