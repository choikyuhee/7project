package com.team.soc00.qna.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.team.soc00.qna.vo.FaqVO;
import com.team.soc00.qna.vo.QnaVO;

public interface QnaDAO {
	
	public List<FaqVO> faqList()throws DataAccessException;
	
	public FaqVO faqView(int f_no)throws DataAccessException;
	
	public int faqWrite(FaqVO faqVO)throws DataAccessException;
	
	public int faqModi(FaqVO vo)throws DataAccessException;
	
	public int faqDelete(int no)throws DataAccessException;
	
	public int qnaWrite(QnaVO qnaVO)throws DataAccessException;
	
	public List<QnaVO> qnaList()throws DataAccessException;
	
	public QnaVO qnaView(int q_no)throws DataAccessException;
	
	public int qnaModi(QnaVO vo)throws DataAccessException;
	
	public int qnaDelete(int no)throws DataAccessException;
}
