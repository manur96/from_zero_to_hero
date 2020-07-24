package com.example.tutorial


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_post.view.*


class RVAdapter(private val postList: List<PostActivity>, private val onItemClick: (PostActivity) -> Unit) :
    RecyclerView.Adapter<RVAdapter.PostViewHolder>() {

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(postList[position])


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_post, parent, false)
        return PostViewHolder(itemView){
            onItemClick(postList[it])
            itemView.like.setTextColor(Color.parseColor("#03DAC5"))
        }
    }

    override fun getItemCount(): Int = postList.size

    //Intentar cambiar la vista (Azul el Me gusta)
    //Al clickar poner como Me gusta el modelo y cambiar la vista

    class PostViewHolder(itemView: View, private val onItemClick: (Int) -> Unit = {}) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.like.setOnClickListener{ onItemClick(adapterPosition) }
            itemView.comment.setOnClickListener{ onItemClick(adapterPosition) }
        }

        fun bind(postActivity: PostActivity) {
            itemView.username.text = postActivity.user
            itemView.description.text = postActivity.description
            itemView.postPhoto.setImageResource(postActivity.idPhoto)
            //itemView.like.setOnClickListener{ onItemClick(adapterPosition) }
        }
    }

}
