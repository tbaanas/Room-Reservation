package com.example.RecruitmentTask.Service;

import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Reservation;

import java.util.List;


public interface HotelService {

    void save(Hotel hotel);

    Hotel findById(long id);

    List<Hotel> findAll();
    List<Reservation> findAllReservation(Hotel hotel);

}
