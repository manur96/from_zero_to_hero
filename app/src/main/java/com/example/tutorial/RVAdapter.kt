package com.example.tutorial


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.android.synthetic.main.activity_post.view.*
import kotlinx.android.synthetic.main.activity_post.view.postPhoto


class RVAdapter(
    private val postList: MutableList<PostView> = mutableListOf(),
    private val onLikeClick: (PostView) -> Unit,
    private val onCommentClick: (PostView) -> Unit
) :
    RecyclerView.Adapter<RVAdapter.PostViewHolder>() {

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(postList[position])


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_post, parent, false)
        return PostViewHolder(itemView,
            {onLikeClick(postList[it])},
            {onCommentClick(postList[it])})
    }

    override fun getItemCount(): Int = postList.size

    fun addAll(posts: List<PostView>) {
        postList.addAll(posts)
        notifyDataSetChanged()
    }

    fun add(post: PostView){
        postList.add(post)
        notifyDataSetChanged()
    }

    class PostViewHolder(
        itemView: View,
        private val onLikeClick: (Int) -> Unit = {},
        private val onCommentClick: (Int) -> Unit = {}
    ) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.like.setOnClickListener { onLikeClick(adapterPosition) }
            itemView.comment.setOnClickListener { onCommentClick(adapterPosition) }
        }

        fun bind(postView: PostView) {
            itemView.username.text = postView.user
            itemView.description.text = postView.description
            itemView.postPhoto.loadUrl(postView.urlPhoto)
            if (postView.isLiked) {
                itemView.like.setTextColor(Color.parseColor("#03DAC5"))
            } else {
                itemView.like.setTextColor(Color.parseColor("#000000"))
            }
        }
    }

}
