import java.sql.Timestamp;

public class Activity {

		private String area;
		private String activity;
		private String type;
		private Timestamp date_time_1;
		private Timestamp date_time_2;
		private int day;
		private String location;
		private String address;
		private int limit_per;
		private int cost;
		
		
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
		public Timestamp getDate_time_1() {
			return date_time_1;
		}
		public void setDate_time_1(Timestamp date_time_1) {
			this.date_time_1 = date_time_1;
		}
		public Timestamp getDate_time_2() {
			return date_time_2;
		}
		public void setDate_time_2(Timestamp date_time_2) {
			this.date_time_2 = date_time_2;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
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
		public int getLimit_per() {
			return limit_per;
		}
		public void setLimit_per(int limit_per) {
			this.limit_per = limit_per;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
}
