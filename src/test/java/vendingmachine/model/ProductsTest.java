package vendingmachine.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductsTest {

    private static Stream<Arguments> exceptionPurchaseCase() {
        return Stream.of(
            Arguments.of("[콜라,1500,1];[사이다,1000,5]", 500, false),
            Arguments.of("[콜라,1500,10];[사이다,1000,10]", 1500, true)
        );
    }

    @DisplayName("\"[콜라-1000-4];[사이다+900+1]\"를 판매상품으로 입력하면, 양식 불일치로 오류 처리")
    @Test
    void exceptionProductsForm() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Products("[콜라-1000-4];[사이다+900+1]"));
    }


    @ParameterizedTest(name = "{0}를 상품으로 입력하고 잔고가 {1}일 때, 구매 상태 {2} 반환")
    @MethodSource("exceptionPurchaseCase")
    void checkPurchaseState(String product, int balance, boolean state) {
        Products products = new Products(product);

        Assertions.assertEquals(products.checkPurchaseState(balance), state);
    }
}