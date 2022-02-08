package com.truongjae.model;

import java.util.ArrayList;

public class User {
	private int id;
	private String name;
	private ArrayList<User> listUser = new ArrayList<>();
	public User() {}
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  ArrayList<User>  getListUser() {
		listUser.add(new User(1,"truong"));
		listUser.add(new User(2,"huy"));
		listUser.add(new User(3,"hoang"));
		listUser.add(new User(4,"thanh"));
		listUser.add(new User(5,"toi"));
		listUser.add(new User(6,"sang"));
		listUser.add(new User(7,"binh"));
		listUser.add(new User(8,"tung"));
		return listUser;
	}
	
}
