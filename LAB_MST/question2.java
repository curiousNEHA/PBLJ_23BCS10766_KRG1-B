/**Question 4: HashMap and Exception Handling 
Write a Java program that uses a HashMap to store product IDs (String) and their prices 
(Double). Implement a method to apply a discount to a product's price based on a percentage 
input. Handle the following cases: 
1. Throw a custom exception if the product ID doesn't exist. 
2. Throw an IllegalArgumentException if the discount percentage is negative or greater 
than 100. 
3. Update the price in the HashMap after applying the discount. 
Expected Output Example: 
Adding products: P001=$50.0, P002=$100.0 
Applying 20% discount to P001... 
New price for P001: $40.0 
Applying 150% discount to P002... 
Error: Discount percentage must be between 0 and 100! 
Applying discount to P999... 
Error: Product ID not found!
**/
import java.util.HashMap;
import java.util.Map;

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

public class ProductDiscountProgram {
    private Map<String, Double> productMap = new HashMap<>();
    public void addProduct(String id, double price) {
        productMap.put(id, price);
    }

    public void applyDiscount(String id, double discountPercent) throws ProductNotFoundException {
        if (!productMap.containsKey(id)) {
            throw new ProductNotFoundException("Error: Product ID not found!");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Error: Discount percentage must be between 0 and 100!");
        }

        double oldPrice = productMap.get(id);
        double newPrice = oldPrice - (oldPrice * discountPercent / 100);
        productMap.put(id, newPrice);

        System.out.println("New price for " + id + ": $" + newPrice);
    }

    public void displayProducts() {
        System.out.println("Adding products: " + productMap);
    }
  
    public static void main(String[] args) {
        ProductDiscountProgram program = new ProductDiscountProgram();

        program.addProduct("P001", 50.0);
        program.addProduct("P002", 100.0);
        program.displayProducts();

        try {
            System.out.println("Applying 20% discount to P001...");
            program.applyDiscount("P001", 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Applying 150% discount to P002...");
            program.applyDiscount("P002", 150);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Applying discount to P999...");
            program.applyDiscount("P999", 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
