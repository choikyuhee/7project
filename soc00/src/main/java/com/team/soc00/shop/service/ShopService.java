package com.team.soc00.shop.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ShopService {

	public List shopList() throws DataAccessException;
}
