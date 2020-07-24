package com.example.tutorial

data class PostActivity(
    val user: String,
    val description: String,
    val idPhoto: Int,
    var isLiked: Boolean = false
)