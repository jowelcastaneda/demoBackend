package asia.corelogic.dppr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.util.Date;


@Builder
@Value
public class ReviewResponse {
    Integer reviewId;
    String restaurantName;
    String reviewerName;
    String reviewerImageUrl;
    String reviewerLocation;
    String review;
    int ratings;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdDate;
}
