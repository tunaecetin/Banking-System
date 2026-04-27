/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

public class IndCustomer extends Customer {

    private final String gender;
    private final String id;
    private String occupation;

    public IndCustomer(String name, String address, String contactDetail, String gender, String id, String occupation, String keycode) {
        super(name, address, contactDetail, keycode);
        this.gender = gender;
        this.id = id;
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Individual Customer: "+ super.toString()  + " Gender:" + gender + " Id: " + id + " Occupation: " + occupation;
    }
}
