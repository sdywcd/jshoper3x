package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ProductSpecificationsTDao;
import com.jshop.entity.ProductSpecificationsT;
import com.jshop.service.ProductSpecificationsTService;

@Service("productSpecificationsTService")
@Scope("prototype")
public class ProductSpecificationsTServiceImpl extends BaseTServiceImpl<ProductSpecificationsT>implements ProductSpecificationsTService {
	@Resource
	private ProductSpecificationsTDao productSpecificationsTDao;

	public ProductSpecificationsTDao getProductSpecificationsTDao() {
		return productSpecificationsTDao;
	}

	public void setProductSpecificationsTDao(ProductSpecificationsTDao productSpecificationsTDao) {
		this.productSpecificationsTDao = productSpecificationsTDao;
	}

	public int delProductSpecification(String[] list) {
		return this.getProductSpecificationsTDao().delProductSpecification(list);
	}

	public List<ProductSpecificationsT> findAllProductSpecificationsT(int currentPage, int lineSize) {
		return this.getProductSpecificationsTDao().findAllProductSpecificationsT(currentPage, lineSize);
	}

	public ProductSpecificationsT findProductSpecificationsTByspecificationsid(String specificationsid) {
		return this.getProductSpecificationsTDao().findProductSpecificationsTByspecificationsid(specificationsid);
	}

	public int updateProductSpecification(ProductSpecificationsT pst) {
		return this.getProductSpecificationsTDao().updateProductSpecification(pst);
	}

	

	@Override
	public List<ProductSpecificationsT> findAllProductSpecificationsT(
			String state) {
		return this.getProductSpecificationsTDao().findAllProductSpecificationsT(state);
	}

	public List<ProductSpecificationsT> sortAllProductSpecificationsT(int currentPage, int lineSize, String queryString) {

		return this.getProductSpecificationsTDao().sortAllProductSpecificationsT(currentPage, lineSize, queryString);
	}

	public int countfindAllProductSpecificationsT() {
		return this.getProductSpecificationsTDao().countfindAllProductSpecificationsT();
	}

	@Override
	public List<ProductSpecificationsT> findAllProductSpecificationsByGoodsTypeId(
			String goodsTypeId, String state) {
		return this.getProductSpecificationsTDao().findAllProductSpecificationsByGoodsTypeId(goodsTypeId, state);
	}

}
