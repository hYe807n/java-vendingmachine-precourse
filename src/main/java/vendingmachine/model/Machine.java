package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.Random.RandomGenerator;
import vendingmachine.enums.Coin;
import vendingmachine.exception.Validation;

public class Machine {

    private final Map<Integer, Integer> coins;

    public Machine(String money) {
        validate(money);
        this.coins = initializeCoins(Integer.parseInt(money));
    }

    public Map<Integer, Integer> getCoins() {
        return this.coins;
    }

    public Map<Integer, Integer> resultCoins(int money) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> unit : this.coins.entrySet()) {
            result = calculateCoins(result, unit.getKey(), unit.getValue(), money);
            money -= unit.getKey() * result.get(unit.getKey());
        }
        return result.entrySet().stream().filter(unit -> unit.getValue() > 0)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (existing, replacement) -> existing, LinkedHashMap::new));
    }

    private Map<Integer, Integer> calculateCoins(Map<Integer, Integer> coins, int key, int value,
        int money) {
        if (key <= money) {
            if (key * value >= money) {
                coins.put(key, money / key);
            }
            if (key * value < money) {
                coins.put(key, value);
            }
            return coins;
        }
        coins.put(key, 0);
        return coins;
    }

    private Map<Integer, Integer> initializeCoins(int money) {
        Map<Integer, Integer> coins = new LinkedHashMap<>();
        int balance = money;
        int count;
        for (Coin unit : Coin.values()) {
            count = calculateRandomCoin(unit, balance);
            coins.put(unit.getAmount(), calculateRandomCoin(unit, balance));
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
        Validation.checkMoneyDivide(money);
    }
}
