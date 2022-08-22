package com.example.RecruitmentTask.Service;

import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Entity.Reservation;

public interface ReservationService {

        String save(ReservationDto reservation);
        String update(ReservationDto oldReservation, ReservationDto newReservation);

}
