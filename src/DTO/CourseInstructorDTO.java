package DTO;

public class CourseInstructorDTO {
	private int CourseID;
	private int PersonID;
	
	public CourseInstructorDTO() {
		
	}
	
	public CourseInstructorDTO(int CourseID, int PersonID) {
		this.CourseID = CourseID;
		this.PersonID = PersonID;
	}

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public int getPersonID() {
		return PersonID;
	}

	public void setPersonID(int personID) {
		PersonID = personID;
	}
	
}
