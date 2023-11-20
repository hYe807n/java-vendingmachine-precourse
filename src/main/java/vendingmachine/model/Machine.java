package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.Random.RandomGenerator;
import vendingmachine.enums.Coin;
import vendingmachine.exception.Validation;

public class Machine {

    private final int money;
    private final Map<Integer, Integer> coins;

    public Machine(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
        this.coins = initializeCoins(Integer.parseInt(money));
    }

    public Map<Integer, Integer> getCoins() {
        return this.coins;
    }

    private Map<Integer, Integer> initializeCoins(int money) {
        Map<Integer, Integer> coins = new LinkedHashMap<>();
        int balance = money;
        int count;
        for (Coin unit: Coin.values()) {
            count = calculateRandomCoin(unit, balance);
            coins.put(unit.getAmount(), count);
            balance -= count * unit.getAmount();
        }
        return coins;
    }

    private int calculateRandomCoin(Coin unit, int balance) {
        int count = 0;
        if (unit.getAmount() <= balance) {
            count = RandomGenerator.pickNumberCount(calculateMaximumCoin(balance, unit));
        }
        if (unit.equals(Coin.COIN_10)) {
            count = calculateMaximumCoin(balance, unit);
        }
        return count;
    }

    private int calculateMaximumCoin(int money, Coin coin) {
        return money / coin.getAmount();
    }

    private void validate(String money) {
        Validation.composeOnlyNumber(money);
        Validation.checkMoneyRange(money);
        Validation.checkMoneyDivide(money);
    }
}
