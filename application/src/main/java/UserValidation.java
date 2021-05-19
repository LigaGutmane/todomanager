import java.util.ArrayList;

public class UserValidation {


    //HOW TO VALIDATE ALL USERS FROM THE ARRAYLIST. FOR NOW VALIDATION IS ONLY FOR 'USER'

    boolean isEmailValid(String emailInput, User user) {
        if (emailInput.equalsIgnoreCase(user.email)) {
            System.out.println(emailInput + " User is recognized");
            return true;
        }
        System.out.println("Wrong email");
            return false;
        }

    boolean isPasswordValid(String passwordInput, User user) {
        if(passwordInput.equalsIgnoreCase(user.password)){
            System.out.println("Password is correct");
            return true;
        }
        System.out.println("Wrong password");
        return false;
    }




}