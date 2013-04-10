package com.jshop.service;

import com.jshop.entity.OutsidegoodsTwocodeRelationshipT;

public interface OutsideGoodsTwocodeRelationshipService {
	/**
	 * 添加二维码商品关系
	 * @param qrcode
	 * @return
	 */
	public int addGoodsQRCode(OutsidegoodsTwocodeRelationshipT qrcode);
	/**
	 * 根据goodsid查询信息
	 * @param goodsid
	 * @return
	 */
	public OutsidegoodsTwocodeRelationshipT findGoodsQRCodeByGoodsid(String id);
	/**
	 * 根据goodsid修改二维码路径
	 * @param goodsqrcode
	 * @return
	 */
	public  int updateGoodsQRCode(String id,String twocodepath);


}
