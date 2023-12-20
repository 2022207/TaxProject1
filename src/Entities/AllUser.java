/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import taxproject1.TaxCredits;
import taxproject1.TaxType;


/**
 *
 * @author suele
 */
public class AllUser {
    
     private static int currentID ;
    // user attributes
    private int id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private double grossIncome;


    public AllUser(String name, String surname, String username, String email, String password, double grossIncome) {
        this.id = currentID++;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.grossIncome = grossIncome;
      
    }

   
    
    public AllUser (int id, String name, String surname, String username, String email, String password, double grossIncome) {
        this.id = id;
        this.name = name;
        this.surname = surname;
         this.username = username;
        this.email = email;
        this.password = password;
        this.grossIncome = grossIncome;
        
        if (currentID <= id){
            currentID = id +1;
        }
    }

    // Getter and Setter methods for retrieving user attributes
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    

    public int getId() {
        return id;
    }

    
    public static int getCurrentID(){
       return currentID;
        }
        
        
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public double getgrossIncome() {
        return grossIncome;
    }

    public void setSalary(double grossIncome) {
        this.grossIncome = grossIncome;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }
    
    //Method to calculate PAYE tax for the user.
      public double calculatePAYE() {
        
        TaxCredits taxCredits = new TaxCredits(0.1, 0.05); 
        return grossIncome * TaxType.PAYE.getRate() - grossIncome * taxCredits.getRateAbove40K();
    }
      
 //Method to calculate USC tax for the user.
   public double calculateUSC() {
    
    TaxCredits taxCredits = new TaxCredits(0.05, 0.02); 

    double usc = grossIncome * TaxType.USC.getRate() - grossIncome * taxCredits.getRateBelow40K();

    return usc;
}
 //Method to calculate PRSI tax for the user.
   public double calculatePRSI() {
    
    double prsi = grossIncome * TaxType.PRSI.getRate(); 
    return prsi;
}

    //  method for a private operation
    private double getGrossIncome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
   

    
    
}
