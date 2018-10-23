package com.example.demoapplication.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

/**
 * 屏幕工具类
 */

public class ScreenUtils {
    public static int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }
    /**
     * 调整图片大小
     *
     * @param resWidth
     * @return
     */
    public static Bitmap getBitmap(Resources res, int resWidth, int resourceId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resourceId, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = resWidth;
        return BitmapFactory.decodeResource(res, resourceId, options);
    }
}
