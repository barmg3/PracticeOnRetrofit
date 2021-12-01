package com.barmge.rertro.api

import com.barmge.rertro.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpaleApi {

    //Get For HardCoded Post Number
    @GET("posts/1")
    suspend fun getPost() : Response<Post>

    //Get For Custom Post Number
    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path ("postNumber") number : Int
    ) : Response<Post>

    @GET("posts/")
    suspend fun getCustomPost(
        @Query ("userId") userId : Int
    ) : Response<List<Post>>

    @GET("posts/")
    suspend fun getCustomPost2(
        @Query ("userId") userId : Int ,
        @QueryMap options : Map<String , String>
    ) : Response<List<Post>>



}