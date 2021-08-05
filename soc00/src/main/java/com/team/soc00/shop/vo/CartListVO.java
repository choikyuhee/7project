package com.team.soc00.shop.vo;

import org.springframework.stereotype.Component;

@Component("cartListVO")
public class CartListVO {

	//상품번호, 회원아이디
	private int p_no;
	private String u_id;
	
	//장바구니
	private int c_no;
	private int c_count;
	
	//상품정보
	private String p_name;
	private String p_pirce;
	private String p_option;
	private String p_filename;
	private String p_thumb;
	
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_pirce() {
		return p_pirce;
	}
	public void setP_pirce(String p_pirce) {
		this.p_pirce = p_pirce;
	}
	public String getP_option() {
		return p_option;
	}
	public void setP_option(String p_option) {
		this.p_option = p_option;
	}
	public String getP_filename() {
		return p_filename;
	}
	public void setP_filename(String p_filename) {
		this.p_filename = p_filename;
	}
	public String getP_thumb() {
		return p_thumb;
	}
	public void setP_thumb(String p_thumb) {
		this.p_thumb = p_thumb;
	}
}
