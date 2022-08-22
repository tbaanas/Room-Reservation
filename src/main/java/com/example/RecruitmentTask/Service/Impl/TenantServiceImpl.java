package com.example.RecruitmentTask.Service.Impl;

import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Repository.ReservationRepository;
import com.example.RecruitmentTask.Service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantServiceImpl implements TenantService {
    private final ReservationRepository repository;


    @Autowired
    public TenantServiceImpl(ReservationRepository repository) {
        this.repository = repository;

    }


    @Override
    public List<ReservationDto> getAllReservations(String tenantName) {


        return changeToList(tenantName);

    }

    private List<ReservationDto> changeToList(String tenantName) {
        return repository.getAllReservationsWhereNameTenant(tenantName).stream().map(reservation -> new ReservationDto.ReservationDtoBuilder()
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
