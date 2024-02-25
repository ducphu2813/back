package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.CourseInstructorDTO;

public class CourseInstructorDAL {
	
	private CourseInstructorDTO mapping(ResultSet rs) {
		CourseInstructorDTO object = new CourseInstructorDTO();
		try {
			object.setCourseID(rs.getInt("CourseID"));
			object.setPersonID(rs.getInt("PersonID"));
			return object;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CourseInstructorDTO> findAll() {
		List<CourseInstructorDTO> list = new ArrayList<CourseInstructorDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM CourseInstructor";
		try {
			rs = DataProvider.query(query);
			while (rs.next()) {
				list.add(mapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<CourseInstructorDTO> findByPage(int page, int itemPerPage) {
		List<CourseInstructorDTO> list = new ArrayList<CourseInstructorDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM CourseInstructor LIMIT ? OFFSET ?";
		try {
			rs = DataProvider.query(query, itemPerPage, (page - 1) * itemPerPage);
			while (rs.next()) {
				list.add(mapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<CourseInstructorDTO> findByPersonID(int id) {
		List<CourseInstructorDTO> list = new ArrayList<CourseInstructorDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM CourseInstructor c INNER JOIN Person p ON c.PersonID = p.PersonID WHERE p.PersonID = ?";
		try {
			rs = DataProvider.query(query, id);
			while (rs.next()) {
				list.add(mapping(rs));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean add(CourseInstructorDTO model) {
		String query = "INSERT INTO CourseInstructor(CourseID, PersonID) VALUES(?, ?)";
		return DataProvider.update(query, model.getCourseID(), model.getPersonID()) >= 1 ? true : false;
	}

	public boolean delete(int CourseID, int PersonID) {
		String query = "DELETE FROM CourseInstructor WHERE CourseID = ? AND PersonID = ?";
		return DataProvider.update(query, CourseID, PersonID) >= 1 ? true : false;
	}

	public int countAll() {
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM CourseInstructor";
		int result = 0;
		try {
			rs = DataProvider.query(query);
			while (rs.next()) {
				result = rs.getInt(1);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
