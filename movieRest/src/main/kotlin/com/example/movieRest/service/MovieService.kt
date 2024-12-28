package com.example.movieRest.service

import com.example.movieRest.dto.MovieDTO

interface MovieService {

    fun createMovie(movieDTO: MovieDTO) : MovieDTO

    fun getMovie() : List<MovieDTO>

    fun getMovieById(id : Int) : MovieDTO

    fun updateMovie(movieDTO: MovieDTO) :MovieDTO

    fun deleteMovie(id : Int)
}