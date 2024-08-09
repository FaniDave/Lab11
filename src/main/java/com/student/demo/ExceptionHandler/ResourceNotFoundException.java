package com.student.demo.ExceptionHandler;

import com.student.demo.Conroller.StudentController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
       private String errorMessage;

       public ResourceNotFoundException(String errorMessage) {
           super(errorMessage);
       }
}
