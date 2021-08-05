package com.team.soc00.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.team.soc00.shop.dao.ShopDAO;
import com.team.soc00.shop.vo.CartVO;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDAO shopDAO;

	@Override
	public List shopList()throws DataAccessException {
		List shopList = null;
		shopList = shopDAO.shopList();
		return shopList;
	}
	
	@Override
	public ShopVO prodInfo(int p_no)throws DataAccessException{
		return shopDAO.prodInfo(p_no);
	}
	
	@Override
	public void prodReg(ShopVO shopVO)throws DataAccessException {
		shopDAO.prodReg(shopVO);
	}
	
	@Override
	public void insertCart(CartVO vo)throws DataAccessException {
		shopDAO.insertCart(vo);
	}
	
	@Override
	public List cartList(String u_id)throws DataAccessException {
		List cartList = null;
		cartList = shopDAO.cartList(u_id);
		return cartList;
	}
	
	@Override
	public int buy(OrderVO vo)throws DataAccessException {
		return shopDAO.buy(vo);
	}
	
	@Override
	public List orderList()throws DataAccessException {
		List orderList = null;
		orderList = shopDAO.orderList();
		return orderList;
	}
	
	@Override
	public OrderVO orderView(int o_no)throws DataAccessException{
		return shopDAO.orderView(o_no);
	}
}
