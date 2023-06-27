package com.gokhanakbas.unichatdeneme.object_class

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.collections.ArrayList

class Posts(var postUser : String) {



        //lateinit var userList :ArrayList<User>
        var postLabel : String=""
        var postDesc : String=""
        var postTime : String=""
        var postFullName : String=""
        var post_photo : String=""

    /*fun getPostSelf(context: Context){

            //Buraya Firestore dan kullanıcıya ait postları çekeceğiz.

                    firestore.collection("Posts").whereEqualTo("post_mail", postUser)
                        .addSnapshotListener { snapshot, exception ->
                            if (exception != null) {
                                Toast.makeText(context,exception.localizedMessage,Toast.LENGTH_LONG).show()
                            } else {
                                if (snapshot != null) {
                                    if (!snapshot.isEmpty) {

                                        var documents = snapshot.documents
                                        postList.clear()

                                        for (document in documents) {
                                            var postObject = Posts(postUser)
                                            postObject.postLabel =document.get("post_label") as String
                                            postObject.postDesc =document.get("post_desc") as String
                                            postObject.postTime =document.get("post_time") as String
                                            postObject.postFullName =document.get("post_FullName") as String
                                            postList.add(postObject)
                                        }



                                    }


                                }

                            }
            }
        }



        fun getPostFriends(){
            //Buraya kullanıcının arkadaşlarına ait postları çekeceğiz.
        } */


}