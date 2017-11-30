package com.komori.yixi.main.mvp


import com.komori.yixi.base.RxPresenter
import com.komori.yixi.speech.mvp.SpeechContract

import javax.inject.Inject

/**
 * Created by KomoriWu
 * on 2017-11-30.
 */


class SpeechPresenter @Inject
constructor() : RxPresenter<SpeechContract.View>(), SpeechContract.Presenter {

    override fun toStr() {
        view!!.showStr("sssssssssssssss")
    }
}
