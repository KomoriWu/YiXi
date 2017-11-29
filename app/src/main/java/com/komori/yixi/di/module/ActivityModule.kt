package com.komori.yixi.di.module

import android.app.Activity


import com.komori.yixi.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    internal fun provideActivity(): Activity {
        return activity
    }

}
