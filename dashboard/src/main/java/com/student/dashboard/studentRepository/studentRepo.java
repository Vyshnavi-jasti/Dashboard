package com.student.dashboard.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.dashboard.studentModel.studentModel;

@Repository
public interface studentRepo extends JpaRepository<studentModel, Long> {
}
