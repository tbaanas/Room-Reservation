package com.example.RecruitmentTask.Service.Impl;

import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Repository.HotelRepository;
import com.example.RecruitmentTask.Repository.LandlordRepository;
import com.example.RecruitmentTask.Repository.ReservationRepository;
import com.example.RecruitmentTask.Repository.TenantRepository;
import com.example.RecruitmentTask.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final LandlordRepository landlordRepository;
    private final HotelRepository hotelRepository;
    private final TenantRepository tenantRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository repository, LandlordRepository landlordRepository, HotelRepository hotelRepository, TenantRepository tenantRepository) {
        this.repository = repository;
        this.landlordRepository = landlordRepository;
        this.hotelRepository = hotelRepository;
        this.tenantRepository = tenantRepository;
    }


    @Override
    public String save(Reservation reservation) {
        if (checkDate(repository.findAllByHotel(reservation.getHotel()),reservation)) {
            try {
                reservation.setHotel(hotelRepository.findById(reservation.getHotel().getId()).get());
                reservation.setTenant(tenantRepository.findById(reservation.getTenant().getId()).get());
                reservation.setLandlord(landlordRepository.findById(reservation.getLandlord().getId()).get());
            }catch (NullPointerException e){
                System.out.println("All data must be exist!");
                System.out.println(e.getMessage());
            }
            reservation.setDays(getDays(reservation));
            reservation.setReservationPrice(reservationPrice(reservation));
            repository.save(reservation);
            return "Termin został zarezerwowany!";
        } else
            return "Podany termin jest zajęty";
    }



    @Override
    public String update(Reservation oldReservation, Reservation newReservation) {
        Reservation old=repository.findById(oldReservation.getId()).get();
        Reservation newRes=repository.findById(newReservation.getId()).get();
        newRes.setDateStart(newReservation.getDateStart());
        newRes.setDateEnd(newReservation.getDateEnd());
        List<Reservation> allReservations = repository.getAllReservations(old.getId(),old.getHotel());

        if (checkDate(allReservations,newRes)) {
            old.setDays(getDays(newRes));
            old.setReservationPrice(reservationPrice(newRes));
            old.setDateStart(newRes.getDateStart());
            old.setDateEnd(newRes.getDateEnd());
            repository.save(old);
            return "Termin został zarezerwowany!";
        } else
            return "Podany termin jest zajęty";
    }


    private int getDays(Reservation reservation) {
        return (int) Duration.between(reservation.getDateStart().atStartOfDay(), reservation.getDateEnd().atStartOfDay()).toDays();
    }

    private Double reservationPrice(Reservation reservation) {
        Double price = reservation.getHotel().getPrice();

        return getDays(reservation) * price;
    }

    public static boolean checkDate(List<Reservation> reservations, Reservation newReservation) {

        boolean check = true;
        for (Reservation reservation : reservations) {

            if (reservation.getDateEnd().isAfter(newReservation.getDateStart())
                    && reservation.getDateStart().isBefore(newReservation.getDateEnd())) {
                check = false;
            }
        }
        return check;
    }


}
