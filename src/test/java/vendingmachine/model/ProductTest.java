package vendingmachine.model;


import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductTest {

    private static Stream<Arguments> exceptionProductInitial() {
        return Stream.of(
            Arguments.of("[cola1,1500,0]", "상품명 한글 외 문자 입력"),
            Arguments.of("[콜라,1500a,0]", "상품 금액에 숫자 외 문자 입력"),
            Arguments.of("[콜라,1500,1a]", "상품 개수에 숫자 외 문자 입력"),
            Arguments.of("[콜라,10,1]", "상품 금액이 100 원 미만"),
            Arguments.of("[콜라,1111,1]", "상품 금액이 10 으로 나누어떨어지지 않"),
            Arguments.of("[콜라,1000,0]", "상품 개수가 1 개 미만")
        );
    }

    @ParameterizedTest(name = "{0} product 가 입력되면, {1}으로 예외 발생")
    @MethodSource("exceptionProductInitial")
    void checkProductInform(String products, String description) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product(products));
    }

    @DisplayName("상품 잔고가 1이라면, false 반환")
    @Test
    void isCountNotZero() {
        Assertions.assertFalse(new Product("[콜라,1000,1]").isZeroCount());
    }

    @DisplayName("상품명 객체가 \"콜라\"이고, 구매 상품명이 \"콜라\"로 일치하면, true 반환")
    @Test
    void isSameProductCheck() {
        Assertions.assertTrue(new Product("[콜라,1000,1]").isZeroCount("콜라"));
    }
}