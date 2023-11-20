package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingmachineController {
    public void run() {
        initializeProperty();
    }

    private void initializeProperty() {
        InputView.readProperty();
    }
}
