package com.example.tutorial

data class PostView(
    val user: String,
    val description: String,
    val idPhoto: Int,
    var isLiked: Boolean = false
)