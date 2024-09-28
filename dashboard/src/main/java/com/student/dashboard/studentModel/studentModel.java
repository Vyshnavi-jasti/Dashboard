package com.student.dashboard.studentModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="students")
@Entity
public class studentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Student Id")
    private Long studentId;
    @Column(name = "Student Name")
    private String studentName;
    @Column(name = "Student Email")
    private String studentEmail;
    @Column(name = "Student Phone" )
    private String studentPhone;
    @Column(name = "Student Address" )
    private String studentAddress;
    @Column(name = "Student Photo")
    @Lob
    private String studentPhoto;

    
}
