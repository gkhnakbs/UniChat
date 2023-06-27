package com.gokhanakbas.unichatdeneme.pages

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gokhanakbas.unichatdeneme.object_class.Posts
import com.gokhanakbas.unichatdeneme.adapter.RecyclerAdapter
import com.gokhanakbas.unichatdeneme.databinding.ActivityMainpageBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainPage : AppCompatActivity() {
    private lateinit var  binding : ActivityMainpageBinding
    private lateinit var recyclerViewAdapter: RecyclerAdapter
    private lateinit var firestore: FirebaseFirestore
    val postList=ArrayList<Posts>()
    var user_mail : String = ""
     @SuppressLint("NotifyDataSetChanged")
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding= ActivityMainpageBinding.inflate(layoutInflater)
         val view = binding.root
         setContentView(view)

         firestore=FirebaseFirestore.getInstance()
         user_mail=intent.getStringExtra("user_mail").toString()
         val user_post= Posts(user_mail)
         getPostSelf(this)
         recyclerViewAdapter= RecyclerAdapter(postList)
         val layoutManager= LinearLayoutManager(this)
         binding.recyclerView.layoutManager=layoutManager
         binding.recyclerView.adapter=recyclerViewAdapter


    }

    @SuppressLint("NotifyDataSetChanged")
    fun getPostSelf(context: Context){

        //Buraya Firestore dan kullanıcıya ait postları çekeceğiz.

        firestore.collection("Posts").whereEqualTo("post_mail", "gkhn.akbs5050@gmail.com")
            .addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    Toast.makeText(context,exception.localizedMessage, Toast.LENGTH_LONG).show()
                } else {
                    if (snapshot != null) {
                        if (!snapshot.isEmpty) {

                            var documents = snapshot.documents
                            postList.clear()

                            for (document in documents) {
                                var postObject = Posts("gkhn.akbs5050@gmail.com")
                                postObject.postLabel =document.get("post_label") as String
                                postObject.postDesc =document.get("post_desc") as String
                                postObject.postTime =document.get("post_time") as String
                                postObject.postFullName =document.get("post_FullName") as String
                                postList.add(postObject)
                            }
                            recyclerViewAdapter.notifyDataSetChanged()
                        }


                    }

                }
            }
    }

    fun profile_page(view : View){
            val intent=Intent(this,User_Profile_Page::class.java)
            intent.putExtra("user_mail",user_mail)
            startActivity(intent)
            finish()
    }



}