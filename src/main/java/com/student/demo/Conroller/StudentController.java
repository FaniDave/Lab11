package com.student.demo.Conroller;

import com.student.demo.Service.StudentService;
import com.student.demo.dto.StudentRequestDto;
import com.student.demo.dto.StudentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eregistrar/api/students")
public class StudentController {

       @Autowired
       private StudentService studentService;

       @PostMapping
       public ResponseEntity<StudentResponseDto> save(@RequestBody StudentRequestDto studentRequestDto) {
             StudentResponseDto studentResponseDto = studentService.save(studentRequestDto);
             return new ResponseEntity<StudentResponseDto>(studentResponseDto, HttpStatus.CREATED);
       }

       @GetMapping
       public ResponseEntity<List<StudentResponseDto>> findAll() {
            List<StudentResponseDto> studentResponseDto = studentService.findAll();
            return new ResponseEntity<List<StudentResponseDto>> (studentResponseDto, HttpStatus.OK);
       }

       @GetMapping("/{student_id}")
       public ResponseEntity<StudentResponseDto> findById(@PathVariable Integer student_id) {
           StudentResponseDto studentResponseDto = studentService.findById(student_id);
           return new ResponseEntity<StudentResponseDto>(studentResponseDto, HttpStatus.OK);
       }

       @PutMapping("/{student_id}")
      public ResponseEntity<StudentResponseDto> update(@PathVariable Integer student_id, @RequestParam Double cgpa, @RequestParam LocalDate enrollmentDate, @RequestParam Boolean isInternational) {
           StudentResponseDto studentResponseDto = studentService.update(student_id, cgpa, enrollmentDate, isInternational);
           return new ResponseEntity<StudentResponseDto>(studentResponseDto, HttpStatus.OK);
       }

       @DeleteMapping("/{student_id}")
       public ResponseEntity<StudentResponseDto> deleteById(@PathVariable Integer student_id) {
           StudentResponseDto studentResponseDto = studentService.deleteById(student_id);
           return new ResponseEntity<StudentResponseDto>(studentResponseDto, HttpStatus.OK);
       }
}
