package asia.corelogic.dppr.service;

import asia.corelogic.dppr.entity.ReviewEntity;
import asia.corelogic.dppr.exception.ErrorException;
import asia.corelogic.dppr.model.ReviewResponse;
import asia.corelogic.dppr.repository.RestaurantRepository;
import asia.corelogic.dppr.repository.ReviewRepository;
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
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public String saveReview() {
        // Create Request Body
        ReviewEntity reviewRequest1 = ReviewEntity.builder()
                .restaurantId(1)
                .reviewerName("Ileyka W.")
                .reviewerImageUrl("/src/images/review/Ileyka.jpg")
                .reviewerLocation("Vinita, OK")
                .review("Very cute atmosphere and good service. If you have a mood for fish and drinks check this place out.Their menu is so friendly and it was easy to order. Delicious sushi. So many flavors. High quality fish and presentation. This was my first visit but I'll come back again!")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest2 = ReviewEntity.builder()
                .restaurantId(1)
                .reviewerName("Sean F.")
                .reviewerImageUrl("/src/images/review/Sean.jpg")
                .reviewerLocation("Charleston, SC")
                .review("I came here for my birthday dinner and this was by far one of my top dining experiences, ever! Not only is the food top notch, but so was the service. I'm so sorry that I forgot our servers name, but he literally treated us like we were celebrities. To add to that, the upscale and intimate decor also makes this place feel quite special. This is definitely a place that would be great for a date or a special occasion.")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest3 = ReviewEntity.builder()
                .restaurantId(1)
                .reviewerName("Marina J.")
                .reviewerImageUrl("/src/images/review/Marina.jpg")
                .reviewerLocation("Downtown Los Angeles, Los Angeles, CA")
                .review("It was my satisfying experience with Restaurant Anzu .I tried their fish ,which was normal in taste and presentation though my order came on time so appreciate their service .Their was some spices issue in fish yet its taste was not bad .Their environment was calm and soothing.")
                .ratings(3)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest4 = ReviewEntity.builder()
                .restaurantId(1)
                .reviewerName("Stefanie C.")
                .reviewerImageUrl("/src/images/review/Stefanie.jpg")
                .reviewerLocation("Denver, CO")
                .review("4 stars. Fun dining experience at ANZU! Located inside Hotel Nikko, I met up with Nina Y. for our first dinner date in awhile. Just like our spontaneous adventure to an expensive steakhouse, we decided to try the omakase here. It was fueled by some delicious cocktails and enjoyment from looking at the gorgeous decor all around.")
                .ratings(4)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest5 = ReviewEntity.builder()
                .restaurantId(1)
                .reviewerName("Frank W.")
                .reviewerImageUrl("/src/images/review/Frank.jpg")
                .reviewerLocation("San Francisco, CA")
                .review("This is an update. I have been meaning to write it. I have been to this restaurant probably a dozen times over the past decade. I'm betting it has changed chefs or managers during that time period. It's better than when I first reviewed it, and I would not hesitate to recommend it.First, what is it? It's a classy Japanese restaurant in a fancy Japanese hotel (where I've stayed a few times for conferences). By the standard of Japanese restaurants, it is neither cheap nor expensive; you can easily drop $100 per person, with tax and tip, or even $150, but you could eat for $60 with a single drink. So for the cuisine and the city, that rates in the middle.Second, how \"authentic\" is it? That term is contested, rightly. California rolls are in some sense not authentic, as you might guess from the name, but they are very much part of Japanese food in America. Another means of considering it is what clientele the place is catering to. This is for people who like rolls. It's not one of those places that prides itself on not serving what the suburban supermarket also carries. To the contrary, they're doing fusion as if it hadn't become frowned upon. That's fine.")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest6 = ReviewEntity.builder()
                .restaurantId(2)
                .reviewerName("Gabrielle W.")
                .reviewerImageUrl("/src/images/review/Gabrielle.jpg")
                .reviewerLocation("Denver, CO")
                .review("I used to live in San Francisco and was delighted to see that this gorgeous restaurant opened in Cole Valley.   was enjoying a solo trip, so I made a reservation to dine alone in the outdoor patio area.  From what I could see, the interior of the space is beautiful, and I look forward to the day when I can visit again and sit inside once the pandemic is over.  I also look forward to exploring the wine list,  which I didn't get a chance to do because I was too busy enjoying the yummy craft cocktails.  I enjoy traveling and dining alone.  At CeoLA, the service was so fantastic, I wasn't alone for long.")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest7 = ReviewEntity.builder()
                .restaurantId(2)
                .reviewerName("Mimi T.")
                .reviewerImageUrl("/src/images/review/Mimi.jpg")
                .reviewerLocation("San Francisco, CA")
                .review("We had food from here twice - Once our friends brought it over the second time we did pick up. Sorry - no pics because both times we devoured the food too quickly.")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest8 = ReviewEntity.builder()
                .restaurantId(2)
                .reviewerName("Sandeep C.")
                .reviewerImageUrl("/src/images/review/Sandeep.jpg")
                .reviewerLocation("San Mateo, CA")
                .review("The staff is friendly here! But they didn't follow Covid guidelines (6 feet apart). I had several other issues with my order. My chai latte came cold. I ordered the basic breakfast with chicken apple sausage and they gave me pork. I did let them know and they made a new plate for me in less than 5 mins. Their Roxanne special is def worth $15 for two bacons, pancakes, Sausage and eggs.")
                .ratings(3)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest9 = ReviewEntity.builder()
                .restaurantId(2)
                .reviewerName("Matt Y.")
                .reviewerImageUrl("/src/images/review/Matt.jpg")
                .reviewerLocation("Outer Sunset, San Francisco, CA")
                .review("Beginning with cocktails, my No Ka Oi was all you would want in a cocktail: smooth, subtle, well balanced, etc. My gf ordered the Mai Tai, the basics of which were the best of any we've tried in the islands. The passionfruit foam that floated upon it, however, made it celestial, and I assume is the result of some dark sorcery.")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest10 = ReviewEntity.builder()
                .restaurantId(2)
                .reviewerName("Mike 'Mikey' K.")
                .reviewerImageUrl("/src/images/review/Mike.jpg")
                .reviewerLocation("Outer Sunset, San Francisco, CA")
                .review("Well, how random that we ended up here. Dad was in Sacramento on his way home and was jonesin' for good Indian food; we decided to meet him halfway from our Marin home and found Saffron on Yelp.")
                .ratings(3)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest11 = ReviewEntity.builder()
                .restaurantId(3)
                .reviewerName("Jozza M.")
                .reviewerImageUrl("/src/images/review/Jozza.jpg")
                .reviewerLocation("San Jose, CA")
                .review("Kev surprised me for lunch here and it was phenomenal! I got the seared scallop and crab risotto and kev got the cioppino. Also got some cup of chowder and some fresh oysters (can never get enough oysters)  ")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest12 = ReviewEntity.builder()
                .restaurantId(3)
                .reviewerName("Connie L.")
                .reviewerImageUrl("/src/images/review/Connie.jpg")
                .reviewerLocation("San Diego, CA")
                .review("I was so happy I got to try these mochi donuts out! They did not disappoint! Maybe I'm biased because I just love mochi in general, lol. We tried chocolate (not pictured. Ate it before we snapped a pic), mango, cinnamon & matcha. Honestly, every flavor we tried was good, the mango was super yummy. The texture of these is addicting")
                .ratings(4)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest13 = ReviewEntity.builder()
                .restaurantId(3)
                .reviewerName("Alice C.")
                .reviewerImageUrl("/src/images/review/Alice.jpg")
                .reviewerLocation("San Francisco, CA")
                .review("Im very happy I found this sushi place. The quality of seafood is fresh and high up there.There was no fishiness to the sushi and the toro just melted in my mouth. I've had toro at other sushi places and felt disappointed to be served just a slightly better cut of maguro. This is legit tuna belly.")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest14 = ReviewEntity.builder()
                .restaurantId(3)
                .reviewerName("Mina N.")
                .reviewerImageUrl("/src/images/review/Mina.jpg")
                .reviewerLocation("Las Vegas, NV")
                .review("Perfect spot if you are dining at Pier 39! They have delicious cocktails, fresh seafood, and a great view. Service was quick & efficient, and everyone was friendly. We got the Clam Chowder soup, Oysters, Seared Scallop & Crab Risotto and Lobster Tails. We were very much full and happy haha. Will be back when we visit SF again!")
                .ratings(5)
                .createdDate(new Date())
                .build();
        ReviewEntity reviewRequest15 = ReviewEntity.builder()
                .restaurantId(3)
                .reviewerName("Ellen F.")
                .reviewerImageUrl("/src/images/review/Ellen.jpg")
                .reviewerLocation("Morristown, NJ")
                .review("I love Denville Dairy. Their service is always fast and great plus the ice creams are delicious. I love their cake but for the first time I tried this Vanilla fudge crunchy pie and I have no words to describe it. If you like ice cream, fudge and a crunch, you must try this pie. Is super well served, so great to buy for a get together with friends.")
                .ratings(5)
                .createdDate(new Date())
                .build();

        // Group all data
        List<ReviewEntity> allReviews = new ArrayList<>();
        allReviews.add(reviewRequest1);
        allReviews.add(reviewRequest2);
        allReviews.add(reviewRequest3);
        allReviews.add(reviewRequest4);
        allReviews.add(reviewRequest5);
        allReviews.add(reviewRequest6);
        allReviews.add(reviewRequest7);
        allReviews.add(reviewRequest8);
        allReviews.add(reviewRequest9);
        allReviews.add(reviewRequest10);
        allReviews.add(reviewRequest11);
        allReviews.add(reviewRequest12);
        allReviews.add(reviewRequest13);
        allReviews.add(reviewRequest14);
        allReviews.add(reviewRequest15);


        // Save Restaurant
        allReviews.forEach(reviewRepository::save);

        return "success";
    }

    public ReviewResponse getReviewById(@NonNull int reviewId) {
        // Get review from database
        ReviewEntity review = reviewRepository.findByReviewId(reviewId);

        if(review == null) {
            throw ErrorException.noReviewFound();
        }
        return mapReportEntityToResponse(review);
    }

    public List<ReviewResponse> getAllReviewsForRestaurant(@NonNull int reviewId) {
        // Get all reviews for specific restaurant from database
        List<ReviewEntity> reviews = reviewRepository.findByRestaurantId(reviewId);

        // Create response body
        List<ReviewResponse> allReviews = new ArrayList<>();
        reviews.forEach(review -> allReviews.add(mapReportEntityToResponse(review)));

        return allReviews;
    }

    private ReviewResponse mapReportEntityToResponse(@NonNull ReviewEntity reviewEntity) {
        return ReviewResponse.builder()
                .reviewId(reviewEntity.getReviewId())
                .restaurantName(restaurantRepository.findByRestaurantId(reviewEntity.getRestaurantId()).getRestaurantName())
                .reviewerName(reviewEntity.getReviewerName())
                .reviewerImageUrl(reviewEntity.getReviewerImageUrl())
                .reviewerLocation(reviewEntity.getReviewerLocation())
                .review(reviewEntity.getReview())
                .ratings(reviewEntity.getRatings())
                .createdDate(reviewEntity.getCreatedDate())
                .build();
    }
}
