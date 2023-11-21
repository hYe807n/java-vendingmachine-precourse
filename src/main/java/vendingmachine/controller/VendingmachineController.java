package vendingmachine.controller;

import vendingmachine.exception.Validation;
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
        purchase(this.products, user.getMoney());
    }

    private void purchase(Products products, int balance) {
        while (products.checkSoldOut()) {
            OutputView.printBalance(balance);
            String purchaseProduct = InputView.readPurchaseProduct();
            balance = products.purchase(purchaseProduct, balance);
        }
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
