package vendingmachine.enums;

public enum Exception {
    HEADER("[ERROR] "),
    MONEY_FORM("금액은 숫자여야 합니다."),
    MONEY_MINIMUM("금액은 100 원 이상이어야 가능합니다."),
    MONEY_DIVIDE("금액은 10 원 단위여야 합니다."),
    PRODUCT_FORM("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 합니다."),
    PRODUCT_COUNT("상품 가격은 1 개 이상이어야 합니다."),
    PRODUCT_NAME("상품명은 한글이어야 합니다."),
    ;

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
