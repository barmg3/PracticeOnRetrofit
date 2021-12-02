package com.barmge.rertro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barmge.rertro.model.Post
import com.barmge.rertro.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseCustom : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponseCustom2 : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    //ViewModel Scope For HardCoded Number Post
    fun getPost(){

        viewModelScope.launch {
            val response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    //ViewModel Scope For custom Number Post
    fun getPost2 (number : Int) {

        viewModelScope.launch {
            val response: Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    //ViewModel Scope For custom UserId Number
    fun getCustomPost (userId : Int , sort : String , order : String){
        viewModelScope.launch {
            val response:Response<List<Post>> = repository.getCustomPost(userId , sort , order)
            myResponseCustom.value = response

        }
    }

    //ViewModel Scope For custom UserId Number and the order of Posts
    fun getCustomPost2 (userId : Int , options : Map<String , String>){
        viewModelScope.launch {
            val response:Response<List<Post>> = repository.getCustomPost2(userId , options)
            myResponseCustom2.value=response

        }
    }

}