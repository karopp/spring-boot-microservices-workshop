package io.javabrains.ratingsdataservice.resources

import io.javabrains.ratingsdataservice.modules.Rating
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ratingsdata")
class RatingsResource {

    @RequestMapping("/{movieId}")
    fun getRating(@PathVariable movieId: String) : Rating = Rating(movieId,4)
}