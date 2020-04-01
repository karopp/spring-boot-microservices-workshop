package io.javabrains.movieinfoservice.resources

import io.javabrains.movieinfoservice.modules.Movie
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movie")
class MovieResource {
    @RequestMapping("/{movieId}")
    fun getMovie(@PathVariable movieId: String): Movie = Movie(movieId, "Test")
}