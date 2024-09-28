package com.student.dashboard.studentService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dashboard.ResponseStatus.StatusEnum;
import com.student.dashboard.studentModel.studentModel;
import com.student.dashboard.studentRepository.studentRepo;
import com.student.dashboard.studentResponse.studentResponse;

@Service
public class studentService {

    @Autowired
    studentRepo studentRepository;

    private static final Logger log = LoggerFactory.getLogger(studentService.class);

    public studentResponse createAndUpdateStudent(studentModel studentCreation){

        studentResponse response = new studentResponse();
        try{
            if(studentCreation.getStudentId() == null) {
                studentModel student = studentRepository.save(studentCreation);
                if(student!=null){
                    response.setCode(200);
                    response.setStatus(StatusEnum.SUCCESS);
                    response.setMessage("Student inserted successfully");
                    response.setData(student);
            }
            else{
                response.setCode(404);
                response.setStatus(StatusEnum.FAILURE);
                response.setMessage("Student not inserted && Method Not found");
                response.setData(null);
            }
        }

        else{
            studentModel student = studentRepository.save(studentCreation);
            if(student!=null){
                response.setCode(200);
                response.setStatus(StatusEnum.SUCCESS);
                response.setMessage("Student updated successfully");
                response.setData(student);
            }
            else{
                response.setCode(404);
                response.setStatus(StatusEnum.FAILURE);
                response.setMessage("Method Not Found and Student not Updated Successfully");
                response.setData(null);
            }
        }
        
    }
    catch(Exception e){
        log.error(e.getMessage());
        response.setCode(500);
        response.setStatus(StatusEnum.FAILURE);
        response.setMessage("Internal Server Error");
        response.setData(null);
    }
    return response;
}

public studentResponse getAllStudents(){
    studentResponse response = new studentResponse();
    try{
        List<studentModel> students = studentRepository.findAll();
        if(students!=null){
            response.setCode(200);
            response.setStatus(StatusEnum.SUCCESS);
            response.setMessage("Students fetched successfully");
            response.setData(students);
        }
        else{
            response.setCode(404);
            response.setStatus(StatusEnum.FAILURE);
            response.setMessage("Students not fetched");
            response.setData(null);
        }
    }
    catch(Exception e){
        log.error(e.getMessage());
        response.setCode(500);
        response.setStatus(StatusEnum.FAILURE);
        response.setMessage("Internal Server Error");
        response.setData(null);
    }
    return response;
}
}
