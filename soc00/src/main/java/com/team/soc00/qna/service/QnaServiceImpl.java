package com.team.soc00.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.team.soc00.board.vo.ArticleVO;
import com.team.soc00.qna.dao.QnaDAO;
import com.team.soc00.qna.vo.FaqVO;
import com.team.soc00.qna.vo.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDAO qnaDAO;
	
	@Override
	public List<FaqVO> faqList()throws DataAccessException {
		List<FaqVO> faqList = qnaDAO.faqList();
		return faqList;
	}
	
	@Override
	public FaqVO faqView(int f_no)throws DataAccessException {
		return qnaDAO.faqView(f_no);
	}
	
	@Override
	public int faqWrite(FaqVO faq)throws DataAccessException {
		return qnaDAO.faqWrite(faq);
	}
	
	@Override
	public int faqModi(FaqVO vo)throws DataAccessException {
		return qnaDAO.faqModi(vo);
	}
	
	@Override
	public int faqDelete(int f_no)throws DataAccessException {
		return qnaDAO.faqDelete(f_no);
	}
	
	@Override
	public int qnaWrite(QnaVO qna)throws DataAccessException {
		return qnaDAO.qnaWrite(qna);
	}
	
	@Override
	public List<QnaVO> qnaList()throws DataAccessException {
		List<QnaVO> qnaList = qnaDAO.qnaList();
		return qnaList;
	}
	
	@Override
	public QnaVO qnaView(int q_no)throws DataAccessException {
		return qnaDAO.qnaView(q_no);
	}
	
	@Override
	public int qnaModi(QnaVO vo)throws DataAccessException {
		return qnaDAO.qnaModi(vo);
	}
	
	@Override
	public int qnaDelete(int q_no)throws DataAccessException {
		return qnaDAO.qnaDelete(q_no);
	}
}
