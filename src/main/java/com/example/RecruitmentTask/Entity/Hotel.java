package com.example.RecruitmentTask.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Double area;

    private String text;



    public Hotel() {
    }


    private Hotel(HotelBuilder hotelBuilder) {
        this.name = hotelBuilder.name;
        this.price = hotelBuilder.price;
        this.area = hotelBuilder.area;
        this.text = hotelBuilder.text;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getArea() {
        return area;
    }

    public String getText() {
        return text;
    }


    public static class HotelBuilder {
        private Long id;

        private String name;

        private Double price;

        private Double area;

        private String text;

        List<Reservation> reservation;

        public HotelBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public HotelBuilder setReservation(List<Reservation> reservation) {
            this.reservation = reservation;
            return this;
        }

        public HotelBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public HotelBuilder setArea(Double area) {
            this.area = area;
            return this;
        }

        public HotelBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public Hotel build() {
            return new Hotel(this);

        }


    }
}


