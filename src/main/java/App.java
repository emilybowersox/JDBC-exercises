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


            Statement myStatement = connection.createStatement();

            //            Do a Select example
            ResultSet myResults = myStatement.executeQuery("SELECT * FROM albums");
            while (myResults.next()) {
                System.out.println(myResults.getLong(1));
            }

            //            An insert example
            String aQuery = "INSERT into albums (artist, name, release_date, genre, sales) VALUES ('Arcade Fire', 'The Suburbs', 2009, 'Alt', 10.1)";
            myStatement.executeUpdate(aQuery, Statement.RETURN_GENERATED_KEYS);
            myResults = myStatement.getGeneratedKeys();

            if (myResults.next()) {
                System.out.println("The new record has been inserted! " + myResults.getLong(1));
            }

//            An update example


//            A delete example



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
