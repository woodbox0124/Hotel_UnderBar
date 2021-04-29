package com.controller.hotel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.HotelDTO;
import com.service.HotelService;

@WebServlet("/HotelSearchServlet")
public class HotelSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkin = request.getParameter("date1");
		String checkout = request.getParameter("date2");
		String location = request.getParameter("location");
		int guest = Integer.parseInt(request.getParameter("guest"));
		HotelService service = new HotelService();
		List<HotelDTO> list = service.hotelList();
		
		request.setAttribute("hotel", list);
				
		HttpSession session = request.getSession();
		session.setAttribute("checkin", checkin);
		session.setAttribute("checkout", checkout);
		session.setAttribute("guest", guest);
		session.setAttribute("location", location);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("hotelList.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

