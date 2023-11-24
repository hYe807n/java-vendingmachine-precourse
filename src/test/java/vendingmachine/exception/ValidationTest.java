package vendingmachine.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @DisplayName("인자에 숫자 이외의 문자가 포함되어있다면 IllegalArgumentException 발생")
    @Test
    void exceptionByContainsString() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
            Validation.composeOnlyNumber("12a"));
    }

    @DisplayName("인자가 최소 금액 100 원 미만이라면  IllegalArgumentException 발생")
    @Test
    void exceptionByOutOfMoneyRange() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
            Validation.checkMoneyRange("99"));
    }

    @Test
    void checkMoneyDivide() {
    }

    @Test
    void checkProductForm() {
    }

    @Test
    void composeOnlyKorean() {
    }

    @Test
    void checkProductCount() {
    }

    @Test
    void noneExistPurchaseProduct() {
    }

    @Test
    void deficiencyPurchaseBalance() {
    }

    @Test
    void zeroCountProduct() {
    }
}