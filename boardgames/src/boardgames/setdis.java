package boardgames;

import java.util.Date;

public class setdis {
	
	private String id = new String();
	private String name = new String();
	private String comment = new String();
	private String date = new String();

	public setdis(String id, String name, String comment, String date) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.date = date;
	}
                                
	public String getid() {
		return id;
	}
	
	public String getname() {
		return name;
	}

	public String getcomment() {
		return comment;
	}

	public String getDate() {
		return date;
	}
}
