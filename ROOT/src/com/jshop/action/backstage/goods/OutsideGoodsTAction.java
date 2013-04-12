package com.jshop.action.backstage.goods;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.OutsideGoodsT;
import com.jshop.entity.OutsidegoodsTwocodeRelationshipT;
import com.jshop.service.OutsideGoodsTService;
import com.jshop.service.OutsideGoodsTwocodeRelationshipService;
import com.opensymphony.xwork2.ActionSupport;
import com.swetake.util.Qrcode;
@Namespace("")
@ParentPackage("jshop")
public class OutsideGoodsTAction extends ActionSupport {
	private OutsideGoodsTService outsideGoodsTService; 
	private OutsideGoodsTwocodeRelationshipService outsideGoodsTwocodeRelationshipService;
	private OutsideGoodsT outside = new OutsideGoodsT();
	private Serial serial;
	private String id;
	private String goodsname;
	private String nname;
	private String lname;
	private String sname;
	private String fname;
	private String navid;
	private String ltypeid;
	private String stypeid;
	private String pictureurl;
	private String salestate;
	private int sort;
	private String linkUrl;
	private Date createtime;
	private String creatorid;
	private Date updatetime;
	private int versiont;
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean flag=false;
	@JSON(serialize=false)
	public OutsideGoodsTwocodeRelationshipService getOutsideGoodsTwocodeRelationshipService() {
		return outsideGoodsTwocodeRelationshipService;
	}
	public void setOutsideGoodsTwocodeRelationshipService(
			OutsideGoodsTwocodeRelationshipService outsideGoodsTwocodeRelationshipService) {
		this.outsideGoodsTwocodeRelationshipService = outsideGoodsTwocodeRelationshipService;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize=false)
	public OutsideGoodsTService getOutsideGoodsTService() {
		return outsideGoodsTService;
	}
	public void setOutsideGoodsTService(OutsideGoodsTService outsideGoodsTService) {
		this.outsideGoodsTService = outsideGoodsTService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
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
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public String getSalestate() {
		return salestate;
	}
	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public int getVersiont() {
		return versiont;
	}
	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
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
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public OutsideGoodsT getOutside() {
		return outside;
	}
	public void setOutside(OutsideGoodsT outside) {
		this.outside = outside;
	}
	/**
	 * 查询所有外链数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value="findAllOutsideGoods",results={@Result(name="json",type="json")})
	public String findAllOutsideGoods(){
		int currentPage =page;
		int lineSize=rp;
		total=this.getOutsideGoodsTService().countAllOutsideGoodsT();
		List<OutsideGoodsT> list=this.getOutsideGoodsTService().findAllOutsideGoodsT(lineSize, currentPage);
		rows.clear();
		if(list!=null){
			for(Iterator it =list.iterator();it.hasNext();){
			OutsideGoodsT ogt = (OutsideGoodsT) it.next();
			if(ogt.getSalestate().equals("1")){
				ogt.setSalestate("上架");
			}
			if(ogt.getSalestate().equals("0")){
				ogt.setSalestate("下架");
			}
			Map cellmap = new HashMap();
			cellmap.put("id",ogt.getId() );
			cellmap.put("cell", new Object[]{ogt.getGoodsname(),ogt.getCreatorid(),ogt.getLinkUrl(),ogt.getSalestate(),ogt.getPictureurl(),ogt.getCreatetime(),ogt.getUpdatetime()});
			rows.add(cellmap);
			}
			return "json";
		}
		return "json";
	}
	/**
	 * 增加外链商品
	 * @return
	 */
	@Action(value="addOutsideGoods",results={@Result(name="json",type="json")})
	public String addOutsideGoods(){
	
		OutsideGoodsT ogt = new OutsideGoodsT();
		ogt.setCreatetime(BaseTools.systemtime());
		ogt.setCreatorid(BaseTools.adminCreateId());
		ogt.setFname(this.getFname());
		ogt.setGoodsname(this.getGoodsname());
		ogt.setId(this.getSerial().Serialid(Serial.OUTSIDEGOODS));
		ogt.setLinkUrl(this.getLinkUrl());
		ogt.setLname(this.getLname());
		ogt.setLtypeid(this.getLtypeid());
		ogt.setNavid(this.getNavid());
		ogt.setNname(this.getNname());
		ogt.setPictureurl(this.getPictureurl());
		ogt.setSalestate(this.getSalestate());
		ogt.setSname(this.getSname());
		ogt.setSort(this.getSort());
		ogt.setStypeid(this.getStypeid());
		ogt.setUpdatetime(BaseTools.systemtime());
		ogt.setVersiont(this.getVersiont());
		ogt.setFname("四级分类");
		if(this.getOutsideGoodsTService().addOutsideGoodsT(ogt)>0){
			this.setFlag(true);
			return "json";
		}
		return "json";
	}
	/**
	 * 修改外链商品
	 * @return
	 */
	@Action(value="updateOutsidegoods",results={@Result(name="json",type="json")})
	public String updateOutsidegoods(){
		OutsideGoodsT goods=this.getOutsideGoodsTService().findOutsideGoodsTById(this.getId());
		if(goods!=null){
		OutsideGoodsT ogt = new OutsideGoodsT();
		ogt.setCreatetime(goods.getCreatetime());
		ogt.setCreatorid(BaseTools.adminCreateId());
		ogt.setGoodsname(this.getGoodsname());
		ogt.setId(this.getId());
		ogt.setLinkUrl(this.getLinkUrl());
		ogt.setLname(this.getLname());
		ogt.setLtypeid(this.getLtypeid());
		ogt.setNavid(this.getNavid());
		ogt.setNname(this.getNname());
		ogt.setPictureurl(this.getPictureurl());
		ogt.setSalestate(this.getSalestate());
		ogt.setSname(this.getSname());
		ogt.setSort(this.getSort());
		ogt.setStypeid(this.getStypeid());
		ogt.setUpdatetime(BaseTools.systemtime());
		ogt.setVersiont(this.getVersiont());
		ogt.setFname("四级分类");
		if(this.getOutsideGoodsTService().updateOutsideGoodsT(ogt)>0){
			this.setFlag(true);
			return "json";
		}
		}
		return "json";
	}
	/**
	 * 删除外链商品
	 * @return
	 */
	@Action(value="delOutsidegoods",results={@Result(name="json",type="json")})
	public String delOutsidegoods(){
		if(Validate.StrNotNull(this.getId())){
		String[] id = this.getId().split(",");
		this.getOutsideGoodsTService().delOutsideGoodsT(id);
		this.setFlag(true);
		return "json";
		}
		this.setFlag(false);
		return "json";
	}
	/**
	 * 生成商品静态路径二维码
	 * @return
	 * @throws IOException
	 */
	@Action(value="encoderOutsideQRcode",results={@Result(name="json",type="json")})
	public String encoderOutsideQRcode() throws IOException{
		OutsideGoodsT goods=new OutsideGoodsT();
		Qrcode qr =new Qrcode();
		qr.setQrcodeErrorCorrect('M');
		qr.setQrcodeEncodeMode('B');
		qr.setQrcodeVersion(7);
		BufferedImage bufImg= new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufImg.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 140,140);
		  // 设定图像颜色 > BLACK  
		gs.setColor(Color.BLACK);
		// 设置偏移量 不设置可能导致解析出错
		int pixoff=2;
		byte[] htmlPath;
		 // 根据商品id获取商品数据
			if (Validate.StrNotNull(this.getId())) {
				goods = this.getOutsideGoodsTService().findOutsideGoodsTById(this.getId().trim());
				
				if (goods != null) {					
					//HttpServletRequest requet=ServletActionContext.getRequest();
					String Path=goods.getLinkUrl();
					 htmlPath=Path.getBytes("utf-8");
					 // 输出内容 > 二维码  
					if(htmlPath.length>0 && htmlPath.length<120){
						boolean[][] codeOut=qr.calQrcode(htmlPath);
						for(int i=0;i<codeOut.length;i++){
							for(int j=0;j<codeOut.length;j++){
								if(codeOut[j][i]){
									gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
								}
							}
						}
					}
					gs.dispose();
					bufImg.flush();
					String jshoppath=ServletActionContext.getServletContext().getRealPath("");//获取根目录
					String path=jshoppath+isexistdir();
					//根目录路径
					String codePath=path+goods.getId()+".png";
					//文件夹路径
					String code = isexistdir()+goods.getId()+".png";
					//生成二维码图片名称
					File imgFile= new File(codePath);
					// 生成二维码QRCode图片
					ImageIO.write(bufImg, "png", imgFile);
					OutsidegoodsTwocodeRelationshipT list = this.getOutsideGoodsTwocodeRelationshipService().findGoodsQRCodeByGoodsid(goods.getId());
					OutsidegoodsTwocodeRelationshipT goodscode = new OutsidegoodsTwocodeRelationshipT();
					//当数据里面存在此记录的时候，只修改二维码路径
					if(list!=null){						
						this.getOutsideGoodsTwocodeRelationshipService().updateGoodsQRCode(goods.getId(), code);
						this.setFlag(true);
						return "json";
					}else{
						//生成商品与二维码关系的记录
						
						goodscode.setGoodsname(goods.getGoodsname());
						goodscode.setGoodsid(this.getSerial().Serialid(Serial.OUTSIDEGOODSQRCODE));
						goodscode.setId(goods.getId());
						goodscode.setState("1");
						goodscode.setTwocodepath(code);
						this.getOutsideGoodsTwocodeRelationshipService().addGoodsQRCode(goodscode);
						
						this.setFlag(true);
						return "json";
					}
				}
				
			}
//			else{
//				htmlPath=this.getOtherPath().getBytes("utf-8");	
//					 // 输出内容 > 二维码  
//					if(htmlPath.length>0 && htmlPath.length<120){
//						boolean[][] codeOut=qr.calQrcode(htmlPath);
//						for(int i=0;i<codeOut.length;i++){
//							for(int j=0;j<codeOut.length;j++){
//								if(codeOut[j][i]){
//									gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
//								}
//							}
//						}
//				}
//				gs.dispose();
//				bufImg.flush();
//				String jshoppath=ServletActionContext.getServletContext().getRealPath("");//获取根目录
//				String path=jshoppath+isexistdir();
//				//生成二维码图片名称
//				File imgFile= new File(path+this.getPathName()+".png");
//				// 生成二维码QRCode图片
//				ImageIO.write(bufImg, "png", imgFile);
//				
//				this.setFlag(true);
//				return "json";
//			}
			return "json";
	}
	/**
	 * 检测目录是否存在
	 * 
	 * @return
	 */

	public static String isexistdir() {
		String nowTimeStr = "";
		String savedir = "/outsideQRcode/";
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
	/**
	 * 根据id获取数据
	 * @return
	 */
	@Action(value="findOutsideGoodsByid",results={@Result(name="json",type="json")})
	public String findOutsideGoodsByid(){
		if(Validate.StrNotNull(this.getId())){
			 outside = this.getOutsideGoodsTService().findOutsideGoodsTById(this.getId());
			if(outside!=null){
				this.setFlag(true);
				return "json";
			}
			this.setFlag(false);
			return "json";
		}
		
		return "json";
	}
	
	
}
