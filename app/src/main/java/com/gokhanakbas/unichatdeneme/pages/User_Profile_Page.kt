package com.gokhanakbas.unichatdeneme.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.gokhanakbas.unichatdeneme.fragments.PostListFragmentDirections
import com.gokhanakbas.unichatdeneme.R
import com.gokhanakbas.unichatdeneme.databinding.ActivityUserProfilePageBinding
import com.gokhanakbas.unichatdeneme.fragments.LikedPostFragmentDirections

class User_Profile_Page : AppCompatActivity() {
    private lateinit var binding : ActivityUserProfilePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_page)
        binding=ActivityUserProfilePageBinding.inflate(layoutInflater)
    }
    fun posts_button(view : View){

        val action=PostListFragmentDirections.actionPostListFragment2ToLikedPostFragment2()
        Navigation.findNavController(view).navigate(action)
    }
    fun liked_button(view: View){
        val action=LikedPostFragmentDirections.actionLikedPostFragment2ToPostListFragment2()
        Navigation.findNavController(view).navigate(action)
    }
}