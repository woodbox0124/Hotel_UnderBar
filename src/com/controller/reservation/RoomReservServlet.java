package com.controller.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.RoomService;

import sun.nio.cs.HistoricallyNamedCharset;


/**
 * Servlet implementation class RoomReservServlet
 */
@WebServlet("/RoomReservServlet")
public class RoomReservServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String hotelname = request.getParameter("hotelname");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String guest = request.getParameter("guest");
		String hotelseq = request.getParameter("hotelseq");
		String roomseq = request.getParameter("roomseq");
		int price = Integer.parseInt(request.getParameter("price"));
		String u_id = request.getParameter("u_id");
		String location = request.getParameter("location");
		String name = request.getParameter("name");
		System.out.println("roomservlet : " + checkin + "\t" + checkout + "\t" + guest + "\t" + hotelseq + "\t" + roomseq +"\t" + price + "\t" + u_id + "\t" + location + "\t" + name);
		
		RoomService service = new RoomService();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("roomseq", roomseq);
		map.put("checkin", checkin);
		int n = service.date(map);
		
		if(n==1) {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
				out.print("<html><head>");
				out.print("<meta http-equiv=\'Content-Type\' content=\'text/html; charset=utf-8\'>");
				out.println("<script language='javascript'>");
		        out.println("alert('이미 예약이 된 방입니다.');");
		        out.println("history.back();");
		        out.println("</script>");
		        out.print("</head></html>");
		}else {
			 RequestDispatcher dis = request.getRequestDispatcher("RoomReserv.jsp");
			  dis.forward(request, response);
		}
		
				 
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
