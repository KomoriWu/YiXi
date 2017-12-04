package com.komori.yixi.application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatDelegate
import com.komori.yixi.R
import com.komori.yixi.di.component.AppComponent
import com.komori.yixi.di.component.DaggerAppComponent
import com.komori.yixi.di.module.AppModule
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import java.util.*


/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

class MyApplication : Application() {
    private var mActivityList: ArrayList<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        if (sInstance == null) {
            sInstance = this
        }
        mActivityList = ArrayList()
        initSmartRefreshLayout()
    }

    fun addActivity(activity: Activity) {
        if (!mActivityList!!.contains(activity)) {
            mActivityList!!.add(activity)
        }
    }


    fun removeAllActivity() {
        for (activity in mActivityList!!) {
            activity.finish()
        }
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }

    companion object {
        private var sImageLoader: ImageLoader? = null
        private var sInstance: MyApplication? = null
        private var sAppComponent: AppComponent? = null

        fun getImageLoader(context: Context): ImageLoader? {
            if (sImageLoader == null) {
                synchronized(ImageLoader::class) {
                    if (sImageLoader == null) {
                        sImageLoader = ImageLoader.getInstance()
                        sImageLoader!!.init(ImageLoaderConfiguration.createDefault(context.
                                applicationContext))
                    }
                }
            }
            return sImageLoader
        }

        fun getInstance(): MyApplication {
            return if (sInstance == null) {
                MyApplication();
            } else {
                sInstance as MyApplication;
            }
        }

        fun getAppComponent(): AppComponent? {
            if (sAppComponent == null) {
                sAppComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(sInstance!!))
                        .build()
            }
            return sAppComponent
        }

        private fun initSmartRefreshLayout() {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
            SmartRefreshLayout.setDefaultRefreshHeaderCreater { context, layout ->
                layout.setPrimaryColorsId(android.R.color.white, R.color.tv_hint)
                ClassicsHeader(context)
            }

            SmartRefreshLayout.setDefaultRefreshFooterCreater { context, layout ->
                layout.setPrimaryColorsId(android.R.color.white, R.color.tv_hint)
                ClassicsFooter(context)
            }
        }



    }
}
