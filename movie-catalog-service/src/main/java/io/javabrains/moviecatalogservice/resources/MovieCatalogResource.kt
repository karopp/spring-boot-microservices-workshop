package io.javabrains.moviecatalogservice.resources

import io.javabrains.moviecatalogservice.modules.CatalogItem
import io.javabrains.moviecatalogservice.modules.Movie
import io.javabrains.moviecatalogservice.modules.Rating
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {
    @RequestMapping("/{userId}")
    fun getCatalog(@PathVariable userId: String) : List<CatalogItem> {

        val restTemplate = RestTemplate()
        val ratings = listOf(Rating("123", 4), Rating("456", 6))
        return ratings.map { rating ->
            val movie = requireNotNull(restTemplate.getForObject("http://localhost:8081/movie/${rating.movieId}", Movie::class.java))
             CatalogItem(movie.name, "Action", rating.rating) }.toList()




    }
}