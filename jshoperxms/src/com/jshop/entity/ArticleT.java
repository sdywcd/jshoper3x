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
	@Column(unique=true, nullable=false, length=20)
	public String getArticleid() {
		return this.articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}


	@Column(nullable=false, length=45)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Lob
	@Column(nullable=false)
	public String getContentvalue() {
		return this.contentvalue;
	}

	public void setContentvalue(String contentvalue) {
		this.contentvalue = contentvalue;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	@Column(length=20)
	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Column(length=45)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}


	@Column(name="HTML_PATH", length=255)
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}


	@Column(length=1)
	public String getIsnotice() {
		return this.isnotice;
	}

	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}


	@Column(length=1)
	public String getIsoutsite() {
		return this.isoutsite;
	}

	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}


	@Column(nullable=false, length=1)
	public String getIspublication() {
		return this.ispublication;
	}

	public void setIspublication(String ispublication) {
		this.ispublication = ispublication;
	}


	@Column(nullable=false, length=1)
	public String getIsrecommend() {
		return this.isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}


	@Column(nullable=false, length=1)
	public String getIstop() {
		return this.istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}


	@Column(length=45)
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	@Column(length=20)
	public String getLtypeid() {
		return this.ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}


	@Column(length=255)
	public String getMainpicture() {
		return this.mainpicture;
	}

	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}


	@Column(name="META_DES", length=225)
	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}


	@Column(name="META_KEYWORDS", length=225)
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	@Column(nullable=false, length=1)
	public String getMobilesync() {
		return this.mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}


	@Column(length=20)
	public String getNavid() {
		return this.navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}


	@Column(length=45)
	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}


	@Column(length=255)
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


	@Column(length=1)
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


	@Column(length=20)
	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	@Column(length=45)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	@Column(length=45)
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


	@Column(nullable=false, length=1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(length=20)
	public String getStypeid() {
		return this.stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}


	@Column(length=100)
	public String getTipcontent() {
		return this.tipcontent;
	}

	public void setTipcontent(String tipcontent) {
		this.tipcontent = tipcontent;
	}


	@Column(nullable=false, length=100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	@Column(nullable=false)
	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}