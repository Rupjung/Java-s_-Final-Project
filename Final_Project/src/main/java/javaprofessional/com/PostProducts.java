package javaprofessional.com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public  class PostProducts {
    private String product;
    private Categories category;
    private static ArrayList<String> productList = new ArrayList<>();
    private String seller;
    private Float price;
    private String description;
    public static HashMap<String, Float> productPrice = new HashMap<>();
    public static HashMap<String, String> productDescription = new HashMap<>();
    public static HashMap<String, HashMap<Categories, ArrayList>> sellingid = new HashMap<>();
    Scanner input = new Scanner(System.in);

    PostProducts(Login seller, Categories category) {
        this.seller = seller.getName();
        this.category = category;
        if (shouldPerformAdditionalInitialization()) {
            System.out.print("Enter a product: ");
            this.product = input.nextLine();
            System.out.print("Enter the price for the product(in Rs.): ");
            String pp = input.nextLine();
            this.price = Float.parseFloat(pp);
            productPrice.put(product, price);
            System.out.print("Enter a description for the product: ");
            this.description = input.nextLine();
            productDescription.put(product, description);
            setProductListByCategories();
            System.out.println("Product posted successfully......");
        }
    }

    protected boolean shouldPerformAdditionalInitialization() {
        return true;
    }


    public void setProductList() {
        this.productList.add(this.product);
    }

    public void setProductListByCategories() {
        if (this.category == Categories.BOOKS) {
            sellingid.get(this.seller).get(Categories.BOOKS).add(this.product);
        }
        else if (this.category == Categories.CLOTHING) {
            sellingid.get(this.seller).get(Categories.CLOTHING).add(this.product);
        }
        else if (this.category == Categories.ELECTRONICS) {
            sellingid.get(this.seller).get(Categories.ELECTRONICS).add(this.product);
        }
        setProductList();

    }
}
