package com.example.movieRest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


//persistence layer
//table structure
@Entity
data class MovieEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,
    var name : String ,
    var rating : Double
)