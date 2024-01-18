
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
			//System.out.println(line);
			 String name = parts[1].trim();
			 String course = parts[2].trim();
			 
			 String grade = parts[3].trim();
			 
			Student student = new Student(id,name,course, grade);
			studentArray[i] = student;
			
			i++;
		 }
			
			
			
		} catch(IOException e) {
			System.out.println("File not found.");
		}
		
		
		
		Arrays.sort(studentArray);
		//sperate array into 3 new arrays one for each course, 
		
		Student[] compSciStudents = new Student[34];
		Student[] apMathStudents = new Student[33];
		Student[] stat = new Student[33];
		
		int i = 0;
		int j = 0;
		int k = 0;
		for(Student student: studentArray) {
			
			
			if(student.getCourse().contains("COMPSCI")) {
				
				try(BufferedWriter writer = new BufferedWriter(new FileWriter("course1.csv"))) {
					compSciStudents[i] = student;
					//System.out.println(compSciStudents[i].toString());
					
					
					
					
					
					writer.write(compSciStudents[i].toString());
					writer.newLine();
				}
				catch (IOException e){
					e.printStackTrace();
				}
				
				i++;
				
				
			}
			
			if(student.getCourse().contains("APMTH")) {
				
				try(BufferedWriter writer = new BufferedWriter(new FileWriter("course2.csv"))) {
					apMathStudents[i] = student;
					
					writer.write(apMathStudents[j].toString());
					writer.newLine();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
				
				j++;
			}
			
			if(student.getCourse().contains("STAT")) {
				
				try(BufferedWriter writer = new BufferedWriter(new FileWriter("course3.csv"))){
					stat[k] = student;
					
					writer.write(stat[k].toString());
					writer.newLine();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				
				
				k++;
			}
			
		}
		
		
		
//		File csvOutputFile = new File(studentGradeCSV);
//		try (PrintWriter writer = new PrintWriter(csvOutputFile)){
//			hasNextLine.stream();
//			.map(this::convertToCSV);
//			.forEach(writer:: println);
//			
//		}
//		
//		assertTrue(studentGradeCSV.exists());
//		
//		Student[] studentCourse = new Student[101];
//		
//		Arrays.sort(studentCourse);
//		
//		File csvOutputFile = new File(studentCourseCSV);
//		try (PrintWriter writer = new Printwriter(csvOutputFile)){
//			hasNextLine.stream();
//			.map(this:: convertToCSV);
//			.forEach(writer::println);
//		}
//		
//		assertTrue(studentCourseGradeCSV.exists());
//	}
	 
	}	
}
