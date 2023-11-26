package vendingmachine.Random;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {

    public static int pickUnit(List<Integer> units) {
        return pickNumberInList(units);
    }

    public static int pickNumberCount(int maximum) {
        return Randoms.pickNumberInRange(1, maximum);
    }
}
