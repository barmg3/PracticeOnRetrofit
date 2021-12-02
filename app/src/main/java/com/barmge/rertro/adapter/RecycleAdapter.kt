package com.barmge.rertro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barmge.rertro.R
import com.barmge.rertro.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*

class recycleAdapter : RecyclerView.Adapter<recycleAdapter.recycleViewHolder>() {


    private var recycleList = emptyList<Post>()


    inner class recycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): recycleAdapter.recycleViewHolder {
        return recycleViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false))
    }

    //i have used kotlin plugin to import views from layout without "findViewById"
    //the plugins are:
    // apply plugin: 'com.android.application'
    // apply plugin: 'kotlin-android'
    // apply plugin: 'kotlin-android-extensions'
    override fun onBindViewHolder(holder: recycleAdapter.recycleViewHolder, position: Int) {
        holder.itemView.userId_textView.text = recycleList[position].userId.toString()
        holder.itemView.id_textView.text = recycleList[position].id.toString()
        holder.itemView.title_textView.text = recycleList[position].title
        holder.itemView.body_textView.text = recycleList[position].body
    }

    override fun getItemCount(): Int {
        return recycleList.size
    }

    fun setData( newList: List<Post> ){
        recycleList = newList
        notifyDataSetChanged()
    }
}