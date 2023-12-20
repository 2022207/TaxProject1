/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package taxproject1;

/**
 *
 * @author suele
 */
public interface Taxable {
    
    //Calculate the tax amount for the taxable entity.
     double calculateTax();

    public double getAmount();
     TaxType getTaxType();
    
}
