package model;

public class admin {
   private int id;
   private String email,password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "admin [id=" + id + ", email=" + email + ", password=" + password + "]";
}
   
}
