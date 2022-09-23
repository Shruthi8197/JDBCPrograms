package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {

	public static void main(String[] args) {
		List<Person> list=new ArrayList<Person>();
		Person p=new Person(21,"ab","hyd",454456,344);
		Person p1=new Person(22,"cd","chn",466767,345);
		Person p2=new Person(23,"ef","syd",54545,346);
		Person p3=new Person(28,"gh","mub",8712,347);
		Person p4=new Person(26,"ij","del",76861,348);
		list.add(p);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		System.out.println(list);
		
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query = "insert into person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			for(Person value:list) {
			ps.setInt(1, value.getId());
			ps.setString(2, value.getName());
			ps.setString(3, value.getAddress());
			ps.setLong(4, value.getPhone());
			ps.setInt(5, value.getPincode());
			ps.addBatch();
			}
			ps.executeBatch();
			System.out.println("All data inserted");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
