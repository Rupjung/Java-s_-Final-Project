package javaprofessional.com;
import java.util.*;


public  class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Texas marketplace!!!!");
        while (true) {
            Boolean flag = false;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter an option:");
            System.out.println("----1.Sign in");
            System.out.println("----2.Create an account");
            System.out.println("----3.Exit");
            String choice = input.nextLine();
            int rojai = Integer.parseInt(choice);
            switch (rojai) {
                case 1:
                    Login user = new Login();
                    if (user.getFlag()) {
                        break;
                    }
                    String email = user.getEmail();
                    Login.seller.put(user.getName(), user);
                    while (true) {
                        Boolean flag1 = false;
                        System.out.println("Choose an option: ");
                        System.out.println("----1.Post product");
                        System.out.println("----2.Display item");
                        System.out.println("----3.Buy item");
                        System.out.println("----4.Display history");
                        System.out.println("----5.Display income/expenditure ");
                        System.out.println("----6.Logout");
                        String choice1 = input.nextLine();

                        int rojai1 = Integer.parseInt(choice1);
                        switch (rojai1) {
                            case 1:
                                System.out.println("Choose a category\n---1.Electronics\n---2.Book\n---3.Clothing");
                                String choice2 = input.nextLine();
                                int rojai2 = Integer.parseInt(choice2);
                                switch (rojai2) {
                                    case 1:
                                        PostProducts post1 = new PostProducts(user, Categories.ELECTRONICS);
                                        break;
                                    case 2:
                                        PostProducts post2 = new PostProducts(user, Categories.BOOKS);
                                        break;
                                    case 3:
                                        PostProducts post3 = new PostProducts(user, Categories.CLOTHING);
                                        break;
                                }
                                break;
                            case 2:
                                Displayitem display = new Displayitem(user);
                                display.DisplayProductList();
                                break;
                            case 3:
                                while (true) {
                                    Boolean flag2 = true;
                                    System.out.print("Enter the seller from whom you want to buy product:  ");
                                    String seller = input.nextLine();
                                    if (seller.equalsIgnoreCase(user.getName())) {
                                        System.out.println("You cannot buy your own product.");
                                        break;
                                    }
                                    System.out.print("Enter the category(ELECTRONICS, CLOTHING or BOOKS):  ");
                                    String category = input.nextLine();
                                    category = category.toUpperCase();
                                    System.out.print("Enter the product you want to buy:  ");
                                    String product = input.nextLine();
                                    Boolean flag3=true;
                                    for (HashMap.Entry<String, List> entry1 : Login.registeredUser.entrySet()) {
                                        String key = entry1.getKey();
                                        String salesman = String.valueOf(Login.registeredUser.get(key).get(2));
                                        if (salesman.equalsIgnoreCase(seller)) {
                                            flag3=false;
                                            switch (category) {
                                                case "ELECTRONICS":
                                                    Buy buy1 = new Buy(Login.seller.get(seller), Categories.ELECTRONICS, product);
                                                    buy1.Buying(user, product);
                                                    break;
                                                case "CLOTHING":
                                                    Buy buy2 = new Buy(Login.seller.get(seller), Categories.CLOTHING, product);
                                                    buy2.Buying(user, product);
                                                    break;
                                                case "BOOKS":
                                                    Buy buy3 = new Buy(Login.seller.get(seller), Categories.BOOKS, product);
                                                    buy3.Buying(user, product);
                                                    break;
                                                default:
                                                    System.out.println("Invalid category");
                                                    flag2 = false;
                                            }


                                        }

                                    }

                                    if (flag3) {
                                        System.out.println("Couldn't find the seller");
                                        continue;
                                    }
                                    if (flag2) break;
                                }

                                break;

                            case 4:
                                UserProfile display_history = new UserProfile(user);
                                display_history.displayHistory();
                                break;

                            case 5:
                                UserProfile displayIncomeExpense = new UserProfile(user);
                                displayIncomeExpense.displayIncomeExpense();
                                break;


                            case 6:
                                flag1=true;
                                break;
                        }
                        if (flag1) break;
                    }
                    break;

                case 2:
                    createAccount newUser = new createAccount();
                    main(null);
                    break;

                case 3:
                    flag = true;
                    break;
            }


            if (flag) break;
        }
    }
}
