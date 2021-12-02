package com.barmge.rertro.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-type" , "application/json")
            .addHeader("X-Platform" , "Android")
            .addHeader("X-Auth-Token" , "123123123")
            .build()
        return chain.proceed(request)
    }
}