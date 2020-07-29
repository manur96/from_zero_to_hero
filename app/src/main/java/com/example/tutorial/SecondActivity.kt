package com.example.tutorial

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_post.*
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
            "http://lorempixel.com/400/200/sports/7/"
        ),
        PostView(
            "Juan", "Yo estuve en la playa este fin de semana y genial :)",
            "http://lorempixel.com/400/200/sports/5/"
        ),
        PostView(
            "Laura", "Ayer salí a dar un paseo por la montaña :P",
            "http://lorempixel.com/400/200/cats/2/"
        ),
        PostView(
            "Pedro", "Estuve esta mañana en la playa viendo el amanecer. ¡Que bonito!",
            "http://lorempixel.com/400/200/sports/3/",
            true
        )
    )

    private fun addPost() {
        //Alert dialog
        this.fab.setOnClickListener { view ->
            Snackbar.make(view, "Nuevo post añadido", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            adapter.add(
                PostView(
                    "Marina", "Probando nuevo post",
                    "http://lorempixel.com/400/200/sports/1/"
                )
            )
            //showDialog()
        }
    }
/*
    private fun showDialog(){
        AlertDialog.Builder(this)
            .setTitle("Nuevo post")
            .setMessage("¿Quieres crear un nuevo post?")
            .setPositiveButton("Si", DialogInterface.OnClickListener{ dialogInterface: DialogInterface, i: Int ->
                adapter.add(
                PostView(
                    "Marina", "Probando nuevo post",
                    "http://lorempixel.com/400/200/sports/1/"
                )
            )})
    }*/

    //Clases: LoQueSeaActivity
    //Diseño: activity_lo_que_sea
    //Items adapter: item_algo
}