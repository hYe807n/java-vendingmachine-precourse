package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {

    private Machine machine;
    public void run() {
        initializeMachineMoney();

    }

    private void initializeMachineMoney() {
        try {
            String money = InputView.readMachineProperty();
            this.machine = new Machine(money);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            initializeMachineMoney();
        }
    }

    private void initializeCoins() {
        OutputView.printMachineCoins();
        machine.getCoins().forEach(
            OutputView::printCoins
        );
    }
}
