package com.controller.review;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dto.ReviewDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.ReviewService;

/**
 * Servlet implementation class ReviewWriteServlet
 */
@WebServlet("/ReviewWriteServlet")
public class ReviewWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8"); 
		
		// 파일이 저장되는 경로
	    //String path = request.getSession().getServletContext().getRealPath("reviewFolder");
		  
	    MultipartRequest multi = null;
	  
	    int size =10 * 1024 * 1024; // 저장가능한 파일 크기
	    ServletContext context = getServletContext(); //어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. 
	    String savePath = context.getRealPath("reviewFolder");
	    String file = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
	    String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름

	    // 실제로 파일 업로드하는 과정
	      multi = new MultipartRequest(request, savePath, size, "UTF-8", new DefaultFileRenamePolicy());

	        Enumeration files = multi.getFileNames();
	        String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장

	        file = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴
	        originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴

	
	        String hotelname=multi.getParameter("hotelname");
			   String content=multi.getParameter("content");
			   String u_id=multi.getParameter("u_id");
			   String title=multi.getParameter("title");
			   String rating=multi.getParameter("star");
			   
		   System.out.println(hotelname+" "+content+" "+u_id+" "+title+" "+rating+" "+file);
		   ReviewService service= new ReviewService();
		   ReviewDTO dto= new ReviewDTO();
		   dto.setU_id(u_id);
		   dto.setTitle(title);
		   dto.setContent(content);
		   dto.setHotelname(hotelname);
		   dto.setRating(Integer.parseInt(rating));
		   dto.setReview_img(file);
		   
		   service.write(dto);
		   
		   HttpSession session=request.getSession();
		   session.setAttribute("rvmesg", "리뷰작성이 완료되었습니다.");
		   
		   
		  RequestDispatcher dis = request.getRequestDispatcher("review/reviewend.jsp");
			dis.forward(request, response);
		  
			
		   
		   
		   
		   
		   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
