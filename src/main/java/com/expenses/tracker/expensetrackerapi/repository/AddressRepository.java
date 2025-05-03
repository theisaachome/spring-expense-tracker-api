package com.expenses.tracker.expensetrackerapi.repository;
import com.expenses.tracker.expensetrackerapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
