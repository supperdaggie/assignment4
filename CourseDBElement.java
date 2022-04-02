
public class CourseDBElement implements Comparable {

	protected String courseID;
	protected int crn;
	protected int numOfcredits;
	protected String roomNumber;
	protected String instructorName;
	
	
	public CourseDBElement() {
		this(null,00000,0,null,null);
	}
	
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		courseID=id;
		this.crn=crn;
		this.numOfcredits=credits;
		this.roomNumber=roomNum;
		instructorName=instructor;
	}
	
	public void setCRN(int crn) {
		this.crn=crn;
	}
	
	
	public int getCRN() {
		return crn;
	}
	
	
	@Override
	public int compareTo(CourseDBElement element) {
		if(element.crn==crn) {
			return 0;
		}
		else if(element.crn<crn) {
			return -1;
		}

			return 1;
		
	}
	
	
	public int hashCode() {
		String crn1=Integer.toString(crn);
		return crn1.hashCode();
	}
	
	public String toString() {
		String course="Course:"+courseID+" CRN:"+crn+" Credits:"+numOfcredits+" Instructor:"+instructorName+" Room:"+roomNumber;
		return course;
	}


}