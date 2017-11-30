package com.komori.yixi.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.ButterKnife

/**
 * Created by KomoriWu
 * on 2017-11-30.
 */


abstract class BaseFragment : Fragment() {
    var progressDialog: ProgressDialog? = null

    abstract fun initView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View

    abstract fun init()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return initView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
        init()
    }

    fun showProgressDialog(id: Int) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(activity)
        }
        progressDialog!!.setMessage(getString(id))
        progressDialog!!.show()

    }

    fun hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog!!.hide()
        }
    }

}
