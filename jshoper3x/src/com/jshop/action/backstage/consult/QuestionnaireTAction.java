package com.jshop.action.backstage.consult;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.QuestionnaireT;
import com.jshop.service.QuestionnaireTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class QuestionnaireTAction extends ActionSupport {

	private QuestionnaireTService questionnaireTService;
	private Serial serial;
	private String qid;
	private String question;
	private String choosetag;
	private String answer;
	private String inputtype;
	private String state;
	private int statistics;
	private String goodsid;
	private Date createtime;
	private String creatorid;
	private int versiont;
	private String title;
	private QuestionnaireT bean=new QuestionnaireT();
	private List<QuestionnaireT>beanlist=new ArrayList<QuestionnaireT>();
	private List rows=new ArrayList();
	private String query;//text
	private String qtype;//select
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;
	
	
	
	@JSON(serialize = false)
	public QuestionnaireTService getQuestionnaireTService() {
		return questionnaireTService;
	}
	public void setQuestionnaireTService(QuestionnaireTService questionnaireTService) {
		this.questionnaireTService = questionnaireTService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChoosetag() {
		return choosetag;
	}
	public void setChoosetag(String choosetag) {
		this.choosetag = choosetag;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getInputtype() {
		return inputtype;
	}
	public void setInputtype(String inputtype) {
		this.inputtype = inputtype;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getStatistics() {
		return statistics;
	}
	public void setStatistics(int statistics) {
		this.statistics = statistics;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
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
	public int getVersiont() {
		return versiont;
	}
	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
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
	public QuestionnaireT getBean() {
		return bean;
	}
	public void setBean(QuestionnaireT bean) {
		this.bean = bean;
	}
	public List<QuestionnaireT> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<QuestionnaireT> beanlist) {
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
	 * 增加问卷信息
	 * @return
	 */
	@Action(value = "addQuestionnaireT", results = { 
			@Result(name = "json",type="json")
	})
	public String addQuestionnaireT(){
		QuestionnaireT qt=new QuestionnaireT();
		qt.setQid(this.getSerial().Serialid(Serial.QUESTIONNAIRET));
		qt.setQuestion(this.getQuestion().trim());
		qt.setChoosetag(this.getChoosetag().trim());
		qt.setAnswer(this.getAnswer().trim());
		qt.setInputtype(this.getInputtype().trim());
		qt.setState("1");
		qt.setStatistics(0);
		qt.setGoodsid("0");
		qt.setCreatetime(BaseTools.systemtime());
		qt.setCreatorid(BaseTools.adminCreateId());
		qt.setVersiont(0);
		qt.setTitle(this.getTitle().trim());
		if(this.getQuestionnaireTService().addQuestionnaireT(qt)>0){
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	@Action(value = "findAllQuestionnaireT", results = { @Result(name = "json", type = "json", params = { "excludeNullProperties", "true" }) })
	public String findAllQuestionnaireT(){
		if("sc".equals(this.getQtype())){
			finddefaultAllQuestionnaireT();
		}else{
			if(Validate.StrisNull(this.getQtype())){
				return "json";
			}else{
				return "json";
			}
		}
		return "json";
	}
	
	
	private void finddefaultAllQuestionnaireT(){
		int currentPage=page;
		int lineSize=rp;
		List<QuestionnaireT>list=this.getQuestionnaireTService().findAllQuestionnaireT(currentPage, lineSize);
		if(!list.isEmpty()){
			ProcessQuestionnaire(list);
		}
		
	}
	
	private void ProcessQuestionnaire(List<QuestionnaireT>list){
		total=this.getQuestionnaireTService().countfindAllQuestionnaireT();
		rows.clear();
		for(Iterator it=list.iterator();it.hasNext();){
			QuestionnaireT qt=(QuestionnaireT)it.next();
			if(qt.getState().equals("1")){
				qt.setState("<span class='truestatue'><img src='../images/base_right_icon.gif'/></span>");
			}else{
				qt.setState("<span class='falsestatue'><img src='../images/base_wrong_icon.gif'/></span>");
			}
			Map<String,Object> cellMap=new HashMap<String,Object>();
			cellMap.put("id", qt.getQid());
			cellMap.put("cell", new Object[]{
				qt.getTitle(),
				qt.getQuestion(),
				qt.getChoosetag(),
				qt.getAnswer(),
				qt.getCreatetime()
			});
			rows.add(cellMap);
		}
	}
	
	@Action(value = "findQuestionnaireTByqid", results = { @Result(name = "json", type = "json") })
	public String findQuestionnaireTByqid(){
		if(Validate.StrNotNull(this.getQid())){
			String qid=this.getQid().trim();
			bean=this.getQuestionnaireTService().findQuestionnaireTByqid(qid);
			if(bean!=null){
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
	@Action(value = "updateQuestionnaireT", results = { @Result(name = "json", type = "json") })
	public String updateQuestionnaireT(){
		bean=this.getQuestionnaireTService().findQuestionnaireTByqid(this.getQid());
		if(bean!=null){
			QuestionnaireT qt=new QuestionnaireT();
			qt.setQid(this.getQid());
			qt.setQuestion(this.getQuestion().trim());
			qt.setChoosetag(this.getChoosetag().trim());
			qt.setAnswer(this.getAnswer().trim());
			qt.setInputtype(this.getInputtype().trim());
			qt.setState("1");
			qt.setStatistics(bean.getStatistics());
			qt.setGoodsid(bean.getGoodsid());
			qt.setCreatetime(bean.getCreatetime());
			qt.setCreatorid(BaseTools.adminCreateId());
			qt.setVersiont(bean.getVersiont());
			qt.setTitle(this.getTitle().trim());
			if(this.getQuestionnaireTService().updateQuestionnaireT(qt)>0){
				this.setSucflag(true);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}
	
	@Action(value = "delQuestionnaireTByqid", results = { @Result(name = "json", type = "json") })
	public String delQuestionnaireTByqid(){
		if(Validate.StrNotNull(this.getQid())){
			String []strs=StringUtils.split(this.getQid(), ',');
			this.getQuestionnaireTService().delQuestionnaireTByqid(strs);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	
}
