package com.example.RecruitmentTask.Service;

import com.example.RecruitmentTask.Dto.ReservationDto;

import java.util.List;

public interface TenantService {
    List<ReservationDto> getAllReservations(String tenantName);
}
