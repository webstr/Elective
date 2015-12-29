package data;

public class User {
	// Private fields
	private Integer id;
	private String login;
	private String password;
	private String name;
	private String type;
	
	// Main constructor
	public User(String login, String password, String name, String type) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", name=" + name + ", type=" + type + "]";
	}
}
