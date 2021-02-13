package model;

import java.util.List;
import java.util.ArrayList;

public class Classroom {
	private List<UserAccount> accounts;
	
	public Classroom() {
		accounts = new ArrayList<>();
	}
	
	public void addUsers(String name, String password, String photo, String birthday, Gender gender, String career, Browser browser) {
		accounts.add(new UserAccount(name, password, photo, birthday, gender, career, browser));
	}
	
	public List<UserAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<UserAccount> accounts) {
		this.accounts = accounts;
	}
	
	public boolean searchUser(String name, String password) {
		boolean find = true;  
		for(int i = 0;i < accounts.size();i++) {
			if(accounts.get(i).getName().equalsIgnoreCase(name) && accounts.get(i).getPassword().equalsIgnoreCase(password)) {
				find = false;
			}
		}
		return find;
	}
	
	public String searchImage(String name, String password) {
		String image = "";

		for(int i = 0;i < accounts.size();i++) {
			if(accounts.get(i).getName().equalsIgnoreCase(name) && accounts.get(i).getPassword().equalsIgnoreCase(password)) {
				image = accounts.get(i).getPhoto();
			}
		}
		return image;
	}
	
}
