package dao;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.dbconnection;
import model.seller;

public class sellerdao {

	public static void insertseller(seller s) {
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "insert into seller(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static seller checklogin(seller s) {
		seller s1 = null;
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "select * from seller where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				s1 = new seller();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setContact(rs.getString("contact"));
				s1.setAddress(rs.getString("address"));
				s1.setEmail(rs.getString("email"));
				s1.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}

	public static void updateprofile(seller s) {
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "update seller set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkpassword(int id, String op) {
		boolean flag = false;
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "select * from seller where id=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

	public static void changepassword(int id, String np) {
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "update seller set password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkemail(String email) {
		boolean flag = false;
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "select * from seller where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void forgotpassword(String email, String np) {
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "update seller set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<seller> getAllseller(){
		List<seller> list = new ArrayList<seller>();
		try {
			Connection conn = dbconnection.createconnection();
			String sql =" Select * from seller";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				seller s1= new seller();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setContact(rs.getString("contact"));
				s1.setAddress(rs.getString("address"));
				s1.setEmail(rs.getString("email"));
				s1.setPassword(rs.getString("password"));
				list.add(s1);
			
			}
				} catch (Exception e) {
					e.printStackTrace();
 		}
		
		return list;
		
		
		
	}

}
