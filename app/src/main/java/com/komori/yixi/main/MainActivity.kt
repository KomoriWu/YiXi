package com.komori.yixi.main

import com.komori.yixi.R
import com.komori.yixi.base.MvpBaseActivity
import com.komori.yixi.branches.BranchesFragment
import com.komori.yixi.site.mvp.RecordContract
import com.komori.yixi.record.mvp.RecordPresenter
import com.komori.yixi.record.RecordFragment
import com.komori.yixi.speech.SpeechFragment
import com.komori.yixi.widget.ViewPageTransformer
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_title.*
import com.komori.yixi.site.SiteFragment

class MainActivity : MvpBaseActivity<RecordPresenter>(), RecordContract.View {
    override val layoutId: Int
        get() = R.layout.activity_main


    override fun setInject() {
        getActivityComponent().inject(this)
    }

    override fun init() {
        presenter?.attachView(this);
        presenter?.toStr()
        initTab()
    }

    private fun initTab() {
        val listTabs: Array<String> = resources.getStringArray(R.array.tabs)
        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add(listTabs[0], SpeechFragment::class.java)
                .add(listTabs[1], BranchesFragment::class.java)
                .add(listTabs[2], SiteFragment::class.java)
                .add(listTabs[3], RecordFragment::class.java)
                .create())
        view_pager.adapter = adapter
        //设置切换动画
        view_pager.setPageTransformer(true, ViewPageTransformer())
        tab_view_pager.setViewPager(view_pager)
    }

    override fun showErrorMsg(msg: String) {

    }

    override fun showStr(str: String) {

    }

}
