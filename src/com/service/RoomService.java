package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.RoomDAO;
import com.dto.RoomDTO;

public class RoomService {

	
	public List<RoomDTO> roomList(String seq) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<RoomDTO> list = null;
		try {
			RoomDAO dao = new RoomDAO();
			list = dao.roomList(session,seq);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

}
