package com.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curPage = request.getParameter("curPage");//현재 페이지 번호 얻기 
		if(curPage == null) curPage = "1";
		
		BoardService service= new BoardService();
		
		//검색어 파싱
		String searchName= request.getParameter("searchName");
		String searchValue= request.getParameter("searchValue");
		
		
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);		
		
	
		BoardPageDTO pdto= service.listAll(Integer.parseInt(curPage),map);	
		
		HttpSession session=request.getSession();
		session.setAttribute("list", pdto);
	
		
		RequestDispatcher dis= request.getRequestDispatcher("boardlist.jsp");
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
