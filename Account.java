package proje2;

import java.util.ArrayList;

public abstract class Account {

    private Customer owner;
    private int accNum = 1000;
    protected double balance;
    private static int counter;

    public Account(Customer owner, double balance) {
        this.owner = owner;
        this.accNum += counter;
        counter++;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited: " + amount + "| New Balance: " + this.balance);
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount + "| Remaining Balance: " + this.balance);
        } else {
            System.out.println("Insufficient funds for withdraw.");
        }
    }

    public Customer getOwner() {
        return owner;
    }

    public int getAccNum() {
        return accNum;
    }

    public double getBalance() {
        return balance;
    }

    public boolean compareAcc(Account s) {
        if (this.getBalance() == s.getBalance()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "accountNumber=" + accNum + ", balance=" + balance + ", ownerName=" + owner ;
    }

}
