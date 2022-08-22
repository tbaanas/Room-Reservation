package com.example.RecruitmentTask.Service.Impl;

import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Repository.HotelRepository;
import com.example.RecruitmentTask.Repository.LandlordRepository;
import com.example.RecruitmentTask.Repository.ReservationRepository;
import com.example.RecruitmentTask.Repository.TenantRepository;
import com.example.RecruitmentTask.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String save(ReservationDto dto) {

        ReservationDto reservationDto = saveCheck(dto);
        if (reservationDto != null) {

            repository.save(new Reservation.ReservationBuild()
                    .setDateStart(dto.getDateStart())
                    .setDateEnd(dto.getDateEnd())
                    .setDays(dto.getDays())
                    .setReservationPrice(dto.getReservationPrice())
                    .setTenant(dto.getTenant())
                    .setLandlord(dto.getLandlord())
                    .setHotel(dto.getHotel())
                    .build()
            );

          /*  repository.saveReservation(dto.getDateStart(),
                    dto.getDateEnd(),
                    dto.getDays(),
                    dto.getReservationPrice(),
                    dto.getTenant().getId(),
                    dto.getLandlord().getId(),
                    dto.getHotel().getId());*/
            return "Termin został zarezerwowany!";
        } else
            return "Podany termin jest zajęty";

    }


    @Override
    public String update(ReservationDto oldReservation, ReservationDto newReservation) {

        Reservation newRes = getNew(newReservation);
        newRes.setDateStart(newReservation.getDateStart());
        newRes.setDateEnd(newReservation.getDateEnd());
        List<Reservation> allReservations = repository.getAllReservations(oldReservation.getId(), getOld(oldReservation).getHotel());

        //TODO DO ZROBIENIA UPDATE!
        if (checkDate(allReservations, changeToDTO(newRes))) {

            repository.save(updateCheck(oldReservation, newReservation));
            return "Termin został zarezerwowany!";
        } else
            return "Podany termin jest zajęty";
    }

    private Reservation getOld(ReservationDto oldReservation) {

        return repository.findById(oldReservation.getId()).get();
    }

    private Reservation getNew(ReservationDto newReservation) {

        return repository.findById(newReservation.getId()).get();
    }


    private int getDays(ReservationDto reservation) {
        return (int) Duration.between(reservation.getDateStart().atStartOfDay(), reservation.getDateEnd().atStartOfDay()).toDays();
    }

    private Double reservationPrice(ReservationDto reservation) {
        Double price = reservation.getHotel().getPrice();

        return getDays(reservation) * price;
    }

    public static boolean checkDate(List<Reservation> reservations, ReservationDto newReservation) {

        boolean check = true;
        for (Reservation reservation : reservations) {

            if (reservation.getDateEnd().isAfter(newReservation.getDateStart())
                    && reservation.getDateStart().isBefore(newReservation.getDateEnd())) {
                check = false;
            }
        }
        return check;
    }


    private ReservationDto saveCheck(ReservationDto dto) {


        if (checkDate(repository.findAllByHotel(dto.getHotel()), dto)) {
            try {
                dto.setHotel(hotelRepository.findById(dto.getHotel().getId()).get());
                dto.setTenant(tenantRepository.findById(dto.getTenant().getId()).get());
                dto.setLandlord(landlordRepository.findById(dto.getLandlord().getId()).get());
            } catch (NullPointerException e) {
                System.out.println("All data must be exist!");
                System.out.println(e.getMessage());
            }
            dto.setDays(getDays(dto));
            dto.setReservationPrice(reservationPrice(dto));

            return dto;
        } else
            return null;
    }


    private Reservation updateCheck(ReservationDto oldReservation, ReservationDto newReservation) {
        Reservation old = getOld(oldReservation);
        Reservation newRes = getNew(newReservation);
        old.setDays(getDays(changeToDTO(newRes)));
        old.setReservationPrice(reservationPrice(changeToDTO(newRes)));
        old.setDateStart(newRes.getDateStart());
        old.setDateEnd(newRes.getDateEnd());

        return old;
    }


    public static ReservationDto changeToDTO(Reservation reservation) {

        return new ReservationDto.ReservationDtoBuilder()
                .setDateStart(reservation.getDateStart())
                .setDateEnd(reservation.getDateEnd())
                .setDays(reservation.getDays())
                .setHotel(reservation.getHotel())
                .setReservationPrice(reservation.getReservationPrice())
                .setLandlord(reservation.getLandlord())
                .setTenant(reservation.getTenant())
                .build();

    }

    private Reservation changeFromDTO(ReservationDto reservation) {

        return new Reservation.ReservationBuild()
                .setDateStart(reservation.getDateStart())
                .setDateEnd(reservation.getDateEnd())
                .setDays(reservation.getDays())
                .setHotel(reservation.getHotel())
                .setReservationPrice(reservation.getReservationPrice())
                .setLandlord(reservation.getLandlord())
                .setTenant(reservation.getTenant())
                .build();

    }

}
