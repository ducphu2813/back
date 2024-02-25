package DTO;

import java.sql.Time;
import java.util.Date;

public class OnsiteCourseDTO {
	private int CourseID;
	private String Location;
	private String Days;
	private Time Time;
	
	public OnsiteCourseDTO() {
		
	}
	
	public OnsiteCourseDTO(int CourseID, String Location, String Days, Time Time) {
		this.CourseID = CourseID;
		this.Location = Location;
		this.Days = Days;
		this.Time = Time;
	}

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDays() {
		return Days;
	}

	public void setDays(String days) {
		Days = days;
	}

	public Time getTime() {
		return Time;
	}

	public void setTime(Time time) {
		Time = time;
	}
	
	
}
