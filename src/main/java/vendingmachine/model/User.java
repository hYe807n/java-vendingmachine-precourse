package vendingmachine.model;

import vendingmachine.exception.Validation;

public class User {

    private final int money;

    public User(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    private void validate(String money) {
        Validation.composeOnlyNumber(money);
        Validation.checkMoneyDivide(money);
    }
}
