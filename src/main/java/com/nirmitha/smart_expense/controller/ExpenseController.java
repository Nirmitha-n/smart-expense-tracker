package com.nirmitha.smart_expense.controller;

import com.nirmitha.smart_expense.dto.ExpenseRequest;
import com.nirmitha.smart_expense.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nirmitha.smart_expense.model.Expense;


import java.util.List;

@RestController
public class ExpenseController{
     private final ExpenseService expenseService;

     public ExpenseController(ExpenseService expenseService){
         this.expenseService = expenseService;
     }

     @GetMapping("/expenses")
    public List<Expense> getExpenses(){
         return expenseService.getAllExpenses();
     }

     @GetMapping("/expenses/{id}")
     public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
         Expense result = expenseService.getExpenseById(id);
         if(result == null){
             return ResponseEntity.notFound().build();
         }
         else{
             return ResponseEntity.ok(result);
         }
     }

     @PostMapping("/expenses")
     public void addExpense(@RequestBody ExpenseRequest request){
         String title = request.getTitle();
         double amount = request.getAmount();
         String category = request.getCategory();
         expenseService.addExpense(title, amount, category);
     }
     @DeleteMapping("/expenses/{id}")
     public ResponseEntity<Void> deleteExpense(@PathVariable Long id){
         boolean res = expenseService.deleteExpense(id);
         if(res){
             return ResponseEntity.ok().build();
         }
         else{
             return ResponseEntity.notFound().build();
         }
     }

     @PutMapping("/expenses/{id}")
    public ResponseEntity<Void> updateExpense(@PathVariable Long id, @RequestBody ExpenseRequest request){
         String title = request.getTitle();
         double amount = request.getAmount();
         String category = request.getCategory();
         boolean res = expenseService.updateExpense(id, title, amount, category);
         if(res){
             return ResponseEntity.ok().build();
         }
         else{
             return ResponseEntity.notFound().build();
         }
     }
}