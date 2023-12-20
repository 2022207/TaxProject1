/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Entities.AllUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.List;

/**
 *
 * @author castr
 */
public class DatabaseWriter extends Database {

    
    
    public boolean addAllUser(AllUser allUser) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
        ) {
            String sql = String.format("INSERT INTO %s (name, surname, username, email, password, grossIncome) VALUES ('%s', '%s', '%s', '%s', '%s', %.2f);",
                     TABLE_NAME,allUser.getName(), allUser.getSurname(), allUser.getUsername(),  allUser.getEmail(), allUser.getPassword(), allUser.getgrossIncome());
           
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        
   

    public boolean removeUser(String username) {
        try (Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
             stmt.execute("USE " + DB_NAME + ";");
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE username = '" + username + "';";
            int rowsAffected = stmt.executeUpdate(sql);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        
        
        
    
}
