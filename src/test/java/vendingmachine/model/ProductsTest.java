package vendingmachine.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class ProductsTest {

    private static Stream<Arguments> exceptionBalanceCase() {
        return Stream.of(
            Arguments.of("[콜라,1500,0];[사이다,1000,5]", 500, false),
            Arguments.of("[콜라,1500,0];[사이다,1000,0]", 500, false),
            Arguments.of("[콜라,1500,0];[사이다,1000,0]", 500, false)
        );
    }

    @DisplayName("\"[콜라-1000-4];[사이다+900+1]\"를 판매상품으로 입력하면, 양식 불일치로 오류 처리")
    @Test
    void exceptionProductsForm() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Products("[콜라-1000-4];[사이다+900+1]"));
    }


    @Test
    void purchase() {
    }
}