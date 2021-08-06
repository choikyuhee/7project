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
	private String p_price;
	private String p_option;
	private String p_filename;
	private String p_thumb;
	private String p_category;
	private String p_content;
	private int p_stock;
	
	
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
	public String getP_price() {
		return p_price;
	}
	public void setP_pirce(String p_price) {
		this.p_price = p_price;
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
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getP_stock() {
		return p_stock;
	}
	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}
	public void setP_price(String p_price) {
		this.p_price = p_price;
	}
}
