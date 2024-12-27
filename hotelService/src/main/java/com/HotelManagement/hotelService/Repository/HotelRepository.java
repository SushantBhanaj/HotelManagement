package com.HotelManagement.hotelService.Repository;

import com.HotelManagement.hotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
