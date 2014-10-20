import com.thoughtworks.iamcoach.pos.CartItem;
import com.thoughtworks.iamcoach.pos.Pos;
import com.thoughtworks.iamcoach.pos.Scanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        pos.comparePrice(freeCartItems, halfCartItems, discountCartItems);

        print(pos);
    }

    private static void print(Pos pos) {
        System.out.println("**********************Let's Go**********************");

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("日期：" + format.format(date));

        System.out.print(creatItemPrint(pos));

        System.out.println("总计：");
        System.out.print("优惠前：" + pos.getSumPrice() + "    ");
        System.out.print("优惠后：" + (pos.getSumPrice() - pos.getPromotionPrice()) + "    ");
        System.out.print("优惠差价：" + pos.getPromotionPrice());
    }

    private static String creatItemPrint(Pos pos) {
        String result = "";
        ArrayList<CartItem> cartItems = pos.getCartItems();
        for (int i = 0; i < cartItems.size(); i++) {
            result += "名称：" + cartItems.get(i).getItem().getName() + ",";
            result += "数量：" + cartItems.get(i).getNum() + ",";
            result += "单价：" + cartItems.get(i).getItem().getPrice() + ",";
            result += "单位：" + cartItems.get(i).getItem().getUnit() + ",";
            result += "总计：" + cartItems.get(i).getSumPrice() + ",";
            result += "优惠金额：" + cartItems.get(i).getPromotionPrice() + "\n";
        }
        return result;
    }
}
