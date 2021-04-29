package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.HotelDAO;
import com.dto.HotelDTO;

public class HotelService {

	
	public List<HotelDTO> hotelList() {
		SqlSession session = MySqlSessionFactory.getSession();
		System.out.println(session);
		List<HotelDTO> list = null;
		try {
			HotelDAO dao = new HotelDAO();
			list = dao.hotelList(session);
			System.out.println("service"+list);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<HotelDTO> searchKey(String place) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<HotelDTO> list = null;
		try {
			HotelDAO dao = new HotelDAO();
			list = dao.searchKey(session, place);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<String> hotelMinprice() {
		SqlSession session = MySqlSessionFactory.getSession();
		System.out.println(session);
		List<String> price=null;
		try {
			HotelDAO dao = new HotelDAO();
			price = dao.hotelMinprice(session);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return price;
	}
}
