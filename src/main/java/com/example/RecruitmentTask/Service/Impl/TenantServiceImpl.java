package com.example.RecruitmentTask.Service.Impl;

import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Repository.ReservationRepository;
import com.example.RecruitmentTask.Service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {
    private final ReservationRepository repository;

    @Autowired
    public TenantServiceImpl(ReservationRepository repository) {
        this.repository = repository;

    }


    @Override
    public List<Reservation> getAllReservations(String tenantName) {
        return repository.getAllReservationsWhereNameTenant(tenantName);

    }
}
