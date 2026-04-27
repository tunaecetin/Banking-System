/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

import java.util.Date;

public class SavingsAccount extends Account {

    private final double interestRate = 5;
    private String accountStatus;

    public SavingsAccount(double balance, Customer owner, String accountStatus) {
        super(owner, balance);
        this.accountStatus = accountStatus;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void InterestSave(Date end, Date start) {
        long miliseconds = end.getTime() - start.getTime();
        double days = miliseconds / (1000.0 * 60 * 60 * 24);
        double total = balance * (days / 365);
        if (accountStatus.equals("Active")) {
            double interestSave = total * (interestRate / 100);
            System.out.println(balance + interestSave);
        } else {
            System.out.println("Account is deactive.");
        }
    }
    


    @Override
    public String toString() {
        return "SavingsAccount"+ super.toString() + ", interestRate=" + interestRate + ", accountStatus='" + accountStatus + "";
    }

}
