package com.example.RecruitmentTask.Dto;

import com.example.RecruitmentTask.Entity.Hotel;
import com.example.RecruitmentTask.Entity.Reservation;

import java.util.List;

public class HotelDto {

    private Long id;

    private String name;

    private Double price;

    private Double area;

    private String text;


    private HotelDto(HotelDtoBuilder hotelBuilder) {
        this.name = hotelBuilder.name;
        this.price = hotelBuilder.price;
        this.area = hotelBuilder.area;
        this.text = hotelBuilder.text;

    }

    public HotelDto(){
    }

/*    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static class HotelDtoBuilder {
        private Long id;

        private String name;

        private Double price;

        private Double area;

        private String text;

        List<Reservation> reservation;

        public HotelDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public HotelDtoBuilder setReservation(List<Reservation> reservation) {
            this.reservation = reservation;
            return this;
        }

        public HotelDtoBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public HotelDtoBuilder setArea(Double area) {
            this.area = area;
            return this;
        }

        public HotelDtoBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public HotelDto build() {
            return new HotelDto(this);

        }


    }


}
