package com.komori.yixi.base


import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by KomoriWu
 * on 2017-11-29.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */

open class RxPresenter<T : BaseView> : BasePresenter<T> {
    @JvmField
    var view: T? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    private fun unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.clear()
        }
    }

    fun addSubscribe(subscription: Disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(subscription)
    }

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
        unSubscribe()
    }
}
