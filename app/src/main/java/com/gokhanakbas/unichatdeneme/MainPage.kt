package com.gokhanakbas.unichatdeneme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
         var user_post : Posts= Posts("gkhn.akbs5050@gmail.com")
         user_post.getPostSelf(this)
         recyclerViewAdapter= RecyclerAdapter(user_post.postList)
         recyclerViewAdapter.notifyDataSetChanged()
    }



}