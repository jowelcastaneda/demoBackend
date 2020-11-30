package asia.corelogic.dppr.model;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class RestaurantRequest {
    String restaurantName;
    Integer ratings;
    String createdBy;
}
