package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dao.HotelDAO;
import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.dto.PageDTO;

public class BoardService {
  BoardDAO dao;
  public BoardService() {
	  dao= new BoardDAO();
  }
  public BoardDTO selectByNum(String num) {
		SqlSession session= MySqlSessionFactory.getSession();
		BoardDTO dto= null;
		try {
			dto= dao.selectByNum(session, num);
			session.commit();
		}finally {
			
		}
		// TODO Auto-generated method stub
		return dto;
	}

	/*
	 * public List<BoardDTO> listAll(HashMap<String, String> map) { SqlSession
	 * session = MySqlSessionFactory.getSession(); List<BoardDTO> list= null; try {
	 * list= dao.listAll(session, map);
	 * 
	 * }finally { session.close(); } return list; }
	 */
	public void write(BoardDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session= MySqlSessionFactory.getSession();
		try {
			dao.write(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		
	}
	public void deleteNum(String num) {
		SqlSession session= MySqlSessionFactory.getSession();
		try {
			dao.deleteNum(session, num);
			session.commit();
		}finally {
			session.close();
		}
		
	}
	public void updateByNum(BoardDTO dto) {
		SqlSession session= MySqlSessionFactory.getSession();
		try {
			dao.updateByNum(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		
	}
	public void answerinsert(BoardDTO dto) {
		SqlSession session= MySqlSessionFactory.getSession();
		try {
			dao.answerinsert(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		
	}
	public BoardPageDTO listAll(int curPage,HashMap<String, String> map) {
		BoardDAO dao = new BoardDAO();
		
		SqlSession session = MySqlSessionFactory.getSession();
		BoardPageDTO pDTO = null;
		 try {
			 pDTO = dao.listAll(session,map,curPage);
	      }finally {
			session.close();
	      }
	      return pDTO;
		}//end select

	
}
