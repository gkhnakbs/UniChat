package com.gokhanakbas.unichatdeneme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gokhanakbas.unichatdeneme.databinding.ActivityMainpageBinding

class MainPage : AppCompatActivity() {
    private lateinit var  binding : ActivityMainpageBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainpageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setContentView(R. layout.activity_mainpage)
    }



}