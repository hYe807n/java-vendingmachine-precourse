package vendingmachine.exception;


import static vendingmachine.enums.Exception.MONEY_DIVIDE;
import static vendingmachine.enums.Exception.MONEY_FORM;
import static vendingmachine.enums.Exception.MONEY_MINIMUM;
import static vendingmachine.enums.Exception.PRODUCT_COUNT;
import static vendingmachine.enums.Exception.PRODUCT_FORM;

public class Validation {

    public static String NUMBER_FORM = "^[0-9]*";
    public static String NAME_FORM = "^[가-힣]*";
    public static String PRODUCTS_FORM = "^(\\[[가-힣]+,[0-9]+,[0-9]+\\]+)(;\\[[가-힣]+,[0-9]+,[0-9]+\\]+)*$";
    public static int MINIMUM_MONEY = 100;
    public static int MINIMUM_UNIT_MONEY = 10;

    public static void composeOnlyNumber(String number) {
        if (!number.matches(NUMBER_FORM)) {
            throw new IllegalArgumentException(MONEY_FORM.getMessage());
        }
    }

    public static void checkMoneyRange(String money) {
        if (Integer.parseInt(money) < MINIMUM_MONEY) {
            throw new IllegalArgumentException(MONEY_MINIMUM.getMessage());
        }
    }

    public static void checkMoneyDivide(String money) {
        if ((Integer.parseInt(money) % MINIMUM_UNIT_MONEY) != 0) {
            throw new IllegalArgumentException(MONEY_DIVIDE.getMessage());
        }
    }

    public static void checkProductForm(String products) {
        if (!products.matches(PRODUCTS_FORM)) {
            throw new IllegalArgumentException(PRODUCT_FORM.getMessage());
        }
    }

    public static void composeOnlyKorean(String productName) {
        if (!productName.matches(NAME_FORM)) {
            throw new IllegalArgumentException(PRODUCT_FORM.getMessage());
        }
    }

    public static void checkProductCount(String count)  {
        if (Integer.parseInt(count) < 1) {
            throw new IllegalArgumentException(PRODUCT_COUNT.getMessage());
        }
    }
}
