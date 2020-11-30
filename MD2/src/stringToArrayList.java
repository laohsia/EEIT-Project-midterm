import java.util.ArrayList;

public class stringToArrayList {
	private ArrayList<String> imgUrl = new ArrayList<String>();
	private ArrayList<String> message = new ArrayList<String>();
	private ArrayList<String> price = new ArrayList<String>();
	private ArrayList<String> buyHowmuch = new ArrayList<String>();
	
	public stringToArrayList(String stringJson) {
		StringBuffer now = new StringBuffer();
		String nowString;
		int count = 0;
		ArrayList<String> A = new ArrayList<String>();
		for(int i = 1; i < stringJson.length()-1; i++) {
			nowString = stringJson.split("")[i];
			if(nowString.equals("[")) {
				i++;
				nowString = stringJson.split("")[i];
				while(!nowString.equals("]")) {
					if(nowString.equals("\"")) {
						count++;				
					}
					if(count % 2 == 0 && nowString.equals(",")) {
						A.add(now.toString());
						now.delete(0, now.length());
						i++;
						nowString = stringJson.split("")[i];
						continue;
					}
					else {
						now.append(nowString);
						i++;
						nowString = stringJson.split("")[i];			
					}
				}
				imgUrl.add(A.get(0).substring(1,A.get(0).length()-1));
				message.add(A.get(1).substring(1,A.get(1).length()-1));
				price.add(A.get(2).substring(1,A.get(2).length()-1));
				buyHowmuch.add(now.toString().substring(1,now.toString().length()-1));
				now.delete(0, now.length());
				A.clear();
			}
		}
	}

	public ArrayList<String> getImgUrl() {
		return imgUrl;
	}

	public ArrayList<String> getMessage() {
		return message;
	}

	public ArrayList<String> getPrice() {
		return price;
	}

	public ArrayList<String> getBuyHowmuch() {
		return buyHowmuch;
	}
	
}
