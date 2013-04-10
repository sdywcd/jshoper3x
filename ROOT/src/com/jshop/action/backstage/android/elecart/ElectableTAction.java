package com.jshop.action.backstage.android.elecart;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

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
import com.jshop.entity.TableT;
import com.jshop.service.TableTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class ElectableTAction extends ActionSupport {
	@Resource
	private TableTService tableTService;
	@Resource
	private Serial serial;
	private TableT bean = new TableT();
	private String tableid;
	private String tableNumber;
	private String roomName;
	private String tabletstrs;
	private Integer androidDevicesCount;
	private String note;
	private Date createtime;
	private String creatorid;
	private Integer nop;
	private String tablestate;
	private Integer floor;
	private Integer rnop;
	private String query;
	private String qtype;
	private List rows = new ArrayList();
	private boolean slogin;
	private boolean sucflag;
	private int rp;
	private int page = 1;
	private int total = 0;
	
	
	
	@JSON(serialize = false)
	public TableTService getTableTService() {
		return tableTService;
	}
	public void setTableTService(TableTService tableTService) {
		this.tableTService = tableTService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public String getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getAndroidDevicesCount() {
		return androidDevicesCount;
	}
	public void setAndroidDevicesCount(Integer androidDevicesCount) {
		this.androidDevicesCount = androidDevicesCount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public Integer getNop() {
		return nop;
	}
	public void setNop(Integer nop) {
		this.nop = nop;
	}
	public String getTablestate() {
		return tablestate;
	}
	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getRnop() {
		return rnop;
	}
	public void setRnop(Integer rnop) {
		this.rnop = rnop;
	}
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
	
	public String getTabletstrs() {
		return tabletstrs;
	}
	public void setTabletstrs(String tabletstrs) {
		this.tabletstrs = tabletstrs;
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
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	public TableT getBean() {
		return bean;
	}
	public void setBean(TableT bean) {
		this.bean = bean;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 获取所有餐桌
	 */
	@Action(value = "findAllTableT", results = { @Result(name = "json", type = "json") })
	public String findAllTableT(){
		if (this.getQtype().equals("sc")){
			this.setTotal(0);
			rows.clear();
			this.findDefaultAllTableT();
		}else{
			if(Validate.StrisNull(this.getQuery())){
				return "json";
			}else{
				return "json";
			}
		}			
		return "json";
	}
	
	public void findDefaultAllTableT(){
		int currentPage = page;
		int lineSize = rp;
		this.setTotal(this.getTableTService().countfindAllTableT());
		List<TableT> list = this.getTableTService().findAllTableT(currentPage, lineSize);
		if(list != null){
			this.ProcessTableTList(list);
		}
	}
	
	public void ProcessTableTList(List<TableT> list){
		rows.clear();
		for (Iterator it = list.iterator(); it.hasNext();){
			TableT tt = (TableT) it.next();
			//if("0".equals(tt.get))
			if("0".equals(tt.getTablestate())){
				tt.setTablestate("<div style='background:green;height:10px'>空</div>");
			}else{
				tt.setTablestate("<div style='background:red;height:10px'>使用中</div>");
			}
			Map<String,Object> cellMap = new HashMap<String,Object>();
			cellMap.put("id", tt.getTableid());
			cellMap.put("cell", new Object[]{tt.getTableNumber(),tt.getRoomName(),tt.getFloor(),tt.getTablestate(),BaseTools.formateDbDate(tt.getCreatetime()),tt.getCreatorid(),tt.getNop(),tt.getRnop(),tt.getNote(),tt.getAndroidDevicesCount()});
			rows.add(cellMap);
		}
	}
	
	/**
	 * 增加餐桌
	 */
	@Action(value = "addTableT", results = { @Result(name = "json", type = "json") })
	public String addTableT(){
		
		if(Validate.StrisNull(this.getTableNumber()) && Validate.StrisNull(this.getRoomName())){
			this.setSucflag(false);
			return "json";
		}
		TableT tt = new TableT();
		tt.setTableid(this.getSerial().Serialid(Serial.ELECTABLE));
		tt.setTableNumber(this.getTableNumber().trim());
		tt.setRoomName(this.getRoomName().trim());
		tt.setFloor(this.getFloor());
		tt.setNop(this.getNop());
		tt.setCreatetime(BaseTools.systemtime());
		tt.setCreatorid(BaseTools.adminCreateId());
		tt.setTablestate("0");

		if(this.getTableTService().addTableT(tt)>0){
			this.setSucflag(true);
			return "json";
		}else{
			this.setSucflag(false);
			return "json";
		}
	}
	/**
	 * 更新餐桌
	 * @return
	 */
	@Action(value = "updateTableT", results = { @Result(name = "json", type = "json") })
	public String updateTableT(){
		if(Validate.StrisNull(this.getTableid()) && Validate.StrisNull(this.getTableNumber()) && Validate.StrisNull(this.getRoomName())){
			this.setSucflag(false);
			return "json";
		}
		if(this.getTableTService().findTableBytableid(this.getTableid())!=null){
			TableT tt = new TableT();
			tt.setTableid(this.getTableid());
			tt.setTableNumber(this.getTableNumber());
			tt.setRoomName(this.getRoomName());
			tt.setFloor(this.getFloor());
			tt.setNop(this.getNop());
			tt.setNote(this.getNote());
			tt.setCreatetime(BaseTools.systemtime());
			tt.setCreatorid(BaseTools.adminCreateId());
			tt.setTablestate(this.getTablestate());
			
			this.getTableTService().updateTableT(tt);
			this.setSucflag(true);
			return "json";
		}else{
			this.setSucflag(false);
			return "json";
		}
	}
	/**
	 * 获取所有餐桌信息
	 */
	@Action(value = "getAllTableT", results = { @Result(name = "json", type = "json") })
	public String getAllTableT(){
		List<TableT> list = this.getTableTService().findAllTableT();
		if(list!=null){
			this.setTabletstrs("");
			this.setTabletstrs("<option value='-1'>---请选择---</option>");
			for(Iterator it =list.iterator(); it.hasNext();){
				TableT tt = (TableT) it.next();
				this.tabletstrs += "<input id='"+tt.getTableid()+"' value='" +tt.getTableNumber()+"' />";
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
	/**
	 * 通过ID获取某个餐桌信息
	 * @return
	 */
	@Action(value = "findTableBytableid", results = { @Result(name = "json" ,type="json") })
	public String findTableBytableid(){
		if(Validate.StrNotNull(this.getTableid())){
			bean = this.getTableTService().findTableBytableid(this.getTableid());
			if(bean !=null){
				return "json";
			}
		}
		return "json";
	}
	/**
	 * 根据ID删除选择的餐桌
	 * @return
	 */
	@Action(value = "delTableT", results = { @Result(name = "json" ,type="json") })
	public String delTableT(){
		if(Validate.StrNotNull(this.getTableid())){
			String[] strs = this.getTableid().trim().split(",");
			int delconfirm =  this.getTableTService().delTableT(strs);
			if(delconfirm>0){
				this.setSucflag(true);
				return "json";
			}else{
				this.setSucflag(false);
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 根据餐桌id改变状态
	 * @return
	 */
	@Action(value = "updateTableTtablestateBytableNo", results = { @Result(name = "json" ,type="json") })
	public String updateTableTtablestateBytableNo(){
		if(Validate.StrNotNull(this.getTableid()) && Validate.StrNotNull(this.getTablestate())){
			String []strs=StringUtils.split(this.getTableid(), ',');
			for(String s:strs){
				@SuppressWarnings("unused")
				int i = this.getTableTService().updateTableTtablestateBytableNo(s, this.getTablestate());
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}
}
