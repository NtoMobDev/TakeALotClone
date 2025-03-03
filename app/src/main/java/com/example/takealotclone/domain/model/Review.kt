package com.example.takealotclone.domain.model

data class Review(
    val comment: String,
    val rating: Int,
    val user_id: Int
)