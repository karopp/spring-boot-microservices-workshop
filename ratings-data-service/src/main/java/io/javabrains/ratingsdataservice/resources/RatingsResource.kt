package io.javabrains.ratingsdataservice.resources

import io.javabrains.ratingsdataservice.modules.Rating
import io.javabrains.ratingsdataservice.modules.UserRating
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ratingsdata")
class RatingsResource {

    @RequestMapping("/{movieId}")
    fun getRating(@PathVariable movieId: String) : Rating = Rating(movieId,4)

    @RequestMapping("/users/{userId}")
    fun getUserRating(@PathVariable userId : String) =
            UserRating(listOf(Rating("1234", 4), Rating("5678", 3)))


}



