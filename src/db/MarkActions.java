package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Course;
import data.Mark;
import data.User;

public class MarkActions {
	public static void insertInDB(Integer studentId, Integer courceId, String mark, String reply) {
		try {
			// Prepare our SQL string
			final String sqlInsert = "INSERT INTO Marks (student_id, cource_id, mark, reply) "
					+ "VALUES ('"
					+ studentId.intValue()
					+ "', '"
					+ courceId.intValue()
					+ "', '"
					+ mark
					+ "', '"
					+ reply
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
	
	public static ArrayList<Mark> getMarksById(User user) {
		try {
			// Create List for Courses
			ArrayList<Mark> Marks = new ArrayList<Mark>();
			// Prepare our SQL string
			final String sqlGet = "SELECT * FROM Marks WHERE student_id = '" + user.getId() + "'";
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
		        Integer _cource_id = 0;
		        Integer _student_id = 0;
		        String _mark = "";
		        String _reply = "";
		        // Column loop
		        for ( int i = 1 ; i <= numColumns ; i++ ) {
		        	switch(i) {
		        	case 1: _id = rs.getInt(i); 		break;
		        	case 2: _cource_id = rs.getInt(i); 	break;
		        	case 3: _student_id = rs.getInt(i); 	break;
		        	case 4: _mark = rs.getString(i); 	break;
		        	case 5: _reply = rs.getString(i); 	break;
		        	}
		           System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
		        }
		        Course tCourse = CoursesActions.getCourceById(_cource_id);
		        System.out.println(tCourse.toString());

		        User tStudent = UserActions.getUserByID(_student_id);
		        Mark tMark = new Mark(_id, tCourse, tStudent, _mark, _reply);
		        tMark.setId(_id);
		        System.out.println("suka 2");
		        // Add Mark object to List
		        Marks.add(tMark);
		    }
			return Marks;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
