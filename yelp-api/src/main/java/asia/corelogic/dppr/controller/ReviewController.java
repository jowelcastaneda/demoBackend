package asia.corelogic.dppr.controller;

import asia.corelogic.dppr.model.ReviewResponse;
import asia.corelogic.dppr.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @ApiOperation(
            value = "Create a review",
            notes = "Returns an object of review details."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addReview() {
        return reviewService.saveReview();
    }

    @ApiOperation(
            value = "Retrieve a review",
            notes = "Returns an object of review details.")
    @GetMapping("/{reviewId}")
    public ReviewResponse getReviewById(@Valid @PathVariable int reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @ApiOperation(
            value = "Get reviews for specific restaurant",
            notes = "Returns a list reviews for a specific restaurant.")
    @GetMapping("/restaurant/{restaurantId}")
    public List<ReviewResponse> getAllReviewsForRestaurant(@Valid @PathVariable int restaurantId) {
        return reviewService.getAllReviewsForRestaurant(restaurantId);
    }
}
