package com.bz.hrm.service;

import java.util.List;
import java.util.Optional;
import com.bz.hrm.entity.AttendanceEntity;

public interface AttendanceService {
    AttendanceEntity saveAttendance(AttendanceEntity attendance); // Renamed for clarity
    List<AttendanceEntity> getAllAttendances(); // Renamed for clarity
    AttendanceEntity getAttendanceById(Long id); // Changed to Optional
    AttendanceEntity updateAttendance(Long id, AttendanceEntity attendance); // Renamed for clarity
    void deleteAttendance(Long id); // Renamed for clarity
}
