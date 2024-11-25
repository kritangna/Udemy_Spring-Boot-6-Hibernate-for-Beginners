package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		//deleteStudent(studentDAO);
		return runner->
		{
			 createStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// queryForStudentsByFirstName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");

		int numOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numOfRowsDeleted + " students");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		// Retrieving the Student with the given id

		System.out.println("Getting Student with ID " + studentId);
		Student theStudent = studentDAO.findById(studentId);
		System.out.println(theStudent);

		// Updating the first name and the last name of the Student with the given id

		System.out.println("Updating Student...");
		theStudent.setFirstName("Woofer");
		theStudent.setLastName("Singh");
		studentDAO.update(theStudent);

		// display the updated student
		System.out.println("Updated student with ID " + studentId + " is: " + theStudent);
	}

	private void queryForStudentsByFirstName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByFirstName("Daffy");

		// Display the list of Students
		for(Student tmepStudent : theStudents) {
			System.out.println(tmepStudent);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		// display the students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a student in readStudent");
		Student tempStudent1 = new Student("Daffy", "Apple", "daffy@luv2code.com");

		// save the student
		studentDAO.save(tempStudent1);

		// display the id of the student
		int theId = tempStudent1.getId();
		System.out.println("Saved Student. Generate id: " +theId);

		// retrieve the student
		System.out.println("Retrieving the student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display the student
		System.out.println("Displaying the student: " + myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting Student with ID " + studentId);

		studentDAO.delete(studentId);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the student object
		System.out.println("Display the saved student by ID: " + tempStudent.getId());
	}
}
