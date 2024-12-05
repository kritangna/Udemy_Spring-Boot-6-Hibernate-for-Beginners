package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner ->
		{
			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			// findStudentAndCourses(appDAO);
			// addMoreCoursesForStudent(appDAO);
			// deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Deleting student id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Expense Sheet Management");
		Course tempCourse2 = new Course("SOLID Principles");
		Course tempCourse3 = new Course("Design Patterns");
		Course tempCourse4 = new Course("Multithreading");

		// add courses to the student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Update student: " + tempStudent);
		System.out.println("Associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);
		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Loaded Courses: " + tempStudent.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded Course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Job Portal Development using Spring-Boot");

		// create the students
		Student tempStudent1 = new Student("John", "Mish", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Lane", "mary@luv2code.com");
		Student tempStudent3 = new Student("Chloe", "Ting", "chloe@luv2code.com");
		Student tempStudent4 = new Student("Jave", "Mayer", "jave@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);
		tempCourse.addStudent(tempStudent4);

		// save the course and associated students
		System.out.println("Saving the courses: " + tempCourse);
		System.out.println("Saving the students: " + tempCourse.getStudents());
		appDAO.save(tempCourse);
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting the course");
		System.out.println("The course is: " + appDAO.findCourseById(theId));

		appDAO.deleteCourseById(theId);

		System.out.println("Course is deleted: " + appDAO.findCourseById(theId));

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println("Course: " + tempCourse);

		// print the reviews
		System.out.println("Reviews: " + tempCourse.getReviews());
	}

	private void createCourseAndReview(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Java Springboot");

		// add some reviews
		tempCourse.addReview(new Review("Great Course!"));
		tempCourse.addReview(new Review("Loved the Course!"));
		tempCourse.addReview(new Review("Recommending!"));
		tempCourse.addReview(new Review("Intermediate Level!"));

		// save the course ... and leverage the cascade all
		// will save the reviews automatically because of the cascade All
		System.out.println("Saving the course");
		System.out.println("course: " + tempCourse);
		System.out.println("Reviews associated with the course are: " + tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Deleted!!!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseById(theId);
		tempCourse.setTitle("Money Minded");

		appDAO.update(tempCourse);

		System.out.println(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Updating the instructor!!!");
		instructor.setLastName("Tester");
		appDAO.update(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		// find the instructor
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("courses : " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		System.out.println(courses);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("courses are: "+ tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Susan", "Paxton", "susan@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses

		Course tempCourse1 = new Course("Guitar");
		Course tempCourse2 = new Course("Pinball");

		// add courses to the instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		// NOTE: this will also save the courses because of CascadingType.PERSIST
		System.out.println("Saving the instructor: " + tempInstructor);
		System.out.println("The courses are: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;

		System.out.println("Deleting the instructor detail with id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: "+ tempInstructorDetail);
		System.out.println("instructor details are: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting the instructor id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("instructor details are: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 Code!!!");
		*/
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube", "Playing Guitar!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
 		// NOTE: this will also save the details object
		appDAO.save(tempInstructor);

	}
}
