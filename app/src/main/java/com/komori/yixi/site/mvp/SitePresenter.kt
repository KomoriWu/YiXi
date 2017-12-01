package com.komori.yixi.main.mvp


import com.komori.yixi.base.RxPresenter
import com.komori.yixi.site.mvp.RecordContract

import javax.inject.Inject

/**
 * Created by KomoriWu
 * on 2017-12-01.
 */

class SitePresenter @Inject
constructor() : RxPresenter<RecordContract.View>(), RecordContract.Presenter {

    override fun toStr() {
        view!!.showStr("sssssssssssssss")
    }
}
