package com.example.tutorial


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post.view.*
import kotlinx.android.synthetic.main.second_screen.*


class RVAdapter (private val postList: List<Post>) : RecyclerView.Adapter<RVAdapter.PostViewHolder>() {

    class PostViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.description
        val photo_post: ImageView = itemView.post_photo
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = postList[position]
        holder.description.text = postList[position].description
        holder.photo_post.setImageResource(postList[position].idPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
