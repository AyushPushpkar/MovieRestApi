package com.example.movieRest.repository

import com.example.movieRest.entity.MovieEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<MovieEntity, Int> {

    @Query("SELECT m FROM MovieEntity as m")
    fun getAllMovies(): List<MovieEntity>
}