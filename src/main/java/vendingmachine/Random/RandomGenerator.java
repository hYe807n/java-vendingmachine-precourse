package vendingmachine.Random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int pickNumberCount(int maximum) {
        return  Randoms.pickNumberInRange(1, maximum);
    }
}
