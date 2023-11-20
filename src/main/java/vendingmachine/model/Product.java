package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import vendingmachine.exception.Validation;

public class Product {

    static private final int INDEX_NAME = 0;
    static private final int INDEX_PRICE = 1;
    static private final int INDEX_COUNT = 2;

    private final String inform;

    public Product(String inform) {
        validate(Arrays.asList(inform.split(",")));
        this.inform = inform;
    }

    private void validate(List<String> inform) {
        Validation.composeOnlyKorean(inform.get(INDEX_NAME));

    }
}
