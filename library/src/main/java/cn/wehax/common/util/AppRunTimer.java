package cn.wehax.common.util;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 程序运行时间计时器
 */
public class AppRunTimer {
    public static final String TAG = "CodeRunTimer";
    public static final String FORMAT_PATTERN = "HH/mm/ss";

    public static final String DEFAULT_TIMER_TAG = "DEFAULT_TIMER_TAG"; // 默认计时器标签

    /**
     * 保存计时开始时间
     * </p>
     * 使用Map可以同时记录多组时间，通过Key（计时器标签）区别彼此
     */
    public static Map<String, Long> recorder = new HashMap<>();

    /**
     * 开始计时
     */
    public static void start() {
        start(DEFAULT_TIMER_TAG);
    }

    public static void start(String timerTag) {
        Long curTime = System.currentTimeMillis();
        recorder.put(timerTag, curTime);
        Log.e(TAG, "[" + timerTag + "]计时器，开始计时:" + TimeUtils.getFormatTime(curTime, FORMAT_PATTERN));
    }

    /**
     * 计算并输出程序运行时间（从开始计时到调用本方法之间经历的时间）
     *
     * @param position 标记输出位置
     */
    public static void outputRunTime(String position) {
        outputRunTime(DEFAULT_TIMER_TAG, position);
    }

    /**
     * 计算并输出程序运行时间（从开始计时到调用本方法之间经历的时间）
     *
     * @param position 标记输出位置
     */
    public static void outputRunTime(String timerTag, String position) {
        if (recorder.containsKey(timerTag)) {
            Long curTime = System.currentTimeMillis();
            Log.e(TAG, "[" + timerTag + "]计时器，运行到 [" + position + "] 位置，使用 " + (curTime - recorder.get(timerTag)) + " 毫秒");
        } else {
            Log.e(TAG, "[" + timerTag + "]计时器，还未开始计时");
        }
    }

    /**
     * 清楚指定计时器
     *
     * @param timerTag
     */
    public static void remove(String timerTag) {
        recorder.remove(timerTag);
    }

    /**
     * 清除所有计时器
     */
    public static void clear() {
        recorder.clear();
    }
}