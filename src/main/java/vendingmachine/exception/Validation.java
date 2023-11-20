package vendingmachine.exception;


import static vendingmachine.enums.Exception.MONEY_DIVIDE;
import static vendingmachine.enums.Exception.MONEY_FORM;
import static vendingmachine.enums.Exception.MONEY_MINIMUM;
import static vendingmachine.enums.Exception.PRODUCT_FORM;

public class Validation {

    public static String NUMBER_FORM = "^[0-9]*";
    public static String NAME_FORM = "^[가-힣]*";
    public static String PRODUCTS_FORM = "^(\\[[가-힣]+,[0-9]+,[0-9]+\\]+)(;\\[[가-힣]+,[0-9]+,[0-9]+\\]+)*$";
    public static int minimumMoney = 100;
    public static int moneyUnit = 10;

    public static void composeOnlyNumber(String number) {
        if (!number.matches(NUMBER_FORM)) {
            throw new IllegalArgumentException(MONEY_FORM.getMessage());
        }
    }

    public static void checkMoneyRange(String number) {
        if (Integer.parseInt(number) < minimumMoney) {
            throw new IllegalArgumentException(MONEY_MINIMUM.getMessage());
        }
    }

    public static void checkMoneyDivide(String number) {
        if ((Integer.parseInt(number) % moneyUnit) != 0) {
            throw new IllegalArgumentException(MONEY_DIVIDE.getMessage());
        }
    }

    public static void checkProductForm(String products) {
        if (!products.matches(PRODUCTS_FORM)) {
            throw new IllegalArgumentException(PRODUCT_FORM.getMessage());
        }
    }

    public static void composeOnlyKorean(String product) {
        if (!product.matches(NAME_FORM)) {
            throw new IllegalArgumentException(PRODUCT_FORM.getMessage());
        }
    }
}
