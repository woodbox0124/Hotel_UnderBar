package com.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardAnswerServlet
 */
@WebServlet("/BoardAnswerServlet")
public class BoardAnswerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num"); //원글의 번호
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		String groupnum=request.getParameter("groupnum");
		String origin=request.getParameter("origin");
		String grouplayer=request.getParameter("grouplayer");
		BoardDTO dto= new BoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setContent(content);
		dto.setOrigin(Integer.parseInt(origin));
		dto.setGrouplayer(Integer.parseInt(grouplayer));
		dto.setGroupnum(Integer.parseInt(groupnum));
		System.out.println(dto.toString());
		
		BoardService service=new BoardService();
		service.answerinsert(dto);
		
		response.sendRedirect("BoardListServlet");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
