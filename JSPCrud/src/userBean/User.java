package userBean;

import java.io.PrintWriter;
import java.io.Serializable;

import javax.xml.ws.Response;

public class User implements Serializable
{
	String account;
	String password;
    String name;
    String gender;
    String birthday;
    String phone;
    String mailaddress;
  
  public User()
  {
  }
  
  public User(String pAccount,String pPassword, String pName, String pGender, String pBirthday,
                  String pPhone, String pMailaddress)
  {
	this.account = pAccount;
	this.password = pPassword;
    this.name = pName;
    this.gender = pGender;
    this.birthday = pBirthday;
    this.phone = pPhone;
    this.mailaddress = pMailaddress;
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}


public String getBirthday() {
	return birthday;
}

public void setBirthday(String birthday) {
	this.birthday = birthday;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getMailaddress() {
	return mailaddress;
}

public void setMailaddress(String mailaddress) {
	this.mailaddress = mailaddress;
}

  

}