/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxproject1;

/**
 *
 * @author suele
 */
public class User  extends GrossIncome implements Taxable {
    
      private final boolean is40000;

    
    public User(double amount, boolean is40000) {
        setAmount(amount);
        this.is40000 = is40000;
    }

    public boolean is40000() {
        return is40000;
    }

    
    @Override
    public double calculateTax() {
        double grossIncome = getAmount();

        // Determine the tax credits based on the user's income
        TaxCredits taxCredits = is40000 ? new TaxCredits(0.05, 0.02) : new TaxCredits(0.1, 0.05);

        // Calculate PAYE tax
        double payeTax = grossIncome * TaxType.PAYE.getRate() - grossIncome * taxCredits.getRateAbove40K();

        // Calculate USC tax
        double uscTax = grossIncome * TaxType.USC.getRate() - grossIncome * taxCredits.getRateBelow40K();

        // Calculate PRSI tax
        double prsiTax = grossIncome * TaxType.PRSI.getRate();

        // Return the total tax
        return payeTax + uscTax + prsiTax;
    }
   

    @Override
    public TaxType getTaxType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
 