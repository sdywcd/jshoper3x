package com.jshop.action.frontstage.usercenter;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.image.ImgTAction;
import com.jshop.action.backstage.template.DataCollectionTAction;
import com.jshop.action.backstage.template.FreeMarkervariable;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.UtilCommon;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class UserCenterMyInfoAction extends ActionSupport implements  
ServletResponseAware {
	private UsertService usertService;
	private DataCollectionTAction dataCollectionTAction;
	private String userid;
	private String username;
	private String realname;
	private String email;
	private String telno;
	private String mobile;
	private String question;
	private String answer;
	private String password;
	private String userstate;
	private Double points;
	private Integer postingcount;
	private String sex;
	private Date registtime;
	private Date disablebegin;
	private Date disableend;
	private String section;
	private String position;
	private String groupid;
	private String parttime1;
	private String parttime2;
	private String parttime3;
	private String parttime4;
	private String parttime5;
	private String parttime6;
	private String hobby;
	private String qq;
	private String msn;
	private String othercontract;
	private String address;
	private String postcode;
	private String birthday;
	private String grade;
	private Date gradetime;
	private String state;
	private String headpath;
	private File fileupload; // 和JSP中input标记name同名  
    private String imageUrl;  
    private String attachmentUrl;  
    private String fileRealName;  
    private HttpServletResponse response;  
    // Struts2拦截器获得的文件名,命名规则，File的名字+FileName  
    // 如此处为 'fileupload' + 'FileName' = 'fileuploadFileName'  
    private String fileuploadFileName; // 上传来的文件的名字  
	private UserT head= new UserT();
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	@JSON(serialize=false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Integer getPostingcount() {
		return postingcount;
	}

	public void setPostingcount(Integer postingcount) {
		this.postingcount = postingcount;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getRegisttime() {
		return registtime;
	}

	public void setRegisttime(Date registtime) {
		this.registtime = registtime;
	}

	public Date getDisablebegin() {
		return disablebegin;
	}

	public void setDisablebegin(Date disablebegin) {
		this.disablebegin = disablebegin;
	}

	public Date getDisableend() {
		return disableend;
	}

	public void setDisableend(Date disableend) {
		this.disableend = disableend;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getParttime1() {
		return parttime1;
	}

	public void setParttime1(String parttime1) {
		this.parttime1 = parttime1;
	}

	public String getParttime2() {
		return parttime2;
	}

	public void setParttime2(String parttime2) {
		this.parttime2 = parttime2;
	}

	public String getParttime3() {
		return parttime3;
	}

	public void setParttime3(String parttime3) {
		this.parttime3 = parttime3;
	}

	public String getParttime4() {
		return parttime4;
	}

	public void setParttime4(String parttime4) {
		this.parttime4 = parttime4;
	}

	public String getParttime5() {
		return parttime5;
	}

	public void setParttime5(String parttime5) {
		this.parttime5 = parttime5;
	}

	public String getParttime6() {
		return parttime6;
	}

	public void setParttime6(String parttime6) {
		this.parttime6 = parttime6;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getOthercontract() {
		return othercontract;
	}

	public void setOthercontract(String othercontract) {
		this.othercontract = othercontract;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getGradetime() {
		return gradetime;
	}

	public void setGradetime(Date gradetime) {
		this.gradetime = gradetime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHeadpath() {
		return headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}

	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public String getFileRealName() {
		return fileRealName;
	}

	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public UserT getHead() {
		return head;
	}

	public void setHead(UserT head) {
		this.head = head;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 根据用户id获取用户信息
	 * @return
	 */
	@Action(value = "findUserInfo", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/memberbasicinfo.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String findUserInfo(){
		UserT user=(UserT)ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(user!=null){
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
			return SUCCESS;
		}
		return INPUT;
	}
	
	
	/**
	 * 更新用户更新自己的资料
	 * @return
	 */
	
	@Action(value = "updateUserforMyInfo", results = { 
			@Result(name = "success",type="chain",location = "findUserInfo"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String updateUserforMyInfo(){
		UserT user=(UserT)ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(user!=null){
			UserT u1=new UserT();
			u1.setHeadpath(this.getHeadpath());
			u1.setUserid(user.getUserid());
			u1.setUsername(user.getUsername());
			u1.setRealname(this.getRealname().trim());
			u1.setEmail(user.getEmail());
			u1.setTelno(this.getTelno().trim());
			u1.setMobile(this.getMobile().trim());
			u1.setQuestion(user.getQuestion());
			u1.setAnswer(user.getAnswer());
			u1.setPassword(user.getPassword());
			u1.setUserstate(user.getUserstate());
			u1.setPoints(user.getPoints());
			u1.setPostingcount(user.getPostingcount());
			u1.setSex(this.getSex().trim());
			u1.setRegisttime(user.getRegisttime());
			u1.setDisablebegin(user.getDisablebegin());
			u1.setDisableend(user.getDisableend());
			u1.setSection(user.getSection());
			u1.setPosition(user.getPosition());
			u1.setGroupid(user.getGroupid());
			u1.setParttime1(user.getParttime1());
			u1.setParttime2(user.getParttime2());
			u1.setParttime3(user.getParttime3());
			u1.setParttime4(user.getParttime4());
			u1.setParttime5(user.getParttime5());
			u1.setParttime6(user.getParttime6());
			u1.setHobby(this.getHobby().trim());
			u1.setQq(this.getQq().trim());
			u1.setMsn(this.getMsn().trim());
			u1.setOthercontract(this.getOthercontract().trim());
			u1.setAddress(this.getAddress().trim());
			u1.setPostcode(this.getPostcode().trim());
			u1.setBirthday(this.getBirthday());
			u1.setGrade(user.getGrade());
			u1.setGradetime(user.getGradetime());
			u1.setState(user.getState());
			u1.setUid(user.getUid());
			u1.setRolemid(user.getRolemid());
			if(this.getUsertService().updateUserforMyInfo(u1)>0){
				return SUCCESS;
			}else{
				return INPUT;
			}
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 上传图片
	 */
	@Action(value="uploadFile", results={ @Result(name = "success",type="redirect",location = "findUserInfo")})
    public String  uploadFile() {  
        String extName = ""; // 保存文件拓展名  
        String newFileName = ""; // 保存新的文件名  
        String nowTimeStr = ""; // 保存当前时间  
        String path="";//根据当天日期创建文件，保存图片
        PrintWriter out = null;  
        SimpleDateFormat sDateFormat;  
        Random r = new Random();  
        String savePath = ServletActionContext.getServletContext().getRealPath(""); // 获取项目根路径  
        ImgTAction imgTAction = new ImgTAction();
        path =imgTAction.isexistdir();
        savePath = savePath + path;  
        HttpServletResponse response = ServletActionContext.getResponse();  
        response.setCharacterEncoding("UTF-8"); // 务必，防止返回文件名是乱码  
        // 生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）  
        int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数  
        sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 时间格式化的格式  
        nowTimeStr = sDateFormat.format(new Date()); // 当前时间  
        // 获取拓展名  
        if(fileuploadFileName!=null){
        if (fileuploadFileName.lastIndexOf(".") >= 0) {  
            extName = fileuploadFileName.substring(fileuploadFileName.lastIndexOf("."));  
        }  
       
        try {  
            out = response.getWriter();  
            newFileName = nowTimeStr + rannum + extName; // 文件重命名后的名字  
            String filePath = savePath + newFileName;  
            String headpath =path + newFileName;
            filePath = filePath.replace("//", "/");  
            //检查上传的是否是图片  
            if (UtilCommon.checkIsImage(extName)) {  
                FileUtils.copyFile(fileupload, new File(filePath));  
                UserT user=(UserT)ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
        		if(user!=null){
        			UserT  u= new UserT();
        			u.setHeadpath(headpath);
        			u.setUserid(user.getUserid());
        			this.getUsertService().updateUserHeadPathByUserId(u);
        		}
        		
              // out.print("<font color='red'>" + fileuploadFileName   + "上传成功!</font>#" + filePath + "#" + fileuploadFileName);  
               return SUCCESS;
            } else {  
            //	out.print("<font color='red'>上传的文件类型错误，请选择jpg,jpeg,png和gif格式的图片!</font>");  
            }  
            out.flush();  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
      //   out.print("上传失败，出错啦!");  
        }  
        }
        return SUCCESS;
       
    }  
    //图片预览 
//    public String showImage() throws Exception {  
//        // 根据图片地址构造file对象  
//        File file = new File(imageUrl);  
//        InputStream is = new FileInputStream(file);  
//        Image image = ImageIO.read(is);// 读图片  
//        String imageType = imageUrl.substring(imageUrl.lastIndexOf(".") + 1);  
//        RenderedImage img = (RenderedImage) image;  
//        OutputStream out = response.getOutputStream();  
//        ImageIO.write(img, imageType, out);  
//        out.flush();  
//        out.close();  
//        return null;  
//    }

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}  
	/**
	 * 根据用户id获取用户头像
	 * 
	 * @return
	 */
	@Action(value = "findUserHeadById", results = { @Result(name = "json", type = "json") })
	public String findUserHeadById() {
		UserT user=(UserT)ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		
		 head = this.getUsertService().findById(user.getUserid());
			if (head != null) {				
				return "json";
			}
		
		return "json";
	}
	
	
}
