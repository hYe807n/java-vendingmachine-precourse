package vendingmachine.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @DisplayName("1 개부터 최대 동전 개수 10 개 중 랜덤 개수가 범위 안에 수를 반환")
    @Test
    void randomCoinCount() {
        Assertions.assertTrue(RandomGenerator.pickNumberCount(10) <= 10);
    }
}