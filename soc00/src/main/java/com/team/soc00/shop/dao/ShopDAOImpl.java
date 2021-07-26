package com.team.soc00.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.member.vo.MemberVO;
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
}