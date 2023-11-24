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

    @DisplayName("인자가 최소 금액 100 원 미만이라면 IllegalArgumentException 발생")
    @Test
    void exceptionByOutOfMoneyRange() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
            Validation.checkMoneyRange("99"));
    }

    @DisplayName("인자의 금액이 10 원으로 나누어지지 않는다면 IllegalArgumentException 발생")
    @Test
    void exceptionByNotDivide() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
            Validation.checkMoneyDivide("1111"));
    }

    @DisplayName("인자로 받은 상품명, 상품 금액, 상품 개수 양식이 잘못되었다면 IllegalArgumentException 발생")
    @Test
    void exceptionByNotProductForm() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
            Validation.checkProductForm("[콜라-10000-2];[사이다-2200-4]"));
    }
}