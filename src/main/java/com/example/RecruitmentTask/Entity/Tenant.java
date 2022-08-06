package com.example.RecruitmentTask.Entity;

import javax.persistence.*;

@Entity
public class Tenant {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Tenant() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private Tenant(TenantBuilder builder) {
        this.name = builder.name;
    }

    public static class TenantBuilder {
        private String name;

        public TenantBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Tenant build() {
            return new Tenant(this);
        }
    }
}
