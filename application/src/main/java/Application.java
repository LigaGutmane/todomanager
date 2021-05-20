import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        UserMapper userMapper = new UserMapper();

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
                boolean isEmailValid = userValidation.isEmailValid( ); //? HOW TO CALL RESULTSET IN HERE);

                //// how to call here. While email will not be equals to any email in the DB continue with while Try again
                if (!isEmailValid) {
                    while (!emailInput.equalsIgnoreCase()) {
                        System.out.println("Try again: ");
                        emailInput = scanner.next();
                    }
                    isEmailValid = true;
                }
                // BUT HERE, WHEN EMAILINPUT = TO ANY FROM DB IT SHOULD ASKS TO INPUT PASS
                if (isEmailValid) {
                   System.out.println("Please enter your password: ");
                    String passwordInput = scanner.next();
                   boolean isPasswordValid = userValidation.isPasswordValid( ); ////? HOW TO CALL RESULTSET IN HERE);
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
                   }









                }
                break;
            default:
               System.out.println("Incorrect input");
        }

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




















































