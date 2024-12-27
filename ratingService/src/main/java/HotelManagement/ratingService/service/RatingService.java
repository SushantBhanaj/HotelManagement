package HotelManagement.ratingService.service;

import HotelManagement.ratingService.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all by UserId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
