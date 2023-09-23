package com.yavor.cruddemo.dao;

import com.yavor.cruddemo.entity.Instructor;
import com.yavor.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
