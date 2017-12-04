package com.komori.yixi.model.http


import com.komori.yixi.base.BaseView

import io.reactivex.subscribers.ResourceSubscriber

/**
 * Created by KomoriWu
 * on 2017/9/16.
 */

abstract class CommonSubscriber<T> : ResourceSubscriber<T> {
    private var mBaseView: BaseView? = null
    private var mErrorMsg: String? = null
    private var mIsShowErrorState = true

    constructor(mBaseView: BaseView) {
        this.mBaseView = mBaseView
    }

    constructor(mBaseView: BaseView, mErrorMsg: String) {
        this.mBaseView = mBaseView
        this.mErrorMsg = mErrorMsg
    }

    constructor(mBaseView: BaseView, mIsShowErrorState: Boolean) {
        this.mBaseView = mBaseView
        this.mIsShowErrorState = mIsShowErrorState
    }

    constructor(mBaseView: BaseView, mErrorMsg: String, mIsShowErrorState: Boolean) {
        this.mBaseView = mBaseView
        this.mErrorMsg = mErrorMsg
        this.mIsShowErrorState = mIsShowErrorState
    }

    override fun onComplete() {

    }

    override fun onError(t: Throwable) {
        if (mBaseView == null) {
            return
        }
        mBaseView!!.showErrorMsg(t.message!!)

    }
}
