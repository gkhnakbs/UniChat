package com.gokhanakbas.unichatdeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gokhanakbas.unichatdeneme.databinding.ActivityEntrypageBinding

class EntryPage : AppCompatActivity() {
    private lateinit var binding:ActivityEntrypageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityEntrypageBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        setContentView(R.layout.activity_entrypage)
    }

    fun login(view : View){
        var usernameText=binding.usernameText
        var passwordText=binding.passwordText

    }
    fun signUp(view : View){

    }
    fun passReset(view : View){

    }
}