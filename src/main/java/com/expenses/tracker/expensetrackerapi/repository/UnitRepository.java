package com.expenses.tracker.expensetrackerapi.repository;

import com.expenses.tracker.expensetrackerapi.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit,Long> {
}
