package com.expenses.tracker.expensetrackerapi.repository;

import com.expenses.tracker.expensetrackerapi.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(String name);
}
