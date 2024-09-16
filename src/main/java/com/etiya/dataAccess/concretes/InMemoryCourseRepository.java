package com.etiya.dataAccess.concretes;

import com.etiya.dataAccess.abstracts.CourseRepository;
import com.etiya.entities.Course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InMemoryCourseRepository implements CourseRepository {

        private List<Course> courses;

        public InMemoryCourseRepository() {
            this.courses = new ArrayList<>();

            Course course1 = new Course(
                    1,
                    "Java",
                    new Date(),
                    new Date(),
                    new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30))
            );

            Course course2 = new Course(
                    2,
                    "Python",
                    new Date(),
                    new Date(),
                    new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30))
            );

            Course course3 = new Course(
                    3,
                    "JavaScript",
                    new Date(),
                    new Date(),
                    new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30))
            );


            courses.add(course1);
            courses.add(course2);
            courses.add(course3);


        }

        @Override
        public List<Course> getAll() {
            return courses;
        }

        public void add(Course course) {
            courses.add(course);
        }


        public void delete(int id) {
            courses.remove(id);
        }


}
