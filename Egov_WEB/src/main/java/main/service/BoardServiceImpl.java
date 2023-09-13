package main.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.service.Impl.BoardDAO;
import main.service.BoardService;



//컨트롤러와 연결되어있는 설정
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDAO")
	public BoardDAO boardDAO;

	@Override
	public String insertNBoard(BoardVO vo) throws Exception {
		return boardDAO.insertNBoard(vo);
	} 

}
