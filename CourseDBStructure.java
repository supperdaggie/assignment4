import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	protected int HashSize=0;
	protected int elementSize=0;
	protected LinkedList<CourseDBElement> [] hashTable;
	

	public CourseDBStructure(int size) {
		HashSize=size;
		hashTable=new LinkedList[HashSize];
	}
	

	public CourseDBStructure(String testing,int size) {
		HashSize=size;
		hashTable=new LinkedList[HashSize];
	}
	

	@Override
	public void add(CourseDBElement element) {

		int code;
		code=Math.abs(element.hashCode())% HashSize;
		LinkedList <CourseDBElement>current=hashTable[code];
		if(element.courseID.contains("-updated")) {
			System.out.println("hello");
			hashTable[code]=new LinkedList<CourseDBElement>();
			hashTable[code].add(element);
			elementSize++;
		}
		if(current==null) {
			hashTable[code]=new LinkedList<CourseDBElement>();
			hashTable[code].add(element);
			elementSize++;
	}
}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		String crn1=Integer.toString(crn);
		int code=Math.abs(crn1.hashCode())% HashSize;
		if(hashTable[code]==null) {
			throw new IOException();
		}
		else{
			return (CourseDBElement) hashTable[code].get(0);
		}

	}

	@Override
	public int getTableSize() {
		return HashSize;
	}
	

	public ArrayList<String> showAll() {
		ArrayList<String> courses=new ArrayList<String>();
		for(int i=0;i<HashSize;i++) {
			while(hashTable[i]!=null) {
				for(int j=0;j<hashTable[i].size();j++) {
					CourseDBElement element= (CourseDBElement) hashTable[i].get(j);
					courses.add("\n"+element.toString());
				}
				break;
			}
		}
		return courses;
	}
}