package com.example.tutorial

import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}

fun AlertDialog.Builder.confirmNewPost(rv: RVAdapter) {
    this.setTitle("Nuevo post")
        .setMessage("¿Quieres crear un nuevo post?")
        .setPositiveButton(
            "Sí",
            DialogInterface.OnClickListener { dialogInterface: DialogInterface, i: Int ->
                rv.add(
                    PostView(
                        "Marina", "Probando nuevo post",
                        "http://lorempixel.com/400/200/sports/1/"
                    )
                )
            })
        .setNegativeButton(
            "No",
            DialogInterface.OnClickListener { dialogInterface: DialogInterface, i: Int -> })
        .show()
}