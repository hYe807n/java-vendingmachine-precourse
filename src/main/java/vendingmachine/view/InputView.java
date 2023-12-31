package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String readMachineProperty() {
        OutputView.printMachineProperty();
        return readLine().trim();
    }

    public static String readProductInform() {
        OutputView.printProduct();
        return readLine().trim();
    }

    public static String readUserProperty() {
        OutputView.printUserProperty();
        return readLine().trim();
    }

    public static String readPurchaseProduct() {
        OutputView.printPurchaseProduct();
        return readLine().trim();
    }
}
