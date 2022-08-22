package com.example.RecruitmentTask.Controller;

import com.example.RecruitmentTask.Dto.ReservationDto;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Service.Impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String createReservation(@RequestBody ReservationDto reservation) {

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
    public String updateReservation(@RequestBody Map<String, ReservationDto> reservationMap) {

        if (reservationMap.get("oldReservation") == null || reservationMap.get("newReservation") == null) {
            return "Two object must Exist";
        } else
            return service.update(reservationMap.get("oldReservation"), reservationMap.get("newReservation"));
    }


}
