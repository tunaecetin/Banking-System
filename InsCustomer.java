/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

/**
 *
 * @author Tuna
 */
public class InsCustomer extends Customer {

    private String SirketType;
    private String sector;
    private double budget;

    public InsCustomer(String name, String address, String contactDetail, String SirketType, String sector, double budget, String keycode) {
        super(name, address, contactDetail, keycode);
        this.SirketType = SirketType;
        this.sector = sector;
        this.budget = budget;

    }

    public String getSirketType() {
        return SirketType;
    }

    public String getSector() {
        return sector;
    }

    public double getBudget() {
        return budget;
    }

    public void setSirketType(String SirketType) {
        this.SirketType = SirketType;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Institutional Customer: " + super.toString() + " Type: " + SirketType + " Sector: " + sector + " Budget: " + budget;
    }
}
