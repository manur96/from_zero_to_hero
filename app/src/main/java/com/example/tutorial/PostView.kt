package com.example.tutorial

data class PostView(
    val user: String,
    val description: String,
    val urlPhoto: String,
    var isLiked: Boolean = false
)