package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.dto.HotelDTO;
import com.dto.PageDTO;

public class BoardDAO {

	

	/*
	 * public List<BoardDTO> listAll(SqlSession session, HashMap<String, String>
	 * map) { List<BoardDTO> list =
	 * session.selectList("com.board.BoardMapper.listAll", map); return list; }
	 */

	public void write(SqlSession session, BoardDTO dto) {
		System.out.println(dto);
		int num= session.insert("com.board.BoardMapper.write", dto);
		System.out.println("추가된 글 갯수 ======="+ num);		
	}

	public BoardDTO selectByNum(SqlSession session, String num) {
		// 글 조회수 증가
		readCnt(session, num);
		BoardDTO dto= session.selectOne("com.board.BoardMapper.selectByNum", Integer.parseInt(num));
		return dto;
	}

	private void readCnt(SqlSession session, String num) {
		int result= session.update("com.board.BoardMapper.readCnt", Integer.parseInt(num));
		System.out.println("result==="+ result);
		
	}

	public void deleteNum(SqlSession session, String num) {
		int result = session.delete("com.board.BoardMapper.deleteByNum", Integer.parseInt(num));
		System.out.println("삭제된 개수 ====="+ result);
	}

	public void updateByNum(SqlSession session, BoardDTO dto) {
		int result= session.update("com.board.BoardMapper.updateByNum", dto);
		System.out.println("업데이트 개수 ====="+ result);
	}

public void answerinsert(SqlSession session, BoardDTO dto) {
		
		int num = dto.getNum();
		int origin = dto.getOrigin();
		int groupnum = dto.getGroupnum();
		int grouplayer = dto.getGrouplayer();
		
		if(num != 0)
		{
			layerupdate(session, origin, groupnum); //답글의 답글을 쓸때 그룹넘버를 +1 시켜주는 코드
			groupnum++;
			grouplayer++;
		
		}
		
		
		dto.setOrigin(origin);
		dto.setGroupnum(groupnum);
		dto.setGrouplayer(grouplayer);
		
		int result= session.insert("com.board.BoardMapper.answerinsert", dto);
		System.out.println("insert 개수 ====="+ result);
		
	}
public int totalCount(SqlSession session,HashMap<String, String> map) {
		
		
		int n=session.selectOne("com.board.BoardMapper.totalCount",map);
		return n;
		
				
	}	


	public BoardPageDTO listAll(SqlSession session, HashMap<String, String> map, int curPage) {
		BoardPageDTO pDTO = new BoardPageDTO();
		int perPage = pDTO.getPerPage();
		int offset = (curPage-1)*perPage;
		List<BoardDTO> list = session.selectList("com.board.BoardMapper.listAll", map, new RowBounds(offset,perPage));
		pDTO.setCurPage(curPage);//현재 페이지
		pDTO.setList(list);//리스트 저장
		
		pDTO.setTotalCount(totalCount(session,map));//검색어도 넘겨서 검색에 관련 전체 레코드 개수 구하기
	
		return pDTO;
	}
	
	public int getTotalCount(SqlSession session)
	{
	  int n=session.selectOne("com.board.BoardMapper.boardTotalCount");
	  return n;
	}
	
	public int getMaxNum(SqlSession session)
	{
	  int max=session.selectOne("com.board.BoardMapper.boardMaxNum");
	  return max;				
	}
	
	public void layerupdate(SqlSession session, int origin, int groupnum)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("origin", origin);
		map.put("groupnum", groupnum);
		session.update("com.board.BoardMapper.updatelayer", map);
		
	}
	

	

}
