package com.gokhanakbas.unichatdeneme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokhanakbas.unichatdeneme.databinding.RecyclerViewItemBinding
import java.util.ArrayList

class RecyclerAdapter(val postlist : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.PostsVH>() {
    //Burada post list i postlarin id sini yazariz diye dusundum.
    private lateinit var binding : RecyclerViewItemBinding
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

        holder.itemBinding
    }

}