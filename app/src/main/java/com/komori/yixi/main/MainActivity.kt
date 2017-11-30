package com.komori.yixi.main

import com.komori.yixi.R
import com.komori.yixi.base.MvpBaseActivity
import com.komori.yixi.main.mvp.MainContract
import com.komori.yixi.main.mvp.MainPresenter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_title.*

class MainActivity : MvpBaseActivity<MainPresenter>(), MainContract.View {
    override val layoutId: Int
        get() = R.layout.activity_main


    override fun setInject() {
        getActivityComponent().inject(this)
    }

    override fun init() {
        presenter?.attachView(this);
        presenter?.toStr()

        val pages = FragmentPagerItems(this)

        val listTabs: Array<String> = resources.getStringArray(R.array.tabs)
        listTabs.mapTo(pages) { FragmentPagerItem.of(it, DemoFragment::class.java) }

        val adapter = FragmentPagerItemAdapter(supportFragmentManager, pages)

        view_pager.adapter = adapter
        tab_view_pager.setViewPager(view_pager)

    }

    override fun showErrorMsg(msg: String) {
    }

    override fun showStr(str: String) {
    }

}
