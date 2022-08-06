package com.example.RecruitmentTask.Controller;

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
    public List<Reservation> getAllReservation(@RequestParam("id") int id) {
        return hotelService.findAllReservation(hotelService.findById(id));
    }






    @RequestMapping("/hotele")
    public List<Hotel> getAllHotels() {
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
