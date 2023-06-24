package com.gokhanakbas.unichatdeneme

import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Posts(var postUser : String) {



        lateinit var userList :ArrayList<User>
        var postLabel : String=""
        var postDesc : String=""
        var postTime : String=""
        var postFullName : String=""
        private var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        var postList = ArrayList<Posts>()



        fun getPostFriends(){
            //Buraya kullanıcının arkadaşlarına ait postları çekeceğiz.
        }
}