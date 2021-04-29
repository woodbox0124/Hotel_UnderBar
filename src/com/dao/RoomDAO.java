package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.HotelDTO;
import com.dto.RoomDTO;

public class RoomDAO {

	

	public List<RoomDTO> roomList(SqlSession session, String seq) {
		List<RoomDTO> list = session.selectList("HotelMapper.roomList",seq);
		return list;
	}
	

}
