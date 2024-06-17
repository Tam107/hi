package com.example.demospring;

import com.example.demospring.Dao.StudentDAO;
import com.example.demospring.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
            //createStudent(studentDAO);

            //readStudent(studentDAO);
            //update student
            //updateStudent(studentDAO);
            deleteStudent(studentDAO);

        };
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id =1;
        studentDAO.delete(id);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        Student myStudent = studentDAO.findById(studentId);
        System.out.println("Updating student......");
        //change the first name to "Scooby"
        myStudent.setFirstName("Scooby");
        studentDAO.update(myStudent);
        //display updated student
        System.out.println("Updated student:  "+myStudent);


    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object......");
        Student tempStudent = new Student("Tam", "Duck","hi");
        //save the object
        System.out.println("Saving student..........");
        studentDAO.save(tempStudent);
        //display id of the saved student
        System.out.println("Saved student. Generated id: "+tempStudent.getId());
        //retrieve student based on the primary key
        Student myStudent = studentDAO.findById(tempStudent.getId());
        System.out.println("Found the student "+myStudent);
    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new object........");
        Student tempStudent = new Student("Paul","Doe","hihihhi");
        System.out.println("Saving the Student...........");
        studentDAO.save(tempStudent);
        //display saved student

        System.out.println("Saved student id: "+tempStudent.getId());
    }

}
