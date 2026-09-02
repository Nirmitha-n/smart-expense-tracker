package com.nirmitha.smart_expense.dto;
public class ExpenseRequest{
    private final String title;
    private final double amount;
    private final String category;

    public ExpenseRequest(String title, double amount, String category){
        this.title = title;
        this.amount = amount;
        this.category = category;
    }


    public String getTitle(){
        return this.title;
    }
    public double getAmount(){
        return this.amount;
    }
    public String getCategory(){
        return this.category;
    }
}