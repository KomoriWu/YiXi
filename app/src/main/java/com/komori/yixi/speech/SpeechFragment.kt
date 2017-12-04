package com.komori.yixi.speech

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.komori.yixi.R
import com.komori.yixi.base.MvpBaseFragment
import com.komori.yixi.record.mvp.RecordPresenter
import com.komori.yixi.site.mvp.RecordContract
import kotlinx.android.synthetic.main.fragment_speech.*

class SpeechFragment : MvpBaseFragment<RecordPresenter>(), RecordContract.View {
    private var mSpeechAdapter: SpeechAdapter? = null

    override fun initInject() {
        getFragmentComponent().inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View {
        return inflater.inflate(R.layout.fragment_speech, container, false)
    }

    override fun init() {
        presenter?.attachView(this);
        presenter?.toStr();
        initRefresh();
    }

    private fun initRefresh() {
        recycler_view.layoutManager = LinearLayoutManager(activity)
        mSpeechAdapter = SpeechAdapter(activity!!)
        recycler_view.adapter = mSpeechAdapter
    }

    override fun showErrorMsg(msg: String) {

    }

    override fun showStr(str: String) {
    }

}


