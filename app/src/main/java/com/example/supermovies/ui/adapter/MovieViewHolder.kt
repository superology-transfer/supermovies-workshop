package com.example.supermovies.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.supermovies.databinding.ItemMovieBinding
import com.example.supermovies.ui.adapter.model.MovieViewModel

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(viewModel: MovieViewModel) = with(binding){
        //root.setOnClickListener{ actionListener.On}

        movieImageView.load(viewModel.imageSrc)
    }
}