package com.komori.yixi.base

/**
 * Created by KomoriWu
 * on 2017-08-15.
 */

interface BasePresenter< in T : BaseView> {
    fun attachView(view:T)
    fun detachView()
}