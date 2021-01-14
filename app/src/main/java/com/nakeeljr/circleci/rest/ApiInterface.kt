package com.nakeeljr.circleci.rest

    import com.nakeeljr.circleci.models.MovieResponse
    import retrofit2.Call
    import retrofit2.http.GET
    import retrofit2.http.Query

    interface ApiInterface {

        @GET("/3/movie/popular")
        fun getPopularMovies(@Query("api_key") apiKey: String): Call<MovieResponse>
    }
