package com.team.soc00.qna.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("questionVO")
public class QnaVO {
	
	private int q_no;
	private String q_title;
	private String q_content;
	private String q_category;
	private Date q_regdate;
	private int q_view;
	private String u_id;
	
	public int getQ_no() {
		return q_no;
	}
	
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	
	public String getQ_title() {
		return q_title;
	}
	
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	
	public String getQ_content() {
		return q_content;
	}
	
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	
	public String getQ_category() {
		return q_category;
	}
	
	public void setQ_category(String q_category) {
		this.q_category = q_category;
	}
	
	public Date getQ_regdate() {
		return q_regdate;
	}
	
	public void setQ_regdate(Date q_regdate) {
		this.q_regdate = q_regdate;
	}
	
	public int getQ_view() {
		return q_view;
	}
	
	public void setQ_view(int q_view) {
		this.q_view = q_view;
	}
	
	public String getU_id() {
		return u_id;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
}
