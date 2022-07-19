package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;
import model.Cart;
import model.Product;

public class DAO {
	Connection conn = null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	public List<Product> getAllProducts(){
		List<Product> list = new ArrayList<>();
		String query ="select * from Products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs =ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Product> getAllProductsBySearchName(String SearchTxt){
		List<Product> list = new ArrayList<>();
		String query ="select * from Products\r\n"
				+ "where product_name like ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%"+SearchTxt+"%");
			rs =ps.executeQuery();
			
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	public Product getProductByid(String id) {
		String query = "select * from Products\r\n"
				+ "where product_id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs =ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Account listCheck(String user, String pass){
		String query ="select * from Account\r\n"
				+ "where user_mail = ?\r\n"
				+ "and [password] = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs =ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public String getLastOrderID() {
		String query ="select top 1 * from Orders\r\n"
				+ "order by order_id desc";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs =ps.executeQuery();
			while (rs.next()) {
				return rs.getString(2);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void addCartToOrderDetail(String order_id, int product_id, String amount, String price ) {
		String query="insert into Orders_detail\r\n"
				+ "values(?,?,?,?)";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, order_id);
			ps.setInt(2, product_id);
			ps.setString(3, amount);
			ps.setString(4, price);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void addCartToOrder(String user, String address){
		String query = "insert into Orders(user_mail,order_address)\r\n"
				+ "values(?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, address);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public double returnSumfromCartDetail() {
		String query="select * from Orders_detail\r\n"
				+ "where order_id=(select top 1 order_id from Orders_detail\r\n"
				+ "order by order_id desc)";
		double result = 0;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs =ps.executeQuery();
			while (rs.next()) {
				result += rs.getDouble(3)*rs.getDouble(4);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Product> list = dao.getAllProductsBySearchName("sam");
		if (dao.getAllProductsBySearchName("sam")==null) {
			System.out.print("ok");
		}
		for (Product o : list) {
			System.out.print(o);
		}
		
	}
}
