package com.example.tutorial

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.second_screen.*

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

       //showEmail()

        val postList = generatePosts()

        rv.adapter = RVAdapter(postList)
        rv.layoutManager = LinearLayoutManager(this);

    }

/*    private fun showEmail() {
        val mail = intent.getStringExtra("email")
        hello_user.text = mail?.split("@")?.get(0)
    }*/

    private fun generatePosts(): List<Post>{
        var post = ArrayList<Post>()
        post.add(Post("Hola buenas estuve en este camping el otro dia y me encanto jejejej muy comodo", 32))
        return post
    }
}