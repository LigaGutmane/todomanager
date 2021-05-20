import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    Connection connection = DbConnection.getConnection();

    public UserValidation() throws SQLException, ClassNotFoundException {
    }

    boolean isEmailValid(String emailInput )  throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from users WHERE login LIKE" + emailInput);
        while (resultSet.next()) {
            String existingUser = resultSet.getString("login");
            System.out.println("User is in the DB: " + emailInput);

            if (emailInput.equalsIgnoreCase(existingUser)) {
                System.out.println(emailInput + " - User is recognized");
                return true;
            }
        }
        System.out.println("Wrong email");
        return false;

}

   boolean isPasswordValid(String passwordInput, UserMapper userMapper) {
      if (passwordInput.equalsIgnoreCase(user.password) {
           System.out.println("Password is correct");
           return true;
        }
        System.out.println("Wrong password");
        return false;
    }


}