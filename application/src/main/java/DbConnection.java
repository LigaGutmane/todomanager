import java.sql.*;

public class DbConnection {

    static Connection getConnection() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/data_for_final_project", "root", "rootroot");
            return connection;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
