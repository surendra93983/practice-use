import java.util.*;

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return id + ". " + name + " - $" + price;
    }
}

class ShoppingCart {
    List<Product> cart = new ArrayList<>();

    public void addProduct(Product product) {
        cart.add(product);
        System.out.println(product.name + " added to cart.");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\nYour Cart:");
        double total = 0;
        for (Product p : cart) {
            System.out.println(p);
            total += p.price;
        }
        System.out.println("Total: $" + total);
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add products before checkout.");
            return;
        }
        viewCart();
        System.out.println("Checkout complete! Thank you for shopping.");
        cart.clear();
    }
}

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 800.00),
            new Product(2, "Smartphone", 500.00),
            new Product(3, "Headphones", 50.00),
            new Product(4, "Smartwatch", 200.00)
        );

        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\nE-Commerce Store:");
            for (Product p : products) {
                System.out.println(p);
            }
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= products.size()) {
                cart.addProduct(products.get(choice - 1));
            } else if (choice == 5) {
                cart.viewCart();
            } else if (choice == 6) {
                cart.checkout();
            } else if (choice == 7) {
                System.out.println("Exiting... Thank you for visiting!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
