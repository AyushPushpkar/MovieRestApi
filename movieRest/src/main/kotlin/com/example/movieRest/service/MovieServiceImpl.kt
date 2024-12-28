package com.example.movieRest.service

import com.example.movieRest.dto.MovieDTO
import com.example.movieRest.repository.MovieRepository
import com.example.movieRest.utils.exception.MovieException
import com.example.movieRest.utils.mapper.MovieMapper
import org.springframework.stereotype.Service
import kotlin.concurrent.thread

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movieDTO: MovieDTO): MovieDTO {

        if (movieDTO.id != null) {
            throw MovieException("Id must be null for a new movie")
        }


        // rating , name , no id
        val movie = movieMapper.toEntity(movieDTO)
        movieRepository.save(movie)
        // movie has a id after saving (auto generated in entity)
        return movieMapper.fromEntity(movie) // return updated object to the user / calling func
    }

    override fun getMovie(): List<MovieDTO> {

        val movieList = movieRepository.getAllMovies()

        if (movieList.isEmpty()) {
            throw MovieException("No movies found")
        }

        return movieList.map {
            movieMapper.fromEntity(it)
        }

//        val movieIterable = movieRepository.findAll()
//        var movieList = mutableListOf<MovieDTO>()
//
//        movieIterable.forEach {
//            movieList.add(movieMapper.fromEntity(it))
//        }

//        return movieList
    }

    override fun getMovieById(id: Int): MovieDTO {
//        val movieEntity = movieRepository.findById(id).get()

        val optionalMovie = movieRepository.findById(id)
        val movieEntity = optionalMovie.orElseThrow {
            MovieException("Movie with id $id is not found")
        }

        return movieMapper.fromEntity(movieEntity)
    }

    override fun updateMovie(movieDTO: MovieDTO): MovieDTO {

        if (movieDTO.id == null){
            throw MovieException("Give id to update the movie")
        }

//        val exists = movieRepository.existsById(movieDTO.id!!)
//        if (!exists) throw  MovieException("Movie with id ${movieDTO.id} is not found")

        getMovieById(movieDTO.id!!)

        if (movieDTO.name == "Default Movie" || movieDTO.rating == 0.0){
            throw MovieException("Complete movie object is expected")
        }
        movieRepository.save(movieMapper.toEntity(movieDTO))

        return movieDTO
    }

    override fun deleteMovie(id: Int) {

        val exists = movieRepository.existsById(id)
        if (!exists) throw  MovieException("Movie with id $id is not found")

        movieRepository.deleteById(id)
    }
}