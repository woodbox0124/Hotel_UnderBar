package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.ReviewDAO;
import com.dto.ReviewDTO;

public class ReviewService {

	public void write(ReviewDTO dto) {
		// TODO Auto-generated method stub
		ReviewDAO dao=new ReviewDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dao.write(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	public List<ReviewDTO> review(String hotelname) {
		ReviewDAO dao=new ReviewDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		
		List<ReviewDTO> list= null;
		try {
			list=dao.review(session, hotelname);
		} finally {
			session.close();
		}
		return list;
	}

	public int reviewDelete(int origin) {
		ReviewDAO dao = new ReviewDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			dao.reviewDelete(session, origin);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public List<ReviewDTO> reviewOrder(String hotelname) {
		ReviewDAO dao=new ReviewDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		
		List<ReviewDTO> list= null;
		try {
			list=dao.reviewOrder(session, hotelname);
		} finally {
			session.close();
		}
		return list;
	
	}

	public int reviewAdminDelete(int num) {
		ReviewDAO dao = new ReviewDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			dao.reviewAdminDelete(session, num);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

}
