package baseball.domain;

import baseball.constants.BallConstants;
import baseball.domain.Balls;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBallsGenerator {
    private static final Random random = ThreadLocalRandom.current();

    public static Balls createRandomBalls() {
        Set<Integer> randomNumbers = new LinkedHashSet<>();

        while (randomNumbers.size() < BallConstants.COUNT) {
            int randomNumber = randomNumberInRange();
            randomNumbers.add(randomNumber);
        }

        return new Balls(new ArrayList<>(randomNumbers));
    }

    private static int randomNumberInRange() {
        return BallConstants.MIN + random.nextInt(BallConstants.MAX - BallConstants.MIN + 1);
    }
}