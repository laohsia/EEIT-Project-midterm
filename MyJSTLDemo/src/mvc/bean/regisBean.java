package mvc.bean;

public class regisBean 
{
	String location;
	String name;
	String birthyear, birthmonth, birthday;
	String id;
	String address;
	String phone;
	String mailaddress;
	
	public regisBean(){
	}
	public regisBean(String pLocation,String pName, String pBirthyear, String pBirthmonth, String pBirthday,
            String pId, String pAddress, String pPhone, String pMailaddress) 
	{
		this.location= pLocation;
		this.name = pName;
		this.birthyear = pBirthyear;
		this.birthmonth = pBirthmonth;
	    this.birthday = pBirthday;
	    this.id = pId;
	    this.address = pAddress;
	    this.phone = pPhone;
	    this.mailaddress = pMailaddress;
	}
	public void setLocation(String pLocation)
	  {
	    this.location=pLocation;
	  }

	  public String getLocation()
	  {
	    return location;
	  }
	
	public void setName(String pName)
	  {
	    this.name=pName;
	  }

	  public String getName()
	  {
	    return name;
	  }

	  public void setBirthyear (String pBirthyear)
	  {
	    this.birthyear=pBirthyear;
	  }

	  public String getBirthyear()
	  {
	    return birthyear;
	  }

	  public void setBirthmonth (String pBirthmonth)
	  {
	    this.birthmonth=pBirthmonth;
	  }

	  public String getBirthmonth()
	  {
	    return birthmonth;
	  }

	  public void setBirthday (String pBirthday)
	  {
	    this.birthday=pBirthday;
	  }

	  public String getBirthday()
	  {
	    return birthday;
	  }

	  public void setId (String pId)
	  {
	    this.id=pId;
	  }
	  
	  public String getId()
	  {
	    return id;
	  }

	  public void setAddress (String pAddress)
	  {
	    this.address=pAddress;
	  }

	  public String getAddress()
	  {
	    return address;
	  }

	  public void setPhone (String pPhone)
	  {
	    this.phone=pPhone;
	  }

	  public String getPhone()
	  {
	    return phone;
	  }

	  public void setMailaddress (String pMailaddress)
	  {
	    this.mailaddress=pMailaddress;
	  }

	  public String getMailaddress()
	  {
	    return mailaddress;
	  }

}
