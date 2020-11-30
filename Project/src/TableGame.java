// Value Object:一個Object代表Dept Table一筆Row

import java.io.*;

public class TableGame implements Serializable{

	private String E_name;
    private String C_name;
    private String img_url;
	private String G_maker;
    private String iss;
    private String info;
    private Integer Price;
    
    public TableGame(String E_name, String C_name) {
		this.E_name = E_name;
		this.C_name = C_name;
	}
    
	public String getE_name() {
		return E_name;
	}
	public void setE_name(String e_name) {
		E_name = e_name;
	}
	public String getC_name() {
		return C_name;
	}
	public void setC_name(String c_name) {
		C_name = c_name;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getG_maker() {
		return G_maker;
	}
	public void setG_maker(String g_maker) {
		G_maker = g_maker;
	}
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(Integer price) {
		Price = price;
	}
 
    

    

}