package com.nakeeljr.circleci.models

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nakeeljr.circleci.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder


class MovieItem(val movieDataItem: MovieModel, val context: Context) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {

        val movieImage = viewHolder.itemView.findViewById<ImageView>(R.id.movieImage)
        val movieTitle = viewHolder.itemView.findViewById<TextView>(R.id.movieTitle)
        movieTitle.text = movieDataItem.title
        loadImage(movieDataItem.backdropPath,movieImage,context)

    }

    fun loadImage(imagePath: String, intoView : ImageView, context: Context) {
            //remove unneccessary elements in string
            Glide.with(context)
                .load(imagePath.replace("\\", ""))
                .into(intoView)
        }




    override fun getLayout() = R.layout.movie_item



    override fun isSameAs(other: com.xwray.groupie.Item<*>?): Boolean {
        if (other !is MovieItem)
            return false
        if (this.movieDataItem != other.movieDataItem)
            return false
        return true
    }

    override fun equals(other: Any?): Boolean {
        return isSameAs(other as? MovieItem)
    }

    override fun hashCode(): Int {
        return movieDataItem.hashCode()
    }

}