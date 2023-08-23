package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.DeptSevice;
import egovframework.example.sample.service.DeptVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


/*다형성 오버라이딩(상속), 오버로딩(같은 클래스)
 * 추상화 
 * 상속
 * 캡슐화
 *  */
@Service("deptService")
public class DeptServiceImpl extends EgovAbstractServiceImpl implements DeptSevice{
     
	@Resource(name="deptDAO")
	private DeptDAO deptDAO;
	
	
	
	@Override
	public String InsertDept(DeptVO vo) throws Exception{
		
		return deptDAO.InsertDept(vo);
	}

	@Override
	public List<?> selectDeptList(DeptVO vo) throws Exception {
		
     return deptDAO.selectDeptList(vo);
	}

	@Override
	public DeptVO selectdeptDetail(int deptno) throws Exception {
		return deptDAO.selectdeptDetail(deptno);
	}

	@Override
	public int deleteDept(int deptno) throws Exception {
		return deptDAO.deleteDept(deptno);
	}



	/*
	 * @Override public void hap() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	
}
