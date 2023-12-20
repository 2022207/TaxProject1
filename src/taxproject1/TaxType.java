/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxproject1;

/**
 *
 * @author suele
 */
public enum TaxType {
    
     PAYE(0.10), // rate for PAYE
    USC(0.05),  // rate for USC
    PRSI(0.02); // rate for PRSI

    
    //to store the tax rate
    private final double rate;

    TaxType(double rate) {
        this.rate = rate;
    }
  
    
    //Getter method to retrieve the tax rate 
    public double getRate() {
        return rate;
    }
}
