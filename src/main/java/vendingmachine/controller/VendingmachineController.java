package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingmachineController {
    public void run() {
        initializeMachineMoney();
    }

    private void initializeMachineMoney() {
        InputView.readMachineProperty();
    }
}
