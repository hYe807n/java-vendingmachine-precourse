package vendingmachine.model;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserTest {

    private static Stream<Arguments> exceptionUserMoneyCase() {
        return Stream.of(
            Arguments.of("a", "숫자 이외 문자 포함으로 오류 처리"),
            Arguments.of("1111", "10 으로 나누어 떨어지지 않으므로 오류 처리")
        );
    }

    @DisplayName("투입 금액이 3000 원이라면 정상적으로 객체 생성")
    @Test
    void userCreateByMoney() {
        new User("3000");
    }

    @ParameterizedTest(name = "투입 금액이 {0} 원이라면 {1}")
    @MethodSource("exceptionUserMoneyCase")
    void exceptionUserMoney(String money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new User(money));
    }
}