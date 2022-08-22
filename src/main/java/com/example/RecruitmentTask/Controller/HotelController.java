package com.example.RecruitmentTask.Controller;

import com.example.RecruitmentTask.Dto.HotelDto;
import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Service.Impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    private final HotelServiceImpl hotelService;

    @Autowired
    public HotelController(HotelServiceImpl hotelService) {
        this.hotelService = hotelService;
    }


    @RequestMapping("/hotel-reservations")
    public List<ReservationDto> getAllReservation(@RequestParam("id") int id) {
        return hotelService.findAllReservation(id);
    }






    @RequestMapping("/hotele")
    public List<HotelDto> getAllHotels() {

        return hotelService.findAll();
    }

    @RequestMapping(value = "/hotel",method = RequestMethod.POST)
    public Hotel getHotel(@RequestParam("id")int id) {
        return hotelService.findById(id);
    }


    @RequestMapping(value = "/addHotel",method = RequestMethod.POST)
    public String setHotel(@RequestBody Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/hotele";

    }

}
