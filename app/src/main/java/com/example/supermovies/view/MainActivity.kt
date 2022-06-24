package com.example.supermovies.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.supermovies.api.RetrofitClient
import com.example.supermovies.api.model.MovieModel
import com.example.supermovies.databinding.ActivityMainBinding
import com.example.supermovies.ui.adapter.MoviesListAdapter
import com.example.supermovies.ui.adapter.model.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter : MoviesListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        adapter= MoviesListAdapter()
        binding.recyclerView.adapter = adapter

        fetchData()
    }

    private fun fetchData(){
        RetrofitClient.fetchMovies().enqueue(object:Callback<List<MovieModel>>{
            override fun onResponse(call: Call<List<MovieModel>>,response: Response<List<MovieModel>>) {
                response.body()?.let {
                    adapter?.update(mapToViewModel(it))
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>,t: Throwable) {
                Log.e("error", "msg")//t.localizedMessage)
            }
        })
    }

    private fun mapToViewModel(movies: List<MovieModel>): List<MovieViewModel>{
        return movies.map {
            MovieViewModel(
                id = it.id.toInt(),
                rating = it.rating.toString(),
                starsCount = (it.rating/2).roundToInt(),
                imageSrc = it.imgSrc,
                title = it.name,
                showOverlay = false)
        } // it.id?.toInt() ?: -1; za rating (it.rating?.roundToInt() ?: 0)/5 - int/int ce vratit int
    }
}