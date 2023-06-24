package com.gokhanakbas.unichatdeneme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gokhanakbas.unichatdeneme.databinding.ActivityMainpageBinding

class MainPage : AppCompatActivity() {
    private lateinit var  binding : ActivityMainpageBinding
    private lateinit var recyclerViewAdapter:RecyclerAdapter

     @SuppressLint("NotifyDataSetChanged")
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainpageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var user_mail=intent.getStringExtra("user_mail").toString()
        var user_post= Posts(user_mail)
         user_post.getPostSelf(this)
         recyclerViewAdapter= RecyclerAdapter(user_post.postList)
         val layoutManager= LinearLayoutManager(this)
         binding.recyclerView.layoutManager=layoutManager
         binding.recyclerView.adapter=recyclerViewAdapter
         recyclerViewAdapter.notifyDataSetChanged()



    }



}