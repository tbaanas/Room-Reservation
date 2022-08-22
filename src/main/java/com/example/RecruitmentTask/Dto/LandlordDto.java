package com.example.RecruitmentTask.Dto;

import com.example.RecruitmentTask.Entity.Landlord;

public class LandlordDto {

    private Long id;

    private String name;

    private LandlordDto(LandlordDtoBuilder builder) {
        this.name = builder.name;
    }

    public static class LandlordDtoBuilder {
        private String name;


        public LandlordDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public LandlordDto build() {
            return new LandlordDto(this);
        }
    }
}
