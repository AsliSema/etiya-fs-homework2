package com.etiya;

import com.etiya.business.abstracts.CourseService;
import com.etiya.business.concretes.CourseManager;
import com.etiya.core.logging.ConsoleLogger;
import com.etiya.core.logging.DatabaseLogger;
import com.etiya.core.logging.Logger;
import com.etiya.dataAccess.concretes.HibernateCourseRepository;
import com.etiya.dataAccess.concretes.InMemoryCourseRepository;
import com.etiya.entities.Course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        Logger[] loggers = {new ConsoleLogger()};


        Course course4 = new Course(
                4,
                "React",
                new Date(),
                new Date(),
                new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30))
        );

        CourseService courseService = new CourseManager(new InMemoryCourseRepository(), loggers);

        courseService.findAll();

        // Add another course
        courseService.add(course4);
        courseService.findAll();

        //Delete the course that doesn't exist
        //courseService.delete(13);

        courseService.delete(4);
        courseService.findAll();





    }
}
