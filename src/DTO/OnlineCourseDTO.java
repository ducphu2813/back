package DTO;

public class OnlineCourseDTO {
	private int CourseID;
	private String url;
	
	public OnlineCourseDTO() {
		
	}
	
	public OnlineCourseDTO(int CourseID, String url) {
		this.CourseID = CourseID;
		this.url = url;
	}

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
