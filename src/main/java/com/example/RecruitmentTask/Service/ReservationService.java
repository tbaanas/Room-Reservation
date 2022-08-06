package com.example.RecruitmentTask.Service;

import com.example.RecruitmentTask.Entity.Reservation;

public interface ReservationService {

        String save(Reservation reservation);
        String update(Reservation oldReservation, Reservation newReservation);

}
