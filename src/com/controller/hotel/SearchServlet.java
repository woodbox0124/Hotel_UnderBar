package com.controller.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.HotelDTO;
import com.service.HotelService;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String location = request.getParameter("location");
		
		HotelService service = new HotelService();
	    List<HotelDTO> list =null;
	    
		if(location!="") {
			list = service.searchKey(location);
		}else {
			list = service.hotelList();
		}
        
		
		
		request.setAttribute("hotel", list);

		RequestDispatcher dis = request.getRequestDispatcher("hotelList.jsp");
		dis.forward(request, response);       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
