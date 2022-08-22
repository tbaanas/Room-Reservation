package com.example.RecruitmentTask.Dto;

import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Landlord;
import com.example.RecruitmentTask.Entity.Reservation;
import com.example.RecruitmentTask.Entity.Tenant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ReservationDto {
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateStart;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;

    private int days;
    private Double reservationPrice;



    private Tenant tenant;


    private Landlord landlord;

    private Hotel hotel;

    public Long getId() {
        return id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
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

    public Hotel getHotel() {
        return hotel;
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

    public ReservationDto() {

    }
    private ReservationDto(ReservationDtoBuilder build) {
        this.dateStart = build.dateStart;
        this.dateEnd = build.dateEnd;
        this.days = build.days;
        this.reservationPrice = build.reservationPrice;
        this.tenant = build.tenant;
        this.landlord = build.landlord;
        this.hotel = build.hotel;
    }

    public static class ReservationDtoBuilder {
        private LocalDate dateStart;
        private LocalDate dateEnd;
        private int days;
        private Double reservationPrice;
        private Tenant tenant;
        private Landlord landlord;
        private Hotel hotel;

        public ReservationDtoBuilder setHotel(Hotel hotel) {
            this.hotel = hotel;
            return this;
        }

        public ReservationDtoBuilder setDateStart(LocalDate dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        public ReservationDtoBuilder setDateEnd(LocalDate dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        public ReservationDtoBuilder setDays(int days) {
            this.days = days;
            return this;
        }

        public ReservationDtoBuilder setReservationPrice(double reservationPrice) {
            this.reservationPrice = reservationPrice;
            return this;
        }

        public ReservationDtoBuilder setTenant(Tenant tenant) {
            this.tenant = tenant;
            return this;
        }

        public ReservationDtoBuilder setLandlord(Landlord landlord) {
            this.landlord = landlord;
            return this;
        }

        public ReservationDto build() {
            return new ReservationDto(this);
        }
    }
}
