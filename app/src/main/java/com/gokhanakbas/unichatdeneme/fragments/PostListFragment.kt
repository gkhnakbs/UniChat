package com.gokhanakbas.unichatdeneme.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gokhanakbas.unichatdeneme.R
import com.gokhanakbas.unichatdeneme.adapter.RecyclerAdapter
import com.gokhanakbas.unichatdeneme.databinding.FragmentPostListBinding
import com.gokhanakbas.unichatdeneme.object_class.Posts
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PostListFragment(var user_mail : String) : Fragment() {
    private lateinit var firestore: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    val postList = ArrayList<Posts>()
    private lateinit var binding: FragmentPostListBinding
    private lateinit var recyclerViewAdapter : RecyclerAdapter


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firestore=FirebaseFirestore.getInstance()
        auth= FirebaseAuth.getInstance()

        getPostSelf()
        recyclerViewAdapter = RecyclerAdapter(postList)
        val layoutManager = LinearLayoutManager(activity?.applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = recyclerViewAdapter
        recyclerViewAdapter.notifyDataSetChanged()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // inflater.inflate(R.layout.fragment_post_list, container, false)
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getPostSelf() {
        //Buraya Firestore dan kullanıcıya ait postları çekeceğiz.

        firestore.collection("Posts").whereEqualTo("post_mail", user_mail)
            .addSnapshotListener { snapshot, exception ->

                if (exception != null) {
                    Toast.makeText(activity?.applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
                } else {

                    if (snapshot != null) {
                        if (!snapshot.isEmpty) {

                            var documents = snapshot.documents
                            postList.clear()
                            for (document in documents) {
                                var postObject = Posts(user_mail)
                                postObject.postLabel = document.get("post_label") as String
                                postObject.postDesc = document.get("post_desc") as String
                                postObject.postTime = document.get("post_time") as String
                                postObject.postFullName = document.get("post_FullName") as String
                                postList.add(postObject)
                            }
                            recyclerViewAdapter.notifyDataSetChanged()
                        }


                    }

                }
            }
    }
    }
