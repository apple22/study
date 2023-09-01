package egovframework.example.sample.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;
import egovframework.example.sample.service.impl.CodeDAO;

@Service("codeService")
public class CodeServiceImpl implements CodeService{
	
	@Resource(name="CodeDAO")
	private CodeDAO CodeDAO;

	@Override
	public String insertCodes(CodeVO vo) throws Exception {
		return CodeDAO.insertCodes(vo);
	}

	@Override // 다형성 (오버라이딩 , 오버로딩)
	public List<?> selectCodesList(CodeVO vo) throws Exception {
		return CodeDAO.selectCodesList(vo);
	}


	@Override
	public int deleteCodes(int code) throws Exception {
	return CodeDAO.deleteCodes(code);
	}

	@Override
	public int selectCodesCount(CodeVO vo) throws Exception {
	return CodeDAO.selectCodesCount(vo);
	}

	@Override
	public CodeVO selectcodesDetail(int code) throws Exception {
		return CodeDAO.selectcodesDetail(code);
	}

	@Override
	public int codeModifySave(CodeVO vo) throws Exception {
		return CodeDAO.codeModifySave(vo);
	}
	
	
}