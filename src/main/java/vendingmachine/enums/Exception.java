package vendingmachine.enums;

public enum Exception {
    HEADER("[ERROR] "),
    MONEY_FORM("금액은 숫자여야 합니다."),
    MONEY_MINIMUM("금액은 100 원 이상이어야 가능합니다."),
    MONEY_DIVIDE("금액은 10 원 단위여야 합니다."),
    ;

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
