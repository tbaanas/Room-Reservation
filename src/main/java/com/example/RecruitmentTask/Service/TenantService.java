package com.example.RecruitmentTask.Service;

import com.example.RecruitmentTask.Entity.Reservation;

import java.util.List;

public interface TenantService {
    List<Reservation> getAllReservations(String tenantName);
}
