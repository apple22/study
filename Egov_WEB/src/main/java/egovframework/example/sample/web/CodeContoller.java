package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;
import egovframework.example.sample.service.DeptVO;

@Controller
public class CodeContoller {
	@Resource(name="codeService")
	private CodeService codeService;
	
	@RequestMapping(value = "codeWrite.do")
	public String codeWrite() {
		return "code/codeWrite";
	}
	
	@RequestMapping(value="/codeList.do")
	public String selectCodesList(CodeVO vo , ModelMap model) throws Exception{
		
		int total = codeService.selectCodesCount(vo);
		List<?> list = codeService.selectCodesList(vo);
		System.out.println("list ======>" + list);
		
		model.addAttribute("resultTotal",total);
		model.addAttribute("resultlist",list);
		return "code/codeList";
		
	}
	
	@RequestMapping(value="/codeModifyWrite.do")
	public String selectCodesDetail(int code , ModelMap model) throws Exception{
		CodeVO vo = codeService.selectcodesDetail(code);
		List<?> list = codeService.selectCodesList(vo);
		System.out.println("list ======>" + list);
		model.addAttribute("vo",vo);
		return "code/codeModifyWrite";
	}
	


	
	/*
	 * @RequestMapping(value="/codeDelete.do") public String deleteCode(int code)
	 * throws Exception{ System.out.println("test"); int result =
	 * codeService.deleteCodes(code); return "redirect:codeList.do"; }
	 */
	
	@RequestMapping(value="/codeDelete.do")
	public String deleteCodes(int code) throws Exception {
		int result = codeService.deleteCodes(code);
		if (result == 1) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}

		return "";
	}
	
	@RequestMapping(value="/codeModifySave.do")
	public String codeModifySave(CodeVO vo , int code) throws Exception{
		
		
		return "redirect:codeList.do";
	}

	
	@RequestMapping(value="/codeWriteSave.do")
	public String insertCodes(CodeVO vo) throws Exception{
		
		String result = codeService.insertCodes(vo);
		
		if (result == null) {
			System.out.println("저장완료");
		} else {
			System.out.println("저장실패");
		}

		return "redirect:codeList.do";
	
	}
	
	
	
	

	

}
