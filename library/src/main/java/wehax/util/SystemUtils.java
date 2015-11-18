package wehax.util;

import android.os.Build;

/**
 * SystemUtils
 */
public class SystemUtils {

    /** recommend default thread pool size according to system available processors, {@link #getDefaultThreadPoolSize()} **/
    public static final int DEFAULT_THREAD_POOL_SIZE = getDefaultThreadPoolSize();

    private SystemUtils() {
        throw new AssertionError();
    }

    /**
     * get recommend default thread pool size
     * 
     * @return if 2 * availableProcessors + 1 less than 8, return it, else return 8;
     * @see {@link #getDefaultThreadPoolSize(int)} max is 8
     */
    public static int getDefaultThreadPoolSize() {
        return getDefaultThreadPoolSize(8);
    }

    /**
     * get recommend default thread pool size
     * 
     * @param max
     * @return if 2 * availableProcessors + 1 less than max, return it, else return max;
     */
    public static int getDefaultThreadPoolSize(int max) {
        int availableProcessors = 2 * Runtime.getRuntime().availableProcessors() + 1;
        return availableProcessors > max ? max : availableProcessors;
    }

    /** >=2.2 */
    public static boolean hasFroyo() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    /** >=2.3 */
    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    /** >=3.0 LEVEL:11 */
    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    /** >=3.1 */
    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    /** >=4.0 14 */
    public static boolean hasICS() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    /**
     * >= 4.1 16
     */
    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    /** >= 4.2 17 */
    public static boolean hasJellyBeanMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }

    /** >= 4.3 18 */
    public static boolean hasJellyBeanMr2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }

    public static int getSDKVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    @SuppressWarnings("deprecation")
    public static String getSDKVersion() {
        return Build.VERSION.SDK;
    }
}
