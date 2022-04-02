import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure cds=new CourseDBStructure(20);

	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde=new CourseDBElement(id,crn,credits,roomNum,instructor);
		cds.add(cde);
		
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner in=new Scanner(input);
		int cred,crn;
		CourseDBElement cde;
		String courses;
		String[] course;
		while (in.hasNextLine()) {
			courses=in.nextLine();
			course=courses.split(" ",5);
			crn=Integer.parseInt(course[1]);
			cred=Integer.parseInt(course[2]);
			cde=new CourseDBElement(course[0],crn,cred,course[3],course[4]);
			cds.add(cde);
		}
		
	}

	
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}
	
}