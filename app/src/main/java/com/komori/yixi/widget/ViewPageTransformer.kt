package com.komori.yixi.widget

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPager
import android.view.View

/**
 * Created by KomoriWu
 * on 2017-11-30.
 */

class ViewPageTransformer : ViewPager.PageTransformer {
    fun handleInvisiblePage(view: View, position: Float) {}

    fun handleLeftPage(view: View, position: Float) {
        ViewCompat.setPivotX(view, view.width.toFloat())
        ViewCompat.setScaleX(view, 1.0f + position)
    }

    fun handleRightPage(view: View, position: Float) {
        ViewCompat.setPivotX(view, 0f)
        ViewCompat.setScaleX(view, 1.0f - position)
        ViewCompat.setAlpha(view, 1f)
    }

    override fun transformPage(view: View, position: Float) {
        if (position < -1.0f) {
            // [-Infinity,-1)
            // This page is way off-screen to the left.
            handleInvisiblePage(view, position)
        } else if (position <= 0.0f) {
            // [-1,0]
            // Use the default slide transition when moving to the left page
            handleLeftPage(view, position)
        } else if (position <= 1.0f) {
            // (0,1]
            handleRightPage(view, position)
        } else {
            // (1,+Infinity]
            // This page is way off-screen to the right.
            handleInvisiblePage(view, position)
        }
    }


}