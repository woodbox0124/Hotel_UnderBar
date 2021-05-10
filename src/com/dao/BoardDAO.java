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

	// 게시물 목록
	public BoardPageDTO listAll(SqlSession session, HashMap<String, String> map, int curPage) {
		BoardPageDTO pDTO = new BoardPageDTO();
		int perPage = pDTO.getPerPage();
		int offset = (curPage - 1) * perPage;
		List<BoardDTO> list = session.selectList("com.board.BoardMapper.listAll", map, new RowBounds(offset, perPage));
		pDTO.setCurPage(curPage);// 현재 페이지
		pDTO.setList(list);// 리스트 저장

		pDTO.setTotalCount(totalCount(session, map));// 검색어도 넘겨서 검색에 관련 전체 레코드 개수 구하기

		return pDTO;
	}
	// 게시글 목록
	
	// 게시글 추가
	public void write(SqlSession session, BoardDTO dto) {
		System.out.println(dto);
		int num = session.insert("com.board.BoardMapper.write", dto);
		System.out.println("추가된 글 갯수 =======" + num);
	}
	// 게시글 추가

	// 게시글 수정
	public void updateByNum(SqlSession session, BoardDTO dto) {
		int result = session.update("com.board.BoardMapper.updateByNum", dto);
		System.out.println("업데이트 개수 =====" + result);
	}
	// 게시글 수정

	// 게시글 삭제
	public void deleteNum(SqlSession session, String num) {
		int result = session.delete("com.board.BoardMapper.deleteByNum", Integer.parseInt(num));
		System.out.println("삭제된 개수 =====" + result);
	}

	// 게시글 삭제
	
	// 글 조회수 증가
	public BoardDTO selectByNum(SqlSession session, String num) {

		readCnt(session, num);
		BoardDTO dto = session.selectOne("com.board.BoardMapper.selectByNum", Integer.parseInt(num));
		return dto;
	}

	private void readCnt(SqlSession session, String num) {
		int result = session.update("com.board.BoardMapper.readCnt", Integer.parseInt(num));
		System.out.println("result===" + result);

	}
	// 글 조회수 증가

	// 댓글
	public void answerinsert(SqlSession session, BoardDTO dto) {

		int num = dto.getNum();
		int origin = dto.getOrigin();
		int groupnum = dto.getGroupnum();
		int grouplayer = dto.getGrouplayer();

		if (num != 0) {
			layerupdate(session, origin, groupnum); // 답글의 답글을 쓸때 그룹넘버를 +1 시켜주는 코드
			groupnum++;
			grouplayer++;

		}

		dto.setOrigin(origin);
		dto.setGroupnum(groupnum);
		dto.setGrouplayer(grouplayer);

		int result = session.insert("com.board.BoardMapper.answerinsert", dto);
		System.out.println("insert 개수 =====" + result);

	}
	//댓글 
	
	// 대댓글
	public void layerupdate(SqlSession session, int origin, int groupnum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("origin", origin);
		map.put("groupnum", groupnum);
		session.update("com.board.BoardMapper.updatelayer", map);
	}
	// 대댓글
	
	public int totalCount(SqlSession session, HashMap<String, String> map) {
		int n = session.selectOne("com.board.BoardMapper.totalCount", map);
		return n;
	}

	public int getTotalCount(SqlSession session) {
		int n = session.selectOne("com.board.BoardMapper.boardTotalCount");
		return n;
	}

}
