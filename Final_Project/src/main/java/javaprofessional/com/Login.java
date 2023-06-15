package javaprofessional.com;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Login {
    Scanner input= new Scanner(System.in);
    private String email;
    private String password;
    public static HashMap<String, List> registeredUser = createAccount.getRegisteredUser();
    public static HashMap<String, Login> seller = new HashMap<>();

    private Boolean flag = false;
    Login()
    {
        while(true) {
            System.out.print("Enter your email: ");
            this.email = input.nextLine();
            System.out.print("Enter your password: ");
            this.password = input.nextLine();
            if (registeredUser.containsKey(email) && registeredUser.get(this.email).get(0).equals(password)) {
                System.out.println("Logging in as "+registeredUser.get(this.email).get(2)+"........");
                System.out.println("Logged in successfully.");
                break;
            } else {
                System.out.println("Log-in failed!");
                System.out.print("Do you want to continue?(Type yes to continue, else type other) ");
                String exiting=input.nextLine();
                if (exiting.equalsIgnoreCase("yes"))
                    continue;
                else {
                    flag=true;
                    break;
                }
            }
        }
    }
    public String getEmail()
    {
        return email;
    }

    public Boolean getFlag() {
        return flag;
    }

    public String getName(){
        String name =String.valueOf(registeredUser.get(this.email).get(2));
        return name;
    }


}
