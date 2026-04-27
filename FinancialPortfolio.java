/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

import java.util.ArrayList;

public class FinancialPortfolio {

    private ArrayList<Account> a1 = new ArrayList();

    public void addAccount(Account account) {
        a1.add(account);
    }

    public void removeAccount(Account account) {
        if (a1.remove(account)) {
        }
    }

    public double getTotalValue() {
        double total = 0;
        for (int i = 0; i < a1.size(); i++) {
            total += a1.get(i).getBalance();
        }
        return total;
    }

    public void printAccounts() {
        for (int i = 0; i < a1.size(); i++) {
            System.out.println(a1.get(i));
        }
    }

    public boolean financeEquals(FinancialPortfolio port) {
        if (this.getTotalValue() == port.getTotalValue()) {
            return true;
        } else {
            return false;
        }
    }

}
