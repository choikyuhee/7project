package com.team.soc00.shop.vo;

import org.springframework.stereotype.Component;

@Component("orderDetailVO")
public class OrderDetailVO {

	private int od_no;
	private int od_count;
	private String od_price;
	private String o_no;
	private int p_no;
	
	public int getOd_no() {
		return od_no;
	}
	public void setOd_no(int od_no) {
		this.od_no = od_no;
	}
	public int getOd_count() {
		return od_count;
	}
	public void setOd_count(int od_count) {
		this.od_count = od_count;
	}
	public String getO_no() {
		return o_no;
	}
	public void setO_no(String o_no) {
		this.o_no = o_no;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getOd_price() {
		return od_price;
	}
	public void setOd_price(String od_price) {
		this.od_price = od_price;
	}
}
