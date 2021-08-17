package com.team.soc00.shop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.member.vo.MemberVO;
import com.team.soc00.shop.vo.CartListVO;
import com.team.soc00.shop.vo.CartVO;
import com.team.soc00.shop.vo.OrderDetailVO;
import com.team.soc00.shop.vo.OrderListVO;
import com.team.soc00.shop.vo.OrderVO;
import com.team.soc00.shop.vo.ShopVO;

@Repository("shopDAO")
public class ShopDAOImpl implements ShopDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int shopListCount()throws DataAccessException {
		return sqlSession.selectOne("mapper.shop.shopListCount");
	}
	
	@Override
	public List shopList(int displayPost, int postNum)throws DataAccessException {
		
		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sqlSession.selectList("mapper.shop.shopList", data);
	}
	
	@Override
	public ShopVO prodInfo(int p_no)throws DataAccessException {
		return sqlSession.selectOne("mapper.shop.prodInfo", p_no);
	}
	
	@Override
	public void insertCart(CartVO vo)throws DataAccessException {
		sqlSession.insert("mapper.shop.insertCart", vo);
	}
	
	@Override
	public List cartList(String u_id)throws DataAccessException {
		List<CartListVO> cartList = null;
		cartList = sqlSession.selectList("mapper.shop.cartList", u_id);
		return cartList;
	}
	
	@Override
	public void orderPageView(CartListVO vo)throws DataAccessException {
		sqlSession.selectOne("mapper.shop.cartList2", vo);
	}
	
	@Override
	public void prodbuy(CartListVO vo)throws DataAccessException {
		sqlSession.selectOne("mapper.shop.cartList2", vo);
	}
	
	@Override
	public void deleteCart(CartVO vo)throws DataAccessException {
		sqlSession.delete("mapper.shop.deleteCart", vo);
	}
	
	@Override
	public void prodReg(ShopVO shopVO)throws DataAccessException {
		sqlSession.insert("mapper.shop.prodReg", shopVO);
	}
	
	@Override
	public int buy(OrderVO vo)throws DataAccessException {
		int result = sqlSession.insert("mapper.shop.insertOrder", vo);
		return result;
	}
	
	@Override
	public void buyDetail(OrderDetailVO od_vo)throws DataAccessException {
		sqlSession.insert("mapper.shop.insertOrderDetail", od_vo);
	}
	
	@Override
	public void deleteAllCart(String u_id)throws DataAccessException {
		sqlSession.delete("mapper.shop.deleteAllCart", u_id);
	}
	
	@Override
	public List orderList(String u_id)throws DataAccessException {
		List<ShopVO> orderList = null;
		orderList = sqlSession.selectList("mapper.shop.orderList", u_id);
		return orderList;
	}
	
	@Override
	public List<OrderListVO> orderListView(OrderVO vo)throws DataAccessException {
		return sqlSession.selectList("mapper.shop.orderListView", vo);
	}
	
	
	@Override
	public OrderVO orderView(int o_no)throws DataAccessException {
		return sqlSession.selectOne("mapper.shop.orderView", o_no);
	}
}
