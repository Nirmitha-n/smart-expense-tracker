package com.nirmitha.smart_expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nirmitha.smart_expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
