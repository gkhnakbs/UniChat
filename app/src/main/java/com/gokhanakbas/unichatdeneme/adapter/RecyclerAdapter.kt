package com.gokhanakbas.unichatdeneme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokhanakbas.unichatdeneme.object_class.Posts
import com.gokhanakbas.unichatdeneme.databinding.RecyclerViewItemBinding
import kotlin.collections.ArrayList

class RecyclerAdapter(val postlist: ArrayList<Posts>) : RecyclerView.Adapter<RecyclerAdapter.PostsVH>() {
    //Burada post list i postlarin id sini yazariz diye dusundum.
    class PostsVH(val itemBinding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsVH {
        val itemBinding= RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        // Burada satir goruntusunu baglamis olduk.
        return PostsVH(itemBinding)
    }

    override fun getItemCount(): Int {
            return postlist.size
    }

    override fun onBindViewHolder(holder: PostsVH, position: Int) {

        holder.itemBinding.postDetails.text= postlist[position].postDesc
        holder.itemBinding.postTime.text= postlist[position].postTime.substring(11)
        holder.itemBinding.postLabel.text= postlist[position].postLabel
    }

}