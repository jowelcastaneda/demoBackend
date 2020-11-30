package asia.corelogic.dppr.controller;

import asia.corelogic.dppr.model.RestaurantRequest;
import asia.corelogic.dppr.model.RestaurantResponse;
import asia.corelogic.dppr.service.RestaurantService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @ApiOperation(
            value = "Create a restaurant data",
            notes = "Returns an object of restaurant details."
    )
    @PostMapping("/{restaurantName}/{owner}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<RestaurantResponse> addRestaurant(@Valid @PathVariable String restaurantName, @PathVariable String owner) {
        return restaurantService.saveRestaurant(restaurantName, owner);
    }

    @ApiOperation(
            value = "Get all available restaurants",
            notes = "Returns a list of object of restaurant details.")
    @GetMapping
    public List<RestaurantResponse> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @ApiOperation(
            value = "Get a specific restaurant",
            notes = "Returns an object of restaurant details.")
    @GetMapping("/{restaurantId}")
    public RestaurantResponse getRestaurantByReportId(@Valid @PathVariable int restaurantId) {
        return restaurantService.getRestaurantByRestaurantId(restaurantId);
    }
}
