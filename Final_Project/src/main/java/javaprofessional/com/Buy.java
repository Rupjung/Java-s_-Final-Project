package javaprofessional.com;
import java.util.Iterator;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buy extends PostProducts {
    private Login buyer;
    private Categories category;
    private Login seller;
    protected String product;
    public static HashMap<String, ArrayList<String>> soldproduct = new HashMap<>();
    public static HashMap<String, ArrayList<String>> boughtproduct = new HashMap<>();

    Buy(Login seller, Categories category, String product) {
        super(seller, category);
        this.seller=seller;
        this.category=category;
    }

    @Override
    protected boolean shouldPerformAdditionalInitialization() {
        return false;
    }

    public void Buying(Login buyer, String product) {
        this.buyer = buyer;
        this.product = product;
        Boolean flag = true;
        for (HashMap.Entry<String, HashMap<Categories, ArrayList>> entry : super.sellingid.entrySet()) {
            String key = entry.getKey();
            HashMap<Categories, ArrayList> value = entry.getValue();
            if (key.equalsIgnoreCase(this.seller.getName())) {
                for (HashMap.Entry<Categories, ArrayList> entry1 : value.entrySet()) {
                    Categories key1 = entry1.getKey();
                    if (key1.equals(this.category)) {
                        ArrayList value1 = entry1.getValue();
                        String itemToRemove = this.product;
                        Iterator<String> iterator = value1.iterator();
                        if (iterator.hasNext()) {
                            while (iterator.hasNext()) {
                                String item = iterator.next();
                                if (item.equals(itemToRemove)) {
                                    iterator.remove();
                                    flag = false;
                                    break;
                                }
                            }

                        }
                        if (flag) {
                            System.out.println("Couldn't find the item");
                            return;
                        } else {
                            value.put(key1, value1);
                            super.sellingid.put(key, value);
                            soldproduct.get(this.seller.getName()).add(this.product);
                            boughtproduct.get(this.buyer.getName()).add(this.product);;
                            System.out.println("You have bought " + this.product + " from " + this.seller.getName() + ".");
                        }break;
                    }
                }break;
            }

        }
    }



  public static ArrayList <String> getSoldList(String seller){
        ArrayList <String> soldlist= new ArrayList<>();
        soldlist=soldproduct.get(seller);
        return soldlist;
    }
    public static ArrayList <String> getBoughtList(String seller){
        ArrayList <String> boughtlist= new ArrayList<>();
        boughtlist=boughtproduct.get(seller);
        return boughtlist;
    }

}



