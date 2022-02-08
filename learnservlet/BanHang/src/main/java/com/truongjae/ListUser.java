package com.truongjae;

import java.util.ArrayList;

public class ListUser {
	private String id;
	private String name;
	private ArrayList<ListUser> listUser= new ArrayList<ListUser>();
	public ListUser() {}
	public ListUser(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<ListUser> list(){
		listUser.add(new ListUser("1", "truong"));
		listUser.add(new ListUser("2", "Hoang"));
		return listUser;
	}
}
