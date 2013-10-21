/**
 * This program is a registrar for students and courses.
 * You are able to add students, add a course, add a course to a student, print a students schedule,
 * print a courses information, print all students, and print all courses.
 * This class is used with 4 different classes containing methods, Student, Course, StudentNode, and CourseNode.
 * @author Keith McGill
 * @version 12/6/12
 */
import java.util.*;

public class Registrar 
{

	public static void main(String[] args) 
	{
		int registerNow = 0, userChoice = 0, studentCount = 0, courseCount = 0;
		String firstName, lastName, studentID, studentName;
		String courseName, courseDepartment, courseNumber, courseDays, courseMeet, courseCRN, courseTime;
		String dupRegister;
		Student dupStudent, checkStudent;
		Course dupCourse, checkCourse;
		StudentNode allStudents = null;
		CourseNode allCourses = null;
		
		Scanner scan = new Scanner(System.in);
		
		while (registerNow == 0)
		{
			System.out.println("Dowling Registrar");
			System.out.println("1. Add a student.");
			System.out.println("2. Add a course.");
			System.out.println("3. Add a course to a student.");
			System.out.println("4. Print a students schedule.");
			System.out.println("5. Print a courses information.");
			System.out.println("6. Print all students.");
			System.out.println("7. Print all courses.");
			System.out.println("8. Quit.");
			System.out.print("Enter your choice: ");
			userChoice = scan.nextInt();
			scan.nextLine();
			
			if (userChoice == 1)
			{
				System.out.print("\nEnter first name: ");
				firstName = scan.nextLine();
				System.out.print("Enter last name: ");
				lastName = scan.nextLine();
				System.out.print("Enter student ID: ");
				studentID = scan.nextLine();
				studentName = firstName + " " + lastName;
				dupStudent = StudentNode.searchStudent(allStudents, studentID);
				if (dupStudent != null)
				{
					System.out.println("Student already registered.\n");
				}
				else
				{
					Student s = new Student(studentName, studentID);
					allStudents = new StudentNode(s, allStudents);
					System.out.println("Registration successful.\n");
				}
			}
			else if (userChoice == 2)
			{
				System.out.print("\nEnter course name: ");
				courseName = scan.nextLine();
				System.out.print("Enter course department: ");
				courseDepartment = scan.nextLine();
				System.out.print("Enter course number: ");
				courseNumber = scan.nextLine();
				System.out.print("Enter days course meets: ");
				courseDays = scan.nextLine();
				System.out.print("Enter time course meets: ");
				courseMeet = scan.nextLine();
				courseCRN = courseDepartment + " " + courseNumber;
				courseTime = courseDays + " " + courseMeet;
				dupCourse = CourseNode.searchCourse(allCourses, courseCRN);
				if (dupCourse != null)
				{
					System.out.println("Course already registered.\n");
				}
				else
				{
					Course c = new Course(courseName, courseCRN, courseTime);
					allCourses = new CourseNode(c, allCourses);
					System.out.println("Registration successful.\n");
				}
			}
			else if (userChoice == 3)
			{
				System.out.print("\nEnter student ID: ");
				studentID = scan.nextLine();
				checkStudent = StudentNode.searchStudent(allStudents, studentID);
				System.out.print("Enter course department: ");
				courseDepartment = scan.nextLine();
				System.out.print("Enter course number: ");
				courseNumber = scan.nextLine();
				courseCRN = courseDepartment + " " + courseNumber;
				checkCourse = CourseNode.searchCourse(allCourses, courseCRN);
				if (checkStudent == null || checkCourse == null)
				{
					if (checkStudent == null)
					{
						System.out.println("No student registered.\n");
					}
					if (checkCourse == null)
					{
						System.out.println("No course registered.\n");
					}
				}
				else
				{
					dupRegister = checkCourse.checkCourseStudents(studentID);
					if (dupRegister != null)
					{
						System.out.println("Already registered.\n");
					}
					else
					{
						checkStudent.addCourse(checkCourse);
						checkCourse.addStudent(checkStudent);
						System.out.println("Registration successful.\n");
					}
				}
			}
			else if (userChoice == 4)
			{
				System.out.print("\nEnter student ID: ");
				studentID = scan.nextLine();
				dupStudent = StudentNode.searchStudent(allStudents, studentID);
				if (dupStudent != null)
				{
					dupStudent.printStudentCourses();
					System.out.println();
				}
				else
				{
					System.out.println("No student registered.\n");
				}
			}
			else if (userChoice == 5)
			{
				System.out.print("\nEnter course department: ");
				courseDepartment = scan.nextLine();
				System.out.print("Enter course number: ");
				courseNumber = scan.nextLine();
				courseCRN = courseDepartment + " " + courseNumber;
				dupCourse = CourseNode.searchCourse(allCourses, courseCRN);
				if (dupCourse != null)
				{
					dupCourse.printCourseStudents();
					System.out.println();
				}
				else
				{
					System.out.println("No course registered.\n");
				}
			}
			else if (userChoice == 6)
			{
				StudentNode cursor;
				System.out.println();
				for (cursor = allStudents; cursor != null; cursor = cursor.link)
			    {
					System.out.println(cursor.getStu().getName() + " " + cursor.getStu().getId());
			    }
			    System.out.println();
			}
			else if (userChoice == 7)
			{
				CourseNode cursor;
				System.out.println();
			    for (cursor = allCourses; cursor != null; cursor = cursor.link)
			    {
			    	System.out.println(cursor.getCou().getName() + " " + cursor.getCou().getCrn() + 
			    			" " + cursor.getCou().getTime());
			    }
			    System.out.println();
			}
			else if (userChoice == 8)
			{
				registerNow = 1;
			}
			else
			{
				System.out.println("Invalid entry. Please try again.\n");
			}
		}
		
	}

}
