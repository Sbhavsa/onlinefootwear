package model;

public class cart {
   private int cid,cusid,pid,quantity;
   private double price;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getCusid() {
	return cusid;
}
public void setCusid(int cusid) {
	this.cusid = cusid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "cart [cid=" + cid + ", cusid=" + cusid + ", pid=" + pid + ", quantity=" + quantity + ", price=" + price
			+ "]";
}


}
