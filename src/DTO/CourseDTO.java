package DTO;

public class CourseDTO {
	private int CourseID;
	private int DepartmentID;
	private String Title;
	private int Credits;
	
	public CourseDTO() {
		
	}
	
	public CourseDTO(int CourseID, String Title, int Credits, int DepartmentID) {
		this.CourseID = CourseID;
		this.DepartmentID = DepartmentID;
		this.Title = Title;
		this.Credits = Credits;
	}
	
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	public int getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getCredits() {
		return Credits;
	}
	public void setCredits(int credits) {
		Credits = credits;
	}
}
