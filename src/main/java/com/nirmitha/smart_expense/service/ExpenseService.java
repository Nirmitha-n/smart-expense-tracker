package com.nirmitha.smart_expense.service;
import com.nirmitha.smart_expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import com.nirmitha.smart_expense.model.Expense;
import java.util.List;

@Service
public class ExpenseService{
    private final ExpenseRepository expenseRepo;
    public ExpenseService(ExpenseRepository expenseRepo){
        this.expenseRepo = expenseRepo;
    }

    public List<Expense> getAllExpenses(){
        return expenseRepo.findAll();
    }

    public Expense getExpenseById(Long id){
        return expenseRepo.findById(id).orElse(null);
    }

    public void addExpense(String title, double amount, String category){
        Expense expense = new Expense(title, amount, category);
        expenseRepo.save(expense);

    }

    public boolean deleteExpense(Long id){
         if(expenseRepo.existsById(id)){
             expenseRepo.deleteById(id);
             return true;
         }
         return false;
    }

    public boolean updateExpense(Long id, String title, double amount, String category){
        Expense newExpense = new Expense(id, title, amount, category);
        if(expenseRepo.existsById(id)) {
            expenseRepo.save(newExpense);
            return true;
        }
        return false;
    }
}