package vendingmachine;

/**
 * Belirtilen slot'ta ürün bulunamadığında fırlatılır.
 */
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
