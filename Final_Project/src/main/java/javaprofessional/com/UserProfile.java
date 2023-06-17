package javaprofessional.com;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class UserProfile {
    String user;
    private Float sum=0.0f;
    private Float total=0.0f;

    UserProfile(Login user) {
        this.user = user.getName();
    }

    public void displayHistory() {
        System.out.println("Your buying history:-");
        Iterator<String> iterator = Buy.getBoughtList(this.user).iterator();
        int i=1;
        if (iterator.hasNext())  {
            while (iterator.hasNext()) {
                String item = iterator.next();
                System.out.println(i + "." + item);
                i++;
            }


        }
        else { System.out.println("Oops!!! You haven't bought anything yet.");}
       System.out.println("Your selling history:-");
         Iterator<String>  iterator1 = Buy.getSoldList(this.user).iterator();
        int j = 1;
        if (iterator1.hasNext())  {
            while (iterator1.hasNext()) {
                String item1 = iterator1.next();
                System.out.println(j + "." + item1);
                j++;
            }
        }
        else{ System.out.println("Either you haven't posted any product or, your product hasn't been sold");}
    }

    public void displayIncomeExpense(){
        System.out.println("Your spending:-");
        Iterator<String> iterator = Buy.getBoughtList(this.user).iterator();
        int i=1;
        if (iterator.hasNext())  {
            while (iterator.hasNext()) {
                String item = iterator.next();
                System.out.println(i +". Rs."+PostProducts.productPrice.get(item)+" for "+item);
                sum=sum+ PostProducts.productPrice.get(item);
                i++;
            }
            System.out.println("Total =Rs."+sum);
        }
        else { System.out.println("Oops!!! You haven't bought anything yet.");}
        System.out.println("Your income:-");
        Iterator<String> iterator1 = Buy.getSoldList(this.user).iterator();
        int j = 1;
        if (iterator1.hasNext())  {
            while (iterator1.hasNext()) {
                String item1 = iterator1.next();
                System.out.println(i +". Rs."+PostProducts.productPrice.get(item1)+" for "+item1);
                total=total + PostProducts.productPrice.get(item1);
                j++;
            }
            System.out.println("Total =Rs."+total);
        }
        else{ System.out.println("Either you haven't posted any product or, your product hasn't been sold");}
    }

    }

