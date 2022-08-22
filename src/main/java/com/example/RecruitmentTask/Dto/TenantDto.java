package com.example.RecruitmentTask.Dto;

public class TenantDto {
    private Long id;
    private String name;

    private TenantDto(TenantDtoBuilder builder) {
        this.name = builder.name;
    }


    public static class TenantDtoBuilder {
        private String name;


        public TenantDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public TenantDto build() {
            return new TenantDto(this);
        }
    }

}
