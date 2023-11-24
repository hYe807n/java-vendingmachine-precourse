package vendingmachine.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MachineTest {

    @ParameterizedTest(name = "자판기 투입 금액이 {0} 원이라면, 숫자 이외 문자 포함/10원으로 나누어 떨어지지않음으로 예외 처리")
    @ValueSource(strings = {"a", "1111"})
    void getInitializeCoin(String money) {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Machine(money));
    }
}