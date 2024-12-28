package com.example.movieRest.web.rest

import com.example.movieRest.dto.MovieDTO
import com.example.movieRest.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MovieResource(
    private val movieService: MovieService,
) {

    @PostMapping
    fun createMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO> {

        println("Received MovieDTO: $movieDTO") // Debug log
//        return try {
//            ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED)
//        } catch (exception: IllegalArgumentException) {
//            ResponseEntity(null, HttpStatus.BAD_REQUEST)
//        }catch (exception: Exception) {
//            println("Error occurred: ${exception.message}")
//            return ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
//        }
        return ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED)
    }

    @GetMapping
    fun getMovies(): ResponseEntity<List<MovieDTO>> {
        return ResponseEntity(movieService.getMovie(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getMoviesById(@PathVariable id : Int): ResponseEntity<MovieDTO> {
        return ResponseEntity(movieService.getMovieById(id), HttpStatus.OK)
    }

    @PutMapping
    fun updateMovie(@RequestBody movieDTO: MovieDTO) : ResponseEntity<MovieDTO>{
        return ResponseEntity(movieService.updateMovie(movieDTO),HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id : Int) : ResponseEntity<Unit>{
        return ResponseEntity(movieService.deleteMovie(id),HttpStatus.NO_CONTENT)
    }
}