package vendingmachine.model;

import vendingmachine.exception.MoneyValidate;

public class Machine {

    public Machine(String money) {
        validate(money);
    }

    private void validate(String money) {
        MoneyValidate.composeOnlyNumber(money);
        MoneyValidate.checkRange(money);
        MoneyValidate.checkDivide(money);
    }
}
