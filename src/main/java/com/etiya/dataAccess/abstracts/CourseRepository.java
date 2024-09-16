package com.etiya.dataAccess.abstracts;

import com.etiya.entities.Course;

import java.util.List;

public interface CourseRepository {

    public void add(Course course);

    public void delete(int id);

    List<Course> getAll();

}
