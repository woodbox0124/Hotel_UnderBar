package com.controller.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/KakaopayServlet")
public class KakaopayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelseq = request.getParameter("hotelseq");
		String u_id = request.getParameter("u_id");
		String roomseq = request.getParameter("roomseq");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int price = Integer.parseInt(request.getParameter("price"));
		int guest = Integer.parseInt(request.getParameter("guest"));
		String u_phone = request.getParameter("u_phone");
		
		System.out.println("pay: " + hotelseq + u_id + roomseq + checkin + checkout + price + guest + u_phone);
		/*
		 * request.setAttribute("hotelseq", hotelseq); request.setAttribute("u_id",
		 * u_id); request.setAttribute("roomseq", roomseq);
		 * request.setAttribute("checkin", checkin); request.setAttribute("checkout",
		 * checkout); request.setAttribute("price", price);
		 * request.setAttribute("guest", guest); request.setAttribute("u_phone",
		 * u_phone);
		 */
		
		RequestDispatcher dispatch = request.getRequestDispatcher("pay/kakaopay.jsp");
		dispatch.forward(request, response);
	}
	
	}
	
	



