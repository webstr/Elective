package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Course;
import data.User;

public class CoursesActions {
	
	private CoursesActions() {
		
	}
	
	public static void insertInDB(Course course) {
		try {
			// Prepare our SQL string
			final String sqlInsert = "INSERT INTO Courses (name, teacher_id) "
					+ "VALUES ('"
					+ course.getName()
					+ "', '"
					+ course.getTeacher().getId()
					+ "')";
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
	
	public static void deleteFromDB(Integer id) {
		try {
			// Prepare our SQL string
			final String sqlDelete = "DELETE FROM Courses WHERE id = '" + id + "' ";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlDelete);
			// Send our SQL Statement
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Course> getCourcesList() {
		try {
			// Create List for Courses
			ArrayList<Course> Courses = new ArrayList<Course>();
			// Prepare our SQL string
			final String sqlGet = "SELECT * FROM Courses";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlGet);
			// Send our SQL Statement and get the result set
			final ResultSet rs = ps.executeQuery();
			// Parsing result set. Row loop.
			while (rs.next()) {
		        int numColumns = rs.getMetaData().getColumnCount();
		        // Store some temporary variables
		        String _name = "";
		        Integer _id = 0;
		        Integer _teacher_id = 0;
		        // Column loop
		        for ( int i = 1 ; i <= numColumns ; i++ ) {
		        	switch(i) {
		        	case 1: _id = rs.getInt(i); break;
		        	case 2: _name = rs.getString(i); break;
		        	case 3: _teacher_id = rs.getInt(i); break;
		        	}
		           //System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
		        }
		        // Get teacher from database, by his id in current course
		        User tTeacher = UserActions.getUserByID(_teacher_id);
		        // Create Course object from database data
		        Course tCourse = new Course(_name, tTeacher);
		        tCourse.setId(_id);
		        // Add Course object to List
		        Courses.add(tCourse);
		    }
			return Courses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static ArrayList<Course> getMyCources(User user) {
		try {
			// Create List for Courses
			ArrayList<Course> Courses = new ArrayList<Course>();
			// Prepare our SQL string
			final String sqlGet = "SELECT * FROM Courses_Students WHERE student_id = '" + user.getId() + "'";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlGet);
			// Send our SQL Statement and get the result set
			final ResultSet rs = ps.executeQuery();
			// Parsing result set. Row loop.
			while (rs.next()) {
		        int numColumns = rs.getMetaData().getColumnCount();
		        // Store some temporary variables
		      
		        Integer _id = 0;
		        // Column loop
		        for ( int i = 1 ; i <= numColumns ; i++ ) {
		        	switch(i) {
		        	case 2: _id = rs.getInt(i); break;
		        	}
		           //System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
		        }
		        Courses.add(getCourceById(_id));
		    }
			return Courses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static Course getCourceById(Integer id) {
		try {
			// Prepare our SQL string
			final String sqlGet = "SELECT * FROM Courses WHERE id = '" + id.intValue() + "'";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlGet);
			// Send our SQL Statement and get the result set
			final ResultSet rs = ps.executeQuery();
			// Parsing result set. Row loop.
			while (rs.next()) {
		        int numColumns = rs.getMetaData().getColumnCount();
		        // Store some temporary variables
		        String _name = "";
		        Integer _id = 0;
		        Integer _teacher_id = 0;
		        // Column loop
		        for ( int i = 1 ; i <= numColumns ; i++ ) {
		        	switch(i) {
		        	case 1: _id = rs.getInt(i); break;
		        	case 2: _name = rs.getString(i); break;
		        	case 3: _teacher_id = rs.getInt(i); break;
		        	}
		           //System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
		        }
		        // Get teacher from database, by his id in current course
		        User tTeacher = UserActions.getUserByID(_teacher_id);
		        // Create Course object from database data
		        Course tCourse = new Course(_name, tTeacher);
		        tCourse.setId(_id);
		        return tCourse;
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static void unJoinCource(Integer id) {
		try {
			// Prepare our SQL string
			final String sqlDelete = "DELETE FROM Courses_Students WHERE course_id = '" + id + "' ";
			// Get DB connection
			Connection con = DBC.getInstance().getConnection();
			// Convert SQL string to SQL Statement
			final PreparedStatement ps = con.prepareStatement(sqlDelete);
			// Send our SQL Statement
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
