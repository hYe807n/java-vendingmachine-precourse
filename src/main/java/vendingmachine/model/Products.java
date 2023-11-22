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

    public boolean checkPurchaseState(int balance) {
        return !(products.stream().allMatch(product -> product.isExpensive(balance))
            && !products.stream().allMatch(Product::isZeroCount));
    }

    public int purchase(String purchaseProduct, int balance) {
        validatePurchase(purchaseProduct, balance);
        return products.stream().filter(product -> product.isSameProduct(purchaseProduct))
            .mapToInt(product -> product.calculateBalance(balance)).sum();
    }

    private void validatePurchase(String purchaseProduct, int balance) {
        validatePurchaseProduct(purchaseProduct);
        validateProductCount(purchaseProduct);
        validatePurchasePrice(balance);
    }

    private void validateProductCount(String purchaseProduct) {
        if (products.stream()
            .filter(product -> product.isSameProduct(purchaseProduct))
            .anyMatch(Product::isZeroCount)) {
            Validation.ZeroCountProduct();
        }
    }

    private void validatePurchasePrice(int balance) {
        if (products.stream().anyMatch(product -> product.isExpensive(balance))) {
            Validation.deficiencyPurchaseBalance();
        }
    }

    private void validatePurchaseProduct(String name) {
        if (products.stream()
            .noneMatch(product -> product.isSameProduct(name))) {
            Validation.NoneExistPurchaseProduct();
        }
    }
}
