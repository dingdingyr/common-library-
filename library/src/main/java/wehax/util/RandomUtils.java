package wehax.util;

import java.security.InvalidParameterException;
import java.util.Random;

public class RandomUtils {
    static Random random = null;

    /**
     * Returns a pseudo-random uniformly distributed {@code int}
     * in the range [left, right).
     *
     * @Note 支持负整数
     */
    public static int getRandomInt(int left, int right) {
        if (left > right) {
            throw new InvalidParameterException("left should less than right");
        }

        if (left == right)
            return left;

        if (random == null) {
            random = new Random();
        }
        return left + random.nextInt(right - left);
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code float}
     * in the half-open range [left, right).
     *
     * @Note 支持负实数
     */
    public static float getRandomFloat(float left, float right) {
        if (left > right) {
            throw new InvalidParameterException("left should less than right");
        }

        if (left == right)
            return left;

        if (random == null) {
            random = new Random();
        }
        return left + random.nextFloat() * (right - left);
    }


}
