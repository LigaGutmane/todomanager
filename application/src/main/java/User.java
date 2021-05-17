import java.util.Scanner;

public class User {

    public String tries;
    Scanner scanner = new Scanner(System.in);

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
        String userInputName = scanner.nextLine();
        System.out.printf("insert your email: ");
        String userInputMail = scanner.nextLine();
        System.out.printf("insert your password: ");
        String userInputPassword = scanner.nextLine();
    }

    void tries() { // correct or not ? why not used ?
        int numberOfTries = 3;
        for (int i = 0; i < 3; i++) {
            System.out.println(numberOfTries);
        }
    }

}

