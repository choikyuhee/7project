package com.team.soc00.shop.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.team.soc00.shop.vo.CartVO;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;

public interface ShopService {

	public List shopList() throws DataAccessException;
	
	public ShopVO prodInfo(int p_no)throws DataAccessException;
	
	public void prodReg(ShopVO shopVO)throws DataAccessException;
	
	public void insertCart(CartVO vo)throws DataAccessException;
	
	public List cartList(String u_id)throws DataAccessException;
	
	public int buy(OrderVO vo)throws DataAccessException;
	
	public List orderList()throws DataAccessException;
	
	public OrderVO orderView(int o_no)throws DataAccessException;
}
