package com.example.movieRest.web.rest

import com.example.movieRest.dto.MovieDTO
import com.example.movieRest.service.MovieService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MovieResource(
    private val movieService: MovieService,
) {

    @PostMapping
    fun createMovie(@RequestBody movieDTO: MovieDTO): MovieDTO? {
//        return try {
//            movieService.createMovie(movieDTO)
//        }catch (exception : IllegalArgumentException){
//            null
//        }
        return movieService.createMovie(movieDTO)
    }
}