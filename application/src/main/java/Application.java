import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to our TO-DO manager");
        System.out.println("Please register or login: ");


        Scanner scanner = new Scanner(System.in);

        User user = new User(123, "firstUser@gmail.com", "firstUser");

        System.out.println("Please enter your email: ");
        String emailInput = scanner.nextLine();

        UserValidation userValidation = new UserValidation();
        boolean isEmailValid = userValidation.isEmailValid(emailInput, user);

        if (!isEmailValid) {
            while (!emailInput.equalsIgnoreCase(user.email)) {
                System.out.println("Try again: ");
                emailInput = scanner.nextLine();
            }
        }
        if (isEmailValid) {
            System.out.println("Please enter your password: ");
            String passwordInput = scanner.nextLine();
            boolean isPasswordValid = userValidation.isPasswordValid(passwordInput, user);
            if (!isPasswordValid) {
                int count = 1;
                do {
                    System.out.println("Enter your password again. You have 3 tries left:"); // to make 3 tries changeable
                    passwordInput = scanner.nextLine();
                    count ++;
                } while ((passwordInput.equalsIgnoreCase(user.password)) || count < 4 );
            } if (isPasswordValid) {
                System.out.println("Welcome! Choose option: ");

            }
        }
    }
}
