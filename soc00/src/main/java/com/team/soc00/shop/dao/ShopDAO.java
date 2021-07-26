package com.team.soc00.shop.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ShopDAO {
	public List shopList() throws DataAccessException;
}
