package com.barmge.rertro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.barmge.rertro.adapter.recycleAdapter
import com.barmge.rertro.model.Post
import com.barmge.rertro.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    //private val myAdapter by lazy { recycleAdapter() }

    /*private var getButton = findViewById<Button>(R.id.button)
    private var numberText = findViewById<TextView>(R.id.editTextNumber)
    private var textArea = findViewById<TextView>(R.id.textView)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setupRecyclView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this , viewModelFactory).get(MainViewModel::class.java)

        //Get Post with Headers
        viewModel.getPost3("11112222")
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.headers().toString())
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

        //Send Post to the server as FormlUrlEcoded
        /*viewModel.pushPost2(2 , 2 , "Waleed Mohamed" , "Android Developer")
        viewModel.myResponse.observe(this , Observer { responce ->
            if(responce.isSuccessful){
                Log.d("Main" , responce.body().toString())
                Log.d("Main" , responce.code().toString())
                Log.d("Main" , responce.message())

            }else{
                Toast.makeText(this , responce.code() , Toast.LENGTH_LONG ).show()
            }

        })*/

       /*//Send Post to the server as json
        val myPost = Post( 2 , 2 , "Waleed Mohamed" , "Android Developer")
        viewModel.pushPost(myPost)
        viewModel.myResponse.observe(this , Observer { responce ->
            if(responce.isSuccessful){
                Log.d("Main" , responce.body().toString())
                Log.d("Main" , responce.code().toString())
                Log.d("Main" , responce.message())

            }else{
                Toast.makeText(this , responce.code() , Toast.LENGTH_LONG ).show()
            }

        })*/

    /* //get data using custom post call with chosen order
        viewModel.getCustomPost(2 , "id" , "desc")
        viewModel.myResponseCustom.observe(this , Observer { responce ->
            if(responce.isSuccessful){
                responce.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(this , responce.code() , Toast.LENGTH_LONG ).show()
            }

        })*/

        //MainViewModel Logic Code to Get the data
        /*viewModel.getPost()
        viewModel.myResponse.observe(this , Observer { responce ->

            if(responce.isSuccessful) {
                Log.d("Response", responce.body()?.userId.toString())
                Log.d("Response", responce.body()?.id.toString())
                Log.d("Response", responce.body()?.title!!)
                Log.d("Response", responce.body()?.body!!)
            }else{
                Log.d("Response" , responce.errorBody().toString())
            }
        })
      }*/

       /* //MainViewModel Logic Code to Get the Data for Custom Post Number
          //and Show it on The Layout
        getButton.setOnClickListener {
            var myNumber = numberText.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))
            viewModel.myResponse2.observe(this , Observer { responce ->

                if(responce.isSuccessful) {
                textArea.text = responce.body().toString()
            }else{
                textArea.text = responce.code().toString()
                }
            })
        }*/

        /*//MainViewModel Logic Code to Get the Data for Custom UserId
        // gets all post have the same UserId number and Show it on The Layout
        getButton.setOnClickListener {
            var myNumber = numberText.text.toString()
            viewModel.getCustomPost(Integer.parseInt(myNumber))
            viewModel.myResponseCustom.observe(this , Observer { responce ->

                if(responce.isSuccessful) {
                    textArea.text = responce.body().toString()
                }else{
                    textArea.text = responce.code().toString()
                }
            })
        }*/

        /*//MainViewModel Logic Code to Get the Data for Custom UserId
        // gets all post have the same UserId number
        // and put the post in the order you chose and Show it on The Layout

        val options : HashMap<String , String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"


        getButton.setOnClickListener {
            var myNumber = numberText.text.toString()
            viewModel.getCustomPost2(Integer.parseInt(myNumber) , options)
            viewModel.myResponseCustom2.observe(this , Observer { responce ->

                if(responce.isSuccessful) {
                    textArea.text = responce.body().toString()
                }else{
                    textArea.text = responce.code().toString()
                }
            })
        }*/

    }
    /*//Set data to the recycle view xml to show the data with orientation of the layout
    private fun setupRecyclView(){
        recycle_view.adapter = myAdapter
        recycle_view.layoutManager = LinearLayoutManager(this)

    }*/
}