package com.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ReviewDTO;
import com.service.ReviewService;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String hotelname=request.getParameter("hotelname");
	
	ReviewService service=new ReviewService();
	List<ReviewDTO>list= service.review(hotelname);
	request.setAttribute("reviewlist", list);
	
	System.out.println("해당 호텔의 리뷰리스트들"+list);
	
	
	RequestDispatcher dis=request.getRequestDispatcher("reviewlist.jsp");
	dis.forward(request, response);
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
