package com.expenses.tracker.expensetrackerapi.repository;
import com.expenses.tracker.expensetrackerapi.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
