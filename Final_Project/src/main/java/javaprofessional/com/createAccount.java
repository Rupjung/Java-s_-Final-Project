package javaprofessional.com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.*;
public class createAccount {

    private static Integer userId=0;
    private String email;
    private String userName;
    private Long number;
    private String address;
    private String password;
    Scanner input = new Scanner(System.in);

    private static HashMap<String, List> registeredUser= new HashMap<>();

    createAccount(){
        setUserName();
        setNumber();
        setAddress();
        setEmail();
        setPassword();


        userId++;
        List<Object> list = new ArrayList<>();
        list.add(this.password);
        list.add(userId);
        list.add(this.userName);
        list.add(this.address);
        list.add(this.number);
        registeredUser.put(this.email, list);
        System.out.println("Account created successfully.....");

    }

    public void setEmail() {
        System.out.print("Enter your email: ");
        this.email= input.nextLine();
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName() {

        System.out.print("Enter your name: ");
        this.userName= input.nextLine();
    }

    public Long getPhoneNumber() {
        return number;

    }

    public void setNumber() {
        System.out.print("Enter your mobile number: ");
        String num= input.nextLine();
        this.number= Long.parseLong(num);

    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        System.out.print("Enter your address: ");
        this.address= input.nextLine();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {

        System.out.print("Create new password: ");
        this.password= input.nextLine();
        while(true)
        {
            System.out.print("Please confirm your password: ");
            String confirmedPassword = input.nextLine();
            if (Objects.equals(this.password, confirmedPassword))
                break;
            else {System.out.println("Password didn't match with the above. Enter again.");}
        }
    }

    public static Integer getUserId() {
        return userId;
    }

    public static HashMap<String, List> getRegisteredUser() {
        return registeredUser;
    }
}
