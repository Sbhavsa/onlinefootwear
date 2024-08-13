package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import connection.dbconnection;
import model.wishlist;

public class wishlistdao {
     public static void insertintowishlist(wishlist w) {
    	 try {
			Connection conn = dbconnection .createconnection();
			String sql="insert into wishlist(cusid,pid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getCusid());
			pst.setInt(2, w.getPid());
			pst.executeUpdate();
			System.out.println("add to wishlist");
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
}
