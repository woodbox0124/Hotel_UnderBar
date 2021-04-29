package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.HotelDTO;

public class HotelDAO {

	
	public List<HotelDTO> hotelList(SqlSession session) {
		List<HotelDTO> list = session.selectList("HotelMapper.hotelList");
		System.out.println(list);
		return list;
	}

	public List<HotelDTO> searchKey(SqlSession session, String place) {
		List<HotelDTO> list = session.selectList("HotelMapper.searchKey", place);
		return list;
	}

	public List<String> hotelMinprice(SqlSession session) {
		List<String> price = session.selectList("HotelMapper.hotelMinprice");
		//System.out.println(price);
		return price;
	}
}
