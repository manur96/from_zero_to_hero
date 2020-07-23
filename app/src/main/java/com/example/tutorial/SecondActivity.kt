package com.example.tutorial

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.post.*
import kotlinx.android.synthetic.main.second_screen.*

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        val postList = generatePosts()

        rv.adapter = RVAdapter(postList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
    }

/*    private fun showEmail() {
        val mail = intent.getStringExtra("email")
        hello_user.text = mail?.split("@")?.get(0)
    }*/

    private fun generatePosts(): List<Post> {
        var post = ArrayList<Post>()
        post.add(
            Post(
                "David",
                "Hola buenas estuve en un camping el otro dia y me encanto jejejej muy comodo",
                R.drawable.ic_launcher_background
            )
        )
        post.add(
            Post(
                "Juan", "Yo estuve en la playa este fin de semana y genial :)",
                R.drawable.ic_launcher_background
            )
        )
        post.add(
            Post(
                "Laura", "Ayer salí a dar un paseo por la montaña jejejeje",
                R.drawable.ic_launcher_background
            )
        )

        post.add(
            Post(
                "Pedro", "Estuve esta mañana en la playa viendo el amanecer. Que bonito!",
                R.drawable.ic_launcher_background
            )
        )

        return post
    }

    private fun changeColor() {
        if(like.callOnClick()){
            Toast.makeText(baseContext, "He dado me gusta a ", Toast.LENGTH_SHORT).show()
        }
    }
}