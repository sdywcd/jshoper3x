package com.jshop.action.backstage.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.Arith;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.MemberRechargeT;
import com.jshop.service.MemberRechargeRecordsTService;
import com.jshop.service.MemberRechargeTService;
import com.jshop.service.impl.Serial;
@Namespace("")
@ParentPackage("jshop")
public class MemberRechargeTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private MemberRechargeRecordsTService memberRechargeRecordsTService;
	private MemberRechargeTService memberRechargeTService;
	private String id;
	private String memberid;
	private String membername;
	private double balance;
	private double money;
	private String type;
	private String operatetype;//操作类型加法还是减法
	private List<Map<String,Object>> rows=new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean sucflag;

	@JSON(serialize = false)
	public MemberRechargeRecordsTService getMemberRechargeRecordsTService() {
		return memberRechargeRecordsTService;
	}
	public void setMemberRechargeRecordsTService(
			MemberRechargeRecordsTService memberRechargeRecordsTService) {
		this.memberRechargeRecordsTService = memberRechargeRecordsTService;
	}
	@JSON(serialize = false)
	public MemberRechargeTService getMemberRechargeTService() {
		return memberRechargeTService;
	}
	public void setMemberRechargeTService(
			MemberRechargeTService memberRechargeTService) {
		this.memberRechargeTService = memberRechargeTService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	public String getOperatetype() {
		return operatetype;
	}
	public void setOperatetype(String operatetype) {
		this.operatetype = operatetype;
	}
	
	public List<Map<String, Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 首次增加充值账户余额
	 * @return
	 */
	@Action(value = "saveMemberRechargeRecordsT", results = { @Result(name = "json", type = "json") })
	public String saveMemberRechargeRecordsT(){
		if(StringUtils.isBlank(String.valueOf(this.getBalance()))){
			return "json";
		}
		if(StringUtils.isBlank(this.getMemberid())){
			return "json";
		}
		MemberRechargeT mrt=new MemberRechargeT();
		mrt=this.getMemberRechargeTService().findMemberRechargeTByMemberId(this.getMemberid().trim());
		if(mrt!=null){
			double mbalance=0.0;
			//如果是增加余额
			if(StaticKey.ONE.equals(this.getOperatetype())){
				//1加法
				mbalance=Arith.add(mrt.getBalance(), this.getBalance());
			}else{
				//减法
				mbalance=Arith.sub(mrt.getBalance(), this.getBalance());
			}
			mrt.setMemberid(this.getMemberid());
			mrt.setMembername(this.getMembername());
			mrt.setBalance(mbalance);
			mrt.setUpdatetime(BaseTools.systemtime());
			mrt.setVersiont(mrt.getVersiont()+1);
			this.getMemberRechargeTService().updateMemberRechargeT(mrt);
			this.setSucflag(true);
			return "json";
		}else{
			MemberRechargeT mrtt=new MemberRechargeT();
			mrtt.setId(this.getSerial().Serialid(Serial.MEMBERRECHARGET));
			mrtt.setMemberid(this.getMemberid());
			mrtt.setMembername(this.getMembername());
			mrtt.setBalance(this.getBalance());
			mrtt.setCreatetime(BaseTools.systemtime());
			mrtt.setUpdatetime(mrtt.getCreatetime());
			mrtt.setVersiont(0);
			this.getMemberRechargeTService().save(mrtt);
			this.setSucflag(true);
			return "json";
		}
		
	}
	
	/**
	 * 查询所有会员充值账户余额
	 * @return
	 */
	@Action(value = "findAllMemberRechargeT", results = {@Result(name = "json",type="json")})
	public String findAllMemberRechargeT(){
		if(StaticKey.SC.equals(this.getQtype())){
			this.findDefaultAllMemberRechargeT();
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return "json";
			}else{
				return "json";
			}
		}
		return "json";
	}
	private void findDefaultAllMemberRechargeT() {
		int currentPage=page;
		int lineSize=rp;
		total=this.getMemberRechargeTService().countfindAllMemberRechargeT();
		List<MemberRechargeT>list=this.getMemberRechargeTService().findAllMemberRechargeT(currentPage, lineSize);
		if(!list.isEmpty()){
			this.processMemberRechargeTList(list);
		}
	}
	
	private void processMemberRechargeTList(List<MemberRechargeT> list) {
		for(Iterator<MemberRechargeT> it=list.iterator();it.hasNext();){
			MemberRechargeT mrt=(MemberRechargeT) it.next();
			Map<String,Object>cellMap=new HashMap<String,Object>();
			cellMap.put("id", mrt.getMemberid());
			cellMap.put("cell", new Object[]{
				mrt.getMembername(),
				mrt.getBalance(),
				BaseTools.formateDbDate(mrt.getCreatetime()),
				BaseTools.formateDbDate(mrt.getUpdatetime())
			});
			rows.add(cellMap);
		}
		
	}
	
	
	
}
