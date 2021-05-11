package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/MemberPwSearchServlet")
public class MemberPwSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id").trim();
		String u_name = request.getParameter("u_name").trim();//양옆 공백 제거
	    String u_phone = request.getParameter("u_phone").trim();
	    String u_email = request.getParameter("u_email").trim();
	    MemberDTO dto = new MemberDTO();
	    dto.setU_id(u_id);
	    dto.setU_name(u_name);
	    dto.setU_phone(u_phone);
	    dto.setU_email(u_email);
	    MemberService service = new MemberService();
	    String u_pw = service.pwSearch(dto);
	    System.out.println(u_pw);
	    String nextPage = null;
	    if (u_pw==null) {//db에 일치 데이터 없음
			nextPage ="serachId.jsp";//idSearch.jsp
			request.setAttribute("mesg", "아이디, 이름 또는 핸드폰이 등록되지 않은 정보");
		} else {
			nextPage="SendMailServlet";
			request.setAttribute("mailTo", u_email);
			request.setAttribute("u_pw", u_pw);
		}
        RequestDispatcher dis = request.getRequestDispatcher(nextPage);
        dis.forward(request, response);    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
