package asia.corelogic.dppr.model;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class ReviewRequest {
    Integer restaurantId;
    String reviewerName;
    String reviewerLocation;
    String review;
    Integer ratings;
}