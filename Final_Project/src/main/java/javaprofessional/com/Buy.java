package javaprofessional.com;
import java.util.Iterator;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buy extends PostProducts {
    private Login buyer;
    private Login seller;
    protected String product;
    private static HashMap<String, ArrayList> soldproduct = new HashMap<>();
    private static HashMap<String, ArrayList> boughtproduct = new HashMap<>();
    private Float price;

    Buy(Login seller, Categories category, String product) {
        super(seller, category);
        this.seller = seller;
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
            if (key.equalsIgnoreCase(this.seller.getName())) {
                HashMap<Categories, ArrayList> value = entry.getValue();
                for (HashMap.Entry<Categories, ArrayList> entry1 : value.entrySet()) {

                    Categories key1 = entry1.getKey();
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
                    if (!flag) {
                        value.put(key1, value1);
                        break;
                    }
                }
                if (!flag) {
                    super.sellingid.put(key, value);
                    break;
                }
                if (flag) {
                    System.out.println("Couldn't find the item.");
                    return;
                }
                soldproduct.get(this.seller.getName()).add(this.product);
                boughtproduct.get(this.buyer.getName()).add(this.product);
                System.out.println("You have bought " + this.product + " from " + this.seller.getName() + ".");
            }

        }
    }


   public static HashMap<String, ArrayList> getSoldproduct() {
        return soldproduct;
    }

    public static HashMap<String, ArrayList> getBoughtproduct() {
        return boughtproduct;
    }

}



