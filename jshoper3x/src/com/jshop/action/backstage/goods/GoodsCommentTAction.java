package com.jshop.action.backstage.goods;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.GoodsCommentT;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsCommentTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.impl.Serial;

@Namespace("")
@ParentPackage("jshop")
public class GoodsCommentTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private GoodsCommentTService goodsCommentTService;
	private GoodsTService goodsTService;
	private String commentid;
	private String goodsid;
	private String goodsname;
	private String replyorcommentusername;
	private Date posttime;
	private String commentcontent;
	private Integer score;
	private String state;
	private String replyorcomment;
	private String replyid;
	private String replyorcommentuserid;
	private String emailable;
	private String userid;
	private GoodsT g = new GoodsT();
	private GoodsCommentT bean = new GoodsCommentT();
	private List<GoodsCommentT> beanlist = new ArrayList<GoodsCommentT>();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	@JSON(serialize = false)
	public GoodsCommentTService getGoodsCommentTService() {
		return goodsCommentTService;
	}

	public void setGoodsCommentTService(
			GoodsCommentTService goodsCommentTService) {
		this.goodsCommentTService = goodsCommentTService;
	}

	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getReplyorcommentusername() {
		return replyorcommentusername;
	}

	public void setReplyorcommentusername(String replyorcommentusername) {
		this.replyorcommentusername = replyorcommentusername;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReplyorcomment() {
		return replyorcomment;
	}

	public void setReplyorcomment(String replyorcomment) {
		this.replyorcomment = replyorcomment;
	}

	public String getReplyid() {
		return replyid;
	}

	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}

	public String getReplyorcommentuserid() {
		return replyorcommentuserid;
	}

	public void setReplyorcommentuserid(String replyorcommentuserid) {
		this.replyorcommentuserid = replyorcommentuserid;
	}

	public String getEmailable() {
		return emailable;
	}

	public void setEmailable(String emailable) {
		this.emailable = emailable;
	}

	public GoodsCommentT getBean() {
		return bean;
	}

	public void setBean(GoodsCommentT bean) {
		this.bean = bean;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
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

	public GoodsT getG() {
		return g;
	}

	public void setG(GoodsT g) {
		this.g = g;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public List<GoodsCommentT> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<GoodsCommentT> beanlist) {
		this.beanlist = beanlist;
	}

	/**
	 * 去除查询所有商品类别的错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加虚拟评论
	 * 
	 * @return
	 */
	@Action(value = "addvirtualGoodsComment", results = { @Result(name = "json", type = "json") })
	public String addvirtualGoodsComment() {
		if (StringUtils.isBlank(this.getGoodsid())) {
			return "json";
		}
		GoodsCommentT gct = new GoodsCommentT();
		gct.setCommentid(this.getSerial().Serialid(Serial.GOODSCOMMENT));
		gct.setGoodsid(this.getGoodsid().trim());
		gct.setGoodsname(this.getGoodsname().trim());
		gct.setReplyorcommentusername(this.getReplyorcommentusername());
		gct.setReplyorcommentuserid(BaseTools.getAdminCreateId());
		gct.setPosttime(BaseTools.systemtime());
		gct.setCommentcontent(this.getCommentcontent());
		gct.setScore(this.getScore());
		gct.setState(StaticKey.COMMENT_STATE_ONE_NUM);
		gct.setReplyorcomment(StaticKey.COMMENT_REPLY_TWO_NUM);
		gct.setReplyid(StaticKey.COMMENT_DEFAULT_REPLYID);
		gct.setEmailable(StaticKey.COMMENT_EMAILABLE_ONE_NUM);
		gct.setVirtualadd(StaticKey.COMMENT_VIRTUALADD_ONE_NUM);
		this.getGoodsCommentTService().save(gct);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 更新商品评论
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsComment", results = { @Result(name = "json", type = "json") })
	public String updateGoodsComment() {
		if (StringUtils.isBlank(this.getCommentid())) {
			return "json";
		}
		bean = this.getGoodsCommentTService().findGoodsCommentById(
				this.getCommentid());
		bean.setReplyorcommentusername(this.getReplyorcommentusername());
		bean.setReplyorcommentuserid(BaseTools.getAdminCreateId());
		bean.setCommentcontent(this.getCommentcontent());
		bean.setScore(this.getScore());
		this.getGoodsCommentTService().updateGoodsComment(bean);
		// this.setSucflag(true);
		return "json";

	}

	/**
	 * 处理商品评论迭代
	 * 
	 * @param gct
	 */
	public void ProcessGoodsCommentList(List<GoodsCommentT> gct) {
		total = this.getGoodsCommentTService().countfindAllGoodsComment();
		for (Iterator<GoodsCommentT> it = gct.iterator(); it.hasNext();) {
			GoodsCommentT gctt = (GoodsCommentT) it.next();
			gctt.setState(StaticKey.DataShowState.getName(gctt.getState()));
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gctt.getGoodsid());
			cellMap.put(
					"cell",
					new Object[] {
							gctt.getGoodsname(),
							gctt.getState(),
							"<a id='showgoodscomment' href='goodscommentlistment.jsp?operate=edit&goodsname="
									+ gctt.getGoodsname()
									+ "&goodsid="
									+ gctt.getGoodsid()
									+ "' name='showgoodscomment'>[查看详细]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 查询所有商品评论数据没有搜索条件
	 */
	public void finddefaultAllGoodsComment() {
		int currentPage = page;
		int lineSize = rp;
		List<GoodsCommentT> gct = this.getGoodsCommentTService()
				.findAllGoodsComment(currentPage, lineSize);
		if (gct != null) {
			ProcessGoodsCommentList(gct);
		}
	}

	/**
	 * 查询所有商品评论数据
	 * 
	 * @return
	 */
	@Action(value = "findAllGoodsComment", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsComment() {
		if ("sc".equals(this.getQtype())) {
			// 获取默认的所有商品评论
			this.setTotal(0);
			rows.clear();
			finddefaultAllGoodsComment();
		} else {
			return "json";
		}
		return "json";
	}

	/**
	 * 删除商品评论
	 * 
	 * @return
	 */
	@Action(value = "delGoodsComment", results = { @Result(name = "json", type = "json") })
	public String delGoodsComment() {
		if (StringUtils.isNotBlank(this.getCommentid())) {
			String[] strs = StringUtils.split(this.getCommentid(), ",");
			if (this.getGoodsCommentTService().delGoodsComment(strs) > 0) {
				this.setSucflag(true);
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 根据goodsid查询所有评论数据
	 * 
	 * @return
	 */
	@Action(value = "findAllGoodsCommentListByGoodsId", results = { @Result(name = "json", type = "json") })
	public String findAllGoodsCommentListByGoodsId() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.finddefaultAllGoodsCommentByGoodsId();
		} else {
			if (StringUtils.isBlank(this.getQuery())) {
				return "json";
			} else {

				return "json";
			}
		}
		return "json";
	}

	private void finddefaultAllGoodsCommentByGoodsId() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getGoodsCommentTService().countfindGoodsCommentByGoodsid(
				this.getGoodsid());
		List<GoodsCommentT> list = this.getGoodsCommentTService()
				.findGoodsCommentByGoodsid(this.getGoodsid(), currentPage,
						lineSize);
		ProcessGoodsCommentListByGoodsid(list);

	}

	/**
	 * 单个商品评论
	 * 
	 * @param gct
	 */
	public void ProcessGoodsCommentListByGoodsid(List<GoodsCommentT> gct) {
		total = this.getGoodsCommentTService().countfindAllGoodsComment();
		for (Iterator<GoodsCommentT> it = gct.iterator(); it.hasNext();) {
			GoodsCommentT gctt = (GoodsCommentT) it.next();
			gctt.setState(StaticKey.DataShowState.getName(gctt.getState()));
			if (gctt.getVirtualadd().equals(
					StaticKey.COMMENT_VIRTUALADD_ONE_NUM)) {
				gctt.setVirtualadd(StaticKey.COMMENT_VIRTULADD);
			} else {
				gctt.setVirtualadd(StaticKey.COMMENT_NOTVIRTULADD);
			}
			if (gctt.getReplyorcomment()
					.equals(StaticKey.COMMENT_REPLY_ONE_NUM)) {
				gctt.setReplyorcomment(StaticKey.COMMENT_REPLY_ONE);
			} else {
				gctt.setReplyorcomment(StaticKey.COMMENT_REPLY_TWO);
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", gctt.getCommentid());
			cellMap.put(
					"cell",
					new Object[] {
							gctt.getCommentcontent(),
							gctt.getReplyorcommentusername(),
							gctt.getScore(),
							gctt.getReplyorcomment(),
							gctt.getVirtualadd(),
							gctt.getState(),
							BaseTools.formateDbDate(gctt.getPosttime()),
							"<a id='goodscommentdetail' href='goodscommentdetail.jsp?operate=editdetail&commentid="
									+ gctt.getCommentid()
									+ "' name='goodscommentdetail'>[编辑]</a>" });
			rows.add(cellMap);
		}
	}

	/**
	 * 后台获取商品的详细评论数据
	 * 
	 * @return
	 */
	@Action(value = "getGoodscommentDetails", results = { @Result(name = "json", type = "json") })
	public String getGoodscommentDetails() {
		if (Validate.StrNotNull(this.getGoodsid())) {
			String goodsid = this.getGoodsid().trim();
			int currentPage = 1;
			int lineSize = 65535;
			List<GoodsCommentT> list = this.getGoodsCommentTService()
					.findGoodsCommentByGoodsid(goodsid, currentPage, lineSize);
			if (!list.isEmpty()) {
				this.setBeanlist(list);
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 更新评论或者回复的显示状态
	 * 
	 * @return
	 */
	@Action(value = "updateGoodsCommentorReplyByState", results = { @Result(name = "json", type = "json") })
	public String updateGoodsCommentorReplyByState() {
		if (Validate.StrNotNull(this.getCommentid())) {
			String[] strs = StringUtils.split(this.getCommentid().trim(), ',');
			String state = this.getState().trim();
			this.getGoodsCommentTService().updateGoodsCommentorReplyByState(
					state, strs);
			this.setSucflag(true);
			return "json";

		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 根据id获取商品评论
	 * 
	 * @return
	 */
	@Action(value = "findGoodsCommentById", results = { @Result(name = "json", type = "json") })
	public String findGoodsCommentById() {
		if (StringUtils.isBlank(this.getCommentid())) {
			return "json";
		}
		bean = this.getGoodsCommentTService().findGoodsCommentById(
				this.getCommentid());
		if (bean != null) {
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}

}
