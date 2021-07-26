package com.team.soc00.shop.vo;

import org.springframework.stereotype.Component;

@Component("shopVO")
public class ShopVO {

	private int p_no;
	private String p_name;
	private String p_price;
	private String p_category;
	private String p_content;
	private String p_option;
	private String p_filename;
	private int p_stock;
	
	public ShopVO() {
		
	}
	
	public ShopVO(int p_no, String p_name, String p_price, String p_category, String p_content, String p_option,
			String p_filename, int p_stock) {
		this.p_name = p_name;
		this.p_no = p_no;
		this.p_price = p_price;
		this.p_content = p_content;
		this.p_category = p_category;
		this.p_option = p_option;
		this.p_stock = p_stock;
		this.p_filename = p_filename;
	}
	
	public int getP_no() {
		return p_no;
	}
	
	public void setP_no(int p_no) {
		this.p_no = p_no;
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
	
	public void setP_price(String p_price) {
		this.p_price = p_price;
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
		this.p_filename= p_filename;
	}
	
	public int getP_stock() {
		return p_stock;
	}
	
	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}
}
