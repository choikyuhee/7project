package com.team.soc00.qna.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("faqVO")
public class FaqVO {
	
	private int f_no;
	private String f_title;
	private String f_content;
	private String f_category;
	private Date f_regdate;
	private int f_view;
	private String u_id;
	
	public int getf_no() {
		return f_no;
	}
	
	public void setf_no(int f_no) {
		this.f_no = f_no;
	}
	
	public String getf_title() {
		return f_title;
	}
	
	public void setf_title(String f_title) {
		this.f_title = f_title;
	}
	
	public String getf_content() {
		return f_content;
	}
	
	public void setf_content(String f_content) {
		this.f_content = f_content;
	}
	
	public String getf_category() {
		return f_category;
	}
	
	public void setf_category(String f_category) {
		this.f_category = f_category;
	}
	
	public Date getf_regdate() {
		return f_regdate;
	}
	
	public void setf_regdate(Date f_regdate) {
		this.f_regdate = f_regdate;
	}
	
	public int getf_view() {
		return f_view;
	}
	
	public void setf_view(int f_view) {
		this.f_view = f_view;
	}
	
	public String getU_id() {
		return u_id;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
}
