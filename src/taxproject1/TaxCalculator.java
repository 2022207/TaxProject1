/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxproject1;

/**
 *
 * @author castr
 */
<<<<<<< HEAD
public class TaxCalculator {
    
=======
public class TaxCalculator  { 
    
    
    //Calculates the tax amount for a given taxable entity, tax type, and tax credits.
    public static double calculateTax(Taxable entities, TaxType taxType, TaxCredits taxCredits) {
        double taxRate = 0;

        //switch the tax rate based on the tax type
        switch (entities.getTaxType()) {
            case PAYE:
                taxRate = 0.10; // flat 10% PAYE rate 
                break;
            case USC:
                taxRate = 0.05; // flat 5% USC rate 
                break;
            case PRSI:
                taxRate = 0.02; //  2% PRSI rate 
                break;
        }

        // Calculate tax after applying tax credits
        double taxableIncome = entities.getAmount() * (1 - getTaxRate(entities, taxCredits));
        double taxAmount = taxableIncome * taxRate;

        return taxAmount;
    }

    private static double getTaxRate(Taxable entities, TaxCredits taxCredits) {
       
        if (entities instanceof User) {
            User user = (User) entities;
            return user.is40000() ? taxCredits.getRateAbove40K() : taxCredits.getRateBelow40K();
        }
        return 0.0; 
    }
>>>>>>> a0f0a93af56db7604f8a836c0758e88915e8f567
}
