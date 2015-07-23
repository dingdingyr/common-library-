package cn.wehax.common.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * 提供与Toast有关的实用方法
 */
public class ToastUtils {
    public static int LENGHT_MID = 2000; // Toast显示时间2秒

    public static void showToast(Activity ctx, int resID) {
        showToast(ctx, ctx.getString(resID), Toast.LENGTH_SHORT);
    }

    public static void showToast(Activity ctx, String text) {
        showToast(ctx, text, Toast.LENGTH_SHORT);
    }

    public static void showToast(Activity ctx, String text, int duration) {
        Toast.makeText(ctx, text, duration).show();
    }
}
