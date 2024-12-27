package com.example.movieRest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class MovieRestApplication {

	@GetMapping("/hello")
	fun hello(): String {
		return "Hello World 4"
	}
}

fun main(args: Array<String>) {
	runApplication<MovieRestApplication>(*args)
}
