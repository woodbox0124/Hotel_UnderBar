package com.controller.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RoomReservServlet
 */
@WebServlet("/RoomReservServlet")
public class RoomReservServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int guest = Integer.parseInt(request.getParameter("guest"));
		
		String hotelseq = request.getParameter("hotelseq");
		String roomseq = request.getParameter("roomseq");
		int price = Integer.parseInt(request.getParameter("price"));
		String u_id = request.getParameter("u_id");
		System.out.println("roomservlet : " + checkin + "\t" + checkout + "\t" + guest + "\t" + hotelseq + "\t" + roomseq +"\t" + price + "\t" + u_id);
		
		/*
		 * ResvService service = new ResvService(); int num = service.resvInsert(dto);
		 * System.out.println(num);
		 */
		
		RequestDispatcher dis = request.getRequestDispatcher("RoomReserv.jsp");
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
