
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMapper {
    Scanner scanner = new Scanner(System.in);
    Connection connection = DbConnection.getConnection();

    public UserMapper() throws SQLException, ClassNotFoundException {
    }

    void addNewUser() throws SQLException, ClassNotFoundException {
        User user = new User();
        System.out.printf("insert your name: ");
        user.setUserName(scanner.next());
        System.out.printf("insert your email: ");
        user.setEmail(scanner.next());
        System.out.printf("insert your password: ");
        user.setPassword(scanner.next());
        System.out.println("New user: " + user.getUserName() + ", Email: " + user.getEmail() +
                ", Password: " + user.getPassword() + " was created.");
        insertUser(user);
        System.out.println("Now please login!");
    }

    List<User> userList () throws SQLException {


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from users");
        List<User> users = new ArrayList<User>();
        while (resultSet.next()){

            Integer userId = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String email = resultSet.getString("login");
            String password = resultSet.getString("password");
            User user = new User(userId, userName, email, password);
            users.add(user);
        }
        return users;
    }

    void insertUser (User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO users (name, login, password) values (?, ?, ?)";
        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.executeUpdate();
    }
}
