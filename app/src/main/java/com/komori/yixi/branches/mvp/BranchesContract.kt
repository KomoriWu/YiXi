package com.komori.yixi.branches.mvp


import com.komori.yixi.base.BasePresenter
import com.komori.yixi.base.BaseView


/**
 * Created by KomoriWu
 * on 2017-12-01.
 */

interface BranchesContract {
    interface View : BaseView{
        fun showStr(str:String)
    }

    interface Presenter : BasePresenter<View> {
        fun toStr()
    }

}
