package ProjectBean;

public class GameBean {
	private String E_name;
    private String C_name;
    private String img_url;
	private String G_maker;
    private String iss;
    private String info;
    private Integer Price;
    
    public GameBean(String p_E_name,String p_C_name,String p_img_url,String p_G_maker,String p_iss,String p_info,String p_Price) {
    	this.E_name=p_E_name;
    	this.C_name=p_C_name;
    	this.img_url=p_img_url;
    	this.G_maker=p_G_maker;
    	this.iss=p_iss;
    	this.info=p_info;
    	this.Price=Integer.parseInt(p_Price);
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
	public GameBean() {
    	
    }

}
