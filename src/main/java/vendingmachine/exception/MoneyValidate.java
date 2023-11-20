package vendingmachine.exception;

import vendingmachine.enums.Exception;

public class MoneyValidate {

    public static String numberForm = "^[0-9]*";

    public static void composeOnlyNumber(String number) {
        if (number.matches(numberForm)) {
            throw new IllegalArgumentException(Exception.MONEY_FORM.getMessage());
        }
    }
}
