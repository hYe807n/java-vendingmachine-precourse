package vendingmachine.model;

import vendingmachine.exception.MoneyValidate;

public class Machine {

    public Machine(String money) {
        MoneyValidate.composeOnlyNumber(money);
    }
}
