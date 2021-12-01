package com.barmge.rertro.api

import com.barmge.rertro.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api : SimpaleApi by lazy {
        retrofit.create(SimpaleApi::class.java)
    }
}