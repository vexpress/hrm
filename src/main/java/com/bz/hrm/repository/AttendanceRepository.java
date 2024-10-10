package com.bz.hrm.repository;

import com.bz.hrm.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> { 

}
