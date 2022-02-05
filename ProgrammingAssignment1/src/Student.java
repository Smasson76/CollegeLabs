
public class Student {
	
	//Variables
	String studentName;
	String className;
	int idNumber;
	double average;
	char letterGrade;
		
	//Default constructor
	public Student() {
		studentName = "No Name Entered";
		className = "No Class Entered";
		idNumber = 0;
		average = 0.0;
		letterGrade = 'F';
	}
	
	//Parameterized constructor
	public Student(String studentName, String className, int idNumber) {
		this.studentName = studentName;
		this.className = className;
		this.idNumber = idNumber;
	}
	
	//Mutators
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public void setidNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public void setAverage(double average) {
		this.average = average;
	}
	
	public void setLetterGrade(char letterGrade) {
		this.letterGrade = letterGrade;
	}
	
	//Accessor
	public String getStudentName() {
		return studentName;
	}
	
	public String getClassName() {
		return className;
	}
	
	public int getidNumber() {
		return idNumber;
	}
	
	public double getAverage() {
		return average;
	}
	
	public char letterGrade() {		
		return letterGrade;
	}
	
	//getLetterGrade returns the Character depending on the grade percentage
	public void getLetterGrade(int average) {
		if (average >= 90) {
			letterGrade = 'A';
		}
		else if (average <= 89 && average >= 80) {
			letterGrade = 'B';
		}
		else if (average <= 79 && average >= 70) {
			letterGrade = 'C';
		}
		else if (average <= 69 && average >= 60) {
			letterGrade = 'D';
		}
		else {
			letterGrade = 'F';
		}
	}
}
