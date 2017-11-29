package com.komori.yixi.main.mvp;


import com.komori.yixi.base.RxPresenter;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */


public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.
        Presenter {

    @Inject
    public MainPresenter() {

    }


    @NotNull
    @Override
    public String toStr() {
        return "mmp";
    }
}
