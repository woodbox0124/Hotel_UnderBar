package com.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ReviewDTO;
import com.service.ReviewService;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

/**
 * Servlet implementation class ReviewWriteServlet
 */
@WebServlet("/ReviewWriteServlet")
public class ReviewWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelname=(String)request.getParameter("hotelname");
		   String content=(String)request.getParameter("content");
		   String u_id=(String)request.getParameter("u_id");
		   String title=(String)request.getParameter("title");
		   System.out.println("리뷰리뷰리뷰============="+u_id+title+content+hotelname);
		   
		   ReviewService service= new ReviewService();
		   ReviewDTO dto= new ReviewDTO();
		   dto.setU_id(u_id);
		   dto.setTitle(title);
		   dto.setContent(content);
		   dto.setHotelname(hotelname);
		   
		   service.write(dto);
		   
		   HttpSession session=request.getSession();
		   session.setAttribute("rvmesg", "리뷰작성이 완료되었습니다.");
		   
		   
		   RequestDispatcher dis = request.getRequestDispatcher("resvMy.jsp");
			dis.forward(request, response);
		   
		   
		   
		   
		   
		   
		   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
