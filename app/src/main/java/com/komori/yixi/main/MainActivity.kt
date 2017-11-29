package com.komori.yixi.main

import android.widget.TextView
import com.komori.yixi.R
import com.komori.yixi.R.id.tv
import com.komori.yixi.base.MvpBaseActivity
import com.komori.yixi.main.mvp.MainContract
import com.komori.yixi.main.mvp.MainPresenter

class MainActivity : MvpBaseActivity<MainPresenter>(), MainContract.View {
    override val layoutId: Int
        get() = R.layout.activity_main


    override fun setInject() {
        getActivityComponent().inject(this)
    }

    override fun init() {
        findViewById<TextView>(tv).text = presenter?.toStr()
    }

    override fun showErrorMsg(msg: String) {
    }
}
