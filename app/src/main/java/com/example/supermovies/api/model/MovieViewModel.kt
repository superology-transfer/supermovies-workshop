package com.example.supermovies.api.model

data class MovieViewModel(
    val id: Int,
    val rating: String,
    val starsCount: Int,
    val imageSrc: String?,
    val title: String?,
    val showOverlay: Boolean
)