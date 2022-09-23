package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ty.dto.Signup;

public class SignupDao {
	
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	
	public Signup saveDetails(Signup s) {
		String query="insert into user values(?,?,?,?,?,?,?)";
		
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setLong(5, s.getPhone());
			ps.setString(6, s.getDob());
			ps.setString(7, s.getGender());
			
			ps.execute();
			return s;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
		
	}
	
	public Signup updateDetails(Signup s) {
		String query="update user set firstname=?, lastname=?,password=?,phone=?,dob=?,gender=? where email=?";
		
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s.getFirstname());
			ps.setString(2,s.getLastname());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getPhone());
			ps.setString(5, s.getDob());
			ps.setString(6, s.getGender());
			ps.setString(7, s.getEmail());
			
			ps.execute();
			return s;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	public String deleteDetails(String email) {
		String query = "delete from user where email=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.execute();
			return "User details deleted";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "User details not deleted";
	}
	public Signup getDetails(String email,String password) {
		String query="Select * from user where email=? and password=?";
		
		
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, this.password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			Signup s3=new Signup();
			while(rs.next()) {
			s3.setFirstname(rs.getString("firstname"));
			s3.setLastname(rs.getString("lastname"));
			s3.setEmail(rs.getString("email"));
			s3.setPassword(rs.getString("password"));
			s3.setPhone(rs.getLong("phone"));
			s3.setDob(rs.getString("dob"));
			s3.setGender(rs.getString("gender"));
			return s3;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public List<Signup> getAllDetails() {
		String query = "select * from user";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Signup> list = new ArrayList();
			while (rs.next()) {
				Signup s4 = new Signup();
				s4.setFirstname(rs.getString(1));
				s4.setLastname(rs.getString(2));
				s4.setEmail(rs.getString(3));
				s4.setPassword(rs.getString(4));
				s4.setPhone(rs.getLong(5));
				s4.setDob(rs.getString(6));
				s4.setGender(rs.getString(7));
				list.add(s4);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

}
