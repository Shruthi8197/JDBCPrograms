package jdbc_maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Student_call {

	public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
	CallableStatement cs=con.prepareCall("call save_student(?,?,?,?,?)");
	cs.setInt(1, 101);
	cs.setString(2, "Ranjitha");
	cs.setLong(3, 5756467);
	cs.setString(4, "CHN");
	cs.setInt(5, 93);
	
	cs.execute();
	System.out.println("Details are saved");
	con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
