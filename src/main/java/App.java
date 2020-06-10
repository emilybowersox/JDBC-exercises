import java.sql.DriverManager;
import java.sql.SQLException;
// instead of above ^? import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class App {
    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );











        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
