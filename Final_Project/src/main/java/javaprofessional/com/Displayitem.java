package javaprofessional.com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Displayitem {
    private Login User;
    static Integer i=1;

    Displayitem(Login  user){
        this.User= user;
    }
    public void DisplayProductList()  {
       for(HashMap.Entry<String, HashMap<Categories, ArrayList>> entry: PostProducts.sellingid.entrySet()){
           String key = entry.getKey();
           if (!key.equals(this.User.getName())) {
               HashMap<Categories, ArrayList> value = entry.getValue();
               for (HashMap.Entry<Categories, ArrayList> entry1 : value.entrySet()) {
                   Categories key1 = entry1.getKey();
                   ArrayList value1 = entry1.getValue();
                   Iterator<String> iterator = value1.iterator();

                       while (iterator.hasNext()) {

                           String item = iterator.next();
                           System.out.println("\n\n"+i+"."+item + " posted by " + key + " at Rs." +
                                   PostProducts.productPrice.get(item) + " under category " + key1);
                           System.out.println("---Product description:\n   "
                                   + PostProducts.productDescription.get(item)+"\n\n");
                           i++;
                       }

               }
           }
       }
    }

}

