/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

/**
 *
 * @author Tuna
 */
public abstract class Customer {

    private final String name;
    private String adress;
    private String contactDetail;
    private static int accCounter = 0;
    private String keycode;

    public Customer(String name, String adress, String contactDetail, String keycode) {
        this.name = name;
        this.adress = adress;
        this.contactDetail = contactDetail;
        this.keycode = keycode;
        accCounter++;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    @Override
    public String toString() {
        return " Name: " + name + " Adress: " + adress  + " Phone: " + contactDetail;
    }
}
