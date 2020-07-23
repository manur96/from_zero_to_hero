package com.example.tutorial

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*

class FirstActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        login.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val email = this.email.text.toString()
        val password = this.password.text.toString()

        if (password == "test" && email == "test@gmail.com") {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        } else {
            Toast.makeText(baseContext, "E-mail o contraseña incorrectos", Toast.LENGTH_SHORT)
                .show()
        }
    }

}