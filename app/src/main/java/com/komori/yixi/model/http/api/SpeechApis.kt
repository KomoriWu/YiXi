package com.komori.yixi.model.http.api


import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by KomoriWu
 * on 2017-12-04.
 */


interface SpeechApis {
    companion object {
        val HOST = "http://v3.wufazhuce.com:8000/api/"
        val END = "?cchannel=wdj&version=4.3.4&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android"
    }

}
