package com.example.supermovies.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.supermovies.api.model.MovieViewModel
import com.example.supermovies.databinding.ItemMovieBinding

class MoviesListAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var data: List<MovieViewModel> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun update(movies: List<MovieViewModel>) {
        this.data = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieViewModel = this.data[position]
        holder.bind(movieViewModel)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}