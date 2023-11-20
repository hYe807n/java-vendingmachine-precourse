package vendingmachine.view;

import java.util.StringJoiner;
import vendingmachine.enums.Exception;
import vendingmachine.enums.Form;

public class OutputView {

    public static void printMachineProperty() {
        System.out.println(Form.MACHINE_PROPERTY_DEMAND.getMessage());
    }

    public static void printException(String message) {
        System.out.println(new StringJoiner("", Exception.HEADER.getMessage(), message));
    }

    public static void printMachineCoins() {
        System.out.println(Form.MACHINE_COIN_START.getMessage());
    }

    public static void printCoins(int unit, int count) {
        System.out.println(String.format(Form.COIN_FORM.getMessage(), unit, count));
    }

    public static void printProduct() {
        System.out.println(Form.PRODUCT_DEMAND.getMessage());
    }

    public static void printUserProperty() {
        System.out.println(Form.USER_PROPERTY_DEMAND.getMessage());
    }

    public static void printBalance(int money) {
        System.out.println(String.format(Form.BALANCE.getMessage(), money));
    }
}
