package com.student.dashboard.studentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dashboard.ResponseStatus.StatusEnum;
import com.student.dashboard.studentModel.studentModel;
import com.student.dashboard.studentResponse.studentResponse;
import com.student.dashboard.studentService.studentService;



@RestController
@RequestMapping("/admin")
public class studentController {

    @Autowired studentService service;

    @PostMapping("/createStudent")  
    public studentResponse createAndUpdate(@RequestBody studentModel student) throws Exception {
        try {
            studentResponse response = service.createAndUpdateStudent(student);
            return response;
            
        } catch (Exception e) {
            studentResponse response = new studentResponse();
            response.setStatus(StatusEnum.FAILURE);
            response.setMessage(e.getMessage());
            return response;
        }
     
    }

    @GetMapping("/allStudents")
    public studentResponse getAllStudents() {

        try{
            studentResponse response = service.getAllStudents();
            return response;
        }
        catch(Exception e){
            studentResponse response = new studentResponse();
            response.setStatus(StatusEnum.FAILURE);
            response.setMessage(e.getMessage());
            return response;
        }
    }
    
    
}
