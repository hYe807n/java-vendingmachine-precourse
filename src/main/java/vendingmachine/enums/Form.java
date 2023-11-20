package vendingmachine.enums;


public enum Form {
    PROPERTY_DEMAND("자판기가 보유하고 있는 금액을 입력해 주세요."),
    ;

    private final String message;

    Form(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
