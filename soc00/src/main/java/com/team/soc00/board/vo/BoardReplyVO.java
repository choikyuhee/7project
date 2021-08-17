package com.team.soc00.board.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("boardReplyVO")
public class BoardReplyVO {

	private int r_no;
	private String r_content;
	private Date r_regdate;
	private String u_id;
	private int no;
	
	public BoardReplyVO() {
		
	}
	
	public BoardReplyVO(int r_no, String r_content, Date r_regdate, String u_id, int no) {
		this.r_no = r_no;
		this.r_content = r_content;
		this.r_regdate = r_regdate;
		this.u_id = u_id;
		this.no = no;
	}
	
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public Date getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(Date r_regdate) {
		this.r_regdate = r_regdate;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "BoardReplyVO [r_no=" + r_no + ", r_content=" + r_content + ", r_regdate=" + r_regdate + ", u_id=" + u_id
				+ ", no=" + no + "]";
	}
	
	
}
