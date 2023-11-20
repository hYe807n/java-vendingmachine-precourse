package vendingmachine.enums;


public enum Form {
    MACHINE_PROPERTY_DEMAND("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_COIN_START("\n자판기가 보유한 동전"),
    FORM_COIN("%d원 - %d개"),
    PRODUCT_DEMAND("\n상품명과 가격, 수량을 입력해 주세요."),
    ;

    private final String message;

    Form(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
