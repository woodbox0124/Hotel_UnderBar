package com.controller.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.txw2.Document;


@WebServlet("/payFail")
public class PayFail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 HttpSession session = request.getSession(); 
		 session.getAttribute("list");
		 
		
		
		  RequestDispatcher dis = request.getRequestDispatcher("RoomSearchServlet");
		  dis.forward(request, response);
		 
		//response.sendRedirect("RoomSearchServlet");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
