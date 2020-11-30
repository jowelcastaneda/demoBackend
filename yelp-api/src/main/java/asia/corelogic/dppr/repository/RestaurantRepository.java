package asia.corelogic.dppr.repository;

import asia.corelogic.dppr.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    RestaurantEntity findByRestaurantName(String restaurantName);
    RestaurantEntity findByRestaurantId(Integer restaurantName);
}