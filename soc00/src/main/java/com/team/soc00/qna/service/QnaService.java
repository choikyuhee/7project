package com.team.soc00.qna.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.team.soc00.qna.vo.FaqVO;
import com.team.soc00.qna.vo.QnaVO;

public interface QnaService {

	public List<FaqVO> faqList()throws DataAccessException;
	
	public int qnaWrite(QnaVO qna)throws DataAccessException;
	
	public List<QnaVO> qnaList()throws DataAccessException;
	
	public QnaVO qnaView(int q_no)throws DataAccessException;
}
