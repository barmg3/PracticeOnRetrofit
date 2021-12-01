package com.barmge.rertro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.barmge.rertro.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private var getButton = findViewById<Button>(R.id.button)
    private var numberText = findViewById<TextView>(R.id.editTextNumber)
    private var textArea = findViewById<TextView>(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this , viewModelFactory).get(MainViewModel::class.java)

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

        //MainViewModel Logic Code to Get the Data for Custom UserId
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
        }


    }
}