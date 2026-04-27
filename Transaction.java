/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

import java.util.Date;

public class Transaction {

    private static int nextId = 1;
    private int transactionId;
    private Account account;
    private double amount;
    private Date date;
    private String type;

    public Transaction(Account account, double amount, String type) {
        this.transactionId = nextId++;
        this.account = account;
        this.amount = amount;
        this.date = new Date();
        this.type = type;
        execute();
    }

    public Transaction(Account acc1, Account acc2, double amount, String type) {
        this.transactionId = nextId++;
        this.amount = amount;
        this.date = new Date();
        this.account = acc1;
        if (acc1.balance >= amount) {
            acc1.balance -= amount;
            acc2.balance += amount;
        }else{
            System.out.println("Transfer Failed.");
        }
        this.type = type;
    }

    private void execute() {
        if (type.equals("Deposit")) {
            account.deposit(amount);
        } else if (type.equals("Withdraw")) {
            account.withdraw(amount);
        } else {
            System.out.println("Transaction invalid");
        }
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction: "+ "transactionId=" + transactionId+ ", accountNumber=" + account.getAccNum()+ ", amount=" + amount+ ", date=" + date+ ", type='" + type;
    }
}
