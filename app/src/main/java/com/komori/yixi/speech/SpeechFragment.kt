package com.komori.yixi.speech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.komori.yixi.R
import com.komori.yixi.base.MvpBaseFragment
import com.komori.yixi.main.mvp.SpeechPresenter
import com.komori.yixi.speech.mvp.SpeechContract
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem
import kotlinx.android.synthetic.main.fragment_demo.*

class SpeechFragment : MvpBaseFragment<SpeechPresenter>(), SpeechContract.View {
    override fun initInject() {
        getFragmentComponent().inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View {
        return inflater.inflate(R.layout.fragment_demo, container, false)
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
