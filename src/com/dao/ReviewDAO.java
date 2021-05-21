package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ReviewDTO;

public class ReviewDAO {

	public void write(SqlSession session, ReviewDTO dto) {
		// TODO Auto-generated method stub
		int num = session.insert("com.review.ReviewMapper.write", dto);
		System.out.println("추가된 글 갯수 =======" + num);
		
	}

	public List<ReviewDTO> review(SqlSession session, String hotelname) {
		// TODO Auto-generated method stub
		List<ReviewDTO> list=session.selectList("com.review.ReviewMapper.review",hotelname );
		return list;
		
	}

}
