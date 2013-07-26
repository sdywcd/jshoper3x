package com.jshop.action.backstage.android.elecart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.Validate;
import com.jshop.entity.TableT;
import com.jshop.service.TableTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class AndroidJshopelectronicmenuTableTAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	@Resource
	private TableTService tableTService;
	private HttpServletRequest request;
    private HttpServletResponse response;
    private int page;
    private TableT bean=new TableT();
    private String responsejsonstr;
	private String tableid;
	private String tableNumber;
	private String roomName;
	private String androidDevicesCount;
	private String note;
	private Date createtime;
	private String creatorid;
	private String nop;
	private String tablestate;
	private String floor;
	private String rnop;
    @JSON(serialize = false)
	public TableTService getTableTService() {
		return tableTService;
	}

	public void setTableTService(TableTService tableTService) {
		this.tableTService = tableTService;
	}
	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;	
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public TableT getBean() {
		return bean;
	}

	public void setBean(TableT bean) {
		this.bean = bean;
	}

	

	public String getResponsejsonstr() {
		return responsejsonstr;
	}

	public void setResponsejsonstr(String responsejsonstr) {
		this.responsejsonstr = responsejsonstr;
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

	public String getAndroidDevicesCount() {
		return androidDevicesCount;
	}

	public void setAndroidDevicesCount(String androidDevicesCount) {
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

	public String getNop() {
		return nop;
	}

	public void setNop(String nop) {
		this.nop = nop;
	}

	public String getTablestate() {
		return tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRnop() {
		return rnop;
	}

	public void setRnop(String rnop) {
		this.rnop = rnop;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	/**
	 * 查询餐桌信息反馈给手机端
	 * @throws IOException 
	 */
	@Action(value="findAllTableTforAndroid")
	public void findAllTableTforAndroid() throws IOException{
		int currentPage=page;
		int lineSize=20;
		List<TableT>list=this.getTableTService().findAllTableT(currentPage, lineSize);
		StringBuilder json=new StringBuilder();
		json.append("[");
		for(Iterator it=list.iterator();it.hasNext();){
			TableT t=(TableT)it.next();
			json.append("{");
			json.append("\"tableid\":\"").append(t.getTableid()).append("\",");
			json.append("\"tableNumber\":\"").append(t.getTableNumber()).append("\",");
			json.append("\"roomName\":\"").append(t.getRoomName()).append("\",");
			json.append("\"androidDevicesCount\":\"").append(t.getAndroidDevicesCount()).append("\",");
			json.append("\"note\":\"").append(t.getNote()).append("\",");
			json.append("\"createtime\":\"").append(BaseTools.formateDbDate(t.getCreatetime())).append("\",");
			json.append("\"nop\":\"").append(t.getNop()).append("\",");
			json.append("\"tablestate\":\"").append(t.getTablestate()).append("\",");
			json.append("\"floor\":\"").append(t.getFloor()).append("\",");
			json.append("\"rnop\":\"").append(t.getRnop()).append("\"");
			json.append("},");
		}
		json.deleteCharAt(json.length()-1);
		json.append("]");
		this.setResponsejsonstr(json.toString());
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(this.getResponsejsonstr());
		out.flush();
		out.close();
	}
	

	/**
	 * 更新餐桌使用状态
	 * @throws IOException 
	 */
	@Action(value="updateTableTtablestateBytableNoforAndroid")
	public void updateTableTtablestateBytableNo() throws IOException{
		if(Validate.StrNotNull(this.getTableid())&&Validate.StrNotNull(this.getTablestate())){
			String tableid=this.getTableid().trim();
			String tablestate=this.getTablestate().trim();
			if(this.getTableTService().updateTableTtablestateBytableNo(tableid, tablestate)>0){
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.write("success");
				out.flush();
				out.close();
			}
		}
	}
	
}
