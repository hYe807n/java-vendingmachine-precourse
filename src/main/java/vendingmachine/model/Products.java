package vendingmachine.model;

import vendingmachine.exception.Validation;

public class Products {

    public Products(String products) {
        Validation.checkProductForm(products);
    }
}
