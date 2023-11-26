package vendingmachine.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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
        Map<Integer, Integer> coins = initializeResultCoins();
        int unit;
        while (money != 0) {
            unit = RandomGenerator.pickUnit(initializeRandomCoins(money));
            if (unit <= money) {
                coins.put(unit, coins.get(unit) + 1);
                money -= unit;
            }
        }
        return coins;
    }

    private List<Integer> initializeRandomCoins(int money) {
        return Arrays.stream(Coin.values()).map(Coin::getAmount).filter(amount ->
            amount <= money).collect(Collectors.toList());
    }

    private Map<Integer, Integer> initializeResultCoins() {
        Map<Integer, Integer> coins = new LinkedHashMap<>();
        Arrays.stream(Coin.values()).forEach(coin -> coins.put(coin.getAmount(), 0));
        return coins;
    }

    private void validate(String money) {
        Validation.composeOnlyNumber(money);
        Validation.checkMoneyDivide(money);
    }
}
