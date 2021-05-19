import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Application {

    // TODO: 17.05.2021 need to add new user into DB and create arrayList of users
    // TODO: 17.05.2021 need to connect DB
    // TODO: 19.05.2021 try reminder in sql - select event



    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        UserMapper userMapper = new UserMapper();

        User user = new User(1, "one", "firstUser@gmail.com", "firstUser");
        User user1 = new User(2, "two", "second@gmail.com", "secondUser");
        User user2 = new User(3, "Three", "3@gmail.com", "third");

        /*ArrayList userList = new ArrayList();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);

        userMapper.insertUser(user);
        userMapper.insertUser(user1);

        System.out.println("All users" + userList);*/


        System.out.println("Welcome to our TO-DO manager");
        System.out.println("Please  choose : 1 - to register or 2 - to login: ");
        int selectOptionInput = scanner.nextInt();

        switch (selectOptionInput) {
            case 1:
                System.out.println("User selected to register - ");
                System.out.println("----------------------------");
                userMapper.addNewUser();
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
                        System.out.println("Welcome! Choose option: ");
                    }




                    TodoList list = new TodoList(01, "make this project", "24/07/2021");
                    prinInfoOptions();
                    int choice = scanner.nextInt();


                    if(choice == 0){
                        System.out.println("Goodbye!");

                    } else if (choice == 1){
                        ItemAdd add = new ItemAdd();
                        System.out.println(add);

                    } else if (choice == 2){

                        System.out.println("Please select which item you want to delete: ");
                        System.out.println(list);
                        int deleteItem = scanner.nextInt();
                        System.out.println(deleteItem + " has been removed from the list!");
                    } else if (choice == 3) {
                        System.out.println("Please select which item you want to move to Doing list: ");
                        System.out.println(list);
                        int changeItem = scanner.nextInt();
                        System.out.println(changeItem + "has been moved to Doing list");
                    } else if (choice == 4){
                        System.out.println("Please select which item you want to move to Done list: ");
                        System.out.println(list);
                        int doneItem = scanner.nextInt();
                        System.out.println(doneItem + "has been moved to Done list");
                    } else if (choice == 5){
                        System.out.println("Full list: ");
                        System.out.println(list);
                    } else {
                        System.out.println("No option like this!");
                    }









                }
                break;
            default:
                System.out.println("Incorrect input");
        }

        EventReminder eventReminder = new EventReminder();
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2021, Month.MAY, 21);
        eventReminder.setEvent1(Event.WORK);
        eventReminder.setUser(user);
        eventReminder.setTime(specificDate);
        eventReminder.setReminderTime(today);
        System.out.println(eventReminder);



    }

    private static void prinInfoOptions() {
        System.out.println("----------------------");
        System.out.println("Welcome to main menu of Your TO-DO list");
        System.out.println("----------------------");
        System.out.println("0. Exit the program");
        System.out.println("1. Add item to list");
        System.out.println("2. Remove item from list");
        System.out.println("3. Update item from list to Doing");
        System.out.println("4. Update item from list to Done");
        System.out.println("5. Display to-do list");
        System.out.println();
        System.out.print("Enter choice: ");
    }


}




















































