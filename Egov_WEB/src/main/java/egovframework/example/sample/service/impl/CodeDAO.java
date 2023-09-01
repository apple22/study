package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import egovframework.example.sample.service.CodeVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("CodeDAO")
public class CodeDAO extends EgovAbstractDAO {

	public String insertCodes(CodeVO vo) {
		return (String) insert("CodeDAO.insertCodes", vo);
	}

	public List<?> selectCodesList(CodeVO vo) {
		return list("CodeDAO.selectCodesList",vo); 
	}

	
	public int deleteCodes(int code) {
		return delete("CodeDAO.deleteCodes",code);
	}

	public int selectCodesCount(CodeVO vo) {
		return (int) select("CodeDAO.selectCodesCount",vo);
	}

	public CodeVO selectcodesDetail(int code) {
		return (CodeVO) select("CodeDAO.selectcodesDetail",code);
	}

	public int codeModifySave(CodeVO vo) {
		return (int) update("CodeDAO.codeModifySave", vo);
	}
}
