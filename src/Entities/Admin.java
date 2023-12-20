/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Database.DatabaseWriter;
import java.util.ArrayList;

/**
 *
 * @author suele
 */
public class Admin extends AllUser {
    
      public Admin(int id, String name, String surname, String username, String email, String password, double grossIncome) {
        super(id, name, surname, username, email, password, grossIncome);
        
    }

    public void modifyProfile() {
        // Implementation for modifying the profile
        System.out.println("Profile modified for admin: " + getUsername());
    }

    
    
    public void accessUserList(ArrayList<AllUser> userList) {
    // Implementation for accessing the list of all users
    System.out.println("List of all users:");
    for (AllUser user : userList) {
        System.out.println("ID: " + user.getId() +
                           ", Name: " + user.getName() +
                           ", Surname: " + user.getSurname() +
                           ", Username: " + user.getUsername() +
                           ", Email: " + user.getEmail() +
                           ", Gross Income: " + user.getgrossIncome());
    }
}


    public void removeUser(ArrayList<AllUser> userList, String username) {
    // Remove the user from the local list
    userList.removeIf(user -> user.getUsername().equals(username));
    System.out.println("User removed: " + username);

    // Update the database to reflect the user removal
    DatabaseWriter dbWriter = new DatabaseWriter();
    if (dbWriter.removeUser(username)) {
        System.out.println("User removed from the database: " + username);
    } else {
        System.out.println("Failed to remove user from the database: " + username);
    }
}
    
   

    public void reviewOperations() {
        // Implementation for reviewing operations
        System.out.println("Reviewing operations for admin: " + getUsername());
    }
    
    
}
