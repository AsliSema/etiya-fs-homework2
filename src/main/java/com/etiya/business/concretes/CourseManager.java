package com.etiya.business.concretes;

import com.etiya.business.abstracts.CourseService;
import com.etiya.core.logging.Logger;
import com.etiya.dataAccess.abstracts.CourseRepository;
import com.etiya.entities.Course;

import java.util.List;

public class CourseManager implements CourseService {
    private CourseRepository courseRepository;
    private Logger[] loggers;

    public CourseManager(CourseRepository courseRepository, Logger[] loggers) {
        this.courseRepository = courseRepository;
        this.loggers = loggers;
    }

    @Override
    public void add(Course course) throws Exception {
        if(course.getName().length() < 3){
            throw new Exception("Course name shouldn't be less than 3!");
        }


        for (Course courses : courseRepository.getAll()) {
            if (courses.getName().equals(course.getName())) {
                throw new Exception("Course already exists! Course name: " + course.getName());
            }
        }

        courseRepository.add(course);

        for (Logger logger : loggers) {
            logger.log(course.getName() + " course added!");
        }
    }

    @Override
    public void findAll() {
        List<Course> courses = courseRepository.getAll();

        if (courses.isEmpty()) {
            for (Logger logger : loggers) {
                logger.log("No courses available.");
            }
        } else {
            String allCourses = "All Courses: ";
            for (int i = 0; i < courses.size(); i++) {
                allCourses += courses.get(i).getName();
                if (i < courses.size() - 1) {
                    allCourses += ", ";
                }
            }

            for (Logger logger : loggers) {
                logger.log(allCourses);
            }
        }
    }



    @Override
    public void delete(int id) throws Exception {
        List<Course> courses = courseRepository.getAll();
        boolean found = false;

        for (int i = 0; i < courses.size(); i++) {
            if (id == courses.get(i).getId()) {  // Compare with course's ID
                System.out.println(courses.get(i).getName() + " deleted!");
                courses.remove(i);  // Remove the course from the list
                found = true;  // Set found to true
                break;  // Exit the loop after removal
            }
        }

        if (!found) {
            throw new Exception("No courses found to delete. Course id: " + id);
        }
    }


}
