import java.sql.*;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
// instead of above ^? import java.sql.*;
//it automatically changed/updated as i kept going


public class App {
    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

//            Do a Select example

            Statement myStatement = connection.createStatement();
            ResultSet myResults = myStatement.executeQuery("SELECT * FROM albums");

            //            An insert example


//            An update example


//            A delete example

            while (myResults.next()) {
                System.out.println(myResults.getLong(1));


            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
