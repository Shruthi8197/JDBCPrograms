package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;

public class CartDAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public Cart insertCart(Cart c) {
		String query = "insert into cart values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getUsername());
			ps.setString(5, c.getAddress());

			ps.execute();
			Cart c1 = new Cart();
			return c1;
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

	public Cart updateCart(Cart c) {
		String query = "update cart set email=?,password=?,username=?,address=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getAddress());
			ps.setInt(5, c.getId());

			ps.execute();
			Cart c2 = new Cart();
			return c2;
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

	public String deleteCart(int id) {
		String query = "delete from cart where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			return "Cart deleted";
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
		return "Cart not deleted";
	}

	public Cart getCart(int id) {
		String query = "select * from cart where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Cart c3 = new Cart();
			while (rs.next()) {
				c3.setId(rs.getInt(1));
				c3.setEmail(rs.getString(2));
				c3.setPassword(rs.getString(3));
				c3.setUsername(rs.getString(4));
				c3.setAddress(rs.getString(5));
				}
			return c3;
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
		return null;
	}

	public List<Cart> getAllCart() {
		String query = "select * from cart";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Cart> list = new ArrayList();
			while (rs.next()) {
				Cart c4 = new Cart();
				c4.setId(rs.getInt(1));
				c4.setEmail(rs.getString(2));
				c4.setPassword(rs.getString(3));
				c4.setUsername(rs.getString(4));
				c4.setAddress(rs.getString(5));
				list.add(c4);
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