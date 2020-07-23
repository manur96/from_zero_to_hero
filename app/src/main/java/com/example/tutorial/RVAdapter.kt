package com.example.tutorial


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post.view.*


class RVAdapter(private val postList: List<Post>) :
    RecyclerView.Adapter<RVAdapter.PostViewHolder>() {

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(postList[position])


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int = postList.size


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            itemView.username.text = post.user
            itemView.description.text = post.description
            itemView.post_photo.setImageResource(post.idPhoto)
        }
    }

}
