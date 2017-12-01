package com.komori.yixi.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

@SuppressLint("AppCompatCustomView")
class HYTextView : TextView {

    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }


    fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        if (isInEditMode) return
        val fontName = "HYXinRenWenSongW.ttf"
        super.setTypeface(Typeface.createFromAsset(getContext().assets,
                "fonts/" + fontName), defStyleAttr)
    }

    companion object {
        private val TITLE = 0
        private val LIGHT = 1
    }
}
