package com.example.RecruitmentTask.Repository;

import com.example.RecruitmentTask.Entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Tenant findByName(String name);
}
