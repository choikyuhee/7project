package com.team.soc00.shop.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("orderVO")
public class OrderVO {

	private int o_no;
	private Date o_date;
	private int o_price;
	private String o_address;
	private String o_phone;
	private String u_id;
	private int p_no;
	private String o_request;
	
	public int getO_no() {
		return o_no;
	}
	
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	
	public Date getO_date() {
		return o_date;
	}
	
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	
	public int getO_price() {
		return o_price;
	}
	
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	
	public String getO_address() {
		return o_address;
	}
	
	public void setO_address(String o_address) {
		this.o_address = o_address;
	}
	

	
	public String getO_phone() {
		return o_phone;
	}
	
	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}
	

	
	public String getU_id() {
		return u_id;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
	public int getP_no() {
		return p_no;
	}
	
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	

	
	public String getO_request() {
		return o_request;
	}
	
	public void setO_request(String o_request) {
		this.o_request = o_request;
	}
}
