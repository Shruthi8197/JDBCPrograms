package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO1 {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public String savePerson(Person p) {
		String query = "insert into person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getAddress());
			ps.setLong(4, p.getPhone());
			ps.setInt(5, p.getPincode());
			int a = ps.executeUpdate();// a=1 since 1row will be affected and returning int
			if (a == 1) {
				return "saved";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "not saved";

	}

	public String updatePerson(Person p) {
		String query = "update person set name=?,address=?,phone=?,pincode=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setString(2, p.getAddress());
			ps.setLong(3, p.getPhone());
			ps.setInt(4, p.getPincode());
			ps.setInt(5, p.getId());
			int a = ps.executeUpdate();// a=1 since 1row will be affected and returning int

			return "updated";

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "not updated";

	}

	public String deletePerson(int id) {
		String query = "delete from person where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int a = ps.executeUpdate();// a=1 since 1row will be affected and returning int

			return "deleted";

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "not deleted";

	}

	public Person getPerson(int id) {
		String query = "select * from person where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();// a=1 since 1row will be affected and returning int
			Person person = new Person();
			while (rs.next()) {
			person.setId(rs.getInt(1));
			person.setName(rs.getString(2));
			person.setAddress(rs.getString(3));
			person.setPhone(rs.getLong(4));
			person.setPincode(rs.getInt(5));
			}
			return person;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return null;

	}

}
