package com.example.supermovies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.supermovies.databinding.ItemMovieBinding
import com.example.supermovies.ui.adapter.model.MovieViewModel

class MoviesListAdapter() : RecyclerView.Adapter<MovieViewHolder>() {

    private var data: List<MovieViewModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MovieViewHolder {
        val viewBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false) //predajemo view context od recycler viewa
        return MovieViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int ) { //postavio podatke na view
        val movieViewModel = data[position]
        holder.bind(movieViewModel)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun update(movies : List<MovieViewModel>){
        this.data = movies
        notifyDataSetChanged()
    }
}