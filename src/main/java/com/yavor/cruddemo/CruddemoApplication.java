package com.yavor.cruddemo;

import com.yavor.cruddemo.dao.AppDao;
import com.yavor.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
//            createCourseAndStudents(appDao);

//            findCourseAndStudents(appDao);

            findStudentAndCourses(appDao);
        };
    }

    private void findStudentAndCourses(AppDao appDao) {
        int id = 2;
        System.out.println("Finding student with id: " + id);

        Student student = appDao.findStudentAndCoursesByStudentId(id);

        System.out.println("Student: " + student);

        System.out.println("Courses: " + student.getCourses());
    }

    private void findCourseAndStudents(AppDao appDao) {
        int id = 10;
        System.out.println("Finding course with id: " + id);

        Course course = appDao.findCourseAndStudentsByCourseId(id);

        System.out.println("Course: " + course);

        System.out.println("Students: " + course.getStudents());
    }

    private void createCourseAndStudents(AppDao appDao) {
        Course course = new Course("The Fellowship of the Ring");
        course.addStudent(new Student("Frodo", "Baggins", "frodo.baggins@lotr.com"));
        course.addStudent(new Student("Samwise", "Gamgee", "samwise.gamgee@lotr.com"));
        course.addStudent(new Student("Peregrin", "Took", "peregrin.took@lotr.com"));

        System.out.println("Saving course: " + course);
        appDao.saveCourse(course);
        System.out.println("Done saving course");
    }

    @Transactional
    private void deleteCourseAndReviews(AppDao appDao) {
        int id = 10;
        System.out.println("Finding course with id: " + id);
        appDao.deleteCourseById(id);
        System.out.println("Done deleting course!");
    }


    private void retrieveCourseAndReviews(AppDao appDao) {
        int id = 10;
        System.out.println("Finding course with id: " + id);

        Course course = appDao.findCourseAndReviewsByCourseId(id);

        System.out.println("Course: " + course);

        System.out.println("Reviews: " + course.getReviews());
    }

    private void createCourseAndReviews(AppDao appDao) {
        Course course = new Course("The Fellowship of the Ring");
        course.addReview(new Review("Great course!"));
        course.addReview(new Review("Cool course!"));
        course.addReview(new Review("Awesome course!"));

        System.out.println("Saving course: " + course);
        appDao.saveCourse(course);
        System.out.println("Done saving course");
    }

    private void deleteCourseById(AppDao appDao) {
        int id = 10;
        System.out.println("Deleting course with id: " + id);

        appDao.deleteCourseById(id);

        System.out.println("Done deleting course!");
    }

    private void updateCourse(AppDao appDao) {
        int id = 10;
        System.out.println("Finding course with id: " + id);

        Course course = appDao.findCourseById(id);

        System.out.println("Course: " + course);

        course.setTitle("The Hobbit");

        System.out.println("Saving course");

        appDao.updateCourse(course);

        System.out.println("Done saving course");
    }

    private void updateInstructor(AppDao appDao) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id);

        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("Instructor: " + instructor);

        instructor.setFirstName("Gandalf");

        System.out.println("Saving instructor");

        appDao.updateInstructor(instructor);

        System.out.println("Done saving instructor");
    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id);

        Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

        System.out.println("Instructor: " + instructor);

        System.out.println("Instructor courses: " + instructor.getCourses());
        System.out.println("Instructor details: " + instructor.getInstructorDetail());
    }

    private void findCoursesForInstructor(AppDao appDao) {
        int id = 1;
        System.out.println("Finding courses for instructor with id: " + id);

        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("Instructor: " + instructor);


        System.out.println("Finding courses for instructor id: " + id);

        List<Course> courses = appDao.findCoursesByInstructorId(id);

        instructor.setCourses(courses);

        System.out.println("Courses: " + instructor.getCourses());

    }


    private void findInstructorWithCourses(AppDao appDao) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id);

        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("Instructor: " + instructor);

        System.out.println("Instructor courses: " + instructor.getCourses());
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
