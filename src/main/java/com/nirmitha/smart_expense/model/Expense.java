package com.nirmitha.smart_expense.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
public class Expense{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double amount;
    private String category;

    protected Expense(){}

    public Expense(Long id, String title, double amount, String category){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }
    public Expense( String title, double amount, String category){
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