package cn.wehax.common.util;

import android.util.Log;

/**
 * 程序运行时间计时器
 */
public class AppRunTimer {
    public static final String TAG = "CodeRunTimer";
    public static final String FORMAT_PATTERN = "HH/mm/ss";

    public static final Long DEFAULT_START_TIME = -1L; // 默认开始时间

    /**
     * 保存计时开始时间
     * </p>
     * 使用Map可以同时记录多组时间，通过Key（计时器标签）区别彼此
     */
    public static Long startTime = DEFAULT_START_TIME;

    /**
     * 开始计时
     */
    public static void start() {
        startTime = System.currentTimeMillis();
        Log.e(TAG, "开始计时:" + TimeUtils.getFormatTime(startTime, FORMAT_PATTERN));
    }

    /**
     * 计算并输出程序运行时间（从开始计时到调用本方法之间经历的时间）
     *
     * @param position 标记输出位置
     */
    public static void outputRunTime(String position) {
        if (startTime != DEFAULT_START_TIME) {
            Long curTime = System.currentTimeMillis();
            Log.e(TAG, "运行到 [" + position + "] 用了 " + (curTime - startTime) + " 毫秒");
        } else {
            Log.e(TAG, "未开始计时");
        }
    }

}