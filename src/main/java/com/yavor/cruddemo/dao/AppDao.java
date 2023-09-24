package com.yavor.cruddemo.dao;

import com.yavor.cruddemo.entity.Course;
import com.yavor.cruddemo.entity.Instructor;
import com.yavor.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);


    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewsByCourseId(int id);
}
