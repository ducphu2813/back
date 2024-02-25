package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.OnsiteCourseDTO;

public class OnsiteCourseDAL {
	
	private OnsiteCourseDTO mapping(ResultSet rs) {
		OnsiteCourseDTO object = new OnsiteCourseDTO();
		try {
			object.setCourseID(rs.getInt("CourseID"));
			object.setLocation(rs.getString("Location"));
			object.setDays(rs.getString("Days"));
			object.setTime(rs.getTime("Time"));
			return object;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OnsiteCourseDTO> findAll() {
		List<OnsiteCourseDTO> list = new ArrayList<OnsiteCourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM OnsiteCourse";
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

	public List<OnsiteCourseDTO> findByPage(int page, int itemPerPage) {
		List<OnsiteCourseDTO> list = new ArrayList<OnsiteCourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM OnsiteCourse LIMIT ? OFFSET ?";
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
	
	public OnsiteCourseDTO findById(int id) {
		ResultSet rs = null;
		String query = "SELECT * FROM OnsiteCourse WHERE CourseID = ?";
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

	public boolean add(OnsiteCourseDTO model) {
		String query = "INSERT INTO OnsiteCourse(CourseID, Location, Days, Time) VALUES(?, ?, ?, ?)";
		return DataProvider.update(query, model.getCourseID(), model.getLocation(), model.getDays(), model.getTime()) >= 1 ? true : false;
	}

	public boolean update(OnsiteCourseDTO model) {
		String query = "UPDATE OnsiteCourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
		return DataProvider.update(query,  model.getLocation(), model.getDays(), model.getTime(), model.getCourseID()) >= 1 ? true : false;
	}

	public boolean delete(int id) {
		String query = "DELETE FROM OnsiteCourse WHERE CourseID = ?";
		return DataProvider.update(query, id) >= 1 ? true : false;
	}

	public int countAll() {
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM OnsiteCourse";
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
