package vendingmachine.exception;

import static vendingmachine.enums.Exception.*;


public class MoneyValidate {

    public static String numberForm = "^[0-9]*";
    public static int minimumMoney = 100;

    public static void composeOnlyNumber(String number) {
        if (!number.matches(numberForm)) {
            throw new IllegalArgumentException(MONEY_FORM.getMessage());
        }
    }

    public static void checkRange(String number) {
        if (Integer.parseInt(number) < minimumMoney) {
            throw new IllegalArgumentException(MONEY_MINIMUM.getMessage());
        }
    }
}
