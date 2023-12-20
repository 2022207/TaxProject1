/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author suele
 */
public class RegularUser extends AllUser {
    
     public RegularUser(int id, String name, String surname, String username, String email, String password, double grossIncome) {
        super(id, name, surname, username, email, password, grossIncome);
    }

    public void modifyProfile() {
        // Implementation for modifying the profile
        System.out.println("Profile modified for regular user: " + getUsername());
    }

    public void saveAndSeeEquations() {
        // Implementation for saving and seeing system of equations
        System.out.println("Equations saved and seen for regular user: " + getUsername());
    }
    
}
