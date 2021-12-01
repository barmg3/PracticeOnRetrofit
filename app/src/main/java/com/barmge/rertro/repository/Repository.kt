package com.barmge.rertro.repository

import com.barmge.rertro.api.RetrofitInstance
import com.barmge.rertro.model.Post
import retrofit2.Response

class Repository {

    //Repo For getPost that Hard Coded
    suspend fun getPost() : Response<Post>
    {
        return RetrofitInstance.api.getPost()
    }

    //Repo For getPost that have Custom Post Number
    suspend fun getPost2 (number : Int) : Response<Post>
    {
        return RetrofitInstance.api.getPost2(number)
    }

    //Repo For getPost that have Custom UserId Number
    suspend fun getCustomPost (userId : Int) : Response<List<Post>>
    {
        return RetrofitInstance.api.getCustomPost(userId)
    }

    //Repo For getPost that have Custom UserId Number , Sorting String and Ordering String
    suspend fun getCustomPost2 (userId : Int , options : Map<String , String>) : Response<List<Post>>
    {
        return RetrofitInstance.api.getCustomPost2(userId , options)
    }


}