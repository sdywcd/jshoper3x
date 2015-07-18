package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the product_t database table.
 * 
 */
@Entity
@Table(name="product_t")
@NamedQuery(name="ProductT.findAll", query="SELECT p FROM ProductT p")
public class ProductT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String productid;
	private BigDecimal cost;
	private Date createtime;
	private String creatorid;
	private int freezeStore;
	private String goodsid;
	private String isDefault;
	private String isSalestate;
	private BigDecimal memberprice;
	private String placeStore;
	private BigDecimal price;
	private String productName;
	private String productSn;
	private BigDecimal saleprice;
	private String shopid;
	private String specificationsName;
	private String specificationsValue;
	private String specificationsid;
	private int store;
	private String unit;
	private Date updatetime;
	private String warehouseLocation;
	private String weight;

	public ProductT() {
	}


	@Id
	@Column(unique=true, nullable=false, length=20)
	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(nullable=false, length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(name="FREEZE_STORE", nullable=false)
	public int getFreezeStore() {
		return this.freezeStore;
	}

	public void setFreezeStore(int freezeStore) {
		this.freezeStore = freezeStore;
	}


	@Column(nullable=false, length=20)
	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(name="IS_DEFAULT", nullable=false, length=1)
	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}


	@Column(name="IS_SALESTATE", nullable=false, length=1)
	public String getIsSalestate() {
		return this.isSalestate;
	}

	public void setIsSalestate(String isSalestate) {
		this.isSalestate = isSalestate;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(BigDecimal memberprice) {
		this.memberprice = memberprice;
	}


	@Column(name="PLACE_STORE", nullable=false, length=100)
	public String getPlaceStore() {
		return this.placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	@Column(name="PRODUCT_NAME", nullable=false, length=200)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Column(name="PRODUCT_SN", nullable=false, length=45)
	public String getProductSn() {
		return this.productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}


	@Column(nullable=false, precision=10, scale=2)
	public BigDecimal getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
	}


	@Column(nullable=false, length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(name="SPECIFICATIONS_NAME", nullable=false, length=200)
	public String getSpecificationsName() {
		return this.specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}


	@Column(name="SPECIFICATIONS_VALUE", nullable=false, length=500)
	public String getSpecificationsValue() {
		return this.specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
	}


	@Column(nullable=false, length=200)
	public String getSpecificationsid() {
		return this.specificationsid;
	}

	public void setSpecificationsid(String specificationsid) {
		this.specificationsid = specificationsid;
	}


	@Column(nullable=false)
	public int getStore() {
		return this.store;
	}

	public void setStore(int store) {
		this.store = store;
	}


	@Column(nullable=false, length=20)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(name="WAREHOUSE_LOCATION", nullable=false, length=100)
	public String getWarehouseLocation() {
		return this.warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}


	@Column(nullable=false, length=45)
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}