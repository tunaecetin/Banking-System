/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Date startDate = new Date(2024, 5, 10);
        Date endDate = new Date(2025, 5, 10);

        //active dorman 3 4 5 iptal edilecek
        // Account Customer 
        Scanner input = new Scanner(System.in);
        ArrayList<IndCustomer> ind = new ArrayList();
        ArrayList<InsCustomer> ins = new ArrayList();
        ArrayList<SavingsAccount> sAccount = new ArrayList();
        ArrayList<CheckingAccount> cAccount = new ArrayList();
        ArrayList<Transaction> Trans = new ArrayList();
        FinancialPortfolio APort = new FinancialPortfolio();
        FinancialPortfolio BPort = new FinancialPortfolio();
        int counter = 1000;
        ind.add(new IndCustomer("Tuna", "Edirne", "5053234301", "Erkek", "26212626524", "Ogrenci", "a"));
        ins.add(new InsCustomer("TunaSirket", "Edirne", "5053234301", "E", "Health", 3000, "b"));

        BankingMenu();
        int menu = input.nextInt();

        if (menu > 0 && menu <= 5) {
            while (menu <= 4 && menu > 0) {

                switch (menu) {
                    case 1://Customer Menu Baslangici

                        CustomerMenu();
                        int customerChoose = input.nextInt();

                        if (customerChoose >= 0 && customerChoose <= 3) {
                            while (customerChoose > 0 && customerChoose <= 3) {

                                if (customerChoose == 1) { //Customer Creator

                                    System.out.println("\n//For Individual Customer Press 1");
                                    System.out.println("//For Institutional Customer Press 2");
                                    System.out.print("Please enter customer type for CREATE:");
                                    int b = input.nextInt();

                                    if (b == 1) { //Individual Customer Creator START
                                        boolean succes = false;
                                        boolean unsucces = false;
                                        IndCustomer indMusteri = null;

                                        System.out.print("Please enter your name:");
                                        String isim = input.next();
                                        System.out.print("Please enter your City:");
                                        String adres = input.next();
                                        System.out.print("Please enter your PhoneNumber (Without +90 or 0):");
                                        String telno = input.next();
                                        if (telno.length() != 10) {
                                            System.out.println("Invalid Phone Number");
                                            break;
                                        }
                                        System.out.println("1-Woman || 2-Man || 3-Other");
                                        System.out.print("Please select your Gender:");
                                        int cinsiyet = input.nextInt();
                                        String cinsiyettip;
                                        if (cinsiyet == 1) {
                                            cinsiyettip = "Woman";
                                        } else if (cinsiyet == 2) {
                                            cinsiyettip = "Man";
                                        } else if (cinsiyet == 3) {
                                            cinsiyettip = "Other";
                                        } else {
                                            System.out.println("Invalid Gender Choose please try again.");
                                            break;
                                        }
                                        System.out.print("Please Enter Your Identification Number: ");
                                        String kimlik = input.next();
                                        if (kimlik.length() != 11) {
                                            System.out.println("Identification Number length must be 11 charecter.");
                                            break;
                                        }
                                        System.out.print("Please Enter Your Job: ");
                                        String meslek = input.next();
                                        System.out.print("Please Enter a keycode for protection (Do not forget it): ");
                                        String keys1 = input.next();
                                        for (int i = 0; i < ind.size(); i++) {
                                            if (!kimlik.equals(ind.get(i).getId()) && !telno.equals(ind.get(i).getContactDetail())) {
                                                succes = true;
                                            } else {
                                                unsucces = true;
                                            }

                                        }

                                        if (succes) {
                                            ind.add(new IndCustomer(isim, adres, telno, cinsiyettip, kimlik, meslek, keys1));
                                            System.out.println("\tSuccesfully Customer Created");
                                        } else if (unsucces) {
                                            System.out.println("\tCustomer exists.");
                                        } //Individual Customer Creator END

                                    } else if (b == 2) { //Institutional Customer Creator START
                                        boolean basari = false;
                                        boolean basarisiz = false;
                                        InsCustomer insMusteri = null;

                                        System.out.print("Please enter name:");
                                        String sirketisim = input.next();
                                        System.out.print("Please enter City:");
                                        String sirketadres = input.next();
                                        System.out.print("Please enter your PhoneNumber (Without +90 or 0):");
                                        String sirkettelno = input.next();
                                        if (sirkettelno.length() != 10) {
                                            System.out.println("Invalid Phone Number");
                                            break;
                                        }
                                        System.out.println("1-Corporation || 2-Partnership || 3-Non-Profit Organization || 4-Government Entity");
                                        System.out.print("Please select Type");
                                        int sirketsecim = input.nextInt();
                                        String sirkettipi;
                                        if (sirketsecim == 1) {
                                            sirkettipi = "Corporation";
                                        } else if (sirketsecim == 2) {
                                            sirkettipi = "Partnership";
                                        } else if (sirketsecim == 3) {
                                            sirkettipi = "Non-Profit Organization";
                                        } else if (sirketsecim == 4) {
                                            sirkettipi = "Government Entity";
                                        } else {
                                            System.out.println("Invalid Type Choose please try again.");
                                            break;
                                        }
                                        System.out.print("Please Enter Sector: ");
                                        String sirketsector = input.next();
                                        System.out.print("Please Enter Budget: ");
                                        double sirketbutce = input.nextDouble();
                                        System.out.print("Please Enter a keycode for protection (Do not forget it): ");
                                        String keys = input.next();

                                        for (int i = 0; i < ins.size(); i++) {
                                            if (!sirketisim.equals(ins.get(i).getName()) && !sirkettelno.equals(ins.get(i).getContactDetail())) {
                                                insMusteri = ins.get(i);
                                                basari = true;
                                            } else {
                                                basarisiz = true;
                                            }

                                        }

                                        if (basari) {
                                            ins.add(new InsCustomer(sirketisim, sirketadres, sirkettelno, sirkettipi, sirketsector, sirketbutce, keys));
                                            System.out.println("\tSuccesfully Customer Created");
                                        } else if (basarisiz) {
                                            System.out.println("\tCustomer exists");
                                        }//Institutional Customer Creator END
                                    }

                                } else if (customerChoose == 2) { // Customer Checker 
                                    System.out.println("//For Check Individual Customer Press 1");
                                    System.out.println("//For Check Institutional Customer Press 2");
                                    System.out.print("Please enter customer type for check:");
                                    int control = input.nextInt();

                                    if (control == 1) {//Individual Customer Checker Start
                                        boolean controller = false;
                                        boolean nothing = false;
                                        IndCustomer IndChecker = null;

                                        System.out.print("Please Enter Your Identification Number For Check: ");
                                        String kontrolkimlik = input.next();
                                        System.out.print("Please enter your keycode For CHECK:");
                                        String kontrolkeycode = input.next();

                                        for (int i = 0; i < ind.size(); i++) {
                                            if (kontrolkimlik.equals(ind.get(i).getId()) && kontrolkeycode.equals(ind.get(i).getKeycode())) {
                                                IndChecker = ind.get(i);
                                                controller = true;
                                            } else {
                                                nothing = true;
                                            }
                                        }

                                        if (controller) {
                                            System.out.println(IndChecker.toString());
                                        } else if (nothing) {
                                            System.out.println("Invalid Customer Please check your KeyCode or ID number.");
                                        }

                                    } //Individual Customer Checker END
                                    else if (control == 2) { // Institutional Customer Checker START
                                        boolean kontrol = false;
                                        boolean nothing = false;
                                        InsCustomer InsChecker = null;

                                        System.out.print("Please Enter Name For Check: ");
                                        String kontrolisim = input.next();
                                        System.out.print("Please enter keycode For Check:");
                                        String kontrolkeycode1 = input.next();

                                        for (int i = 0; i < ins.size(); i++) {
                                            if (kontrolisim.equals(ins.get(i).getName()) && kontrolkeycode1.equals(ins.get(i).getKeycode())) {
                                                InsChecker = ins.get(i);
                                                kontrol = true;
                                            } else {
                                                nothing = true;
                                            }

                                        }
                                        if (kontrol) {
                                            System.out.println(InsChecker.toString());
                                        } else if (nothing) {
                                            System.out.println("Invalid Customer Please check your Name or Keycode.");
                                        }
                                    }//Institutional Customer Checker END

                                } else if (customerChoose == 3) {
                                    System.out.println("//For Check Individual Customer Press 1");
                                    System.out.println("//For Check Institutional Customer Press 2");
                                    System.out.print("Please enter customer type for UPDATE:");
                                    int update = input.nextInt();

                                    if (update == 1) {//Individual Customer UPDATER Start
                                        boolean controllerUpdate = false;
                                        boolean nothingUpdate = false;
                                        IndCustomer IndUpdater = null;

                                        System.out.print("Please Enter Your Identification Number For UPDATE: ");
                                        String kontrolkimlik = input.next();
                                        System.out.print("Please enter your keycode For UPDATE:");
                                        String kontrolkeycode = input.next();

                                        for (int i = 0; i < ind.size(); i++) {
                                            if (kontrolkimlik.equals(ind.get(i).getId()) && kontrolkeycode.equals(ind.get(i).getKeycode())) {
                                                IndUpdater = ind.get(i);
                                                controllerUpdate = true;
                                            } else {
                                                nothingUpdate = true;
                                            }
                                        }

                                        if (controllerUpdate) {
                                            System.out.println("\n\tINDIVIDUAL CUSTOMER INFORMATION");  // 2 tane aynÄ± tel no girilebiliyor.
                                            System.out.println(IndUpdater.toString());
                                            System.out.println("10-To change address:");
                                            System.out.println("11-To change phoneNumber:");
                                            System.out.println("12-To change occupation: ");
                                            System.out.println("13-To change keyCode:");
                                            System.out.print("Choose your chooice: ");
                                            int IndUpdaterSecim = input.nextInt();
                                            switch (IndUpdaterSecim) {
                                                case 10:
                                                    System.out.println("Please Enter Adress to change");
                                                    String changeAdress = input.next();
                                                    IndUpdater.setAdress(changeAdress);
                                                    System.out.println("Address Changed");

                                                    break;
                                                case 11:
                                                    System.out.println("Please Enter Phone Num to change");
                                                    String changeTelno = input.next();
                                                    if (changeTelno.length() != 10) {
                                                        System.out.println("Invalid Phone Number");
                                                        break;
                                                    }
                                                    IndUpdater.setContactDetail(changeTelno);
                                                    System.out.println("Phone number changed");
                                                    break;
                                                case 12:
                                                    System.out.println("Please Enter Occupation to change");
                                                    String changeJob = input.next();
                                                    IndUpdater.setOccupation(changeJob);
                                                    System.out.println("Occupation Changed");

                                                    break;
                                                case 13:
                                                    System.out.println("Please Enter KeyCode to change");
                                                    String changeKeycode = input.next();
                                                    IndUpdater.setKeycode(changeKeycode);
                                                    System.out.println("Keycode changed.");
                                                    break;
                                            }

                                        } else if (nothingUpdate) {
                                            System.out.println("Invalid Customer Please check your KeyCode or ID number.");
                                        }

                                    } //Individual Customer UPDATER END
                                    else if (update == 2) {
                                        boolean kontrolUpdate = false;
                                        boolean nothingUpdate = false;
                                        InsCustomer InsUpdater = null;

                                        System.out.print("Please Enter Name For UPDATE: ");
                                        String kontrolisim = input.next();
                                        System.out.print("Please enter keycode For UPDATE:");
                                        String kontrolkeycode1 = input.next();

                                        for (int i = 0; i < ins.size(); i++) {
                                            if (kontrolisim.equals(ins.get(i).getName()) && kontrolkeycode1.equals(ins.get(i).getKeycode())) {
                                                InsUpdater = ins.get(i);
                                                kontrolUpdate = true;
                                            } else {
                                                nothingUpdate = true;
                                            }

                                        }
                                        if (kontrolUpdate) {
                                            System.out.println("\n\tINSTITUTIONAL CUSTOMER INFORMATION");  // 2 tane aynÄ± tel no girilebiliyor.
                                            System.out.println(InsUpdater.toString());
                                            System.out.println("10-To change address:");
                                            System.out.println("11-To change phoneNumber:");
                                            System.out.println("12-To change occupation: ");
                                            System.out.println("13-To change keyCode:");
                                            System.out.println("14-To change budget:");
                                            System.out.print("Choose your chooice: ");
                                            int InsUpdaterSecim = input.nextInt();
                                            switch (InsUpdaterSecim) {
                                                case 10:
                                                    System.out.println("Please Enter Adress to change");
                                                    String changeAdress = input.next();
                                                    InsUpdater.setAdress(changeAdress);
                                                    System.out.println("Address Changed");

                                                    break;
                                                case 11:
                                                    System.out.println("Please Enter Phone Num to change");
                                                    String changeTelno = input.next();
                                                    if (changeTelno.length() != 10) {
                                                        System.out.println("Invalid Phone Number");
                                                        break;
                                                    }
                                                    InsUpdater.setContactDetail(changeTelno);
                                                    System.out.println("Phone number changed");
                                                    break;
                                                case 12:
                                                    System.out.println("Please Enter Sector to change");
                                                    String changeSector = input.next();
                                                    InsUpdater.setSector(changeSector);
                                                    System.out.println("Occupation Changed");

                                                    break;
                                                case 13:
                                                    System.out.println("Please Enter KeyCode to change");
                                                    String changeKeycode = input.next();
                                                    InsUpdater.setKeycode(changeKeycode);
                                                    System.out.println("Keycode changed.");
                                                    break;
                                                case 14:
                                                    System.out.println("Please Enter Budget to change");
                                                    double changeBudget = input.nextDouble();
                                                    InsUpdater.setBudget(changeBudget);
                                                    System.out.println("Budget changed.");

                                                    break;
                                            }
                                        } else if (nothingUpdate) {
                                            System.out.println("Invalid Customer Please check your Name or Keycode.");
                                        }
                                    }
                                }
                                CustomerMenu();
                                customerChoose = input.nextInt();

                            }
                        } else {
                            customerChoose = 0;
                        }
                        break;               //Customer Menu Bitis

                    case 2:
                        AccountMenu();
                        int accChoose = input.nextInt();
                        if (accChoose >= 0 && accChoose <= 2) {
                            while (accChoose > 0 && accChoose <= 2) {

                                if (accChoose == 1) {
                                    System.out.println("//For Create SavingsAccount Press 1");
                                    System.out.println("//For Create CheckingAccount Press 2");
                                    System.out.print("Please enter Account type for create:");
                                    int secim = input.nextInt();
                                    IndCustomer IndAccount = null;
                                    InsCustomer InsAccount = null;
                                    boolean indhesapbu = false;
                                    boolean inshesapbu = false;
                                    boolean indyanlis = false;
                                    boolean insyanlis = false;

                                    switch (secim) {
                                        case 1:
                                            System.out.println("\n\tSavingsAccount");
                                            System.out.println("For Individual Customer Press 1");
                                            System.out.println("For Institutional Customer Press 2");
                                            System.out.print("Please enter Customer type for create:");
                                            int AccSecimInd = input.nextInt();
                                            if (AccSecimInd == 1) {
                                                System.out.print("Please Enter Your Identification Number For IND ACC CREATOR: ");
                                                String kontrolAcc = input.next();
                                                System.out.print("Please enter your keycode For IND ACC CREATOR:");
                                                String kontrolAccKey = input.next();
                                                System.out.println("1-Active || 2-Dormant || 3-Closed");
                                                System.out.print("Please enter Account Status:");
                                                int status = input.nextInt();
                                                String accountStatus;
                                                if (status == 1) {
                                                    accountStatus = "Active";
                                                } else if (status == 2) {
                                                    accountStatus = "Dormant";
                                                } else if (status == 3) {
                                                    accountStatus = "Closed";
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                for (int i = 0; i < ind.size(); i++) {
                                                    if (kontrolAcc.equals(ind.get(i).getId()) && kontrolAccKey.equals(ind.get(i).getKeycode())) {
                                                        IndAccount = ind.get(i);
                                                        indhesapbu = true;
                                                    } else {
                                                        indyanlis = true;
                                                    }
                                                }

                                                if (indhesapbu) {

                                                    sAccount.add(new SavingsAccount(0, IndAccount, accountStatus));
                                                    System.out.println("Your account is created successfully. Account Number: " + counter);
                                                    counter++;

                                                } else if (indyanlis) {
                                                    System.out.println("Invalid Account Please check your ID , Keycode.");
                                                }

                                            } else if (AccSecimInd == 2) {
                                                System.out.print("Please Enter Name For INS ACC CREATOR: ");
                                                String kontrolAccIsim = input.next();
                                                System.out.print("Please enter keycode For INS ACC CREATOR:");
                                                String kontrolAccKey1 = input.next();
                                                System.out.println("1-Active || 2-Dormant || 3-Closed");
                                                System.out.print("Please enter Account Status:");
                                                int status = input.nextInt();
                                                String accountStatus;
                                                if (status == 1) {
                                                    accountStatus = "Active";
                                                } else if (status == 2) {
                                                    accountStatus = "Dormant";
                                                } else if (status == 3) {
                                                    accountStatus = "Closed";
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                for (int i = 0; i < ins.size(); i++) {
                                                    if (kontrolAccIsim.equals(ins.get(i).getName()) && kontrolAccKey1.equals(ins.get(i).getKeycode())) {
                                                        InsAccount = ins.get(i);
                                                        inshesapbu = true;
                                                    } else {
                                                        insyanlis = true;
                                                    }
                                                }

                                                if (inshesapbu) {
                                                    sAccount.add(new SavingsAccount(0, InsAccount, accountStatus));
                                                    System.out.println("Your account is created successfully. Account Number: " + counter);
                                                    counter++;
                                                } else if (insyanlis) {
                                                    System.out.println("Invalid Account Please check your Name , Keycode.");
                                                }
                                            }

                                            break;
                                        case 2:
                                            System.out.println("\n\t CheckingAccount");
                                            System.out.println("//For Individual Customer Press 1");
                                            System.out.println("//For Institutional Customer Press 2");
                                            System.out.print("Please enter Customer type for create:");
                                            int AccSecimIns = input.nextInt();
                                            if (AccSecimIns == 1) {
                                                System.out.print("Please Enter Your Identification Number For IND ACC CREATOR: ");
                                                String kontrolAcc = input.next();
                                                System.out.print("Please enter your keycode For IND ACC CREATOR:");
                                                String kontrolAccKey = input.next();
                                                System.out.println("1-Yes || 2-No");
                                                System.out.print("Please enter if you want Debit Card:");
                                                int hasDebitcardInt = input.nextInt();
                                                boolean hasDebitcard;
                                                if (hasDebitcardInt == 1) {
                                                    hasDebitcard = true;
                                                } else if (hasDebitcardInt == 2) {
                                                    hasDebitcard = false;
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                System.out.println("1-Yes || 2-No");
                                                System.out.print("Please enter if you want ATM Access:");
                                                int atmAccessInt = input.nextInt();
                                                boolean atmAccess;
                                                if (atmAccessInt == 1) {
                                                    atmAccess = true;
                                                } else if (atmAccessInt == 2) {
                                                    atmAccess = false;
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                System.out.println("1-Yes || 2-No");
                                                System.out.print("Please enter if you want Online Banking Access:");
                                                int onlineBankingAccessInt = input.nextInt();
                                                boolean onlineBankingAccess;
                                                if (onlineBankingAccessInt == 1) {
                                                    onlineBankingAccess = true;
                                                } else if (onlineBankingAccessInt == 2) {
                                                    onlineBankingAccess = false;
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                System.out.println("1-Active || 2-Dormant || 3-Closed");
                                                System.out.print("Please enter Account Status:");
                                                int status = input.nextInt();
                                                String accountStatus;
                                                if (status == 1) {
                                                    accountStatus = "Active";
                                                } else if (status == 2) {
                                                    accountStatus = "Dormant";
                                                } else if (status == 3) {
                                                    accountStatus = "Closed";
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                for (int i = 0; i < ind.size(); i++) {
                                                    if (kontrolAcc.equals(ind.get(i).getId()) && kontrolAccKey.equals(ind.get(i).getKeycode())) {
                                                        IndAccount = ind.get(i);
                                                        indhesapbu = true;
                                                    } else {
                                                        indyanlis = true;
                                                    }
                                                }

                                                if (indhesapbu) {
                                                    cAccount.add(new CheckingAccount(0, IndAccount, hasDebitcard, atmAccess, onlineBankingAccess, accountStatus));
                                                    System.out.println("Your account is created successfully. Account Number: " + counter);
                                                    counter++;
                                                } else if (indyanlis) {
                                                    System.out.println("Invalid Account Please check your ID , Keycode.");
                                                }

                                            } else if (AccSecimIns == 2) {
                                                System.out.print("Please Enter Name For INS ACC CREATOR: ");
                                                String kontrolAccIsim = input.next();
                                                System.out.print("Please enter keycode For INS ACC CREATOR:");
                                                String kontrolAccKey1 = input.next();
                                                System.out.println("1-Yes || 2-No");
                                                System.out.print("Please enter if you want Debit Card:");
                                                int hasDebitcardInt = input.nextInt();
                                                boolean hasDebitcard;
                                                if (hasDebitcardInt == 1) {
                                                    hasDebitcard = true;
                                                } else if (hasDebitcardInt == 2) {
                                                    hasDebitcard = false;
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                System.out.println("1-Yes || 2-No");
                                                System.out.print("Please enter if you want ATM Access:");
                                                int atmAccessInt = input.nextInt();
                                                boolean atmAccess;
                                                if (atmAccessInt == 1) {
                                                    atmAccess = true;
                                                } else if (atmAccessInt == 2) {
                                                    atmAccess = false;
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                System.out.println("1-Yes || 2-No");
                                                System.out.print("Please enter if you want ATM Access:");
                                                int onlineBankingAccessInt = input.nextInt();
                                                boolean onlineBankingAccess;
                                                if (onlineBankingAccessInt == 1) {
                                                    onlineBankingAccess = true;
                                                } else if (onlineBankingAccessInt == 2) {
                                                    onlineBankingAccess = false;
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                System.out.println("1-Active || 2-Dormant || 3-Closed");
                                                System.out.print("Please enter Account Status:");
                                                int status = input.nextInt();
                                                String accountStatus;
                                                if (status == 1) {
                                                    accountStatus = "Active";
                                                } else if (status == 2) {
                                                    accountStatus = "Dormant";
                                                } else if (status == 3) {
                                                    accountStatus = "Closed";
                                                } else {
                                                    System.out.println("Invalid Status Choose please try again.");
                                                    break;
                                                }
                                                for (int i = 0; i < ins.size(); i++) {
                                                    if (kontrolAccIsim.equals(ins.get(i).getName()) && kontrolAccKey1.equals(ins.get(i).getKeycode())) {
                                                        InsAccount = ins.get(i);
                                                        inshesapbu = true;
                                                    } else {
                                                        insyanlis = true;
                                                    }
                                                }

                                                if (inshesapbu) {
                                                    cAccount.add(new CheckingAccount(0, InsAccount, hasDebitcard, atmAccess, onlineBankingAccess, accountStatus));
                                                    System.out.println("Your account is created successfully. Account Number: " + counter);
                                                    counter++;
                                                } else if (insyanlis) {
                                                    System.out.println("Invalid Account Please check your Name , Keycode.");
                                                }
                                            }
                                            break;
                                    }
                                } else if (accChoose == 2) {
                                    SavingsAccount updateAccS = null;
                                    CheckingAccount updateAccC = null;
                                    boolean updateisTrueS = false;
                                    boolean updateisTrueC = false;
                                    System.out.print("Please enter Acc Number:");
                                    int UpdateNum = input.nextInt();
                                    System.out.print("Please enter KeyCode:");
                                    String UpdateKeycode = input.next();

                                    for (int i = 0; i < sAccount.size(); i++) {
                                        if (sAccount.get(i).getAccNum() == UpdateNum) {
                                            updateAccS = sAccount.get(i);
                                            updateisTrueS = true;
                                        }
                                    }

                                    for (int i = 0; i < cAccount.size(); i++) {
                                        if (cAccount.get(i).getAccNum() == UpdateNum) {
                                            updateAccC = cAccount.get(i);
                                            updateisTrueC = true;
                                        }
                                    }

                                    if (updateisTrueS) {
                                        System.out.println("1-Active || 2-Dormant || 3-Closed");
                                        System.out.print("Please enter Account Status:");
                                        int Accountstatus = input.nextInt();
                                        String UpdateaccountStatus;
                                        if (Accountstatus == 1) {
                                            UpdateaccountStatus = "Active";
                                        } else if (Accountstatus == 2) {
                                            UpdateaccountStatus = "Dormant";
                                        } else if (Accountstatus == 3) {
                                            UpdateaccountStatus = "Closed";
                                        } else {
                                            System.out.println("Invalid Status Choose please try again.");
                                            break;
                                        }
                                        updateAccS.setAccountStatus(UpdateaccountStatus);
                                        System.out.println("Status Successfully Changed as: " + updateAccS.getAccountStatus());

                                    } else if (updateisTrueC) {
                                        System.out.println("1-Active || 2-Dormant || 3-Closed");
                                        System.out.print("Please enter Account Status:");
                                        int AccountstatusC = input.nextInt();
                                        String UpdateaccountStatusC;
                                        if (AccountstatusC == 1) {
                                            UpdateaccountStatusC = "Active";
                                        } else if (AccountstatusC == 2) {
                                            UpdateaccountStatusC = "Dormant";
                                        } else if (AccountstatusC == 3) {
                                            UpdateaccountStatusC = "Closed";
                                        } else {
                                            System.out.println("Invalid Status Choose please try again.");
                                            break;
                                        }
                                        System.out.println("1-Yes || 2-No");
                                        System.out.print("Please enter if you want Debit Card:");
                                        int hasDebitcardIntC = input.nextInt();
                                        boolean hasDebitcardC;
                                        if (hasDebitcardIntC == 1) {
                                            hasDebitcardC = true;
                                        } else if (hasDebitcardIntC == 2) {
                                            hasDebitcardC = false;
                                        } else {
                                            System.out.println("Invalid Status Choose please try again.");
                                            break;
                                        }
                                        System.out.println("1-Yes || 2-No");
                                        System.out.print("Please enter if you want ATM Access:");
                                        int atmAccessIntC = input.nextInt();
                                        boolean atmAccessC;
                                        if (atmAccessIntC == 1) {
                                            atmAccessC = true;
                                        } else if (atmAccessIntC == 2) {
                                            atmAccessC = false;
                                        } else {
                                            System.out.println("Invalid Status Choose please try again.");
                                            break;
                                        }
                                        System.out.println("1-Yes || 2-No");
                                        System.out.print("Please enter if you want Online Banking Access:");
                                        int onlineBankingAccessIntC = input.nextInt();
                                        boolean onlineBankingAccessC;
                                        if (onlineBankingAccessIntC == 1) {
                                            onlineBankingAccessC = true;
                                        } else if (onlineBankingAccessIntC == 2) {
                                            onlineBankingAccessC = false;
                                        } else {
                                            System.out.println("Invalid Status Choose please try again.");
                                            break;
                                        }
                                        updateAccC.setAccountStatus(UpdateaccountStatusC);
                                        updateAccC.setAtmAccess(atmAccessC);
                                        updateAccC.setHasDebitCard(hasDebitcardC);
                                        updateAccC.setOnlineBankingAccess(onlineBankingAccessC);
                                        System.out.println("Updated Account: " + updateAccC.toString());
                                    }
                                }
                                AccountMenu();
                                accChoose = input.nextInt();

                            }
                        } else {
                            accChoose = 0;
                        }

                        break;
                    case 3:
                        SavingsAccount ActiveOrCloseS = null;
                        CheckingAccount ActiveOrCloseC = null;
                        boolean isActiveS = false;
                        boolean isActiveC = false;
                        System.out.print("Please enter Acc Number:");
                        int ActiveAccNum = input.nextInt();
                        System.out.print("Please enter KeyCode:");
                        String ActiveKeycode = input.next();

                        for (int i = 0; i < sAccount.size(); i++) {
                            if (ActiveAccNum == sAccount.get(i).getAccNum()
                                    && sAccount.get(i).getOwner().getKeycode().equals(ActiveKeycode)
                                    && sAccount.get(i).getAccountStatus().equals("Active")) {
                                ActiveOrCloseS = sAccount.get(i);
                                isActiveS = true;
                            }
                        }

                        for (int i = 0; i < cAccount.size(); i++) {
                            if (ActiveAccNum == cAccount.get(i).getAccNum()
                                    && cAccount.get(i).getOwner().getKeycode().equals(ActiveKeycode)
                                    && cAccount.get(i).getAccountStatus().equals("Active")) {
                                ActiveOrCloseC = cAccount.get(i);
                                isActiveC = true;
                            }
                        }
                        if (isActiveS) {
                            ikinciMenu();
                            int ikincisecim = input.nextInt();
                            while (ikincisecim < 4 && ikincisecim > 0) {
                                switch (ikincisecim) {
                                    case 1:
                                        TransactionExecution();
                                        int transSecim = input.nextInt();
                                        switch (transSecim) {
                                            case 1:
                                                System.out.print("Please enter your Deposit Amount:");
                                                double DepositAmount = input.nextDouble();
                                                Trans.add(new Transaction(ActiveOrCloseS, DepositAmount, "Deposit"));
                                                break;
                                            case 2:

                                                System.out.print("Please enter your Withdraw Amount:");
                                                double WithdrawAmount = input.nextDouble();
                                                Trans.add(new Transaction(ActiveOrCloseS, WithdrawAmount, "Withdraw"));
                                                break;

                                            case 3:
                                                System.out.print("Please enter Acc Num to send money:");
                                                int AccTo = input.nextInt();
                                                System.out.print("Please enter amount of money:");
                                                double money = input.nextDouble();
                                                CheckingAccount TransferC = null;
                                                SavingsAccount TransferS = null;
                                                boolean TransferSTo = false;
                                                boolean TransferCTo = false;

                                                for (int i = 0; i < sAccount.size(); i++) {
                                                    if (AccTo == sAccount.get(i).getAccNum()) {
                                                        TransferS = sAccount.get(i);
                                                        TransferSTo = true;
                                                    }

                                                }
                                                for (int i = 0; i < cAccount.size(); i++) {
                                                    if (AccTo == cAccount.get(i).getAccNum()) {
                                                        TransferC = cAccount.get(i);
                                                        TransferCTo = true;
                                                    }
                                                }

                                                if (TransferSTo) {
                                                    Trans.add(new Transaction(ActiveOrCloseS, TransferS, money, "Transfer"));
                                                    System.out.println("Successfully Transfered" + "to" + TransferS.getAccNum());
                                                }
                                                if (TransferCTo) {
                                                    Trans.add(new Transaction(ActiveOrCloseS, TransferC, money, "Transfer"));
                                                    System.out.println("Successfully Transfered " + " to " + TransferC.getAccNum());
                                                }
                                                break;

                                        }
                                        break;

                                    case 2:
                                        Transaction TransS = null;
                                        Transaction TransS1 = null;
                                        boolean TransSisTrue = false;

                                        for (int i = 0; i < Trans.size(); i++) {
                                            if (Trans.get(i).getAccount().getAccNum() == ActiveOrCloseS.getAccNum()) {
                                                TransS1 = TransS;
                                                TransS = Trans.get(i);
                                                TransSisTrue = true;
                                            }
                                        }

                                        if (TransSisTrue) {
                                            System.out.println(TransS);
                                            System.out.println(TransS1);

                                        }
                                        break;
                                    case 3:
                                        System.out.println(ActiveOrCloseS.toString());
                                        System.out.println("Balance after one year with interest rate:");
                                        ActiveOrCloseS.InterestSave(endDate, startDate);
                                        break;
                                }
                                ikinciMenu();
                                ikincisecim = input.nextInt();
                            }

                        } else if (isActiveC) {
                            ikinciMenu();
                            int ikincisecim = input.nextInt();
                            while (ikincisecim < 4 && ikincisecim > 0) {
                                switch (ikincisecim) {
                                    case 1:
                                        TransactionExecution();
                                        int transSecim = input.nextInt();
                                        switch (transSecim) {
                                            case 1:

                                                System.out.print("Please enter your Deposit Amount:");
                                                double DepositAmount = input.nextDouble();
                                                Trans.add(new Transaction(ActiveOrCloseC, DepositAmount, "Deposit"));

                                                break;
                                            case 2:

                                                System.out.print("Please enter your Withdraw Amount:");
                                                double WithdrawAmount = input.nextDouble();

                                                Trans.add(new Transaction(ActiveOrCloseC, WithdrawAmount, "Withdraw"));

                                                break;

                                            case 3:

                                                System.out.print("Please enter Acc Num to send money:");
                                                int AccTo = input.nextInt();
                                                System.out.print("Please enter amount of money:");
                                                double money = input.nextDouble();
                                                CheckingAccount TransferC1 = null;
                                                SavingsAccount TransferS1 = null;
                                                boolean TransferSTo = false;
                                                boolean TransferCTo = false;

                                                for (int i = 0; i < sAccount.size(); i++) {
                                                    if (AccTo == sAccount.get(i).getAccNum()) {
                                                        TransferS1 = sAccount.get(i);
                                                        TransferSTo = true;
                                                    }

                                                }
                                                for (int i = 0; i < cAccount.size(); i++) {
                                                    if (AccTo == cAccount.get(i).getAccNum()) {
                                                        TransferC1 = cAccount.get(i);
                                                        TransferCTo = true;
                                                    }
                                                }

                                                if (TransferSTo) {
                                                    Trans.add(new Transaction(ActiveOrCloseC, TransferS1, money, "Transfer"));
                                                    System.out.println("Successfully Transfered " + " to " + TransferS1.getAccNum());
                                                }
                                                if (TransferCTo) {
                                                    Trans.add(new Transaction(ActiveOrCloseC, TransferC1, money, "Transfer"));
                                                    System.out.println("Successfully Transfered " + " to " + TransferC1.getAccNum());
                                                }
                                                break;

                                        }
                                        break;

                                    case 2:
                                        Transaction TransC = null;
                                        Transaction TransC1 = null;
                                        boolean TransCisTrue = false;

                                        for (int i = 0; i < Trans.size(); i++) {
                                            if (Trans.get(i).getAccount().getAccNum() == ActiveOrCloseC.getAccNum()) {
                                                TransC1 = TransC;
                                                TransC = Trans.get(i);
                                                TransCisTrue = true;
                                            }
                                        }

                                        if (TransCisTrue) {
                                            System.out.println(TransC);
                                            System.out.println(TransC1);
                                        }
                                        break;
                                    case 3:
                                        System.out.println(ActiveOrCloseC.toString());
                                        System.out.println("Balance after one year with interest rate:");
                                        ActiveOrCloseS.InterestSave(endDate, startDate);
                                        break;
                                }
                                ikinciMenu();
                                ikincisecim = input.nextInt();
                            }
                        } else if (isActiveS == false && isActiveC == false) {
                            System.out.println("Invalid Account Num");
                        }
                        break;
                    case 4:
                        FinanceMenu();
                        int PortSecim = input.nextInt();

                        switch (PortSecim) {
                            case 1:
                                boolean isTruePortS = false;
                                boolean isTruePortC = false;
                                SavingsAccount PortSaving = null;
                                CheckingAccount PortChecking = null;
                                System.out.print("Please enter Acc Number:");
                                int PortAccNum = input.nextInt();
                                System.out.println("Please choose Portfolia to add.");
                                System.out.println("For A Press -1");
                                System.out.println("For B Press -2");
                                int PortAdd = input.nextInt();
                                String PortAddAB;
                                if (PortAdd == 1) {
                                    PortAddAB = "A";
                                } else if (PortAdd == 2) {
                                    PortAddAB = "B";
                                } else {
                                    System.out.println("Invalid Choose Please Try again");
                                    break;
                                }

                                for (int i = 0; i < sAccount.size(); i++) {
                                    if (PortAccNum == sAccount.get(i).getAccNum()) {
                                        PortSaving = sAccount.get(i);
                                        isTruePortS = true;

                                    }
                                }

                                for (int i = 0; i < cAccount.size(); i++) {
                                    if (PortAccNum == cAccount.get(i).getAccNum()) {
                                        PortChecking = cAccount.get(i);
                                        isTruePortC = true;

                                    }
                                }

                                if (isTruePortS && PortAddAB.equals("A")) {
                                    APort.addAccount(PortSaving);
                                    System.out.println("Account numbered " + PortSaving.getAccNum() + " Successfully added to A Portfolio");
                                }
                                if (isTruePortS && PortAddAB.equals("B")) {
                                    BPort.addAccount(PortSaving);
                                    System.out.println("Account numbered " + PortSaving.getAccNum() + " Successfully added to B Portfolio");
                                }
                                if (isTruePortC && PortAddAB.equals("A")) {
                                    APort.addAccount(PortChecking);
                                    System.out.println("Account numbered " + PortChecking.getAccNum() + " Successfully added to A Portfolio");
                                }
                                if (isTruePortC && PortAddAB.equals("B")) {
                                    BPort.addAccount(PortChecking);
                                    System.out.println("Account numbered " + PortChecking.getAccNum() + " Successfully added to B Portfolio");
                                }
                                break;
                            case 2:
                                boolean isTruePortRemoveS = false;
                                boolean isTruePortRemoveC = false;
                                SavingsAccount PortReemoveSaving = null;
                                CheckingAccount PortRemoveChecking = null;
                                System.out.print("Please enter Acc Number:");
                                int PortRemoveAccNum = input.nextInt();

                                for (int i = 0; i < sAccount.size(); i++) {
                                    if (PortRemoveAccNum == sAccount.get(i).getAccNum()) {
                                        PortReemoveSaving = sAccount.get(i);
                                        isTruePortRemoveS = true;

                                    }
                                }

                                for (int i = 0; i < cAccount.size(); i++) {
                                    if (PortRemoveAccNum == cAccount.get(i).getAccNum()) {
                                        PortRemoveChecking = cAccount.get(i);
                                        isTruePortRemoveC = true;

                                    }
                                }

                                if (isTruePortRemoveS) {
                                    APort.removeAccount(PortReemoveSaving);
                                    BPort.removeAccount(PortReemoveSaving);
                                    System.out.println("Account numbered " + PortReemoveSaving.getAccNum() + " Successfully removed from Portfolio");
                                }
                                if (isTruePortRemoveC) {
                                    APort.removeAccount(PortRemoveChecking);
                                    BPort.removeAccount(PortRemoveChecking);
                                    System.out.println("Account numbered " + PortRemoveChecking.getAccNum() + " Successfully removed from Portfolio");
                                }

                                break;
                            case 3:

                                System.out.println("For A Press -1");
                                System.out.println("For B Press -2");
                                System.out.print("Please choose Portfolia Print Total Value.");
                                int PortTotal = input.nextInt();
                                String PortTotalAB;
                                if (PortTotal == 1) {
                                    PortTotalAB = "A";
                                } else if (PortTotal == 2) {
                                    PortTotalAB = "B";
                                } else {
                                    System.out.println("Invalid Choose Please Try again");
                                    break;
                                }

                                if (PortTotalAB.equals("A")) {
                                    System.out.println(APort.getTotalValue());
                                }
                                if (PortTotalAB.equals("B")) {
                                    System.out.println(BPort.getTotalValue());
                                }
                                break;
                            case 4:
                                System.out.println("Are 2 Port values equals to each other.");
                                System.out.println("If yes returns true.");
                                System.out.println("If no returns false");
                                System.out.println("(" + APort.financeEquals(BPort) + ")");
                                break;

                            case 5:

                                System.out.println("For A Press -1");
                                System.out.println("For B Press -2");
                                System.out.print("Please choose Portfolia Print Info.");
                                int PortPrint = input.nextInt();
                                String PortPrintAB;
                                if (PortPrint == 1) {
                                    PortPrintAB = "A";
                                } else if (PortPrint == 2) {
                                    PortPrintAB = "B";
                                } else {
                                    System.out.println("Invalid Choose Please Try again");
                                    break;
                                }

                                if (PortPrintAB.equals("A")) {
                                    APort.printAccounts();
                                }
                                if (PortPrintAB.equals("B")) {
                                    BPort.printAccounts();
                                }
                                break;
                            case 6:
                                SavingsAccount ControlS = null;
                                SavingsAccount ControlS1 = null;
                                System.out.print("Please enter first Acc Number:");
                                int controling = input.nextInt();
                                System.out.print("Please enter second Acc Number:");
                                int controling1 = input.nextInt();

                                for (int i = 0; i < sAccount.size(); i++) {
                                    if (controling == sAccount.get(i).getAccNum()) {
                                        ControlS = sAccount.get(i);
                                    }
                                    if (controling1 == sAccount.get(i).getAccNum()) {
                                        ControlS1 = sAccount.get(i);
                                    }
                                }

                                if (ControlS.compareAcc(ControlS1)) {
                                    System.out.println(ControlS.getAccNum() + " " + ControlS1.getAccNum() + " balances equal.");
                                } else {
                                    System.out.println("Balances not equal.");
                                }

                                break;
                            case 7:
                                System.out.println("Numbers Of Customer");
                                System.out.println(ins.size()+ind.size());
                                break;
                                
                        }

                }
                BankingMenu();
                menu = input.nextInt();

            }
            if (menu == 6) {

            }
        } else {
            System.out.println("Invalid Choose!");
        }

    }

    public static void BankingMenu() {
        System.out.println("\n\tMT BANKING SYSTEM");

        System.out.println("[1] For Customer Menu.");
        System.out.println("[2] Account Creator and Updater Menu.");
        System.out.println("[3] Account Manage Menu");
        System.out.println("[4] Portfolio Menu");
        System.out.println("[5] Exit.");
        System.out.println("");
        System.out.print("Enter your choice:");
    }

    public static void CustomerMenu() {
        System.out.println("\n\tCustomer Menu:");
        System.out.println("[1] Create Customer");
        System.out.println("[2] Display Customer Details");
        System.out.println("[3] Update a contact details");
        System.out.println("[0] Go back");
        System.out.println("");
        System.out.print("Enter your choice:");
    }

    public static void AccountMenu() {
        System.out.println("\n\tAccount Menu:");
        System.out.println("[1] Create");
        System.out.println("[2] Update Account");
        System.out.println("[0] Go back");
        System.out.println("");
        System.out.print("Enter your choice:");
    }

    public static void TransactionExecution() {
        System.out.println("\n\tTransaction Menu:");
        System.out.println("[1] Deposit Into Account");
        System.out.println("[2] Withdrawals from Accounts");
        System.out.println("[3] Transfer Between Accounts");
        System.out.println("[0] Go back");
        System.out.println("");
        System.out.print("Enter your choice:");
    }

    public static void FinanceMenu() {
        System.out.println("\n\tFinancial Portfolio Menu:");
        System.out.println("[1] Add account to Portfolio");
        System.out.println("[2] Remove account to Portfolio");
        System.out.println("[3] Total Value Of Portfolio");
        System.out.println("[4] Compare 2 Portfolio");
        System.out.println("[5] Print All Account infos in the Portfolio");
        System.out.println("[6] Compare 2 Account");
        System.out.println("[7] Numbers of Customers");
        System.out.println("[0] Go back");
        System.out.println("");
        System.out.print("Enter your choice:");
    }

    public static void ikinciMenu() {
        System.out.println("[1] Transaction Execution");
        System.out.println("[2] Transfer History");
        System.out.println("[3] Display Account Data");
        System.out.println("[0] Go back");
        System.out.println("");
        System.out.print("Enter your choice:");
    }
}
