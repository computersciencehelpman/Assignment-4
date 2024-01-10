
import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Assignment4 {

	public static void main(String[] args) {
		
		Student[] studentArray = new Student[101];
		
		try {
			
		File file = new File("MasterFile.txt");
		Scanner scanner = new Scanner(file);
		 
		int i =0;
		 while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(",");
			String id = parts[0].trim();
			System.out.println(line);
			 String name = parts[1].trim();
			 String course = parts[2].trim();
			 
			 int grade = Integer.parseInt(parts[3].trim());
			 
			Student student = new Student(id,name,course, grade); 
			i++;
		 }
			
			
			
		} catch(IOException e) {
			System.out.println("File not found.");
		}
		
		Student[] studentGrade = new Student[101];
		
		Arrays.sort(studentGrade);
		
		File csvOutputFile = new File(studentGradeCSV);
		try (PrintWriter writer = new PrintWriter(csvOutputFile)){
			hasNextLine.stream();
			.map(this::convertToCSV);
			.forEach(writer:: println);
			
		}
		
		assertTrue(studentGradeCSV.exists());
		
		Student[] studentCourse = new Student[101];
		
		Arrays.sort(studentCourse);
		
		File csvOutputFile = new File(studentCourseCSV);
		try (PrintWriter writer = new Printwriter(csvOutputFile)){
			hasNextLine.stream();
			.map(this:: convertToCSV);
			.forEach(writer::println);
		}
		
		assertTrue(studentCourseGradeCSV.exists());
	}
	 
	
}
