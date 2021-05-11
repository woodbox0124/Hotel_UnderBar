package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardRetrive
 */
@WebServlet("/BoardRetrive")
public class BoardRetrive extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num= request.getParameter("num");
		BoardService service= new BoardService();
		BoardDTO dto= service.selectByNum(num);
		int origin=dto.getOrigin();
		System.out.println("이글의 origin번호"+origin);
		
		String Oauthor=service.selectauthor(origin);
		System.out.println("이글의 원글자"+Oauthor);
		
		HttpSession session=request.getSession();
		session.setAttribute("retrieve", dto);
		session.setAttribute("originauthor", Oauthor);
		
		RequestDispatcher dis= request.getRequestDispatcher("boardretrieve.jsp");
		dis.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
