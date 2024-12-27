package com.example.movieRest.utils.exception

import org.springframework.http.HttpStatus
import java.io.ObjectInputFilter.Status

data class ApiError(
    private val _message: String?,
    val status: HttpStatus = HttpStatus.BAD_REQUEST,
    val code : Int = status.value()
){

    val message: String
        get() = _message ?: "Something went wrong"

}