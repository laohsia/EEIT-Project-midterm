package mvc.bean;

public class activityBean {
		String area;
		String activity;
		String type;
		String date_time_1;
		String date_time_2;
		String day;
		String location;
		String address;
		String limit_per;
		String cost;
	
		public activityBean(){
		}
		public activityBean(String pArea,String pActivity, String pType, String pDate_time_1, String pDate_time_2,
	            String pDay, String pLocation, String pAddress, String pLimit_per, String pCost)
		{
			this.area= pArea;
			this.activity = pActivity;
			this.type = pType;
			this.date_time_1 = pDate_time_1;
		    this.date_time_2 = pDate_time_2;
		    this.day = pDay;
		    this.location = pLocation;
		    this.address = pAddress;
		    this.limit_per = pLimit_per;
		    this.cost = pCost;
}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getActivity() {
			return activity;
		}
		public void setActivity(String activity) {
			this.activity = activity;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDate_time_1() {
			return date_time_1;
		}
		public void setDate_time_1(String date_time_1) {
			this.date_time_1 = date_time_1;
		}
		public String getDate_time_2() {
			return date_time_2;
		}
		public void setDate_time_2(String date_time_2) {
			this.date_time_2 = date_time_2;
		}
		public String getDay() {
			return day;
		}
		public void setDay(String day) {
			this.day = day;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getLimit_per() {
			return limit_per;
		}
		public void setLimit_per(String limit_per) {
			this.limit_per = limit_per;
		}
		public String getCost() {
			return cost;
		}
		public void setCost(String cost) {
			this.cost = cost;
		}
		
}