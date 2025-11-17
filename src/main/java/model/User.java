package model;

import java.io.Serializable ;

public class User implements Serializable {
	private int id ;
	private String name;
	private String email;
	private String password;
	private boolean isAdmin;
	
	public User() {}
	public User(int id, String name, String email, String password, boolean isAdmin) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
}
