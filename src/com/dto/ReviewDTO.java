package com.dto;

public class ReviewDTO {
	int num;
	String title;
	String u_id;
	String content;
	String writedate;
	int origin;
	int groupnum;
	String hotelname;
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewDTO(int num, String title, String u_id, String content, String writeday, int origin, int groupnum,
			String hotelname) {
		super();
		this.num = num;
		this.title = title;
		this.u_id = u_id;
		this.content = content;
		this.writedate = writeday;
		this.origin = origin;
		this.groupnum = groupnum;
		this.hotelname = hotelname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteday() {
		return writedate;
	}
	public void setWriteday(String writeday) {
		this.writedate = writeday;
	}
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public int getGroupnum() {
		return groupnum;
	}
	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	@Override
	public String toString() {
		return "ReviewDTO [num=" + num + ", title=" + title + ", u_id=" + u_id + ", content=" + content + ", writeday="
				+ writedate + ", origin=" + origin + ", groupnum=" + groupnum + ", hotelname=" + hotelname + "]";
	}
	

	
}
