package com.example.tutorial

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val postList = generatePosts()

        rv.adapter = RVAdapter(postList) {
            it.isLiked = true
            Toast.makeText(baseContext, "He dado me gusta a " + it.user, Toast.LENGTH_SHORT).show()
        }
        rv.layoutManager = LinearLayoutManager(this)
    }

    //Clases: LoQueSeaActivity
    //Diseño: activity_lo_que_sea
    //Items adapter: item_algo

    private fun generatePosts() = listOf(
        PostActivity(
            "David",
            "Hola buenas estuve en un camping el otro dia y me encanto jejejej muy comodo",
            R.drawable.ic_launcher_background
        ),
        PostActivity(
            "Juan", "Yo estuve en la playa este fin de semana y genial :)",
            R.drawable.ic_launcher_background
        ),
        PostActivity(
            "Laura", "Ayer salí a dar un paseo por la montaña jejejeje",
            R.drawable.ic_launcher_background
        ),
        PostActivity(
            "Pedro", "Estuve esta mañana en la playa viendo el amanecer. Que bonito!",
            R.drawable.ic_launcher_background
        )
    )

}