package vendingmachine.enums;


public enum Form {
    MACHINE_PROPERTY_DEMAND("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_COIN_START("\n자판기가 보유한 동전"),
    COIN_FORM("%d원 - %d개"),
    PRODUCT_DEMAND("\n상품명과 가격, 수량을 입력해 주세요."),
    USER_PROPERTY_DEMAND("\n투입 금액을 입력해 주세요."),
    BALANCE("\n투입 금액: %d원"),
    USER_PURCHASE_DEMAND("구매할 상품명을 입력해 주세요."),
    RESULT_CHANGE("잔돈"),
    ;

    private final String message;

    Form(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
