
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.dbconnection;
import model.cart;
import model.customer;

public class cartdao {
   public static void insertintocart(cart c)   {
	   try {
		   Connection conn = dbconnection.createconnection();
			  String sql="insert into cart(cusid,pid,quantity,price) values(?,?,?,?)";
			  PreparedStatement pst = conn.prepareStatement(sql);
			  pst.setInt(1, c.getCusid());
			  pst.setInt(2, c.getPid());
			  pst.setInt(3, c.getQuantity());
			  pst.setDouble(4, c.getPrice());
			  pst.executeUpdate();
			  System.out.println("inserted into cart");
	} catch (Exception e) {
         e.printStackTrace();
	}
   }
   public static List<cart> cartproduct(int id){
		List<cart> list = new ArrayList<cart>();
		try {
			Connection conn = dbconnection.createconnection();
			String sql="select * from cart where cusid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				cart c = new cart();
				c.setCid(rs.getInt("cid"));
				c.setCusid(rs.getInt("cusid"));
				c.setPid(rs.getInt("pid"));
				c.setQuantity(rs.getInt("quantity"));
				c.setPrice(rs.getDouble("price"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
