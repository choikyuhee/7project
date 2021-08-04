package com.team.soc00.shop.vo;

import java.util.Date;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ImageVO {
	
	private int i_no;
	private String i_filename;
	private Date i_regdate;
	private int p_no;
	
	public int getI_no() {
		return i_no;
	}
	
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	
	public String getI_filename() {
		return i_filename;
	}
	
	public void setI_filename(String i_filename) {
		try {
			if(i_filename != null && i_filename.length() != 0) {
				this.i_filename = URLEncoder.encode(i_filename,"utf-8");
			}
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public Date getI_regdate() {
		return i_regdate;
	}
	
	public void setI_regdate(Date i_regdate) {
		this.i_regdate = i_regdate;
	}
	
	public int getP_no() {
		return p_no;
	}
	
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	
}
