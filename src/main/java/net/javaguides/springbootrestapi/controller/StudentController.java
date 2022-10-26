package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student((long) 1,"Melih","Bağçeli");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","melih")
                .body(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student((long) 1,"Melih1","Bağçeli1"));
        students.add(new Student((long) 2,"Melih2","Bağçeli2"));
        students.add(new Student((long) 3,"Melih3","Bağçeli3"));
        return students;
    }

    //Spring Boot Rest api with path variable
    @GetMapping("/student/{studentId}")
    public Student getStudentPathVariable(@PathVariable("studentId") int id){
        Student student = new Student((long) id,"Melih","Bağçeli");
        return student;
    }

    //Spring Boot Rest api with request param
    //http://localhost:8080/students?id=1
    @GetMapping("/students/query")
    public Student studentRequestValue(
            @RequestParam("studentId") int id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName){
        Student student = new Student((long) id,firstName,lastName);
        return student;
    }

    //Spring Boot Rest api with post request
    //@PostMapping and @RequestBody
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return student;
    }

    //Spring Boot Rest api with put request
    //@PostMapping and @RequestBody
    @PutMapping("/students/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") long studentId){
        return student;
    }

}
