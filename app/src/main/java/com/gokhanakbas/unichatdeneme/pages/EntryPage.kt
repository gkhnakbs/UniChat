package com.gokhanakbas.unichatdeneme.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gokhanakbas.unichatdeneme.databinding.ActivityEntrypageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class EntryPage : AppCompatActivity() {
    private lateinit var binding:ActivityEntrypageBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var firestore: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding=ActivityEntrypageBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        auth=FirebaseAuth.getInstance()

        if(auth.currentUser!=null){
            val intent = Intent(this, MainPage::class.java)
            intent.putExtra("user_mail",auth.currentUser?.email.toString())
            startActivity(intent)
        }

    }

    fun login(view : View){
        var user_mailText =binding.usermailText.text.trim().toString()
        var passwordText =binding.passwordText.text.trim().toString()

        if (user_mailText != "" && passwordText != ""){
            auth.signInWithEmailAndPassword(user_mailText,passwordText).addOnCompleteListener {
                    //val guncelKullanici=auth.currentUser?.email.toString()
                    val intent = Intent(this, MainPage::class.java)
                    intent.putExtra("user_mail",user_mailText)
                    startActivity(intent)
                }.addOnFailureListener{
                    Toast.makeText(this.applicationContext,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this.applicationContext,"Bos Alanlar Var",Toast.LENGTH_LONG).show()
        }


    }

    fun signUp(view: View){

    }
    fun passReset(view : View){

    }
}