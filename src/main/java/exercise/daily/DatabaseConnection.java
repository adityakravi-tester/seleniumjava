package exercise.daily;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatabaseConnection {
  
  public static void createConnection() throws SQLException, ClassNotFoundException {
    //Class.forName("com.mysql.jdbc.Driver");
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root@123");
    Statement createStatement = connect.createStatement();
    ResultSet query = createStatement.executeQuery("SELECT * FROM student");
    while(query.next()) {
      System.out.println(query.getString("name"));
    }
    connect.close();
  }
  
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    DatabaseConnection.createConnection();
  }
}
