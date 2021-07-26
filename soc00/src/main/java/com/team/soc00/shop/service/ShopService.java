package com.team.soc00.shop.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.team.soc00.shop.vo.ShopVO;

public interface ShopService {

	public List shopList() throws DataAccessException;
	
	public ShopVO prodInfo(int p_no)throws DataAccessException;
}
