import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);
    Connection connection;


    int userId;
    String userName;
    String email;
    String password;

    public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void addNewUser() {
        System.out.printf("insert your name: ");
        String inputName = scanner.next();
        System.out.printf("insert your email: ");
        String inputMail = scanner.next();
        System.out.printf("insert your password: ");
        String inputPassword = scanner.next();
        System.out.println("New user: " + inputName + ", Email: " + inputMail + ", Password: " + inputPassword + " was created.");
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
        String sql = "INSERT INTO users (id, name, login, password) values (?, ?, ?)";
        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.executeUpdate();
    }

}



