package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String readProperty() {
        OutputView.printProperty();
        return readLine();
    }
}
