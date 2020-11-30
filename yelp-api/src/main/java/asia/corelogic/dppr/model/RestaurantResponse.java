package asia.corelogic.dppr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import java.util.Date;


@Builder
@Value
public class RestaurantResponse {
    Integer restaurantId;
    String restaurantName;
    Integer ratings;
    String imageUrl;
    String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdDate;
}