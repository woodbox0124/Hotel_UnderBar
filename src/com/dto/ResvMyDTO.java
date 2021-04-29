package com.dto;

public class ResvMyDTO {
	
	double Rating;
	String Hotelname;
	String Addr;
	String Roomname;
	String Checkin;
	String Checkout;
	String Resvdate;
	int Guest;
	int Price;
	public ResvMyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResvMyDTO(double rating, String hotelname, String addr, String roomname, String checkin, String checkout,
			String resvdate, int guest, int price) {
		super();
		Rating = rating;
		Hotelname = hotelname;
		Addr = addr;
		Roomname = roomname;
		Checkin = checkin;
		Checkout = checkout;
		Resvdate = resvdate;
		Guest = guest;
		Price = price;
	}
	public double getRating() {
		return Rating;
	}
	public void setRating(double rating) {
		Rating = rating;
	}
	public String getHotelname() {
		return Hotelname;
	}
	public void setHotelname(String hotelname) {
		Hotelname = hotelname;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getRoomname() {
		return Roomname;
	}
	public void setRoomname(String roomname) {
		Roomname = roomname;
	}
	public String getCheckin() {
		return Checkin;
	}
	public void setCheckin(String checkin) {
		Checkin = checkin;
	}
	public String getCheckout() {
		return Checkout;
	}
	public void setCheckout(String checkout) {
		Checkout = checkout;
	}
	public String getResvdate() {
		return Resvdate;
	}
	public void setResvdate(String resvdate) {
		Resvdate = resvdate;
	}
	public int getGuest() {
		return Guest;
	}
	public void setGuest(int guest) {
		Guest = guest;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "ResvMyDTO [Rating=" + Rating + ", Hotelname=" + Hotelname + ", Addr=" + Addr + ", Roomname=" + Roomname
				+ ", Checkin=" + Checkin + ", Checkout=" + Checkout + ", Resvdate=" + Resvdate + ", Guest=" + Guest
				+ ", Price=" + Price + "]";
	}
	
	
}
