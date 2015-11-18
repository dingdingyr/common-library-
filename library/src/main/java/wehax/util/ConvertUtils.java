package wehax.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * ScreenUtils
 * <ul>
 * <strong>Convert between dp and sp</strong>
 * <li>{@link wehax.util.ConvertUtils#dpToPx(android.content.Context, float)}</li>
 * <li>{@link wehax.util.ConvertUtils#pxToDp(android.content.Context, float)}</li>
 * </ul>
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-14
 */
public class ConvertUtils {

    private ConvertUtils() {
        throw new AssertionError();
    }

    public static float dpToPx(Context context, float dip) {
        // 单位转换标准实现方式
        Resources resources = context.getResources();
        int px = Math
                .round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        dip, resources.getDisplayMetrics()));
        return px;
    }

    public static float pxToDp(Context context, float px) {
        if (context == null) {
            return -1;
        }
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float dpToPxInt(Context context, float dp) {
        return (int) (dpToPx(context, dp) + 0.5f);
    }

    public static float pxToDpCeilInt(Context context, float px) {
        return (int) (pxToDp(context, px) + 0.5f);
    }
}
