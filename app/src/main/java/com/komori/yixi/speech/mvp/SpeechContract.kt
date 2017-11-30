package com.komori.yixi.speech.mvp


import com.komori.yixi.base.BasePresenter
import com.komori.yixi.base.BaseView

/**
 * Created by KomoriWu
 * on 2017-11-30.
 */


interface SpeechContract {
    interface View : BaseView{
        fun showStr(str:String)
    }

    interface Presenter : BasePresenter<View> {
        fun toStr()
    }

}
