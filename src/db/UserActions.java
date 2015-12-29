package db; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.User;

public class UserActions {

	private UserActions() {

	}

	// Add new user to database
	public static void insertInDB(User user) {
		try {
			// Prepare our SQL string
			final String sqlInsert = "INSERT INTO Users (login, password, name, type) "
					+ "VALUES ('"
					+ user.getLogin()
					+ "', '"
					+ user.getPassword()
					+ "', '"
					+ user.getName()
					+ "', '"
					+ user.getType() + "')";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlInsert);
			// Send our SQL Statement
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Load user from database
	public static User getUserFromDB(String login, String password) {
		try {
			// Prepare our SQL string
			final String sqlGet = "SELECT * FROM Users WHERE login = '"
					+ login + "' AND  password = '" + password + "'";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlGet);
			// Send our SQL Statement and get the result set
			final ResultSet rs = ps.executeQuery();
			// Store some temporary variables
			String _login = "", _password = "", _name = "", _type = "";
			Integer _id = 0;
			// Parsing result set
			if (rs.next()) {
				_id = rs.getInt("id");
				_login = rs.getString("login");
				_password = rs.getString("password");
				_name = rs.getString("name");
				_type = rs.getString("type");
			}
			// Create user from database data
			User tUser = new User(_login, _password, _name, _type);
			tUser.setId(_id);

			return tUser;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Check if the database includes login or not
	// true-exist, false-not
	public static Boolean checkLoginInDB(String login) {
		try {
			// Prepare our SQL string
			final String sqlCheck = "SELECT count(*) FROM Users WHERE login = '"
					+ login + "'";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlCheck);
			// Send our SQL Statement and get the result set
			final ResultSet rs = ps.executeQuery();
			// Parsing result set
			if (rs.next()) {
				// Getting login entries count
				final int count = rs.getInt(1);
				if (count >= 1) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static User getUserByID(Integer id) {
		try {
			// Prepare our SQL string
			final String sqlGet = "SELECT * FROM Users WHERE id = '" + id + "'";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlGet);
			// Send our SQL Statement and get the result set
			final ResultSet rs = ps.executeQuery();
			// Store some temporary variables
			String _login = "", _password = "", _name = "", _type = "";
			Integer _id = 0;
			// Parsing result set
			if (rs.next()) {
				_id = rs.getInt("id");
				_login = rs.getString("login");
				_password = rs.getString("password");
				_name = rs.getString("name");
				_type = rs.getString("type");
			}
			// Create user from database data
			User tUser = new User(_login, _password, _name, _type);
			tUser.setId(_id);

			return tUser;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<User> getStudentsByCourseID(Integer id) {
		try {
			// Create List for students
			ArrayList<User> students = new ArrayList<User>();
			// Prepare our SQL string
			final String sqlGet = "SELECT student_id FROM Courses_Students WHERE course_id = '" + id + "'";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlGet);
			// Send our SQL Statement and get the result set
			final ResultSet rs = ps.executeQuery();
			// Parsing result set. Row loop.
			while (rs.next()) {
		        int numColumns = rs.getMetaData().getColumnCount();
		        System.out.println("col count = " + numColumns);
		        // Store some temporary variables
		        Integer _student_id = 0;
		        // Get Student id
		        _student_id =rs.getInt(1);
		        // Get Student from database, by his id in current course
		        User tStudent = UserActions.getUserByID(_student_id);
		        System.out.println(tStudent.toString());
		        // Add Course object to List
		        students.add(tStudent);
		    }
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public static void joinCourse(User user, Integer courceID) {
		try {
			// Prepare our SQL string
			final String sqlInsert = "INSERT INTO Courses_Students (course_id, student_id) "
					+ "VALUES ('"
					+ courceID
					+ "', '"
					+ user.getId() + "')";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlInsert);
			// Send our SQL Statement
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
