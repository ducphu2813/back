package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.OnlineCourseDTO;

public class OnlineCourseDAL {

	private OnlineCourseDTO mapping(ResultSet rs) {
		OnlineCourseDTO object = new OnlineCourseDTO();
		try {
			object.setCourseID(rs.getInt("CourseID"));
			object.setUrl(rs.getString("url"));
			return object;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OnlineCourseDTO> findAll() {
		List<OnlineCourseDTO> list = new ArrayList<OnlineCourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM OnlineCourse";
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

	public List<OnlineCourseDTO> findByUrl(String url) {
		List<OnlineCourseDTO> list = new ArrayList<OnlineCourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM OnlineCourse WHERE url LIKE ?";
		try {
			rs = DataProvider.query(query, "%" + url + "%");
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

	public List<OnlineCourseDTO> findByPage(int page, int itemPerPage) {
		List<OnlineCourseDTO> list = new ArrayList<OnlineCourseDTO>();
		ResultSet rs = null;
		String query = "SELECT * FROM OnlineCourse LIMIT ? OFFSET ?";
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
	
	public OnlineCourseDTO findById(int id) {
		ResultSet rs = null;
		String query = "SELECT * FROM OnlineCourse WHERE CourseID = ?";
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

	public boolean add(OnlineCourseDTO model) {
		String query = "INSERT INTO OnlineCourse(CourseID, url) VALUES(?, ?)";
		return DataProvider.update(query, model.getCourseID(), model.getUrl()) >= 1 ? true : false;
	}

	public boolean update(OnlineCourseDTO model) {
		String query = "UPDATE OnlineCourse SET url = ? WHERE CourseID = ?";
		return DataProvider.update(query, model.getUrl(), model.getCourseID()) >= 1 ? true : false;
	}

	public boolean delete(int id) {
		String query = "DELETE FROM OnlineCourse WHERE CourseID = ?";
		return DataProvider.update(query, id) >= 1 ? true : false;
	}

	public int countAll() {
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM OnlineCourse";
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
