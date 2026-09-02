package com.nirmitha.smart_expense.model;
public class Expense{
    private final Long id;
    private final String title;
    private final double amount;
    private final String category;

    public Expense(Long id, String title, double amount, String category){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public Long getId(){
        return this.id;
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