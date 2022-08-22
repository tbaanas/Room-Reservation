package com.example.RecruitmentTask.Service.Impl;

import com.example.RecruitmentTask.Dto.HotelDto;
import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Repository.HotelRepository;
import com.example.RecruitmentTask.Repository.ReservationRepository;
import com.example.RecruitmentTask.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private ReservationRepository repository;


    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, ReservationRepository repository) {
        this.hotelRepository = hotelRepository;
        this.repository = repository;
    }

    //TODO DO ZROBIENIA
    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel findById(long id) {

        return hotelRepository.findById(id).orElse(null);
    }


    //TODO ZROBIONE
    @Override
    public List<HotelDto> findAll() {

        List<HotelDto> collect = hotelRepository.allHotels().stream().map(hotel -> new HotelDto.HotelDtoBuilder()
                .setName(hotel.getName())
                .setArea(hotel.getArea())
                .setPrice(hotel.getPrice())
                .setText(hotel.getText())
                .build()

        ).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ReservationDto> findAllReservation(long id) {

        return changeToList(repository.getReservWhereHotelId(id));

    }

    private List<ReservationDto> changeToList(List<Reservation> reservationList) {
        return reservationList.stream().map(reservation -> new ReservationDto.ReservationDtoBuilder()
                .setDateStart(reservation.getDateStart())
                .setDateEnd(reservation.getDateEnd())
                .setReservationPrice(reservation.getReservationPrice())
                .setDays(reservation.getDays())
                .setHotel(reservation.getHotel())
                .setTenant(reservation.getTenant())
                .setLandlord(reservation.getLandlord())
                .build()
        ).collect(Collectors.toList());

    }

}
