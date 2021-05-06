package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.HotelDTO;
import com.dto.PageDTO;
import com.dto.ResvDTO;
import com.dto.ResvMyDTO;
import com.dto.ResvPageDTO;

public class ResvDAO {

	public List<ResvMyDTO> resvMy(SqlSession session, String u_id) {
		List<ResvMyDTO> list = session.selectList("ResvMapper.resvMy", u_id);
		return list;
	}
	public int resvInsert(SqlSession session, ResvDTO dto) {
		int num = session.insert("ResvMapper.resvInsert", dto);
		System.out.println("dao num = "+num);
		return num;
		}

	public int resvCancel(SqlSession session, int seq) {
		int num = session.update("ResvMapper.resvCancel", seq);
		System.out.println("dao num = "+num);
		return num;
	}
	
	private int totalCount(SqlSession session,String u_id) {
		int num = session.selectOne("ResvMapper.totalCount",u_id);
		System.out.println("totalCount\t"+num);
		return num; 
	}

	public ResvPageDTO resvMyList(SqlSession session, int curPage, String u_id) {
		ResvPageDTO RpDTO = new ResvPageDTO();
		int perPage = RpDTO.getPerPage();
		int offset = (curPage-1)*perPage;
		List<ResvMyDTO> list = session.selectList("ResvMapper.resvMyList", u_id, new RowBounds(offset,perPage));
		RpDTO.setCurPage(curPage);//현재 페이지
		RpDTO.setList(list);//리스트 저장
		RpDTO.setTotalCount(totalCount(session, u_id));//검색어도 넘겨서 검색에 관련 전체 레코드 개수 구하기
		System.out.println("RpDTO\t"+RpDTO);
		return RpDTO;
		
	}
}
