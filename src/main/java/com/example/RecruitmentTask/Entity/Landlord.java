package com.example.RecruitmentTask.Entity;

import javax.persistence.*;

@Entity
public class Landlord {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Landlord() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    private Landlord(LandlordBuilder builder) {
        this.name = builder.name;
    }

    public static class LandlordBuilder {
        private String name;


        public LandlordBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public Landlord build() {
            return new Landlord(this);
        }
    }
}
