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
}
