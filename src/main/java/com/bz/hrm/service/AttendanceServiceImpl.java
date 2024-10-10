package com.bz.hrm.service;

import com.bz.hrm.entity.AttendanceEntity;
import com.bz.hrm.repository.AttendanceRepository; // Import your repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository; // Assuming you have a repository

    @Override
    public AttendanceEntity saveAttendance(AttendanceEntity attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<AttendanceEntity> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public AttendanceEntity getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null); // Handle the case when not found
    }

    @Override
    public AttendanceEntity updateAttendance(Long id, AttendanceEntity attendance) {
        attendance.setId(id); // Assuming there's an `setId` method
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
