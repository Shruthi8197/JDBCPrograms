package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public String saveMobile(Mobile m) {
		String query = "insert into mobile values(?,?,?,?,?,?,?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getBrand());
			ps.setString(4, m.getColour());
			ps.setDouble(5, m.getPrice());
			ps.setInt(6, m.getRam());
			ps.setString(7, m.getManufacture());
			int a = ps.executeUpdate();
			if(a==1)
			return "Saved";
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
		return "Not saved";
	}

	public String updateMobile(Mobile m) {
		String query = "update mobile set name=?,brand=?,colour=?,price=?,ram=?,manufacture=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, m.getName());
			ps.setString(2, m.getBrand());
			ps.setString(3, m.getColour());
			ps.setDouble(4, m.getPrice());
			ps.setInt(5, m.getRam());
			ps.setString(6, m.getManufacture());
			ps.setInt(7, m.getId());
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

	public String deleteMobile(int id) {
		String query = "delete from mobile where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int a = ps.executeUpdate();
			return "deleted";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "not deleted";
	}

	public Mobile getMobile(int id) {
		String query = "Select * from mobile where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Mobile m = new Mobile();
			while (rs.next()) {
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setColour(rs.getString(4));
				m.setPrice(rs.getDouble(5));
				m.setRam(rs.getInt(6));
				m.setManufacture(rs.getString(7));

				return m;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}