package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.exception.Validation;

public class Products {

    private final List<Product> products;

    public Products(String products) {
        Validation.checkProductForm(products);
        this.products = Arrays.stream(products.split(";"))
            .map(Product::new)
            .collect(Collectors.toList());
    }
}
