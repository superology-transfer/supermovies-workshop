package com.example.supermovies.ui.adapter.model

data class MovieViewModel (
        val id: Int,
        val rating: String,
        val starsCount: Int,
        val imageSrc: String?,
        val title: String,
        var showOverlay: Boolean
)