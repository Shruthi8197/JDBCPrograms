package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public Product saveProduct(Product p) {
		String query = "insert into product values( ?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getManufacture());
			ps.setInt(5, p.getDiscount());
			ps.setInt(6, p.getWarranty());
			ps.setString(7, p.getManu_date());
			ps.setDouble(8, p.getGst());

			ps.execute();
			Product p1 = new Product();
			return p1;
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

	public Product updateProduct(Product p) {
		String query = "update product set name=?,price=?,manufacture=?,discount=?,warranty=?,manu_date=?,gst=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getManufacture());
			ps.setInt(4, p.getDiscount());
			ps.setInt(5, p.getWarranty());
			ps.setString(6, p.getManu_date());
			ps.setDouble(7, p.getGst());
			ps.setInt(8, p.getId());
			ps.execute();
			Product p2 = new Product();
			return p2;

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

	public String deleteProduct(int id) {
		String query = "delete from product where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
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
					e.printStackTrace();
				}
			}
		}
		return "not deleted";
	}

	public Product getProduct(int id) {
		String query = "Select * from product where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Product p2 = new Product();
			while (rs.next()) {
				p2.setId(rs.getInt(1));
				p2.setName(rs.getString(2));
				p2.setPrice(rs.getDouble(3));
				p2.setManufacture(rs.getString(4));
				p2.setDiscount(rs.getInt(5));
				p2.setWarranty(rs.getInt(6));
				p2.setManu_date(rs.getString(7));
				p2.setGst(rs.getDouble(8));

				return p2;
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
	
	public List<Product> getAllProduct(){
		
		String query="Select * from product";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			List<Product> list=new ArrayList();
			
			while(rs.next()) {
				Product p3=new Product();
				p3.setId(rs.getInt(1));
				p3.setName(rs.getString(2));
				p3.setPrice(rs.getDouble(3));
				p3.setManufacture(rs.getString(4));
				p3.setDiscount(rs.getInt(5));
				p3.setWarranty(rs.getInt(6));
				p3.setManu_date(rs.getString(7));
				p3.setGst(rs.getDouble(8));
				list.add(p3);
				
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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