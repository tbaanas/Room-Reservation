package com.example.RecruitmentTask.Repository;

import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByHotel(Hotel hotel);


    @Query("select r from Reservation r where r.id <> :old and r.hotel=:hotel")
    List<Reservation> getAllReservations(@Param("old") long oldReservation, @Param("hotel") Hotel hotel);


    @Query("select r from Reservation r where r.tenant.name = :name")
    List<Reservation> getAllReservationsWhereNameTenant(@Param("name") String tenantName);

    @Query("Select r from Reservation r where r.hotel.id=:id")
    List<Reservation> getReservWhereHotelId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Reservation (date_end, date_start, days, reservation_price, hotel_id, landlord_id, tenant_id) VALUES (:dateStart,:dateEnd,:days,:reservationPrice,:tenant,:landlord,:hotel)", nativeQuery = true)
    void saveReservation(@Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd, @Param("days") int days,
                         @Param("reservationPrice") Double reservationPrice, @Param("tenant") long tenant, @Param("landlord") long landlord, @Param("hotel") long hotel);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Reservation  VALUES (:reservation)", nativeQuery = true)
    void saveReservation2(@Param("reservation") Reservation reservation);

}
