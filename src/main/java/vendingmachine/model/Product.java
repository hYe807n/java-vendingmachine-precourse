package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import vendingmachine.exception.Validation;

public class Product {

    static private final int INDEX_NAME = 0;
    static private final int INDEX_PRICE = 1;
    static private final int INDEX_COUNT = 2;

    private final String name;
    private final int price;
    private final int count;

    public Product(String inform) {
        List<String> informs = Arrays.asList(inform.split(","));
        validate(informs);
        this.name = informs.get(INDEX_NAME);
        this.price = Integer.parseInt(informs.get(INDEX_PRICE));
        this.count = Integer.parseInt(informs.get(INDEX_COUNT));
    }

    public boolean isZeroCount() {
        return this.count == 0;
    }

    public boolean isSameProduct(String name) {
        return this.name.equals(name);
    }

    public boolean isExpensive(int money) {
        return this.price > money;
    }

    public int calculateBalance(int money) {
        return money - this.price;
    }

    private void validate(List<String> inform) {
        Validation.composeOnlyKorean(inform.get(INDEX_NAME));
        Validation.composeOnlyNumber(inform.get(INDEX_PRICE));
        Validation.composeOnlyNumber(inform.get(INDEX_COUNT));
        Validation.checkMoneyRange(inform.get(INDEX_PRICE));
        Validation.checkMoneyDivide(inform.get(INDEX_PRICE));
        Validation.checkProductCount(inform.get(INDEX_COUNT));
    }
}
