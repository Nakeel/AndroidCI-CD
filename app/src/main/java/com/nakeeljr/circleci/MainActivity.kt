package com.nakeeljr.circleci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nakeeljr.circleci.models.MovieItem
import com.nakeeljr.circleci.models.MovieModel
import com.nakeeljr.circleci.viewmodel.MainActivityViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar : ProgressBar
    private lateinit var mMovieRecycler : RecyclerView
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        mMovieRecycler = findViewById(R.id.movieRecyclerView)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        viewModel.getMovieLiveData().observe(this, Observer {
            progressBar.visibility = View.GONE
//            movieAdapter.submitList(it)
            createMovieList(it)
        })

    }

    private fun createMovieList(movieList :List<MovieModel>) {
        val itemList = mutableListOf<Item>()
        for (movie in movieList) {
            val movieTicketItem = MovieItem(movie, this)
            itemList.add(movieTicketItem)
        }
        createMovieTicketList(itemList)
    }


    private lateinit var   movieTicketSection : Section
    fun createMovieTicketList(movieListItem: List<Item>) {
        var shouldInitRecyclerview = true
        fun init() {
            mMovieRecycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = GroupAdapter<ViewHolder>().apply {
                    movieTicketSection = Section(movieListItem)
                    this.add(movieTicketSection)
//                    setOnItemClickListener(onItemClick)
                }
                shouldInitRecyclerview = false
            }
        }
        fun updateMovieTicket() = movieTicketSection.update(movieListItem)

        if (shouldInitRecyclerview){
            init()
        }else{
            updateMovieTicket()
        }
    }
}