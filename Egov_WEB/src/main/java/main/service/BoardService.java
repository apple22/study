package main.service;

import java.util.List;

public interface BoardService {
	/* 저장처리 */
	public String insertNBoard(BoardVO vo) throws Exception;

	/* 일반게시판 화면 목록 */
	public List<?> selectNBoardList(BoardVO vo) throws Exception;

}
