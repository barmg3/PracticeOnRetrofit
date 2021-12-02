package com.barmge.rertro.api

import com.barmge.rertro.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpaleApi {

    //Push post as json
    @POST("Posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

    //Push post as FormUrl
    @FormUrlEncoded
    @POST("Posts")
    suspend fun pushPost2(
        @Field ("userId") userId: Int,
        @Field ("id") id: Int,
        @Field ("title") title: String,
        @Field ("body") body: String
    ): Response<Post>

    //Get For HardCoded Post Number
    @GET("posts/1")
    suspend fun getPost() : Response<Post>

    //Get For Custom Post Number
    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path ("postNumber") number : Int
    ) : Response<Post>

    //Get Post with headers
    @GET("posts/1")
    suspend fun getPost3(
        @Header("Auth") auth: String)
    : Response<Post>

    @GET("posts/")
    suspend fun getCustomPost(
        @Query ("userId") userId : Int ,
        @Query ("_sort") sort : String ,
        @Query ("_order") order : String
    ) : Response<List<Post>>

    @GET("posts/")
    suspend fun getCustomPost2(
        @Query ("userId") userId : Int ,
        @QueryMap options : Map<String , String>
    ) : Response<List<Post>>



}