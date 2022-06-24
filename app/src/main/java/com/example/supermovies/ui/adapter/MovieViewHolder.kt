package com.example.supermovies.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.supermovies.api.model.MovieViewModel
import com.example.supermovies.databinding.ItemMovieBinding

class MovieViewHolder(
    private val viewBinding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(viewModel: MovieViewModel) = with(viewBinding) {
        movieImageView.load(viewModel.imageSrc)
    }
}