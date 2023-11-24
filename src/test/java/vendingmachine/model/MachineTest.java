package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MachineTest {

    @ParameterizedTest(name = "자판기 투입 금액이 {0} 원이라면, 숫자 이외 문자 포함/10원으로 나누어 떨어지지않음으로 예외 처리")
    @ValueSource(strings = {"a", "1111"})
    void getInitializeCoin(String money) {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Machine(money));
    }

    @DisplayName("자판기 투입 금액이 760 원이라면, 각 동전을 최소 개수로 한 잔돈 반환")
    @Test
    void checkBalanceResult() {
        Map<Integer, Integer> resultCoin = new LinkedHashMap<>();
        resultCoin.put(500, 1);
        resultCoin.put(100, 2);
        resultCoin.put(50, 1);
        resultCoin.put(10, 1);

        Assertions.assertEquals(new Machine("1000000000").resultCoins(760), resultCoin);
    }
}