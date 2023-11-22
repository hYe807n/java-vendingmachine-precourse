package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.model.Products;
import vendingmachine.model.User;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {

    private Machine machine;
    private Products products;
    private User user;

    public void run() {
        initializeMachineMoney();
        printRandomCoins();
        initializeProduct();
        initializeUserMoney();
        int balance = purchase(this.products, user.getMoney());
        changeResult(balance);
    }

    private void changeResult(int balance) {
        OutputView.printBalance(balance);
        OutputView.printResultChange();
        machine.resultCoins(balance).forEach(OutputView::printCoins);
    }

    private int purchase(Products products, int balance) {
        try {
            while (products.checkPurchaseState(balance)) {
                OutputView.printBalance(balance);
                balance = products.purchase(InputView.readPurchaseProduct(), balance);
            }
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            purchase(products, balance);
        }
        return balance;
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

    private void initializeUserMoney() {
        try {
            String money = InputView.readUserProperty();
            this.user = new User(money);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            initializeUserMoney();
        }
    }
}
