package com.barmge.rertro.repository

import com.barmge.rertro.api.RetrofitInstance
import com.barmge.rertro.model.Post
import retrofit2.Response

class Repository {

    //Repo for pushPost to send the post as json
    suspend fun pushPost(post: Post) : Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }

    //Repo for pushPost to send the post as json
    suspend fun pushPost2(userId: Int , id : Int , title : String , body : String ) : Response<Post>{
        return RetrofitInstance.api.pushPost2(userId , id , title , body)
    }

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

    suspend fun getPost3(auth: String): Response<Post> {
        return RetrofitInstance.api.getPost3(auth)
    }

    //Repo For getPost that have Custom UserId Number
    suspend fun getCustomPost (userId : Int , sort : String , order : String) : Response<List<Post>>
    {
        return RetrofitInstance.api.getCustomPost(userId , sort , order)
    }

    //Repo For getPost that have Custom UserId Number , Sorting String and Ordering String
    suspend fun getCustomPost2 (userId : Int , options : Map<String , String>) : Response<List<Post>>
    {
        return RetrofitInstance.api.getCustomPost2(userId , options)
    }


}