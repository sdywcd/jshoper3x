package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
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
	private double cost;
	private Date createtime;
	private String creatorid;
	private int freezeStore;
	private String goodsid;
	private String isDefault;
	private String isSalestate;
	private double memberprice;
	private String placeStore;
	private double price;
	private String productName;
	private String productSn;
	private double saleprice;
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
	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(name="FREEZE_STORE")
	public int getFreezeStore() {
		return this.freezeStore;
	}

	public void setFreezeStore(int freezeStore) {
		this.freezeStore = freezeStore;
	}


	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	@Column(name="IS_DEFAULT")
	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}


	@Column(name="IS_SALESTATE")
	public String getIsSalestate() {
		return this.isSalestate;
	}

	public void setIsSalestate(String isSalestate) {
		this.isSalestate = isSalestate;
	}


	public double getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}


	@Column(name="PLACE_STORE")
	public String getPlaceStore() {
		return this.placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
	}


	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Column(name="PRODUCT_NAME")
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Column(name="PRODUCT_SN")
	public String getProductSn() {
		return this.productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}


	public double getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(name="SPECIFICATIONS_NAME")
	public String getSpecificationsName() {
		return this.specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}


	@Column(name="SPECIFICATIONS_VALUE")
	public String getSpecificationsValue() {
		return this.specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
	}


	public String getSpecificationsid() {
		return this.specificationsid;
	}

	public void setSpecificationsid(String specificationsid) {
		this.specificationsid = specificationsid;
	}


	public int getStore() {
		return this.store;
	}

	public void setStore(int store) {
		this.store = store;
	}


	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(name="WAREHOUSE_LOCATION")
	public String getWarehouseLocation() {
		return this.warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}


	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}