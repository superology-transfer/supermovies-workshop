package com.example.supermovies.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.supermovies.api.RetrofitClient
import com.example.supermovies.api.model.MovieModel
import com.example.supermovies.api.model.MovieViewModel
import com.example.supermovies.databinding.ActivityMainBinding
import com.example.supermovies.ui.adapter.MoviesListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

/**
 * Test comment.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: MoviesListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        adapter = MoviesListAdapter()

        binding.recyclerView.adapter = adapter

        println("TEST onCreate")
        fetchData()
    }

    private fun fetchData() {
        RetrofitClient.fetchMovies().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(call: Call<List<MovieModel>>, response: Response<List<MovieModel>>) {
                response.body()?.let {
                    adapter?.update(mapToViewModel(it))
                    println("TEST onResponse")
                }
            }

            override fun onFailure(
                call: Call<List<MovieModel>>,
                t: Throwable
            ) {
                println("TEST onFailure")
                Log.e("nesto", t.localizedMessage)
            }
        })
    }

    private fun mapToViewModel(movies: List<MovieModel>) : List<MovieViewModel> {
        return movies.map { model ->
            MovieViewModel(
                id = model.id?.toInt() ?: -1,
                rating = model.rating?.toString() ?: "-",
                starsCount = (model.rating?.roundToInt() ?: 0)/2,
                imageSrc = model.imgSrc,
                title = model.name,
                showOverlay = false
            )
        }
    }
}