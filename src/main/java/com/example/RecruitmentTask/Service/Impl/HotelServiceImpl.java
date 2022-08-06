package com.example.RecruitmentTask.Service.Impl;

import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Repository.HotelRepository;
import com.example.RecruitmentTask.Repository.ReservationRepository;
import com.example.RecruitmentTask.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private ReservationRepository repository;

@Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, ReservationRepository repository) {
        this.hotelRepository = hotelRepository;
        this.repository = repository;
    }

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel findById(long id) {

        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Reservation> findAllReservation(Hotel hotel) {

        return repository.getReservWhereHotelId(hotel.getId());

    }

}
