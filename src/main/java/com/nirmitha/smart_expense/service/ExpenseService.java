package com.nirmitha.smart_expense.service;
import org.springframework.stereotype.Service;
import com.nirmitha.smart_expense.model.Expense;
import java.util.List;
import java.util.ArrayList;

@Service
public class ExpenseService{
    public ExpenseService(){
        this.addExpense("Salary", 80000.00, "Income");
        this.addExpense("Shopping", 7990, "Expense");
    }

    private final List<Expense> expenses = new ArrayList<>();

    public List<Expense> getAllExpenses(){
        return expenses;
    }

    public Expense getExpenseById(Long id){
        for(int i = 0; i < expenses.size(); i++){
            if(expenses.get(i).getId().equals(id)){
               return expenses.get(i);
            }
        }
        return null;
    }

    public void addExpense(String title, double amount, String category){
        long id = expenses.size() + 1;
        Expense expense = new Expense(id, title, amount, category);
        expenses.add(expense);

    }

    public boolean deleteExpense(Long id){
        return expenses.removeIf(expense -> expense.getId().equals(id));
    }

    public boolean updateExpense(Long id, String title, double amount, String category){
        for(int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId().equals(id)) {
                Expense newExpense = new Expense(id, title, amount, category);
                expenses.set(i, newExpense);
                return true;
            }
        }
        return false;
    }
}