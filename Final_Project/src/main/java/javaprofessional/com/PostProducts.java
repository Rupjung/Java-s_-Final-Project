package javaprofessional.com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public  class PostProducts {
    private String product;
    private Categories category;
    private static ArrayList<String> productList = new ArrayList<>();
    protected static HashMap<Categories, ArrayList> productListByCategories = new HashMap<>();
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
            productListByCategories.put(category.ELECTRONICS, new ArrayList<>());
            productListByCategories.put(category.CLOTHING, new ArrayList<>());
            productListByCategories.put(category.BOOKS, new ArrayList<>());
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
        productListByCategories.get(this.category).add(this.product);
        sellingid.put(this.seller, this.productListByCategories);
        setProductList();
    }
}