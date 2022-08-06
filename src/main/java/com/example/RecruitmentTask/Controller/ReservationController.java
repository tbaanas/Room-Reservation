package com.example.RecruitmentTask.Controller;

import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Landlord;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Entity.Tenant;
import com.example.RecruitmentTask.Repository.HotelRepository;
import com.example.RecruitmentTask.Repository.LandlordRepository;
import com.example.RecruitmentTask.Repository.TenantRepository;
import com.example.RecruitmentTask.Service.Impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class ReservationController {

    private final ReservationServiceImpl service;

    @Autowired
    public ReservationController(ReservationServiceImpl service) {
        this.service = service;
    }

    /*
  ZAPIS rezerwacji
  JSON:
  {
  "dateStart": "2022-08-25",
  "dateEnd": "2022-08-29",
  "tenant": {"id":1},
  "landlord": {"id":1},
  "hotel": {"id":1}
}
   */
    @RequestMapping(
            value = "/new-reservation",
            method = RequestMethod.POST)
    public String createReservation(@RequestBody Reservation reservation) {

        return service.save(reservation);
    }


    /*
    JSON:
        {
     "oldReservation":{
         "id":6,
         "dateStart": "2022-08-25",
         "dateEnd": "2022-08-29",
         "tenant": {"id":1},
         "landlord": {"id":1},
         "hotel": {"id":1}
},

     "newReservation":{
                 "id":6,
                   "dateStart": "2022-08-19",
                   "dateEnd": "2022-08-25",
                   "hotel": {"id":1}
                  }
   }
}

ZMIANA DATY wynajmu
     */
    @RequestMapping(
            value = "/update-reservation",
            method = RequestMethod.POST)
    public String updateReservation(@RequestBody Map<String, Reservation> reservationMap) {

        if (reservationMap.get("oldReservation") == null || reservationMap.get("newReservation") == null) {
            return "Two object must Exist";
        } else
            return service.update(reservationMap.get("oldReservation"), reservationMap.get("newReservation"));
    }


}
