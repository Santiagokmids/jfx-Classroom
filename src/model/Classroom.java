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
	
	public void addUsers(String name, String password, String photo, String birthday, Gender gender, String career, Browser browser, String file) {
		users.add(new UserAccount(name, password, photo, birthday, gender, career, browser, file));
	}

	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}
	
	public boolean searchUser(String name, String password) {
		boolean find = true;
		
		for(int i = 0;i < users.size();i++) {
			if(users.get(i).getName().equalsIgnoreCase(name) && users.get(i).getPassword().equalsIgnoreCase(password)) {
				find = false;
			}
		}
		return find;
	}
	
	public String searchImage(String name, String password) {
		String image = "";
		
		for(int i = 0;i < users.size();i++) {
			if(users.get(i).getName().equalsIgnoreCase(name) && users.get(i).getPassword().equalsIgnoreCase(password)) {
				image = users.get(i).getPhoto();
			}
		}
		return image;
	}
}
	
