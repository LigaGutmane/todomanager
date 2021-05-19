import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Application {

    // TODO: 17.05.2021 need to add new user into DB and create arrayList of users
    // TODO: 17.05.2021 need to connect DB
    // TODO: 19.05.2021 try reminder in sql - select event



    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Scanner scanner = new Scanner(System.in);

        User user = new User(1, "one", "firstUser@gmail.com", "firstUser");
        User user1 = new User(2, "two", "second@gmail.com", "secondUser");
        User user2 = new User(3, "Three", "3@gmail.com", "third");
        ArrayList userList = new ArrayList();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        //  user.insertUser(user); DB NOT CONNECTED

        System.out.println("All users" + userList);

        // EVENT REMINDER - need to be put in specific place in the common code.

        EventReminder eventReminder = new EventReminder();
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2021, Month.MAY, 21);
        eventReminder.setEvent1(Event.WORK);
        eventReminder.setUser(user);
        eventReminder.setTime(specificDate);
        eventReminder.setReminderTime(today);
        System.out.println(eventReminder);


        System.out.println("Welcome to our TO-DO manager");
        System.out.println("Please  choose : 1 - to register or 2 - to login: ");
        int selectOptionInput = scanner.nextInt();

        switch (selectOptionInput) {
            case 1:
                System.out.println("User selected to register - ");
                System.out.println("----------------------------");
                user.addNewUser(); //HOW GET FROM SCANNER INFO INTO DB OR ARRAYLIST/ HOW TO CREATE OBJECT FROM SCANNER INPUT


                break;

            case 2:
                System.out.println("User selected to Login-");
                System.out.println("________________________________");

                System.out.println("Please enter your email: ");
                String emailInput = scanner.next();
                System.out.println("Email input: " + emailInput);
                UserValidation userValidation = new UserValidation();
                boolean isEmailValid = userValidation.isEmailValid(emailInput, user);

                if (!isEmailValid) {
                    while (!emailInput.equalsIgnoreCase(user.email)) {
                        System.out.println("Try again: ");
                        emailInput = scanner.next();
                    }
                    isEmailValid = true;
                }
                if (isEmailValid) {
                    System.out.println("Please enter your password: ");
                    String passwordInput = scanner.next();
                    boolean isPasswordValid = userValidation.isPasswordValid(passwordInput, user);
                    if (!isPasswordValid) {
                        int count = 1;
                        do {
                            System.out.println("Enter your password again. You have: " + (4 - count) + " tries left");
                            passwordInput = scanner.next();
                            count++;
                        } while ((passwordInput.equalsIgnoreCase(user.password)) || count < 4);
                        System.out.println("End of attempts. Access denied!");
                    }
                    if (isPasswordValid) {
                        System.out.println("Welcome! Choose option: "); // HERE SHOULD GOES MENU OF OPTIONS FROM REGINA
                    }
                }
                break;
            default:
                System.out.println("Incorrect input");
        }










    }


}




















































