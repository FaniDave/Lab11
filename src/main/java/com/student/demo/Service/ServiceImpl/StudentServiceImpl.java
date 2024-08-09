package com.student.demo.Service.ServiceImpl;

import com.student.demo.ExceptionHandler.ResourceNotFoundException;
import com.student.demo.Mapper.StudentRequestDto_TO_Student;
import com.student.demo.Repository.StudentRepository;
import com.student.demo.Service.StudentService;
import com.student.demo.domain.Student;
import com.student.demo.dto.StudentRequestDto;
import com.student.demo.dto.StudentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {

         @Autowired
         private StudentRepository studentRepository;

         public StudentResponseDto save(StudentRequestDto studentRequestDto) {
               Student student = StudentRequestDto_TO_Student.requestDto_To_domain(studentRequestDto);
                studentRepository.save(student);
                StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
                return studentResponseDto;

         }

         public List<StudentResponseDto> findAll() {
             List<Student> students = studentRepository.findAll();
             List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
             for(Student student : students) {
                 StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
                 studentResponseDtos.add(studentResponseDto);
             }
             return studentResponseDtos;
         }

         public StudentResponseDto findById(Integer student_id){
             Student student = studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("studentId is not Found"));
             StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
             return studentResponseDto;
         }

         public StudentResponseDto update(Integer student_id, Double cgpa, LocalDate enrollmentDate, Boolean isInternational) {
             Student student = studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("studentId is not Found"));
             student.setCgpa(cgpa);
             student.setEnrollmentDate(enrollmentDate);
             student.setIsInternational(isInternational);
             studentRepository.save(student);
             StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
             return studentResponseDto;
         }

         public StudentResponseDto deleteById(Integer student_id) {
             Student student = studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("studentId is not Found"));
             studentRepository.deleteById(student_id);
             StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
             return studentResponseDto;
         }

}
