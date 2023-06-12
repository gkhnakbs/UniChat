package com.gokhanakbas.unichatdeneme

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
        val guncelKullanici=auth.currentUser
        if(guncelKullanici!=null){
            val intent = Intent(applicationContext, MainPage::class.java)
            intent.putExtra("user_mail",auth.currentUser?.email.toString())
            startActivity(intent)
            finish()
        }


        setContentView(R.layout.activity_entrypage)
    }

    fun login(view : View){
        var user_mailText : String =binding.usermailText.text.toString().trim()
        var passwordText : String =binding.passwordText.text.toString().trim()

        //if (!user_mailText.isEmpty() && !passwordText.isEmpty()){
            auth.signInWithEmailAndPassword(user_mailText,passwordText).addOnCompleteListener {
                    val guncelKullanici=auth.currentUser?.email.toString()
                    val intent = Intent(applicationContext, MainPage::class.java)
                    intent.putExtra("user_mail",user_mailText)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener{
                    Toast.makeText(this.applicationContext,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        /*}
        else{
            Toast.makeText(this.applicationContext,"Bos Alanlar Var",Toast.LENGTH_LONG).show()
        }*/


    }

    fun signUp(view: View){

    }
    fun passReset(view : View){

    }
}