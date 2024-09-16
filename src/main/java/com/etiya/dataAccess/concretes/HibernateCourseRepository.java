package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.CourseRepository;
import com.etiya.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class HibernateCourseRepository implements CourseRepository {

    List<Course> courses = new ArrayList<Course>();

    @Override
    public void add(Course course) {
        System.out.println(course.getName() + " created with Hibernate!");
    }

    @Override
    public void delete(int id) {
        System.out.println("Course deleted with Hibernate!");
    }

    @Override
    public List<Course> getAll() {
        return courses;
    }
}
