package model;

import java.util.List;
import java.util.ArrayList;

public class Classroom {
	private List<UserAccount> users;
	
	public Classroom() {
		users = new ArrayList<>();
	}
	
	public List<UserAccount> getUsers() {
		return users;
	}
	
	public void addUsers(String name, String password, String photo, String birthday, Gender gender, Career career, Browser browser) {
		users.add(new UserAccount(name, password, photo, birthday, gender, career, browser));
	}

	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}
	
}
