package com.komori.yixi.utils

import com.komori.yixi.model.http.exception.ApiException
import com.komori.yixi.model.http.reponse.MyHttpResponse

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe
import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Created by KomoriWu
 * on 2017-12-04.
 */

object RxUtil {
    /**
     * 统一线程处理
     * @param <T>
     * @return
    </T> */
    fun <T> rxSchedulerHelper(): FlowableTransformer<T, T> {    //compose简化线程
        return FlowableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * 统一返回结果处理
     * @param <T>
     * @return
    </T> */
    fun <T> handleResult(): FlowableTransformer<MyHttpResponse<T>, T> {   //compose判断结果
        return FlowableTransformer { httpResponseFlowable ->
            httpResponseFlowable.flatMap { tMyHttpResponse ->
                if (tMyHttpResponse.res == 200) {
                    createData(tMyHttpResponse.data)
                } else {
                    Flowable.error(ApiException("服务器返回error"))
                }
            }
        }
    }

    /**
     * 生成Flowable
     * @param <T>
     * @return
    </T> */
    fun <T> createData(t: T?): Flowable<T> {
        return Flowable.create({ emitter ->
            try {
                emitter.onNext(t!!)
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }, BackpressureStrategy.BUFFER)
    }
}
