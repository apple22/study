package main.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import main.service.BoardService;

@Controller
public class BoardController {
	@Resource(name="boardService")
	private BoardService boardService;
	

	@RequestMapping("/boardWrite.do")
	
	public String boardWrite() {
		return "board/boardWrite";
	}

}
