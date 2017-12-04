package com.komori.yixi.model.http


import com.komori.yixi.utils.Utils

import java.io.IOException

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by KomoriWu
 * on 2017-12-04.
 */
class CacheInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (Utils.isNetworkConnected()) {
            val response = chain.proceed(request)
            // read from cache for 0 s  有网络不会使用缓存数据
            val maxAge = 10
            val cacheControl = request.cacheControl().toString()
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build()
        } else {
            //无网络时强制使用缓存数据
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
            val response = chain.proceed(request)
            //set cahe times ; value is useless at all !
            //            int maxStale = 60;
            val maxStale = 60 * 60 * 24 * 3
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build()
        }
    }
}