package egovframework.example.sample.web;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import egovframework.example.sample.service.DeptSevice;
import egovframework.example.sample.service.DeptVO;
//어노테이션
// @ : 주석
@Controller
public class DeptController {
	@Resource(name = "deptService")
	private DeptSevice deptService;
	@RequestMapping(value = "/deptWrite.do")
	public String deptWrite() {
		return "dept/deptWrite";
	}
	@RequestMapping(value = "/deptWriteSave.do")
	public String InsertDept(DeptVO vo) throws Exception {
		System.out.println(vo.getDeptno());
		System.out.println(vo.getDname());
		System.out.println(vo.getLoc());
		String result = deptService.InsertDept(vo);
		if (result == null) {
			// ok
			System.out.println("저장완료");
		} else {
			System.out.println("저장실패");
		}
		return "";
	}
	@RequestMapping(value = "deptList.do") 
	public String selectDeptList(DeptVO vo , ModelMap model) throws Exception {
		List<?> list = deptService.selectDeptList(vo);
		System.out.println(list);
		model.addAttribute("resultList",list);
		return "dept/deptList";
	}
	
	
	@RequestMapping(value="deptDelete.do") 
	public String deleteDept(int deptno) throws Exception {
		int result = deptService.deleteDept(deptno);
		if(result == 1) {
			System.out.println("삭제완료");
		}else {
			System.out.println("삭제실패");
			
		}
		
		return "";
	}
	
	
	@RequestMapping(value="/deptDetail.do")
	public String selectdeptDetail(int deptno , ModelMap model) throws Exception{
		DeptVO vo = deptService.selectdeptDetail(deptno);
		model.addAttribute("DeptVO",vo);
		return "dept/deptDetail";
	}
}
