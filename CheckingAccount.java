/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

import java.util.Date;

public class CheckingAccount extends Account {

    private static final double interestRate = 3.0;
    private boolean hasDebitCard;
    private boolean atmAccess;
    private boolean onlineBankingAccess;
    private String accountStatus;

    public CheckingAccount(double balance, Customer owner, boolean hasDebitCard, boolean atmAccess, boolean onlineBankingAccess, String accountStatus) {
        super(owner, balance);
        this.hasDebitCard = hasDebitCard;
        this.atmAccess = atmAccess;
        this.onlineBankingAccess = onlineBankingAccess;
        this.accountStatus = accountStatus;
    }

    public boolean isHasDebitCard() {
        return hasDebitCard;
    }

    public boolean isAtmAccess() {
        return atmAccess;
    }

    public boolean isOnlineBankingAccess() {
        return onlineBankingAccess;
    }

    public void setHasDebitCard(boolean hasDebitCard) {
        this.hasDebitCard = hasDebitCard;
    }

    public void setAtmAccess(boolean atmAccess) {
        this.atmAccess = atmAccess;
    }

    public void setOnlineBankingAccess(boolean onlineBankingAccess) {
        this.onlineBankingAccess = onlineBankingAccess;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void InterestCheck(Date end, Date start) {
        long miliseconds = end.getTime() - start.getTime();
        double days = miliseconds / (1000.0 * 60 * 60 * 24);
        double total = balance * (days / 365);
        if (accountStatus.equals("Active")) {
            double interestCheck = total * (interestRate / 100);
            System.out.println(balance + interestCheck);
        } else {
            System.out.println("Account is deactive.");
        }

    }


    @Override
    public String toString() {
        return "CheckingAccount" + super.toString() + ", interestRate=" + interestRate + ", accountStatus='" + accountStatus;
    }

}
