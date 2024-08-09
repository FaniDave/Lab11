package com.student.demo.Mapper;

import com.student.demo.domain.Student;
import com.student.demo.dto.StudentRequestDto;
import com.student.demo.dto.StudentResponseDto;

public class StudentRequestDto_TO_Student {

      public static Student requestDto_To_domain (StudentRequestDto dto) {

             Student student = new Student();

             student.setFirstName(dto.getFirstName());
             student.setLastName(dto.getLastName());
             student.setStudentNumber(dto.getStudentNumber());
             student.setMiddleName(dto.getMiddleName());
             student.setEnrollmentDate(dto.getEnrollmentDate());
             student.setCgpa(dto.getCgpa());
             student.setIsInternational(dto.getIsInternational());
             student.setStudent_id(null);

             return student;
      }

      public static StudentResponseDto domain_TO_responseDto (Student student) {
            StudentResponseDto responseDto = new StudentResponseDto();

            responseDto.setFirstName(student.getFirstName());
            responseDto.setLastName(student.getLastName());
            responseDto.setStudentNumber(student.getStudentNumber());
            responseDto.setMiddleName(student.getMiddleName());
            responseDto.setCgpa(student.getCgpa());
            responseDto.setEnrollmentDate(student.getEnrollmentDate());
            responseDto.setIsInternational(student.getIsInternational());
            responseDto.setStudentId(student.getStudent_id());

            return responseDto;
      }
}
