/* Skylar Masson
 * 2/3/2022
 * Programming Assignment #1 - Student/Teacher application
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TestApplication {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();		//Creating arraylist object for storage
		Student student = new Student();								//Creating student object for reference
		displayMenu(studentList, student);								//When program starts, this function is performed
	}
	
	/* This function displays the menu
	 * and allows the user to input their choice
	 * and calls other functions depending on users input
	 */
	public static void displayMenu(ArrayList<Student> studentList, Student student) {
		
		Scanner scnr = new Scanner(System.in);							//Creating a scanner object for user input
		
		int userChoice;													//integer for user input
		do {															//do-while loop to display menu & receive input
			//Menu For Application										//checks for validation. If incorrect, repeats process
			System.out.println("---CLASS MENU OPTION---");
			System.out.println("Which would you like to do?");
			System.out.println("1 - Add Student\n" +
							   "2 - Display Roster (names)\n" +
							   "3 - Display names and grades\n" +
							   "4 - Display student full information\n" +
							   "5 - Delete a student from roster\n" +
							   "6 - Update a students information\n" +
							   "7 - Exit Application");
			System.out.println("---------------------------------------");
			System.out.print("\nEnter a number: ");
			userChoice = scnr.nextInt();
			
			if (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4 && userChoice != 5 && userChoice != 6 && userChoice != 7) {
				System.out.println("Invalid Input. Please Try Again!");
				System.out.println("");
			}
		} while(userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4 && userChoice != 5 && userChoice != 6 && userChoice != 7);
		
		//Switch case for user input and calling function
		//depending on the user choice
		switch (userChoice) {
			case 1:
				addStudent(studentList, scnr);
				break;
			case 2:
				displayRoster(studentList, student);
				break;
			case 3:
				displayNamesAndGrades(studentList, student);
				break;
			case 4:
				displayFullInformation(studentList, student);
				break;
			case 5:
				deleteStudent(studentList, student);
				break;
			case 6:
				updateStudentInfo(studentList, student);
				break;
			case 7:
				System.out.println("Application Exited");
				break;
			default:
				break;
		}
	}
	
	//This function is called when input = 1
	//Function asks for name, class, ID, along with 5 grades for input
	//Then calculates grades calling the Student class
	public static void addStudent(ArrayList<Student> studentList, Scanner scnr) {		
		String studentName, className;
		int idNumber;
		System.out.println("--ADD STUDENT MENU--");
		System.out.print("Students Name: ");
		studentName = scnr.nextLine();
		studentName = scnr.nextLine();
		System.out.print("Students Class: ");
		className = scnr.nextLine();
		System.out.print("Students ID number: ");
		idNumber = scnr.nextInt();
		
		Student student = new Student(studentName, className, idNumber);
		studentList.add(student);
		
		
		System.out.println("");
		System.out.println("Student Successfully Created.\n" +
						   "Students Name: " + studentName +
						   "\nStudents Class: " + className +
						   "\nStudents ID Number: " + idNumber);
		
		System.out.println("");
		
		//Variables for calculation
		int[] grades = new int[5];						//Array to store 5 grade numbers
		int average;									//Integer that holds the average of the 5 grades
		int totalSum = 0;								//Integer that holds the total sum of all 5 grades
		int courseTotal = 5;							//Integer that holds the max of 5 classes to divide from
		for (int i = 0; i < grades.length; i++) {
			System.out.println("Enter Students Grade (in integer format): ");
			grades[i] = scnr.nextInt();
			totalSum += grades[i];
		}
		average = totalSum / courseTotal;
		System.out.println("The grades you entered are: \n" +
						    grades[0] + "\n" +
						    grades[1] + "\n" +
						    grades[2] + "\n" +
						    grades[3] + "\n" +
						    grades[4] + "\n" );
		System.out.println("The average is: " + average + "%");
		student.getLetterGrade(average);
		
		displayMenu(studentList, student);
		
	}
	
	//When input = 2
	//This function displays the results of the list of students
	//Only displays names
	public static void displayRoster(ArrayList<Student> studentList, Student student) {
		System.out.println("--STUDENT ROSTER--");
		for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getStudentName());
        }
		System.out.println("");
		displayMenu(studentList, student);
	}
	
	//When input = 3
	//This function displays names and grades
	public static void displayNamesAndGrades(ArrayList<Student> studentList, Student student) {
		System.out.println("--STUDENT ROSTER WITH GRADES--");
		for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getStudentName() + " - Avg: " + studentList.get(i).letterGrade());
        }
		System.out.println("");
		displayMenu(studentList, student);
	}
	
	//When input = 4
	//This function displays students name, class, idnumber, and letter grade
	public static void displayFullInformation(ArrayList<Student> studentList, Student student) {
		System.out.println("--STUDENTS FULL INFORMATION--");
		for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getStudentName());
            System.out.println(studentList.get(i).getClassName());
            System.out.println(studentList.get(i).getidNumber());
            System.out.println(studentList.get(i).letterGrade());
        }
		System.out.println("");
		displayMenu(studentList, student);
	}
	
	//When input = 5
	//This function deletes previously created student from the list
	public static void deleteStudent(ArrayList<Student> studentList, Student student) {
		for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentName() == student.getStudentName()) {
                studentList.remove(studentList.get(i));
                break;
            }
        }
		System.out.println("Student Successfully Deleted");
		System.out.println("");
		displayMenu(studentList, student);
	}
	
	//When input = 6
	//This function (does nothing as of yet)
	public static void updateStudentInfo(ArrayList<Student> studentList, Student student) {
		System.out.println("--STUDENT ROSTER--");
		Scanner scnr = new Scanner(System.in);
		for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getStudentName() + "   ID: " + studentList.get(i).getidNumber());
        }
		
		int choice;
		int i;
		do {
			System.out.println("Which student would you like to edit? (Enter the students current ID number");
			choice = scnr.nextInt();
			for (i = 0; i < studentList.size(); i++) {
				if (choice == studentList.get(i).getidNumber()) {
					break;
				}
	        }
			if (choice != studentList.get(i).getidNumber()) {
				System.out.println("Invalid Input. Please Try Again!");
				System.out.println("");
			}
		} while(choice != studentList.get(i).getidNumber());
		
		int z;
		for (z = 0; z < studentList.size(); z++) {
            if (choice == studentList.get(z).getidNumber()) {
            	String studentName, className;
        		int idNumber;
        		System.out.println("--UPDATE STUDENT MENU--");
        		System.out.print("Students Name: ");
        		studentName = scnr.nextLine();
        		studentName = scnr.nextLine();
        		System.out.print("Students Class: ");
        		className = scnr.nextLine();
        		System.out.print("Students ID number: ");
        		idNumber = scnr.nextInt();
        		
        		Student updateStudent = new Student(studentName, className, idNumber);
        		studentList.set(z, updateStudent);
        		
        		
        		System.out.println("");
        		System.out.println("Student Successfully Created.\n" +
        						   "Students Name: " + studentName +
        						   "\nStudents Class: " + className +
        						   "\nStudents ID Number: " + idNumber);
            }
        }
		
		displayMenu(studentList, student);
	}
}