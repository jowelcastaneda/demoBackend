package asia.corelogic.dppr.repository;

import asia.corelogic.dppr.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    ReviewEntity findByReviewId(Integer reviewId);
    List<ReviewEntity> findByRestaurantId(Integer restaurantId);
}