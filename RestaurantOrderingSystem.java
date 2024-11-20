import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    String itemName;
    double price;
    String category;

    public MenuItem(String itemName, double price, String category) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public String getItemDetails() {
        return "Item: " + itemName + "\t" + price + "\tCategory: " + category;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

class CustomerOrder {
    String customerName;
    ArrayList<MenuItem> orderedItems = new ArrayList<MenuItem>();
    double tipPercentage;
    double taxRate;
    double t_price;
    ArrayList<Integer> itemNumber = new ArrayList<Integer>();

    public CustomerOrder() {
        tipPercentage = 0.2;
        taxRate = 0.16;
    }

    public void addItem(MenuItem item) {
        orderedItems.add(item);
    }

    public double calculateTotal() {
        for (int i = 0; i < orderedItems.size(); i++) {
            t_price += orderedItems.get(i).price * (1 + tipPercentage + taxRate);
        }
        return t_price;
    }

    public void getOrderDetails() {
        double subtotal = orderedItems.get(0).price;
        System.out.println("\nCustomer: " + customerName + "\nOrdered Items: ");
        System.out.println(orderedItems.get(0).getItemDetails() + "\tQuantity: " + itemNumber.get(0) + "\tPrice: "
                + orderedItems.get(0).price * itemNumber.get(0));
        for (int i = 1, j = 1; i < orderedItems.size(); i++) {

            if (!orderedItems.get(i).itemName.equals(orderedItems.get(i - 1).itemName)) {
                System.out.println(orderedItems.get(i).getItemDetails() + "\tQuantity: " + itemNumber.get(j)
                        + "\tPrice: " + orderedItems.get(i).price * itemNumber.get(j));
                j++;
            }
            subtotal += orderedItems.get(i).price;
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t    -----------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t       " + subtotal);
        System.out.println("\t\t\t\t\t\t\t\t\t\t    -----------");
        System.out.println("\nTotal Price(including tax&tips): " + (int) calculateTotal() + "\n");
    }
}

public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
        MenuItem m1 = new MenuItem("Pav Baji           ", 15, "Snack      ");
        MenuItem m2 = new MenuItem("Samosa             ", 25, "Snack      ");
        MenuItem m3 = new MenuItem("Rasam rice         ", 35, "Main Course");
        MenuItem m7 = new MenuItem("Pista ice cream    ", 20, "Desert     ");
        MenuItem m4 = new MenuItem("Masal Dosa         ", 45, "Main Course");
        MenuItem m8 = new MenuItem("Chocolate Ice cream", 15, "Desert     ");
        MenuItem m5 = new MenuItem("Rice bath          ", 35, "Main Course");
        MenuItem m6 = new MenuItem("Poori baji         ", 40, "Main Course");
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.add(m4);
        menu.add(m5);
        menu.add(m6);
        menu.add(m7);
        menu.add(m8);
        System.out.println("Enter 1: " + m1.getItemDetails() + "\n" + "Enter 2: " + m2.getItemDetails() + "\n"
                + "Enter 3: " + m3.getItemDetails() + "\n"
                + "Enter 4: " + m4.getItemDetails() + "\n" + "Enter 5: " + m5.getItemDetails() + "\n" + "Enter 6: "
                + m6.getItemDetails() + "\n"
                + "Enter 7: " + m7.getItemDetails() + "\n" + "Enter 8: " + m8.getItemDetails() + "\n");
        ArrayList<CustomerOrder> customer = new ArrayList<CustomerOrder>();
        int k = 0;
        while (k < 10) {
            CustomerOrder c1 = new CustomerOrder();
            System.out.println("Enter the item number followed by number of each item(0 0 to exit the menu): ");
            int m = sc.nextInt();
            int n = sc.nextInt();
            ArrayList<Integer> num = new ArrayList<Integer>();
            while (m != 0 && n != 0) {
                num.add(n);
                for (int i = 0; i < n; i++) {
                    c1.addItem(menu.get(m - 1));
                }
                m = sc.nextInt();
                n = sc.nextInt();
            }
            if (num.size() == 0) {
                num.add(0);
            }
            if (num.get(0) != 0) {
                System.out.println("Please enter your name & tip percentage for our service");
                String customerName = sc.next();
                double tipPercentage = sc.nextDouble();
                c1.customerName = customerName;
                c1.tipPercentage = tipPercentage;
                c1.itemNumber = num;
                c1.getOrderDetails();
                customer.add(c1);
            }
            k++;
        }
        for (int i = 0; i < customer.size(); i++) {
            customer.get(i).getOrderDetails();
        }
        sc.close();
    }
}
