package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO {

	public String InsertDept(DeptVO vo) {
		return (String) insert("deptDAO.InsertDept",vo);
	}

	public List<?> selectDeptList(DeptVO vo) {
		return (List<?>) list("deptDAO.selectDeptList",vo);
	}

	public DeptVO selectdeptDetail(int deptno) {
		/* return (DeptVO) select("deptDAO.selectdeptDetail", deptno); */
		return (DeptVO) select("deptDAO.selectdeptDetail", deptno);
	}

	public int deleteDept(int deptno) {
		return delete("deptDAO.deleteDept",deptno);
	}

	public int updateDept(DeptVO vo) {
		return update("deptDAO.updateDept", vo);
	}

}
