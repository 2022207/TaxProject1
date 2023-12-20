/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author castr
 */
public class DatabaseSetup  extends Database {
   
     

    // Method to set up the database and create table
    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
         // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
             try (
                 //connection to the database
                 Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                     
              //statement for executing SQL queries
                Statement stmt = conn.createStatement() ;
            ){
                 
        // Execute SQL queries to create the database and table
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            stmt.execute("USE " + DB_NAME + ";");
            String sql = 
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "  ("
                    + "id INT(10)PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(255),"
                    + "surname VARCHAR(255),"
                    + "username VARCHAR(255),"
                    + "email VARCHAR(255),"
                    + "password VARCHAR(255),"
                    + "grossIncome DOUBLE"
                    + ");";
            stmt.execute(sql);
            
            // Return true to indicate successful database setup
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    
    }

