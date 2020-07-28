package com.example.tutorial

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_recycler_view.*

class SecondActivity : Activity() {

    private val adapter = RVAdapter(
        onLikeClick = {
            it.isLiked = !it.isLiked
            notifyChange()
            Toast.makeText(
                baseContext,
                "${if (it.isLiked) "He dado" else "He quitado el"} like a ${it.user}",
                Toast.LENGTH_SHORT
            ).show()
        },
        onCommentClick = {
            Toast.makeText(baseContext, "He comentado en el post de ${it.user}", Toast.LENGTH_SHORT)
                .show()
        }
    )

    private fun notifyChange() {
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val postList = generatePosts()

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        adapter.addAll(postList)

        addPost()
    }

    private fun generatePosts() = mutableListOf(
        PostView(
            "David",
            "Hola buenas estuve en un camping el otro dia y me encanto jejeje muy cómodo",
            R.drawable.ic_launcher_background
        ),
        PostView(
            "Juan", "Yo estuve en la playa este fin de semana y genial :)",
            R.drawable.ic_launcher_background
        ),
        PostView(
            "Laura", "Ayer salí a dar un paseo por la montaña :P",
            R.drawable.ic_launcher_background
        ),
        PostView(
            "Pedro", "Estuve esta mañana en la playa viendo el amanecer. ¡Que bonito!",
            R.drawable.ic_launcher_background,
            true
        )
    )

    private fun addPost() {
        this.fab.setOnClickListener { view ->
            Snackbar.make(view, "Nuevo post añadido", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            adapter.add(
                PostView(
                    "Marina", "Probando nuevo post",
                    R.drawable.ic_launcher_background
                )
            )
        }
    }

    //Clases: LoQueSeaActivity
    //Diseño: activity_lo_que_sea
    //Items adapter: item_algo
}