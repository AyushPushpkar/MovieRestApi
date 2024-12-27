package com.example.movieRest.utils.mapper

import com.example.movieRest.dto.MovieDTO
import com.example.movieRest.entity.MovieEntity
import org.springframework.stereotype.Service

@Service
class MovieMapper : Mapper<MovieDTO, MovieEntity>  {
    override fun fromEntity(entity: MovieEntity): MovieDTO {
        return MovieDTO(
            entity.id ,
            entity.name ,
            entity.rating
        )
    }

    override fun toEntity(domain: MovieDTO): MovieEntity {
        return MovieEntity(
            domain.id ,
            domain.name ,
            domain.rating
        )
    }
}