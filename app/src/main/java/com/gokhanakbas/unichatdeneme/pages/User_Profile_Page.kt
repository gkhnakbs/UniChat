package com.gokhanakbas.unichatdeneme.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.gokhanakbas.unichatdeneme.fragments.PostListFragmentDirections
import com.gokhanakbas.unichatdeneme.R
import com.gokhanakbas.unichatdeneme.databinding.ActivityUserProfilePageBinding
import com.gokhanakbas.unichatdeneme.databinding.FragmentLikedPostBinding
import com.gokhanakbas.unichatdeneme.fragments.LikedPostFragment
import com.gokhanakbas.unichatdeneme.fragments.LikedPostFragmentDirections
import com.gokhanakbas.unichatdeneme.fragments.PostListFragment

class User_Profile_Page : AppCompatActivity() {
    private lateinit var binding : ActivityUserProfilePageBinding
    private var fragmentStatus : Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUserProfilePageBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }
    fun posts_button(view: View){
        if(fragmentStatus!=0){
            val fragment=PostListFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView3,fragment)
                .commit()
            /*val action=PostListFragmentDirections.actionPostListFragmentToLikedPostFragment()
            Navigation.findNavController(view).navigate(action)*/
            fragmentStatus=0
            }
    }

    fun liked_button(view: View){
        if(fragmentStatus!=1){
            val fragment=LikedPostFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView3,fragment)
                .commit()
            /*val action=LikedPostFragmentDirections.actionLikedPostFragmentToPostListFragment()
            Navigation.findNavController(view).navigate(action)*/
            fragmentStatus=1
        }
    }

}