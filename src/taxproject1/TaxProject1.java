/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author castr
 *  * GitHub link: https://github.com/2022207/TaxProject1
 * Group Member 1 Name: Suelen Rocha
 * Group Member 1 Student Number: 2022345
 * Group Member 2 Name: Carolina Azevedo de Castro
 * Group Member 2 Student Number: 2022207
 * 
 * 
 * 
 */





package taxproject1;


import Database.DatabaseSetup;
import Database.DatabaseWriter;
import Entities.Admin;
import Entities.AllUser;
import Entities.RegularUser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class TaxProject1 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO code application logic here
        
        
        
    // Creating an admin webpage
    Admin admin = new Admin(1, "Mary", "Christmas", "CCT", "noel@cct.ie", "Dublin", 100000);
       
    // Creating an ArrayList to store user objects (instances of AllUser class)
    ArrayList<AllUser> userList = new ArrayList<>();
        
    // Printing the current ID from the AllUser class  
    System.out.println(AllUser.getCurrentID());
    
    // Try to set up the database and check it it is created or not
    try {
    if (DatabaseSetup.setupDB()) {
    System.out.println("Database and table created");
    } else {
    System.out.println("Oh no! There was a database creation problem...");
     }
    
    // Creating a Scanner object to read input
    Scanner scanner = new Scanner(System.in);
        
    // Give the user a selection of options and give option to Login or Create Account
    System.out.println("Welcome to the Tax System!");
    System.out.println("1. Login");
    System.out.println("2. Create new account");
    System.out.print("Choose an option: ");

    // Use a switch statement to perform actions based on the user's choice
    int choice = scanner.nextInt();

            switch (choice) {
                
                // Call the loginUser method for option 1
                case 1: 
                    loginUser(scanner, admin, userList);
                    break;
                    
                    // Call the createAccount method for option 2
                case 2:
                    createAccount(scanner, userList);
                    break;
                    
                    // Call the adminMenu method for option 3
                    case 3:
                    adminMenu(scanner, admin, userList);
                     break;
                     
                   // Display a message for an invalid option and exit
                default:
                    System.out.println("Invalid option. Exiting...");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method for user login to enter username and password
    private static void loginUser(Scanner scanner, Admin admin, ArrayList<AllUser> userList) throws SQLException {
        System.out.println("Login:");

        System.out.print("Username: ");
        String username = scanner.next();
        
        System.out.print("Password: ");
        String password = scanner.next();
        
        
     // Check credentials is from Admin
    if (username.equals("CCT") && password.equals("Dublin")) {
        System.out.println("Admin login successful!");
        adminMenu(scanner, admin, userList); 
        
    } else {
        
        // The entered credentials are not for the admin, check regular users
        boolean userFound = false;
        for (AllUser user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                userFound = true;
                System.out.println("User login successful!");
                if (user instanceof Admin) {
            adminMenu(scanner, (Admin) user, userList); // Admin menu for admin user
             } else if (user instanceof RegularUser) {
                regularUserMenu(scanner, (RegularUser) user, userList); // Regular user menu for regular user
          

                }
                break;
            }
        }
              
         // If no matching user is found, display an error message
        if (!userFound) {
              System.out.println("Invalid username or password. Exiting...");
        }
    }
    }
           
    
    // Method to display the admin menu
    private static void adminMenu(Scanner scanner, Admin admin, ArrayList<AllUser> userList) {
    
        // Use a loop to keep the admin menu active until the user chooses to logout
    while (true) {
        System.out.println("Admin Menu:");
        System.out.println("1. Modify Admin Profile");
        System.out.println("2. Access User List");
        System.out.println("3. Remove User");
        System.out.println("4. Review Operations");
        System.out.println("5. Logout");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
   //options to Admin list
        switch (choice) {
            case 1:
                admin.modifyProfile();
                break;
            case 2:
                admin.accessUserList(userList);
                
                break;
            case 3:
                System.out.print("Enter the Username of the user to remove: ");
                String removeUser = scanner.next();
                admin.removeUser(userList, removeUser);
                break;
            case 4:
                admin.reviewOperations();
                break;
            case 5:
                System.out.println("Logout successful!");
                return;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}
    // Method to create a new user account
        private static void createAccount(Scanner scanner, ArrayList<AllUser> userList) throws SQLException {
        
        
            System.out.println("Create new account:");
            
      // Input the user to enter account details
           System.out.print("Name: ");
           String name = scanner.next();
           scanner.nextLine();
            

            System.out.print("Surname: ");
            String surname = scanner.nextLine();
            
              System.out.print("Username: ");
            String username =   scanner.nextLine();
  
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
             System.out.print("password: ");
            String password = scanner.nextLine();
            
             System.out.print("grossIncome: ");
             double grossIncome = scanner.nextDouble();
             
           // Create a new user instance and add it to the user list
            AllUser newUser = new AllUser(name, surname, username, email, password, grossIncome);
             userList.add(newUser); 
            
            System.out.println("User ID: " + newUser.getId());
            
            
            // Write the new user to the database
            DatabaseWriter dbWriter = new DatabaseWriter();
            if (dbWriter.addAllUser(newUser)) {
                System.out.println("User added to the database");
            } else {
                System.out.println("Failed to add user to the database");
            }
            
            
    // Display user information and tax calculations
    System.out.println("User ID: " + newUser.getId());
    System.out.println("PAYE: " + newUser.calculatePAYE());
    System.out.println("USC: " + newUser.calculateUSC());
    System.out.println("PRSI: " + newUser.calculatePRSI());

            
    }
     // Method to regular user menu
 private static void regularUserMenu(Scanner scanner, RegularUser regularUser, ArrayList<AllUser> userList) {
    while (true) {
        
        
        System.out.println("Regular User Menu:");
        System.out.println("1. Modify Profile");
        System.out.println("2. Save and See Equations");
        System.out.println("3. Logout");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
       // Switch to regular user menu options
        switch (choice) {
            case 1:
                regularUser.modifyProfile();
                break;
            case 2:
                regularUser.saveAndSeeEquations();
                break;
            case 3:
                System.out.println("Logout successful!");
                return;  // This will exit the regularUserMenu method
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

        
      // Additional methods with placeholder code  
    private static void createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void adminLogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void adminMenu(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
