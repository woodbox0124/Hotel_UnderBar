package com.controller.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.ResvDTO;
import com.service.ResvService;

/**
 * Servlet implementation class RoomReservServlet
 */
@WebServlet("/RoomReservServlet")
public class RoomReservServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberDTO dto1 = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if(dto1!=null) {
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int guest = Integer.parseInt(request.getParameter("guest"));
		
		String hotelseq = request.getParameter("hotelseq");
		String roomseq = request.getParameter("roomseq");
		int price = Integer.parseInt(request.getParameter("price"));
		String u_id = request.getParameter("u_id");
		
		ResvDTO dto = new ResvDTO();
		dto.setCheckin(checkin);
		dto.setCheckout(checkout);
		dto.setGuest(guest);
		dto.setHotelseq(hotelseq);
		dto.setRoomseq(roomseq);
		dto.setPrice(price);
		dto.setU_id(u_id);
		
		System.out.println(dto);
		ResvService service = new ResvService();
		int num = service.resvInsert(dto);
		System.out.println(num);
		nextPage = "MainServlet";
		}else {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");			
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
