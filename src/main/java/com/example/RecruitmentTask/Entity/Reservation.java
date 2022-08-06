package com.example.RecruitmentTask.Entity;

import com.example.RecruitmentTask.Config;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateStart;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;

    private int days;
    private Double reservationPrice;



    @ManyToOne
    private Tenant tenant;

    @ManyToOne
    private Landlord landlord;

    @ManyToOne
    private Hotel hotel;

    public Reservation() {

    }
    public Reservation(ReservationBuild build) {
        this.dateStart = build.dateStart;
        this.dateEnd = build.dateEnd;
        this.days = build.days;
        this.reservationPrice = build.reservationPrice;
        this.tenant = build.tenant;
        this.landlord = build.landlord;
        this.hotel = build.hotel;
    }

    public Reservation(LocalDate dateStart, LocalDate dateEnd, Tenant tenant, Landlord landlord, Hotel hotel) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.tenant = tenant;
        this.landlord = landlord;
        this.hotel = hotel;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", days=" + days +
                ", reservationPrice=" + reservationPrice +
                ", tenant=" + tenant +
                ", landlord=" + landlord +
                ", hotel=" + hotel +
                '}';
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateStart() {
        return Config.getDate(dateStart.toString());
    }

    public LocalDate getDateEnd() {
        return Config.getDate(dateEnd.toString());
    }

    public int getDays() {
        return days;
    }

    public Double getReservationPrice() {
        return reservationPrice;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setReservationPrice(Double reservationPrice) {
        this.reservationPrice = reservationPrice;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public static class ReservationBuild {
        private LocalDate dateStart;
        private LocalDate dateEnd;
        private int days;
        private Double reservationPrice;
        private Tenant tenant;
        private Landlord landlord;
        private Hotel hotel;

        public ReservationBuild setHotel(Hotel hotel) {
            this.hotel = hotel;
            return this;
        }

        public ReservationBuild setDateStart(LocalDate dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        public ReservationBuild setDateEnd(LocalDate dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        public ReservationBuild setDays(int days) {
            this.days = days;
            return this;
        }

        public ReservationBuild setReservationPrice(double reservationPrice) {
            this.reservationPrice = reservationPrice;
            return this;
        }

        public ReservationBuild setTenant(Tenant tenant) {
            this.tenant = tenant;
            return this;
        }

        public ReservationBuild setLandlord(Landlord landlord) {
            this.landlord = landlord;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }



}
