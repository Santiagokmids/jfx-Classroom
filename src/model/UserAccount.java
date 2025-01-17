package model;

public class UserAccount {
	private String name;
	private String password;
	private String photo;
	private Gender gender;
	private String career;
	private String birthday; 
	private Browser browser;
	
	public UserAccount(String name, String password, String photo, String birthday, Gender gender, String career, Browser browser) {
		this.name = name;
		this.password = password;
		this.photo = photo;
		this.birthday = birthday;
		this.gender = gender;
		this.career = career;
		this.browser = browser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}
	
	
}
