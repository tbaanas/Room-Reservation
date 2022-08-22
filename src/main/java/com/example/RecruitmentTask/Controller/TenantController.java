package com.example.RecruitmentTask.Controller;

import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Service.Impl.TenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantController {

    private final TenantServiceImpl service;

    @Autowired
    public TenantController(TenantServiceImpl service) {
        this.service = service;
    }


    @RequestMapping("/tenant-reservations")
    public List<ReservationDto> getReservationsByTenantName(@RequestParam("name") String name) {
        return service.getAllReservations(name);
    }
}
