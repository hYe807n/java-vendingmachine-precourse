package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {
    public void run() {
        initializeMachineMoney();
    }

    private void initializeMachineMoney() {
        try {
            String money = InputView.readMachineProperty();
            Machine machine = new Machine(money);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            initializeMachineMoney();
        }
    }
}
