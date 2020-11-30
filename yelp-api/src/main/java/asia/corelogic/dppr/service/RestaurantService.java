package asia.corelogic.dppr.service;

import asia.corelogic.dppr.entity.RestaurantEntity;
import asia.corelogic.dppr.exception.ErrorException;
import asia.corelogic.dppr.model.RestaurantRequest;
import asia.corelogic.dppr.model.RestaurantResponse;
import asia.corelogic.dppr.repository.RestaurantRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<RestaurantResponse> saveRestaurant(@NonNull String restaurantName, String owner) {
        // Create request body
        RestaurantRequest restaurantRequest = RestaurantRequest.builder()
                .restaurantName(restaurantName)
                .ratings(5)
                .createdBy(owner)
                .build();

        // Check if restaurant name is valid
        validateRestaurantName(restaurantRequest.getRestaurantName());

        // Create Restaurant Entity
        RestaurantEntity restaurantEntity = RestaurantEntity.builder()
                .restaurantName(restaurantRequest.getRestaurantName())
                .ratings(restaurantRequest.getRatings())
                .imageUrl("/src/images/restaurants/"+ restaurantRequest.getRestaurantName() +".jpg")
                .createdBy(restaurantRequest.getCreatedBy())
                .createdDate(new Date())
                .build();

        // Save Restaurant
        RestaurantEntity savedData = restaurantRepository.save(restaurantEntity);
        mapReportEntityToResponse(savedData);

        return getAllRestaurants();
    }

    public RestaurantResponse getRestaurantByRestaurantId(@NonNull int restaurantId) {
        // Get restaurant from database
        RestaurantEntity restaurant = restaurantRepository.findByRestaurantId(restaurantId);

        if(restaurant == null) {
            throw ErrorException.noRestaurantFound();
        }
        return mapReportEntityToResponse(restaurant);
    }

    public List<RestaurantResponse> getAllRestaurants() {
        // Get all available restaurants from database
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();

        // Create response body
        List<RestaurantResponse> allRestaurants = new ArrayList<>();
        restaurants.forEach(restaurant -> allRestaurants.add(mapReportEntityToResponse(restaurant)));

        return allRestaurants;
    }

    private RestaurantResponse mapReportEntityToResponse(@NonNull RestaurantEntity reportEntity) {
        return RestaurantResponse.builder()
                .restaurantId(reportEntity.getRestaurantId())
                .restaurantName(reportEntity.getRestaurantName())
                .ratings(reportEntity.getRatings())
                .imageUrl(reportEntity.getImageUrl())
                .createdBy(reportEntity.getCreatedBy())
                .createdDate(reportEntity.getCreatedDate())
                .build();
    }

    private void validateRestaurantName(String restaurantName) {
        if(restaurantRepository.findByRestaurantName(restaurantName) != null) {
            throw ErrorException.noRestaurantFound();
        }
    }
}
