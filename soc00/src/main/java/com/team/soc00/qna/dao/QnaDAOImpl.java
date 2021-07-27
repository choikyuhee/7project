package com.team.soc00.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.qna.vo.FaqVO;
import com.team.soc00.qna.vo.QnaVO;

@Repository("qnaDAO")
public class QnaDAOImpl implements QnaDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<FaqVO> faqList()throws DataAccessException{
		List<FaqVO> faqList = sqlSession.selectList("mapper.qna.faqList");
		return faqList;
	}
	
	@Override
	public int qnaWrite(QnaVO qnaVO)throws DataAccessException{
		int result = sqlSession.insert("mapper.qna.qnaWrite", qnaVO);
		return result;
	}
	
	@Override
	public List<QnaVO> qnaList()throws DataAccessException {
		List<QnaVO> qnaList = sqlSession.selectList("mapper.qna.qnaList");
		return qnaList;
	}
	
	
	public QnaVO qnaView(int q_no)throws DataAccessException {
		return sqlSession.selectOne("mapper.qna.qnaView", q_no);
	}
}
