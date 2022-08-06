package com.example.RecruitmentTask.Repository;

import com.example.RecruitmentTask.Entity.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {
}
