package com.HotelManagement.hotelService.service.Impl;

import com.HotelManagement.hotelService.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);
}
