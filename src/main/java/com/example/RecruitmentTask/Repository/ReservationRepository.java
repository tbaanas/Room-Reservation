package com.example.RecruitmentTask.Repository;

import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Landlord;
import com.example.RecruitmentTask.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

}
