import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;
public class Application {

    // TODO: 17.05.2021 need to add new user into DB
    // TODO: 17.05.2021 need to connect DB
    // TODO: 17.05.2021 left tries - about password check ?
    // TODO: 17.05.2021  why code is not running correctly
    // TODO: 17.05.2021 after login _create menu of options
    // TODO: 17.05.2021 for me - task remainder
    // TODO: 17.05.2021 where to build task table ? in console or in sql ?


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        User user = new User(1, "one", "firstUser@gmail.com", "firstUser");

        System.out.println("Welcome to our TO-DO manager");
        System.out.println("Please  choose : 1 - to register or 2 - to login: ");
        int selectOptionInput = scanner.nextInt();

        switch (selectOptionInput) {
            case 1:
                System.out.println("User selected to register - ");
                System.out.println("----------------------------");
                user.addNewUser();
                // here - need to add new user to the DB


                break;

            case 2:
                System.out.println("User selected to Login-");
                System.out.println("________________________________");

                System.out.println("Please enter your email: ");
                String emailInput = scanner.nextLine();
                System.out.println("Email input: " + emailInput);
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
                            System.out.println ("Enter your password again. You have" + user.tries + "tries left"); // to make count of tries changeable
                            passwordInput = scanner.nextLine();
                            count++;
                        } while ((passwordInput.equalsIgnoreCase(user.password)) || count < 4);
                    }
                    if (isPasswordValid) {
                        System.out.println("Welcome! Choose option: ");
                    }
                }
                break;
            default:
                System.out.println("Incorrect input");
        }


    }
}




















































