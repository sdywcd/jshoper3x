package com.jshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the article_t database table.
 * 
 */
@Entity
@Table(name="article_t")
@NamedQuery(name="ArticleT.findAll", query="SELECT a FROM ArticleT a")
public class ArticleT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String articleid;
	private String author;
	private String contentvalue;
	private Date createtime;
	private String creatorid;
	private String fname;
	private String htmlPath;
	private String isnotice;
	private String isoutsite;
	private String ispublication;
	private String isrecommend;
	private String istop;
	private String lname;
	private String ltypeid;
	private String mainpicture;
	private String metaDes;
	private String metaKeywords;
	private String mobilesync;
	private String navid;
	private String nname;
	private String outsitelink;
	private int pageCount;
	private String position;
	private int readcount;
	private String shopid;
	private String shopname;
	private String sname;
	private int sort;
	private String status;
	private String stypeid;
	private String tipcontent;
	private String title;
	private Date updatetime;
	private int versiont;

	public ArticleT() {
	}


	@Id
	public String getArticleid() {
		return this.articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}


	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Lob
	public String getContentvalue() {
		return this.contentvalue;
	}

	public void setContentvalue(String contentvalue) {
		this.contentvalue = contentvalue;
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


	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}


	@Column(name="HTML_PATH")
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}


	public String getIsnotice() {
		return this.isnotice;
	}

	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}


	public String getIsoutsite() {
		return this.isoutsite;
	}

	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}


	public String getIspublication() {
		return this.ispublication;
	}

	public void setIspublication(String ispublication) {
		this.ispublication = ispublication;
	}


	public String getIsrecommend() {
		return this.isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}


	public String getIstop() {
		return this.istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}


	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getLtypeid() {
		return this.ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}


	public String getMainpicture() {
		return this.mainpicture;
	}

	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}


	@Column(name="META_DES")
	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}


	@Column(name="META_KEYWORDS")
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	public String getMobilesync() {
		return this.mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}


	public String getNavid() {
		return this.navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}


	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}


	public String getOutsitelink() {
		return this.outsitelink;
	}

	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}


	@Column(name="PAGE_COUNT")
	public int getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public int getReadcount() {
		return this.readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getStypeid() {
		return this.stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}


	public String getTipcontent() {
		return this.tipcontent;
	}

	public void setTipcontent(String tipcontent) {
		this.tipcontent = tipcontent;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}