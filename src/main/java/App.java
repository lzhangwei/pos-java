import com.thoughtworks.iamcoach.pos.CartItem;
import com.thoughtworks.iamcoach.pos.Pos;
import com.thoughtworks.iamcoach.pos.Scanner;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static final String CART_FILE = "../resources/cart.txt";
    public static final String FREE_FILE = "../resources/buy_two_get_one_free_promotion.txt";
    public static final String HALF_FILE = "../resources/second_half_price_promotion.txt";
    public static final String DISCOUNT_FILE = "../resources/discount_promotion.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        List<String> cartItemBarcodes = scanner.readFile(CART_FILE);

        Pos pos = new Pos();
        pos.parseBarcode(cartItemBarcodes);

        List<String> freeItemBarcodes = scanner.readFile(FREE_FILE);
        ArrayList<CartItem> freeCartItems = pos.calFreePromotion(freeItemBarcodes);

        List<String> halfItemBarcodes = scanner.readFile(HALF_FILE);
        ArrayList<CartItem> halfCartItems = pos.calHalfPromotion(halfItemBarcodes);

        List<String> discountItemBarcodes = scanner.readFile(DISCOUNT_FILE);
        ArrayList<CartItem> discountCartItems = pos.calDiscountPromotion(discountItemBarcodes);

        pos.comparePrice(freeCartItems,halfCartItems,discountCartItems);

        print(pos);
    }

    private static void print(Pos pos) {
        
    }
}
