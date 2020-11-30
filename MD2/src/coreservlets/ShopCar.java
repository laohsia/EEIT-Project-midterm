package coreservlets;

import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;

/** A simple bean that has a single String property
 *  called message.
 *  <P>
 */

public class ShopCar{

	private String user = new String();
	private String imgUrl = new String();
	private String cName = new String();
	private Integer price = new Integer(0);
	private Integer buyHowmuch = new Integer(0);
	private String E_Name = new String();
	
	public ShopCar(String user, String imgUrl, String cName, int price, int buyHowmuch, String eName) {
		this.user = user;
		this.imgUrl = imgUrl;
		this.cName = cName;
		this.price = price;
		this.buyHowmuch = buyHowmuch;
		this.E_Name = eName;
	}
	public String user() {
	    return this.user;
	  }
	public String getCName() {
	    return this.cName;
	  }
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public Integer getButHowmuch() {
		return buyHowmuch;
	}
	public String getE_Name() {
		return E_Name;
	}
	
}
