package dto;

public class Locker {
	private int lockerno;
	private String name;
	private String mail;
	private String salt;
	private String password;
	private String created_at;
	
	public Locker(int lockerno, String name, String mail, String salt, String password, String created_at) {
		super();
		this.lockerno = lockerno;
		this.name = name;
		this.mail = mail;
		this.salt = salt;
		this.password = password;
		this.created_at = created_at;
	}

	public int getLockerno() {
		return lockerno;
	}

	public void setLockerno(int lockerno) {
		this.lockerno = lockerno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
}
