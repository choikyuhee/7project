package com.team.soc00.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.member.vo.MemberVO;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;

@Repository("shopDAO")
public class ShopDAOImpl implements ShopDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List shopList()throws DataAccessException {
		List<ShopVO> shopList = null;
		shopList = sqlSession.selectList("mapper.shop.shopList");
		return shopList;
	}
	
	@Override
	public ShopVO prodInfo(int p_no)throws DataAccessException {
		return sqlSession.selectOne("mapper.shop.prodInfo", p_no);
	}
	
	@Override
	public void prodReg(ShopVO shopVO)throws DataAccessException {
		sqlSession.insert("mapper.shop.prodReg", shopVO);
	}
	
	@Override
	public int buy(OrderVO vo)throws DataAccessException {
		int result = sqlSession.insert("mapper.shop.prodBuy", vo);
		return result;
	}
	
	@Override
	public List orderList()throws DataAccessException {
		List<ShopVO> orderList = null;
		orderList = sqlSession.selectList("mapper.shop.orderList");
		return orderList;
	}
	
	@Override
	public OrderVO orderView(int o_no)throws DataAccessException {
		return sqlSession.selectOne("mapper.shop.orderView", o_no);
	}
}
