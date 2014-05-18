package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.CartTDao;
import com.jshop.entity.CartT;
import com.jshop.service.CartTService;

@Service("cartTService")
@Scope("prototype")
public class CartTServiceImpl extends BaseTServiceImpl<CartT> implements CartTService {
	@Resource
	private CartTDao cartTDao;

	public CartTDao getCartTDao() {
		return cartTDao;
	}

	public void setCartTDao(CartTDao cartTDao) {
		this.cartTDao = cartTDao;
	}

	public int countfindAllCart() {
		return this.getCartTDao().countfindAllCart();
	}

	public List<CartT> findAllCart(int currentPage, int lineSize) {
		return this.getCartTDao().findAllCart(currentPage, lineSize);
	}

	public List<CartT> findAllCartByUserId(String userid, String state, String orderTag) {
		return this.getCartTDao().findAllCartByUserId(userid, state, orderTag);
	}

	public CartT findGoodsInCartOrNot(String userid, String goodsid, String state) {
		return this.getCartTDao().findGoodsInCartOrNot(userid, goodsid, state);
	}

	public int updateCartNeedquantityByGoodsid(String userid, String goodsid, int needquantity, String state) {
		return this.getCartTDao().updateCartNeedquantityByGoodsid(userid, goodsid, needquantity, state);
	}

	public int reduceCartNeddquantityByGoodsid(String userid, String goodsid, int needquantity) {
		return this.getCartTDao().reduceCartNeddquantityByGoodsid(userid, goodsid, needquantity);
	}

	public int delCartByGoodsId(String userid, String goodsid, String state) {
		return this.getCartTDao().delCartByGoodsId(userid, goodsid, state);
	}

	public int updateCartNeedquantity(String userid, String goodsid, int needquantity) {
		return this.getCartTDao().updateCartNeedquantity(userid, goodsid, needquantity);
	}

	public int updateCartSubtotal(String userid, String goodsid, double subtotal) {
		return this.getCartTDao().updateCartSubtotal(userid, goodsid, subtotal);
	}

	public int updateCartState(String userid, String goodsid, String state) {
		return this.getCartTDao().updateCartState(userid, goodsid, state);
	}

	public int updateCartStateandOrderidByGoodsidList(String cartid, String orderid, String userid, String state) {
		return this.getCartTDao().updateCartStateandOrderidByGoodsidList(cartid, orderid, userid, state);
	}

	public List<CartT> findCartGoodsByOrderid(String orderid) {
		return this.getCartTDao().findCartGoodsByOrderid(orderid);
	}

	public int updateCartStateByGoodsidList(String userid, String[] goodsid, String state) {
		return this.getCartTDao().updateCartStateByGoodsidList(userid, goodsid, state);
	}

	public int updateCartIdBygoodsid(String cartid, String memberid, String goodsid, String state) {
		return this.getCartTDao().updateCartIdBygoodsid(cartid, memberid, goodsid, state);
	}

	@Override
	public int updateCartIdByproductid(String cartid, String userid, String productid, String state) {
		return this.getCartTDao().updateCartIdByproductid(cartid, userid, productid, state);
	}

	public List<CartT> findCartByCartid(String cartid, String state) {
		return this.getCartTDao().findCartByCartid(cartid, state);
	}

	@Override
	public CartT findGoodsInCartOrNot(String userid, String goodsid, String productid, String state) {
		return this.getCartTDao().findGoodsInCartOrNot(userid, goodsid, productid, state);
	}

	@Override
	public int updateCartNeedquantityByGoodsid(String userid, String goodsid, String productid, int needquantity, String state) {
		return this.getCartTDao().updateCartNeedquantityByGoodsid(userid, goodsid, productid, needquantity, state);
	}

	@Override
	public int delCartByid(String id) {
		return this.getCartTDao().delCartByid(id);
	}

	@Override
	public CartT findProductInCart(String memberid, String goodsid,
			String productid, String state) {
		return this.getCartTDao().findProductInCart(memberid, goodsid, productid, state);
	}

	@Override
	public List<CartT> findAllCartByMemberId(String memberid, String state,
			String orderTag) {
		return this.getCartTDao().findAllCartByMemberId(memberid, state, orderTag);
	}

}
