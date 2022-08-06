package com.example.RecruitmentTask;


import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Landlord;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Entity.Tenant;
import com.example.RecruitmentTask.Repository.HotelRepository;
import com.example.RecruitmentTask.Repository.LandlordRepository;
import com.example.RecruitmentTask.Repository.ReservationRepository;
import com.example.RecruitmentTask.Repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ImportDataBase implements ApplicationListener<ApplicationReadyEvent> {

    private HotelRepository hotelRepository;
    private LandlordRepository landlordRepository;
    private TenantRepository tenantRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public ImportDataBase(HotelRepository hotelRepository, LandlordRepository landlordRepository, TenantRepository tenantRepository, ReservationRepository reservationRepository) {
        this.hotelRepository = hotelRepository;
        this.landlordRepository = landlordRepository;
        this.tenantRepository = tenantRepository;
        this.reservationRepository = reservationRepository;
    }

    //Inject Service or repository if you have.


    /**
     * Executes on application ready event
     * Check's if data exists & calls to create or read data
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        //Import do bazy zamiast z import.sql
        createHotels();
        createTenants();
        createLandlords();
        createReservations();

    }

    private Hotel getHotel(long id) {
        return hotelRepository.findById(id).get();
    }

    private Landlord getLandlord(long id) {
        return landlordRepository.findById(id).get();
    }

    private Tenant getTenant(long id) {
        return tenantRepository.findById(id).get();
    }

    private void createReservations() {


        reservationRepository.save(new Reservation.ReservationBuild().setDateStart(Config.getDate("2022-08-01")).setDateEnd(Config.getDate("2022-08-02"))
                .setReservationPrice(getHotel((long) 1).getPrice()).setDays(1).setHotel(getHotel(1)).setLandlord(getLandlord(1)).setTenant(getTenant(1)).build());
        reservationRepository.save(new Reservation.ReservationBuild().setDateStart(Config.getDate("2022-07-01")).setDateEnd(Config.getDate("2022-07-06"))
                .setReservationPrice(getHotel((long) 6).getPrice()).setDays(5).setHotel(getHotel(6)).setLandlord(getLandlord(3)).setTenant(getTenant(2)).build());

        reservationRepository.save(new Reservation.ReservationBuild().setDateStart(Config.getDate("2022-07-10")).setDateEnd(Config.getDate("2022-07-19"))
                .setReservationPrice(getHotel(4).getPrice()).setDays(9).setHotel(getHotel(4)).setLandlord(getLandlord(2)).setTenant(getTenant(3)).build());

        reservationRepository.save(new Reservation.ReservationBuild().setDateStart(Config.getDate("2022-07-05")).setDateEnd(Config.getDate("2022-07-12"))
                .setReservationPrice(getHotel((long) 5).getPrice()).setDays(7).setHotel(getHotel(5)).setLandlord(getLandlord(5)).setTenant(getTenant(4)).build());

        reservationRepository.save(new Reservation.ReservationBuild().setDateStart(Config.getDate("2022-07-21")).setDateEnd(Config.getDate("2022-08-30"))
                .setReservationPrice(getHotel((long) 8).getPrice()).setDays(9).setHotel(getHotel(8)).setLandlord(getLandlord(4)).setTenant(getTenant(5)).build());


    }


    private void createHotels() {

        hotelRepository.save(new Hotel.HotelBuilder().setArea(12.4).setName("hotel1").setPrice(10.1).setText("Opis hotelu 1").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(20.6).setName("hotel2").setPrice(800.2).setText("Opis hotelu 2").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(32.3).setName("hotel3").setPrice(43.0).setText("Opis hotelu 3").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(42.9).setName("hotel4").setPrice(13.4).setText("Opis hotelu 4").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(52.3).setName("hotel5").setPrice(60.0).setText("Opis hotelu 5").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(62.7).setName("hotel6").setPrice(321.7).setText("Opis hotelu 6").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(72.44).setName("hotel7").setPrice(154.0).setText("Opis hotelu 7").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(82.46).setName("hotel8").setPrice(198.0).setText("Opis hotelu 8").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(92.42).setName("hotel9").setPrice(39.0).setText("Opis hotelu 9").build());
        hotelRepository.save(new Hotel.HotelBuilder().setArea(31.87).setName("hotel10").setPrice(54.5).setText("Opis hotelu 10").build());
    }


    private void createTenants() {
        tenantRepository.save(new Tenant.TenantBuilder().setName("Lokator1").build());
        tenantRepository.save(new Tenant.TenantBuilder().setName("Lokator2").build());
        tenantRepository.save(new Tenant.TenantBuilder().setName("Lokator3").build());
        tenantRepository.save(new Tenant.TenantBuilder().setName("Lokator4").build());
        tenantRepository.save(new Tenant.TenantBuilder().setName("Lokator5").build());
    }

    private void createLandlords() {
        landlordRepository.save(new Landlord.LandlordBuilder().setName("Wynajmujący1").build());
        landlordRepository.save(new Landlord.LandlordBuilder().setName("Wynajmujący2").build());
        landlordRepository.save(new Landlord.LandlordBuilder().setName("Wynajmujący3").build());
        landlordRepository.save(new Landlord.LandlordBuilder().setName("Wynajmujący4").build());
        landlordRepository.save(new Landlord.LandlordBuilder().setName("Wynajmujący5").build());
    }


}
