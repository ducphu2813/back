package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.CourseDTO;

public class CourseDAL {

	private CourseDTO mapping(ResultSet rs) {
		CourseDTO object = new CourseDTO();
		try {
			object.setCourseID(rs.getInt("CourseID"));
			object.setDepartmentID(rs.getInt("DepartmentID"));
			object.setTitle(rs.getString("Title"));
			object.setCredits(rs.getInt("Credits"));
			return object;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CourseDTO> findAll() {
		List<CourseDTO> list = new ArrayList<CourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM Course";
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

	public List<CourseDTO> findByTitle(String Title) {
		List<CourseDTO> list = new ArrayList<CourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM Course WHERE Title LIKE ?";
		try {
			rs = DataProvider.query(query, "%" + Title + "%");
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

	public List<CourseDTO> findByPage(int page, int itemPerPage) {
		List<CourseDTO> list = new ArrayList<CourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM Course LIMIT ? OFFSET ?";
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
	
	public CourseDTO findById(int id) {
		ResultSet rs = null;
		String query = "SELECT * FROM Course WHERE CourseID = ?";
		try {
			rs = DataProvider.query(query, id);
			return mapping(rs);
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

	public boolean add(CourseDTO model) {
		String query = "INSERT INTO Course(CourseID, DepartmentID, Title, Credits) VALUES(?, ?, ?, ?)";
		return DataProvider.update(query, model.getCourseID(), model.getDepartmentID(), model.getTitle(),
				model.getCredits()) >= 1 ? true : false;
	}

	public boolean update(CourseDTO model) {
		String query = "UPDATE Course SET DepartmentID = ?, Title = ?, Credits = ? WHERE CourseID = ?";
		return DataProvider.update(query, model.getDepartmentID(), model.getTitle(), model.getCredits(),
				model.getCourseID()) >= 1 ? true : false;
	}

	public boolean delete(int id) {
		String query = "DELETE FROM Course WHERE CourseID = ?";
		return DataProvider.update(query, id) >= 1 ? true : false;
	}

	public int countAll() {
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM Course";
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
