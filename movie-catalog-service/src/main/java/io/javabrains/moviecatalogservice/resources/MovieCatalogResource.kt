package io.javabrains.moviecatalogservice.resources

import io.javabrains.moviecatalogservice.modules.CatalogItem
import io.javabrains.moviecatalogservice.modules.Movie
import io.javabrains.moviecatalogservice.modules.UserRating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {

    @Autowired
    private lateinit var restTemplate : RestTemplate

    @RequestMapping("/{userId}")
    fun getCatalog(@PathVariable userId: String) : List<CatalogItem> {

        val ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/$userId", UserRating::class.java)

        return ratings.userRating.map { rating ->
            val movie = requireNotNull(restTemplate.getForObject("http://localhost:8081/movie/${rating.movieId}", Movie::class.java))
             CatalogItem(movie.name, "Action", rating.rating) }.toList()




    }
}