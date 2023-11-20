package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.model.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {

    private Machine machine;
    private Products products;
    public void run() {
        initializeMachineMoney();
        printRandomCoins();
        initializeProduct();
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

    private void printRandomCoins() {
        OutputView.printMachineCoins();
        machine.getCoins().forEach(
            OutputView::printCoins
        );
    }

    private void initializeProduct() {
        try {
            String products = InputView.readProductInform();
            this.products = new Products(products);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            initializeProduct();
        }
    }
}
