package com.komori.yixi.base

import com.komori.yixi.application.MyApplication
import com.komori.yixi.di.component.ActivityComponent
import com.komori.yixi.di.component.DaggerActivityComponent
import com.komori.yixi.di.module.ActivityModule
import javax.inject.Inject

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

abstract class MvpBaseActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @JvmField
    @Inject
    var presenter: T? = null

    abstract fun setInject()

    fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build()
    }

    private fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }

    override fun onCreateView() {
        super.onCreateView()
        setInject()
//        presenter?.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.detachView()
    }
}
