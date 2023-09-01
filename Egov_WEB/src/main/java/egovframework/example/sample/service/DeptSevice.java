package egovframework.example.sample.service;

import java.util.List;


/*인터페이스 역할을 하는 명세 파일*/
public interface DeptSevice {
	
public String InsertDept(DeptVO vo) throws Exception;
public List<?> selectDeptList(DeptVO vo) throws Exception;
public DeptVO selectdeptDetail(int deptno) throws Exception;
public int deleteDept(int deptno) throws Exception;
public int updateDept(DeptVO vo) throws Exception;

}
