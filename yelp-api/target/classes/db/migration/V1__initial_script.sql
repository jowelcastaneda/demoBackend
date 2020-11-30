CREATE TABLE RESTAURANTS (
  restaurant_id bigserial,
  restaurant_name varchar(150),
  ratings int,
  image_url varchar(150),
  created_by varchar(150),
  created_date Date,
  PRIMARY KEY (restaurant_id)
);

CREATE TABLE REVIEWS (
  review_id bigserial,
  restaurant_id int,
  reviewer_name varchar(150),
  reviewer_image_url varchar(150),
  reviewer_location varchar(150),
  review text,
  ratings int,
  created_date Date,
  PRIMARY KEY (review_id)
)