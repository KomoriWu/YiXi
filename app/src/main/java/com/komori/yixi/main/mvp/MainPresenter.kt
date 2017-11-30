package com.komori.yixi.main.mvp


import com.komori.yixi.base.RxPresenter

import javax.inject.Inject

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */


class MainPresenter @Inject
constructor() : RxPresenter<MainContract.View>(), MainContract.Presenter {

    override fun toStr() {
        view!!.showStr("sssssssssssssss")
    }
}
