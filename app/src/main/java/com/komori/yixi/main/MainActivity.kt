package com.komori.yixi.main

import com.komori.yixi.R
import com.komori.yixi.base.MvpBaseActivity
import com.komori.yixi.main.mvp.MainContract
import com.komori.yixi.main.mvp.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpBaseActivity<MainPresenter>(), MainContract.View {
    override val layoutId: Int
        get() = R.layout.activity_main


    override fun setInject() {
        getActivityComponent().inject(this)
    }

    override fun init() {
       tv?.text = presenter?.toStr()
    }

    override fun showErrorMsg(msg: String) {
    }
}
