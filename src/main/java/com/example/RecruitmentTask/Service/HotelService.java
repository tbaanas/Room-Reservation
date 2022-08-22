package com.example.RecruitmentTask.Service;

import com.example.RecruitmentTask.Dto.HotelDto;
import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Entity.Hotel;

import java.util.List;


public interface HotelService {

    void save(Hotel hotel);

    Hotel findById(long id);

    List<HotelDto> findAll();
    List<ReservationDto> findAllReservation(long id);

}
