package com.komori.yixi.branches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.komori.yixi.R
import com.komori.yixi.base.MvpBaseFragment
import com.komori.yixi.record.mvp.RecordPresenter
import com.komori.yixi.site.mvp.RecordContract
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem
import kotlinx.android.synthetic.main.fragment_branches.*

class BranchesFragment : MvpBaseFragment<RecordPresenter>(), RecordContract.View {
    override fun initInject() {
        getFragmentComponent().inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View {
        return inflater.inflate(R.layout.fragment_branches, container, false)
    }

    override fun init() {
        presenter?.attachView(this);
        presenter?.toStr();
//        item_title.text = "" + position
    }

    override fun showErrorMsg(msg: String) {

    }

    override fun showStr(str: String) {
        val position = FragmentPagerItem.getPosition(arguments)
        item_title.text = str + position
    }
}
