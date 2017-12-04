package com.komori.yixi.utils

import android.os.Environment
import com.komori.yixi.application.MyApplication

import java.io.File

/**
 * Created by KomoriWu
 * on 2017-12-04.
 */
object Constants {
    //path
    val PATH_DATA = MyApplication.getInstance().cacheDir.absolutePath + File.separator + "data"
    val PATH_CACHE = PATH_DATA + "/NetCache"
    val PATH_SDCARD = Environment.getExternalStorageDirectory().absolutePath + File.separator + "YiXi"

    val CACHE_SIZE = (50 * 1024 * 1024).toLong()
    val MOVIE_VIEW_PAGE_SIZE = 10000

}
