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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/BoardUpdateServlet")
public class BoardUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num= request.getParameter("num");
		String title= request.getParameter("title");
		String author= request.getParameter("author");
		String content= request.getParameter("content");
		
		BoardDTO dto= new BoardDTO();
		dto.setAuthor(author);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setNum(Integer.parseInt(num));
		
		BoardService service= new BoardService();
		service.updateByNum(dto);
		
		response.sendRedirect("BoardListServlet");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
