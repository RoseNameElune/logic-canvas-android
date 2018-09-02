package com.toly1994.logic_canvas.go.interpolator;

import android.animation.TimeInterpolator;
import android.util.Log;

import com.toly1994.logic_canvas.logic.Logic;


/**
 * 作者：张风捷特烈
 * 时间：2018/7/9:10:08
 * 邮箱：1981462002@qq.com
 * 说明：三角函数实现减速插值器
 */
public class A_Sin_Inter implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {

        float result;
//        if (input <= 0.5) {
        result = (float) (Math.sin((Logic.rad(90 * input + 90))));
        // 使用正弦函数来实现先减速后加速的功能，逻辑如下：
        // 因为正弦函数初始弧度变化值非常大，刚好和余弦函数是相反的
        // 随着弧度的增加，正弦函数的变化值也会逐渐变小，这样也就实现了减速的效果。
        // 当弧度大于π/2之后，整个过程相反了过来，现在正弦函数的弧度变化值非常小，渐渐随着弧度继续增加，变化值越来越大，弧度到π时结束，这样从0过度到π，也就实现了先减速后加速的效果
//        } else {
//            result = (float) (Math.sin((Logic.rad(input))));
//        }

        Log.d("TAG", "getInterpolation: " + Logic.rad(90 * input) + ":" + result);
        return 1-result;
        // 返回的result值 = 随着动画进度呈先减速后加速的变化趋势
    }
}
