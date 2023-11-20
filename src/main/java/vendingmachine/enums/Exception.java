package vendingmachine.enums;

public enum Exception {
    HEADER("[ERROR] "),
    MONEY_FORM("금액은 숫자여야 합니다."),
    ;

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
