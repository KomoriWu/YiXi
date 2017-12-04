package com.komori.yixi.model.http.exception

/**
 * Created by KomoriWu
 * on 2017-12-04.
 */


class ApiException : Exception {
    var code: Int = 0

    constructor(message: String) : super(message) {}

    constructor(message: String, code: Int) : super(message) {
        this.code = code
    }
}
