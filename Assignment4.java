
import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Assignment4 {

	public static void main(String[] args) {
		
		Student[] studentArray = new Student[101];
		
		try (Scanner scanner = new Scanner(new File("MasterFile.txt"))) {
			
		int i =0;
		 while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(",");
			String id = parts[0].trim();
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
		
		writeStudentsToCSV("course1.csv", studentArray, "COMPSCI");
		writeStudentsToCSV("course2.csv", studentArray, "APMTH");
		writeStudentsToCSV("course3.csv", studentArray, "STAT");
		
		//sperate array into 3 new arrays one for each course, 
		
//		Student[] compSciStudents = new Student[34];
//		Student[] apMathStudents = new Student[33];
//		Student[] stat = new Student[33];
//		
//		int i = 0;
//		int j = 0;
//		int k = 0;
			
		
		
		}
		
	  private static void writeStudentsToCSV(String fileName, Student[] students, String course) {
		  try {
			  // Read existing content of the file
			  
			  Set<String> existingContent = readExistingContent(fileName);
			  
			  //Create a FileWriter in append mode
			  BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			  
			  //If the file is empty, write the headers
			  if(existingContent.isEmpty()) {
				  writer.write("ID,Name,Course,Grade");
				  writer.newLine();
			  }
			  
			  //Write new students that are not duplicates
			  for(Student student : students) {
				  if(student != null && student.getCourse().contains(course)) {
					  String studentData = student.toString();
					  if(!existingContent.contains(studentData)) {
						  writer.write(studentData);
						  writer.newLine();
					  }
				  }
			  }
			  writer.close();
		  } catch (IOException  e) {
			  e.printStackTrace();
		  }
		  
		  
	  }
	  
	  private static Set<String> readExistingContent(String fileName){
		  Set<String> existingContent = new HashSet<>();
		  try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			  // Skip the header line
			  reader.readLine();
			  
			  //Read existing content and add it to the set
			  String line;
			  while((line = reader.readLine()) != null) {
				  existingContent.add(line);
			  }
		  } catch (IOException e) {
			  //Ignore if the file doesn't exist or can't be read
		  }
		  return existingContent;
	  }
	 
	}	

