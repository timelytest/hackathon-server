package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Query(value = "select * from appointment where date < ?1 and  effectiveDate > 1",nativeQuery = true)
    List<Appointment> findAllByDateAfterAndEffectiveDateBefore(String date);
}
