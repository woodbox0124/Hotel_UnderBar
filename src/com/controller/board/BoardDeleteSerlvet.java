package com.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BoardService;

/**
 * Servlet implementation class BoardDeleteSerlvet
 */
@WebServlet("/BoardDeleteSerlvet")
public class BoardDeleteSerlvet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num= request.getParameter("num");
		BoardService serivce= new BoardService();
		serivce.deleteNum(num);
		response.sendRedirect("BoardListServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
