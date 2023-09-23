package com.yavor.cruddemo;

import com.yavor.cruddemo.dao.AppDao;
import com.yavor.cruddemo.entity.Course;
import com.yavor.cruddemo.entity.Instructor;
import com.yavor.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
//            createInstructor(appDao);

//            findInstructor(appDao);

//            deleteInstructor(appDao);

//            findInstructorDetail(appDao);

//            deleteInstructorDetail(appDao);

            createInstructorWithCourses(appDao);
        };
    }

    private void createInstructorWithCourses(AppDao appDao) {
        Instructor instructor = new Instructor("Bilbo", "Baggins", "bilbo@lotr.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.rivendell.com/youtube", "Steal the ring");
        instructor.setInstructorDetail(instructorDetail);

        Course course1 = new Course("The Fellowship of the Ring");
        Course course2 = new Course("The Two Towers");
        Course course3 = new Course("The Return of the King");

        instructor.addCourse(course1);
        instructor.addCourse(course2);
        instructor.addCourse(course3);

        System.out.println("Saving instructor: " + instructor);

        appDao.save(instructor);

        System.out.println("Done saving instructor");
    }

    private void deleteInstructorDetail(AppDao appDao) {
        int id = 3;
        System.out.println("Deleting instructor detail with id: " + id);

        appDao.deleteInstructorDetailById(id);

        System.out.println("Done deleting instructor detail");
    }

    private void findInstructorDetail(AppDao appDao) {
        int id = 2;
        System.out.println("Finding instructor detail with id: " + id);

        InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);

        System.out.println("Instructor detail: " + instructorDetail);

        System.out.println("Instructor: " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDao appDao) {
        int id = 1;
        System.out.println("Deleting instructor with id: " + id);

        appDao.deleteInstructorById(id);

        System.out.println("Done deleting instructor");
    }

    private void findInstructor(AppDao appDao) {
        int id = 2;
        System.out.println("Finding instructor with id: " + id);

        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("Instructor: " + instructor);

        System.out.println("Instructor details: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDao appDao) {
//        Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//        InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
//        instructor.setInstructorDetail(instructorDetail);
//
//        System.out.println("Saving instructor: " + instructor);
//
//        appDao.save(instructor);
//
//        System.out.println("Done saving instructor");


        Instructor instructor2 = new Instructor("Frodo", "Baggins", "frodo@lotr.com");
        InstructorDetail instructorDetail2 = new InstructorDetail("http://www.theshire.com/youtube", "Drink beer");
        instructor2.setInstructorDetail(instructorDetail2);

        System.out.println("Saving instructor: " + instructor2);

        appDao.save(instructor2);

        System.out.println("Done saving instructor");
    }


}
