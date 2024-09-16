package com.etiya.business.abstracts;

import com.etiya.entities.Course;

public interface CourseService {
    void add(Course course) throws Exception;

    void findAll();

    void delete(int id) throws Exception;
}
