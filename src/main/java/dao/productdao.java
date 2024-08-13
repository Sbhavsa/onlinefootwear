package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.dbconnection;
import model.cart;
import model.product;

public class productdao {
	public static void insertproduct(product p) {
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "insert into product(sid,image,pn,pp,pc) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getSid());
			pst.setString(2, p.getImage());
			pst.setString(3, p.getPname());
			pst.setDouble(4, p.getPprice());
			pst.setString(5, p.getPcategory());

			pst.executeUpdate();
			System.out.println("product stored");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static List<product> getAllProduct(){
		List<product> list = new ArrayList<product>();
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "select * from product";
			PreparedStatement  pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pn"));
				p.setPprice(rs.getDouble("pp"));
				p.setPcategory(rs.getString("pc"));	
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static product edit(int id){
		 product p1 = null;
		try {
			Connection conn = dbconnection.createconnection();
			String sql = "select * from product where sid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				product p = new product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pn"));
				p.setPprice(rs.getDouble("pp"));
				p.setPcategory(rs.getString("pc"));	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p1;
		
			
	}
	public static List<product> getproductbysid(int id){
		List<product> list = new ArrayList<product>();
		try {
		    Connection conn = dbconnection.createconnection();
			String sql = "select * from product where sid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pn"));
				p.setPprice(rs.getDouble("pp"));
				p.setPcategory(rs.getString("pc"));
				list.add(p);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public static product getproductbyid(int pid) {
		product p = null;
		try {
			  Connection conn = dbconnection.createconnection();
				String sql = "select * from product where pid=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, pid);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					 p = new product();
					p.setPid(rs.getInt("pid"));
					p.setSid(rs.getInt("sid"));
					p.setImage(rs.getString("image"));
					p.setPname(rs.getString("pn"));
					p.setPprice(rs.getDouble("pp"));
					p.setPcategory(rs.getString("pc"));	
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}
	
	  	}

