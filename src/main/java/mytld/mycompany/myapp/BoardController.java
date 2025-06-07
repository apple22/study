package mytld.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController { //Controller -> POJO
 
	@RequestMapping("/boardList.do") //Controller/boardList.do

	public String boardList() {
		return "boardList"; //WEB-INF/views/boardList.jsp
	}
}
