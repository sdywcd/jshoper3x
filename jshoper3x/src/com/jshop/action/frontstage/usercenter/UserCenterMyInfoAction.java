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
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.action.backstage.tools.UtilCommon;
import com.jshop.entity.MemberT;
import com.jshop.entity.UserT;
import com.jshop.service.MemberTService;
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
	private MemberTService memberTService;
	private DataCollectionTAction dataCollectionTAction;
	private String id;
	private String loginname;
	private String loginpwd;
	private String nick;
	private String realname;
	private String city;
	private String district;
	private String sex;
	private String whichsex;
	private String merrystatus;
	private String birthday;
	private String blood;
	private String constellation;
	private String des;
	private String email;
	private String qq;
	private String weixin;
	private String sinaweibo;
	private String tag;
	private Integer belove;
	private Integer loveother;
	private Integer postingcount;
	private String question;
	private String answer;
	private String memberstate;
	private Date createtime;
	private String creatorid;
	private Date updatetime;
	private String mobile;
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
	private MemberT bean= new MemberT();
	private boolean sucflag;
	@JSON(serialize=false)
	public MemberTService getMemberTService() {
		return memberTService;
	}

	public void setMemberTService(MemberTService memberTService) {
		this.memberTService = memberTService;
	}

	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
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

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWhichsex() {
		return whichsex;
	}

	public void setWhichsex(String whichsex) {
		this.whichsex = whichsex;
	}

	public String getMerrystatus() {
		return merrystatus;
	}

	public void setMerrystatus(String merrystatus) {
		this.merrystatus = merrystatus;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getSinaweibo() {
		return sinaweibo;
	}

	public void setSinaweibo(String sinaweibo) {
		this.sinaweibo = sinaweibo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getBelove() {
		return belove;
	}

	public void setBelove(Integer belove) {
		this.belove = belove;
	}

	public Integer getLoveother() {
		return loveother;
	}

	public void setLoveother(Integer loveother) {
		this.loveother = loveother;
	}

	public String getMemberstate() {
		return memberstate;
	}

	public void setMemberstate(String memberstate) {
		this.memberstate = memberstate;
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

	public MemberT getBean() {
		return bean;
	}

	public void setBean(MemberT bean) {
		this.bean = bean;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
	@Action(value = "findMemberInfo", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/memberbasicinfo.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String findMemberInfo(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if(memberT!=null){
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
	
	@Action(value = "updateMemberforMyInfo", results = { 
			@Result(name = "success",type="chain",location = "findMemberInfo"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String updateMemberforMyInfo(){
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		if(memberT!=null){
			MemberT m=new MemberT();
			m.setId(memberT.getId());
			m.setLoginname(memberT.getLoginname());
			m.setNick(this.getNick().trim());
			m.setRealname(this.getRealname().trim());
			m.setCity(this.getCity().trim());
			m.setDistrict(this.getDistrict().trim());
			m.setSex(this.getSex());
			m.setWhichsex(this.getWhichsex());
			m.setMerrystatus(this.getMerrystatus());
			m.setBirthday(this.getBirthday().trim());
			m.setBlood(this.getBlood());
			m.setConstellation(this.getConstellation());
			m.setDes(this.getDes());
			m.setEmail(this.getEmail());
			m.setQq(this.getQq());
			m.setWeixin(this.getWeixin());
			m.setSinaweibo(this.getSinaweibo());
			m.setTag(this.getTag());
			m.setBelove(memberT.getBelove());
			m.setLoveother(memberT.getLoveother());
			m.setPostingcount(memberT.getPostingcount());
			m.setQuestion(memberT.getQuestion());
			m.setAnswer(memberT.getAnswer());
			m.setMemberstate(memberT.getMemberstate());
			m.setHeadpath(this.getHeadpath().trim());
			m.setCreatetime(memberT.getCreatetime());
			m.setCreatorid(memberT.getCreatorid());
			m.setUpdatetime(BaseTools.systemtime());
			m.setMobile(this.getMobile().trim());
			m.setVersiont(memberT.getVersiont()+1);
			m.setMid(memberT.getMid());
			this.getMemberTService().updateMemberT(m);
			return SUCCESS;
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
                MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
        		if(memberT!=null){
        			memberT.setHeadpath(headpath);
        			memberT.setId(memberT.getId());
        			this.getMemberTService().updateMemberHeadpathByid(memberT);
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
	@Action(value = "findMemberHeadById", results = { @Result(name = "json", type = "json") })
	public String findMemberHeadById() {
		MemberT memberT=(MemberT)ActionContext.getContext().getSession().get(StaticString.MEMBER_SESSION_KEY);
		bean = this.getMemberTService().findMemberTById(memberT.getId());
			if (bean != null) {
				this.setSucflag(true);
				return "json";
			}
		return "json";
	}
	
	
}
