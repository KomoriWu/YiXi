package com.komori.yixi.main.mvp


import com.komori.yixi.base.BasePresenter
import com.komori.yixi.base.BaseView

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */


interface MainContract {
    interface View : BaseView{
        fun showStr(str:String)
    }

    interface Presenter : BasePresenter<View> {
        fun toStr()
    }

}
