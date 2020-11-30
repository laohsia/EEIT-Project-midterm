package mvcdemo.bean;

import java.io.Serializable;

public class LoBean implements Serializable{
	String account;
	String password;
	String name;
	public boolean valid;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean newValid) {
		valid = newValid;
	}

	
}
