package com.jshop.action.backstage.content.article;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.staticspage.CreateHtml;
import com.jshop.action.backstage.staticspage.DataCollectionTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.ArticleT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.impl.Serial;

import freemarker.template.TemplateException;
@Namespace("")
@ParentPackage("jshop")
public class ArticleTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private ArticleTService articleTService;
	private ArticleCategoryTService articleCategoryTService;
	private DataCollectionTAction dataCollectionTAction;
	private CreateHtml createHtml;
	private String articleid;
	private String tipcontent;
	private String nname;
	private String lname;
	private String sname;
	private String fname;
	private String navid;
	private String ltypeid;
	private String stypeid;
	private String title;
	private String metaKeywords;
	private String metaDes;
	private String contentvalue;
	private String status;
	private String creatorid;
	private String author;
	private String ispublication;
	private String isrecommend;
	private String istop;
	private String mobilesync;
	private String readcount;
	private String htmlPath;
	private Integer pageCount;
	private String isnotice;
	private Date createtime;
	private Date updatetime;
	private Integer version;
	private String isoutsite;
	private String outsitelink;
	private String sort;
	private String mainpicture;
	private ArticleT bean = new ArticleT();
	private ArticleCategoryT actbean = new ArticleCategoryT();
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	private String basepath;
	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}

	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}
	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}


	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	
	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}
	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDes() {
		return metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

	public String getContentvalue() {
		return contentvalue;
	}

	public void setContentvalue(String contentvalue) {
		this.contentvalue = contentvalue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIspublication() {
		return ispublication;
	}

	public void setIspublication(String ispublication) {
		this.ispublication = ispublication;
	}

	public String getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public ArticleT getBean() {
		return bean;
	}

	public void setBean(ArticleT bean) {
		this.bean = bean;
	}

	public List<Map<String,Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String,Object>> rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public ArticleCategoryT getActbean() {
		return actbean;
	}

	public void setActbean(ArticleCategoryT actbean) {
		this.actbean = actbean;
	}


	public String getIsnotice() {
		return isnotice;
	}

	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}

	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getTipcontent() {
		return tipcontent;
	}

	public void setTipcontent(String tipcontent) {
		this.tipcontent = tipcontent;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getNavid() {
		return navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}

	public String getLtypeid() {
		return ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}

	public String getStypeid() {
		return stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}

	public String getMobilesync() {
		return mobilesync;
	}

	public void setMobilesync(String mobilesync) {
		this.mobilesync = mobilesync;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getMainpicture() {
		return mainpicture;
	}

	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getIsoutsite() {
		return isoutsite;
	}

	public void setIsoutsite(String isoutsite) {
		this.isoutsite = isoutsite;
	}

	public String getOutsitelink() {
		return outsitelink;
	}

	public void setOutsitelink(String outsitelink) {
		this.outsitelink = outsitelink;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}



	/**
	 * 增加文章
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "addArticleT", results = { @Result(name = "json", type = "json") })
	public String addArticleT() throws IOException, TemplateException {
		ArticleT at = new ArticleT();
		at.setArticleid(this.getSerial().Serialid(Serial.ARTICLE));
		at.setNname(this.getNname());
		at.setNavid(this.getNavid());
		at.setLname(this.getLname());
		at.setLtypeid(this.getLtypeid());
		at.setSname(this.getSname());
		at.setStypeid(this.getStypeid());
		at.setFname(this.getFname());
		at.setTitle(this.getTitle());
		at.setMetaKeywords(this.getMetaKeywords());
		at.setMetaDes(this.getMetaDes());
		at.setContentvalue(this.getContentvalue());
		at.setStatus(StaticKey.ONE);//显示
		at.setAuthor(this.getAuthor());
		at.setIspublication(this.getIspublication());
		at.setIsrecommend(this.getIsrecommend());
		at.setIstop(this.getIstop());
		at.setReadcount(0);
		at.setPageCount(1);//默认只分一页
		at.setCreatetime(BaseTools.systemtime());
		at.setCreatorid(BaseTools.getAdminCreateId());
		at.setUpdatetime(at.getCreatetime());
		at.setVersiont(0);
		at.setMobilesync(this.getMobilesync());
		at.setTipcontent(this.getTipcontent());
		at.setHtmlPath("#");
		at.setSort(Integer.parseInt(this.getSort()));
		at.setMainpicture(this.getMainpicture().trim());
		at.setIsoutsite(this.getIsoutsite());
		at.setOutsitelink(this.getOutsitelink());
		List<ArticleCategoryT>list=this.getArticleCategoryTService().findArticleCategoryByparentId(StaticKey.ONE, this.getNavid());
		if(!list.isEmpty()){
			if (list.get(0).getPosition() != null && list.get(0).getPosition().equals(StaticKey.ONE)) {
				at.setPosition(StaticKey.ONE);
			} else {
				at.setPosition(StaticKey.ZERO);
			}
		}
		at.setIsnotice(this.getIsnotice());
		this.getArticleTService().save(at);
		this.setBean(at);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 更新文章静态路径
	 * 
	 * @param articleid
	 * @param htmlPath
	 */
	public void updateHtmlPath(String articleid, String htmlPath) {
		this.getArticleTService().updateHtmlPath(articleid, htmlPath);
	}

	/**
	 * 根据articleid获取文章
	 * 
	 * @return
	 */
	@Action(value = "findArticleByarticleid", results = { @Result(name = "json", type = "json") })
	public String findArticleByarticleid() {
		if(StringUtils.isNotBlank(this.getArticleid())){
			bean = this.getArticleTService().findArticleByarticleid(this.getArticleid().trim());
			if (bean != null) {
				this.setBasepath(BaseTools.getBasePath());
				this.setSucflag(true);
				return "json";
			}
			return "json";
		}
		return "json";

	}

	/**
	 * 更新文章
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "updateArticleT", results = { @Result(name = "json", type = "json") })
	public String updateArticleT() throws IOException, TemplateException {
		ArticleT at = new ArticleT();
		at=this.getArticleTService().findArticleByarticleid(this.getArticleid());
		at.setNname(this.getNname());
		at.setNavid(this.getNavid());
		at.setLname(this.getLname());
		at.setLtypeid(this.getLtypeid());
		at.setSname(this.getSname());
		at.setStypeid(this.getStypeid());
		at.setFname(this.getFname());
		at.setTitle(this.getTitle());
		at.setMetaKeywords(this.getMetaKeywords());
		at.setMetaDes(this.getMetaDes());
		at.setContentvalue(this.getContentvalue());
		at.setStatus(StaticKey.ONE);//显示
		at.setAuthor(this.getAuthor());
		at.setIspublication(this.getIspublication());
		at.setIsrecommend(this.getIsrecommend());
		at.setIstop(this.getIstop());
		at.setReadcount(0);
		at.setPageCount(1);//默认只分一页
		at.setCreatorid(BaseTools.getAdminCreateId());
		at.setUpdatetime(BaseTools.systemtime());
		at.setVersiont(at.getVersiont()+1);
		at.setMobilesync(this.getMobilesync());
		at.setTipcontent(this.getTipcontent());
		at.setSort(Integer.parseInt(this.getSort()));
		at.setMainpicture(this.getMainpicture().trim());
		at.setIsoutsite(this.getIsoutsite());
		at.setOutsitelink(this.getOutsitelink());
		List<ArticleCategoryT>list=this.getArticleCategoryTService().findArticleCategoryByparentId(StaticKey.ONE, this.getNavid());
		if(!list.isEmpty()){
			if (list.get(0).getPosition() != null && list.get(0).getPosition().equals(StaticKey.ONE)) {
				at.setPosition(StaticKey.ONE);
			} else {
				at.setPosition(StaticKey.ZERO);
			}
		}
		at.setIsnotice(this.getIsnotice());
		if (this.getArticleTService().updateArticleT(at) > 0) {
			this.setBean(at);
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

	/**
	 * 批量删除文章
	 * 
	 * @return
	 */
	@Action(value = "delArticleT", results = { @Result(name = "json", type = "json") })
	public String delArticleT() {
		String[] strs = StringUtils.split(this.getArticleid(), ",");
		for(String s:strs){
			this.getArticleTService().delArticleT(s);
		}
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 查询所有文章
	 * 
	 * @return
	 * @throws Exception 
	 */
	@Action(value = "findAllArticleT", results = { @Result(name = "json", type = "json") })
	public String findAllArticleT() throws Exception {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllArticle();				
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllArticle() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getArticleTService().countfindAllArticle();
		List<ArticleT> list = this.getArticleTService().findAllArticleT(currentPage, lineSize);
		if (list != null) {
			this.ProcessArticleTList(list);
		}
	}

	public void ProcessArticleTList(List<ArticleT> list) {
		for (Iterator<ArticleT> it = list.iterator(); it.hasNext();) {
			ArticleT at = (ArticleT) it.next();
			if (at.getIspublication().equals("1")) {
				at.setIspublication("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				at.setIspublication("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (at.getIsrecommend().equals("1")) {
				at.setIsrecommend("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				at.setIsrecommend("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (at.getIstop().equals("1")) {
				at.setIstop("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				at.setIstop("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			if (at.getIsnotice().equals("1")) {
				at.setIsnotice("<span class='truestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-apply.png'/></span>");
			} else {
				at.setIsnotice("<span class='falsestatue'><img width='20px' height='20px' src='../ui/assets/img/header/icon-48-deny.png'/></span>");
			}
			
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", at.getArticleid());
			cellMap.put("cell", new Object[] { at.getTitle(), at.getNname(),at.getIsnotice(), at.getIspublication(), at.getIsrecommend(), at.getIstop(), BaseTools.formateDbDate(at.getCreatetime()), "<a id='editarticle' href='article.jsp?operate=edit&folder=pagecontent&articleid=" + at.getArticleid() + "' name='editarticle'>[编辑]</a><a id='showarticle' href="+BaseTools.getBasePath()+"/"+at.getHtmlPath()+" name='showarticle'>[预览]</a>" });
			rows.add(cellMap);
		}
	}
	/**
	 * 生成文章PDF文件
	 * @return
	 * @throws Exception
	 */
	@Action(value="PDF", results = { @Result(name = "json", type = "json")})
	public  String PDF() throws Exception{		
		Document d = new Document();
		try {
			bean=this.getArticleTService().findArticleByarticleid(this.getArticleid());
			String path=ServletActionContext.getServletContext().getRealPath("");//获取根目录
			String savePath=isexistdir();
			savePath=path+savePath;
			String savePDF= savePath+bean.getTitle();
			PdfWriter.getInstance(d, new FileOutputStream(savePDF+".PDF"));
			BaseFont bf = BaseFont.createFont( "c:\\windows\\fonts\\simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			d.addAuthor("作者-alextao");
			d.open();
			d.add(new Paragraph(bean.getContentvalue(),new Font(bf)));
			d.close();
		} catch (Exception e) {
			throw e;
		} 
		return "json";
		
	}
	/**
	 * 检测目录是否存在
	 * 
	 * @return
	 */

	public static String isexistdir() {
		String nowTimeStr = "";
		String savedir = "/PDF/";
		String realpath = "";
//		SimpleDateFormat sDateFormat;
//		sDateFormat = new SimpleDateFormat("yyyyMMdd");
//		nowTimeStr = sDateFormat.format(new Date());
		String savePath = ServletActionContext.getServletContext().getRealPath("");
		savePath = savePath + savedir ;
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
			realpath = savedir ;
			return realpath;
		} else {
			realpath = savedir ;
			return realpath;
		}
	}

	
}
