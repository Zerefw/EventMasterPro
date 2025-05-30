
package com.mycompany.eventemasterpromedellin;


public class FinancialRecord {
    private int eventId;
    private double budget;
    private double expenses;
    private double income;
    
    public FinancialRecord(int eventId, double budget){
        this.eventId = eventId;
        this.budget = budget;
        this.expenses = 0.0;
        this.income = 0.0;
    }
    
    public int getEventId(){return eventId;}
    public void setEventId(int eventId){this.eventId = eventId;}
    
    public double getBudget(){return budget;}
    public void setBudget(double budget){this.budget = budget;}
    
    public double getExpenses(){return expenses;}
    public void setExpenses(double expenses){this.expenses = expenses;}
    
    public double getIncome(){return income;}
    public void setIncome(double income){this.income = income;}
    
    public void addExpense(double amount){
        expenses += amount;
        System.out.println("Expense added: " + amount);
    }
    
    public void addIncome(double amount){
        income += amount;
        System.out.println("Income added: " + amount);        
    }
    
    public double calculateBalance(){
        return income - expenses;
    }
    
    @Override
    public String toString(){
        return "Event ID: " + eventId + ", Budget: " + budget + ", Expenses: " + expenses + ", Income: " + income + ", Balance: " + calculateBalance();
    }
    
}
