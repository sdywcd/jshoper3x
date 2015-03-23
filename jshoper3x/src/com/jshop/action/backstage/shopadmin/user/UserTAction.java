package com.jshop.action.backstage.shopadmin.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jshop.action.backstage.authority.UserRoleMAction;
//import com.jshop.action.backstage.authority.UserRoleMAction;
import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.base.DataCollectionTAction;
import com.jshop.action.backstage.base.InitTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.MD5Code;
import com.jshop.action.backstage.utils.enums.BaseEnums;
import com.jshop.action.backstage.utils.enums.BaseEnums.UserType;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.jshop.entity.FunctionM;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.OrderT;
//import com.jshop.entity.FunctionM;
//import com.jshop.entity.OrderT;
import com.jshop.entity.UserT;
import com.jshop.service.GlobalParamService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.UserRoleMService;
import com.jshop.service.UsertService;
import com.jshop.service.impl.Serial;
import com.opensymphony.xwork2.ActionContext;

@Namespace("/shopadmin")
@ParentPackage("jshop")
public class UserTAction extends BaseTAction {
	private static final long serialVersionUID = 1L;
	@Resource
	private UsertService usertService;
	@Resource
	private InitTAction initTAction;
	@Resource
	private UserRoleMService userRoleMService;
	@Resource
	private UserRoleMAction userRoleMAction;
	@Resource
	private GlobalParamService globalParamService;
	@Resource
	private DataCollectionTAction dataCollectionTAction;
	@Resource
	private JshopbasicInfoTService jshopbasicInfoTService;
	// @Resource
	// private JmsTemplate jmsTemplate;
	private UserT bean = new UserT();
	private String param;
	private List<UserT> user = new ArrayList<UserT>();
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String goingToURL;
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
	private Date postingcount;
	private String section;
	private String position;
	private String groupid;
	private String parttime1;
	private String parttime2;
	private String parttime3;
	private String qq;
	private String sinaweibo;
	private String state;
	private String uid;
	private String rolemname;
	private String rolemid;
	private String headpath;
	private String weixin;
	private String newpassword;
	private String message;
	private String roleid;
	private boolean slogin = false;
	private boolean sucflag;
	private boolean sauthority;
	private String baseurl;
	private String basepath;


	@JSON(serialize = false)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@JSON(serialize = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JSON(serialize = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
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

	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getGoingToURL() {
		return goingToURL;
	}

	public void setGoingToURL(String goingToURL) {
		this.goingToURL = goingToURL;
	}

	public UserT getBean() {
		return bean;
	}

	public void setBean(UserT bean) {
		this.bean = bean;
	}

	public List<UserT> getUser() {
		return user;
	}

	public void setUser(List<UserT> user) {
		this.user = user;
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

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public String getRolemname() {
		return rolemname;
	}

	public void setRolemname(String rolemname) {
		this.rolemname = rolemname;
	}

	public String getRolemid() {
		return rolemid;
	}

	public void setRolemid(String rolemid) {
		this.rolemid = rolemid;
	}

	public Date getPostingcount() {
		return postingcount;
	}

	public void setPostingcount(Date postingcount) {
		this.postingcount = postingcount;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSinaweibo() {
		return sinaweibo;
	}

	public void setSinaweibo(String sinaweibo) {
		this.sinaweibo = sinaweibo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getHeadpath() {
		return headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public boolean isSauthority() {
		return sauthority;
	}

	public void setSauthority(boolean sauthority) {
		this.sauthority = sauthority;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 验证登陆
	 */
	@Action(value = "/checklogin", results = { @Result(name = "json", type = "json", params = {
			"includeProperties", "slogin" }) })
	public String checklogin() {
		// this.setBasepath(this.getDataCollectionTAction().getBasePath());
		UserT admin = (UserT) ActionContext.getContext().getSession()
				.get(StaticKey.BACK_USER_SESSION_KEY);
		if (admin != null) {
			this.setSlogin(false);
			return "json";
		} else {
			this.setSlogin(true);
			return "json";
		}
	}

	@Action(value = "/checkAuthorityException", results = { @Result(name = "json", type = "json", params = {
			"includeProperties", "sauthority" }) })
	public String checkAuthorityException() {
		String authorityE = (String) ActionContext.getContext().getSession()
				.get(StaticKey.AUTHORITYEXCEPTION);
		if (authorityE != null) {
			if (StaticKey.ONE.equals(authorityE)) {
				this.setSauthority(true);
				ActionContext.getContext().getSession()
						.remove(StaticKey.AUTHORITYEXCEPTION);
				return "json";
			}
		} else {
			this.setSauthority(false);
			return "json";
		}
		return "json";
	}

	/**
	 * 店铺管理员登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "/login", results = { @Result(name = "success", type = "redirect", location = "/shopadmin/index.jsp?session=${param}"), @Result(name = "input", type = "redirect", location = "/shopadmin/login.jsp?msg=${param}") })
	public String shopadminlogin() throws Exception {
		if(StringUtils.isBlank(this.getUsername())){
			this.setParam(StaticKey.ONE);
			return INPUT;
		}
		if(StringUtils.isBlank(this.getPassword())){
			this.setParam(StaticKey.ONE);
			return INPUT;
		}
		MD5Code md5 = new MD5Code();
		UserT user = new UserT();
		user.setUsername(this.getUsername().toLowerCase(Locale.CHINA).trim());
		user.setPassword(md5.getMD5ofStr(password));
		user.setUserstate(BaseEnums.UserState.ACTIVE.getState());
		Criterion criterion = Restrictions
				.and(Restrictions.eq("username", user.getUsername()))
				.add(Restrictions.eq("password", user.getPassword()))
				.add(Restrictions.eq("userstate", user.getUserstate()));
		user = this.usertService.findOneByCriteria(UserT.class, criterion);
		if (user != null) {
			doSysIndexInit(user,md5);
			setBasicShopInfoToSessionContext(user.getShopid());
			return SUCCESS;
		}
		this.setParam(StaticKey.ONE);
		return INPUT;
	}

	/**
	 * 获取店铺基础信息
	 * @param username
	 */
	private void setBasicShopInfoToSessionContext(String shopid){
		if(!StringUtils.equals(shopid, StaticKey.ZERO)){
			JshopbasicInfoT jbi=this.jshopbasicInfoTService.findByPK(JshopbasicInfoT.class, shopid);
			if(jbi!=null){
				ActionContext.getContext().getSession().put(StaticKey.BASIC_SHOP_INFO, jbi);
			}
		}
	}
	/**
	 * 进行用户登录有的系统首页数据初始化及用户权限相关初始化
	 */
	private void doSysIndexInit(UserT user, MD5Code md5) {
		ActionContext.getContext().getSession()
				.put(StaticKey.BACK_USER_SESSION_KEY, user);
		this.setParam(md5.getMD5ofStr(user.getUserid()));
		ActionContext.getContext().getSession()
				.put(StaticKey.BACK_SESSION_KEY, param);
		// 获取默认主题
		this.initTAction.InitDefaultThemeT();
		// 收集权限信息并放入内存
		List<FunctionM> userfunctionlist = this.userRoleMAction
				.findUserRoleFunctionList(user.getUserid());
		// List<FunctionM>allfunctionlist=this.userRoleMAction.findAllFunctionM();
		ActionContext.getContext().getSession()
				.put(StaticKey.USERROLEFUNCTION, userfunctionlist);
		// ActionContext.getContext().getSession().put(BaseTools.ALLROLEFUNCTION,
		// allfunctionlist);
		// 获取前5条需要发货的订单信息
		List<OrderT> listOrderTs = this.initTAction.findNewestOrders();
		ActionContext.getContext().getSession()
				.put(StaticKey.NEWESTORDERS, listOrderTs);
	}

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	@Action(value = "/findAllUsert", results = { @Result(name = "json", type = "json") })
	public String findAllUsert() {
		if (StaticKey.SC.equals(this.getQtype())) {
			finddefaultAllUserT();
		} else {
			if (StringUtils.isBlank(this.getQtype())) {
				return JSON;
			} else {
				return JSON;
			}
		}
		return JSON;
	}

	private void finddefaultAllUserT() {
		int currentPage = page;
		int lineSize = rp;
		total = this.usertService.countfindAll(UserT.class);
		List<UserT> list = this.usertService.findAll(UserT.class, currentPage,
				lineSize);
		if (!list.isEmpty()) {
			processUserList(list);
		}
	}

	private void processUserList(List<UserT> list) {
		for (Iterator<UserT> it = list.iterator(); it.hasNext();) {
			UserT u = (UserT) it.next();
			if (StringUtils.equals(BaseEnums.UserType.NORMALMANAGER.getState(),
					u.getState())) {
				u.setState(BaseEnums.UserType.NORMALMANAGER.getName());
			}
			if (StringUtils.equals(BaseEnums.UserType.SHOPMANAGER.getState(),
					u.getState())) {
				u.setState(BaseEnums.UserType.SHOPMANAGER.getName());
			}
			if (StringUtils.equals(BaseEnums.UserType.SUPERMANAGER.getState(),
					u.getState())) {
				u.setState(BaseEnums.UserType.SUPERMANAGER.getName());
			}

			if (StringUtils.equals(BaseEnums.UserState.ACTIVE.getState(),
					u.getUserstate())) {
				u.setUserstate(BaseEnums.UserState.ACTIVE.getName());
			}
			if (StringUtils.equals(BaseEnums.UserState.UNACTIVE.getState(),
					u.getUserstate())) {
				u.setUserstate(BaseEnums.UserState.UNACTIVE.getName());
			}
			if (StringUtils.equals(BaseEnums.UserState.LOCK.getState(),
					u.getUserstate())) {
				u.setUserstate(BaseEnums.UserState.LOCK.getName());
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", u.getUserid());
			cellMap.put(
					"cell",
					new Object[] {
							u.getShopname(),
							u.getUsername(),
							u.getRealname(),
							u.getEmail(),
							u.getMobile(),
							u.getRolemname(),
							u.getState(),
							u.getUserstate(),
							"<a id='edituser' href='user.jsp?operate=edit&folder=user&userid="
									+ u.getUserid()
									+ "' name='edituser'>[编辑]</a>" });
			rows.add(cellMap);
		}

	}

	/**
	 * 管理员增加用户
	 *
	 * @return
	 */
	@Action(value = "/saveUserT", results = { @Result(name = "json", type = "json") })
	public String saveUserT() {
		if (StringUtils.isNotBlank(this.getUsername())
				&& StringUtils.isNotBlank(this.getPassword())
				&& StringUtils.isNotBlank(this.getEmail())) {
			MD5Code md5 = new MD5Code();
			// PasswordHelper ph = new PasswordHelper();
			UserT u = new UserT();
			u.setUsername(this.getUsername().trim());
			u.setEmail(this.getEmail().trim());
			Criterion criterion = Restrictions.and(
					Restrictions.eq("username", u.getUsername())).add(
					Restrictions.eq("email", u.getEmail()));
			u = this.usertService.findOneByCriteria(UserT.class, criterion);
			if (u != null) {
				this.setMessage("用户已经存在");// 表示用户已经存在
				return "json";
			} else {
				u = new UserT();
				u.setUsername(this.getUsername().trim());
				u.setEmail(this.getEmail().trim());
				Criterion criterion2 = Restrictions.and(
						Restrictions.eq("username", u.getUsername())).add(
						Restrictions.eq("email", u.getEmail()));
				u = this.usertService
						.findOneByCriteria(UserT.class, criterion2);

				if (u != null) {
					this.setMessage("用户邮箱已经存在");// 表示用户邮箱存在
					return "json";
				}
				UserT user = new UserT();
				user.setUserid(this.getSerial().Serialid(Serial.USER));
				user.setUid(md5.getMD5ofStr(user.getUserid()));
				user.setUsername(this.getUsername().trim());
				user.setRealname(this.getRealname().trim());
				user.setEmail(this.getEmail().trim());
				user.setTelno(StaticKey.EMPTY);
				user.setMobile(this.getMobile().trim());
				user.setQuestion(this.getQuestion().trim());
				user.setAnswer(this.getAnswer().trim());
				user.setPassword(md5.getMD5ofStr(this.getPassword().trim()));// 默认密码7个1
				user.setUserstate(this.getUserstate());
				user.setPostingcount(0);
				user.setSection(StaticKey.EMPTY);
				user.setPosition(StaticKey.EMPTY);
				user.setGroupid(StaticKey.EMPTY);
				user.setParttime1(StaticKey.EMPTY);
				user.setParttime2(StaticKey.EMPTY);
				user.setParttime3(StaticKey.EMPTY);
				user.setQq(this.getQq().trim());
				user.setSinaweibo(StaticKey.EMPTY);
				user.setWeixin(StaticKey.EMPTY);
				user.setState(this.getState());
				user.setRolemid(StaticKey.ZERO);
				user.setRolemname(StaticKey.EMPTY);
				user.setHeadpath(this.getHeadpath().trim());
				user.setCreatorid(BaseTools.getAdminCreateId());
				user.setCreatetime(BaseTools.getSystemTime());
				user.setUpdatetime(user.getCreatetime());
				user.setSalt(StaticKey.EMPTY);
				user.setCredentialsalt(StaticKey.EMPTY);
				user.setShopid(StaticKey.ZERO);
				user.setShopname(StaticKey.ZERO);
				// ph.encrypPassword(user);
				this.usertService.save(user);
				this.setSucflag(true);
				return "json";

			}
		}
		this.setMessage("邮箱，用户名，密码必须填写");
		return "json";

	}

	/**
	 * 更新系统用户
	 * 
	 * @return
	 */
	@Action(value = "/updateUserT", results = { @Result(name = "json", type = "json") })
	public String updateUserT() {
		if (StringUtils.isBlank(this.getUserid())) {
			return JSON;
		}
		bean = this.usertService.findByPK(UserT.class, this.getUserid());
		if (bean != null) {
			bean.setRealname(this.getRealname());
			bean.setMobile(this.getMobile());
			bean.setQq(this.getQq());
			bean.setWeixin(this.getWeixin());
			bean.setSinaweibo(this.getSinaweibo());
			bean.setHeadpath(this.getHeadpath());
			bean.setEmail(this.getEmail());
			bean.setQuestion(this.getQuestion());
			bean.setAnswer(this.getAnswer());
			bean.setUserstate(this.getUserstate());
			bean.setState(this.getState());
			bean.setUpdatetime(BaseTools.getSystemTime());
			this.usertService.update(bean);
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}

	/**
	 * 根据用户id获取用户信息
	 *
	 * @return
	 */
	@Action(value = "/findUserById", results = { @Result(name = "json", type = "json") })
	public String findUserById() {
		if (StringUtils.isNotBlank(this.getUserid())) {
			bean = this.usertService.findByPK(UserT.class, this.getUserid());
			if (bean != null) {
				bean.setHeadpath(BaseTools.getBasePath() + bean.getHeadpath());
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}

	/**
	 * 管理员更新用户信息，不包含密码等安全信息
	 *
	 * @return
	 */
	@Action(value = "/UpdateUserTunpwd", results = { @Result(name = "json", type = "json") })
	public String UpdateUserTunpwd() {
		this.checklogin();
		if (!this.isSlogin()) {
			UserT user = this.usertService.findByPK(UserT.class,
					this.getUserid());
			if (user != null) {
				user.setUsername(this.getUsername().trim());
				user.setEmail(this.getEmail().trim());
				user.setUserstate(this.getUserstate());
				user.setState(this.getState());
				this.usertService.update(user);
				this.setSucflag(true);
				return JSON;
			}
		}
		this.setSucflag(false);
		return JSON;
	}

	/**
	 * 管理员批量删除用户
	 *
	 * @return
	 */
	@Action(value = "/DelUsert", results = { @Result(name = "json", type = "json") })
	public String DelUsert() {
		if (StringUtils.isNotBlank(this.getUserid())) {
			String[] strs = StringUtils.split(this.getUserid(),
					StaticKey.SPLITDOT);
			for (String s : strs) {
				UserT user = this.usertService.findByPK(UserT.class, s);
				if (user != null) {
					this.usertService.delete(user);
				}
			}
			this.setSucflag(true);
			return JSON;
		}
		return JSON;
	}

	/**
	 * 更改管理员密码
	 *
	 * @return
	 */
	@Action(value = "/UpdateUserMember", results = { @Result(name = "json", type = "json") })
	public String UpdateUserMember() {
		this.checklogin();
		if (!this.isSlogin()) {
			MD5Code md5 = new MD5Code();
			UserT user = this.usertService.findByPK(UserT.class,
					this.getUserid());
			if (user != null) {
				user.setPassword(md5.getMD5ofStr(this.getNewpassword().trim()));
				this.usertService.update(user);
			}
			return JSON;

		}
		return JSON;
	}

	@Action(value = "/updateUserbyuserstate", results = { @Result(name = "json", type = "json") })
	public String updateUserbyuserstate() {
		if (StringUtils.isNotBlank(this.getUserid())) {
			UserT user = this.usertService.findByPK(UserT.class,
					this.getUserid());
			if (user != null) {
				if (StringUtils.equals(user.getUserstate(), StaticKey.ZERO)) {
					this.setSucflag(false);
					return JSON;
				} else {
					user.setUserstate(this.getUserstate());
					this.usertService.update(user);
					this.setSucflag(true);
					return "json";
				}
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 更新用户表中后台管理者的权限标记，后期可能全面启用写死的userstate模式改成此模式
	 * 
	 * @return
	 */
	@Action(value = "/updateUserRoleMByuserid", results = { @Result(name = "json", type = "json") })
	public String updateUserRoleMByuserid() {
		if (StringUtils.isNotBlank(this.getUserid())
				&& StringUtils.isNotBlank(this.getRoleid())
				&& StringUtils.isNotBlank(this.getRolemname())) {
			UserT user = this.usertService.findByPK(UserT.class,
					this.getUserid());
			if (user != null) {
				user.setRolemid(this.getRoleid());
				user.setRolemname(this.getRolemname());
				this.usertService.update(user);
				this.setSucflag(true);
				return JSON;
			}
		}
		return JSON;
	}

	/**
	 * 后台登出
	 */
	@Action(value = "/adminlogout", results = { @Result(name = "json", type = "json") })
	public String adminlogout() {
		ActionContext.getContext().getSession()
				.remove(StaticKey.BACK_USER_SESSION_KEY);
		ActionContext.getContext().getSession()
				.remove(StaticKey.USERROLEFUNCTION);
		ActionContext.getContext().getSession()
				.remove(StaticKey.BACK_SESSION_KEY);
		return JSON;
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	@Action(value = "findShopAdminUser", results = { @Result(name = "json", type = "json") })
	public String findShopAdminUser(){
		//用户账号类型是店铺管理员且shopid＝0
		Criterion criterion=Restrictions.and(Restrictions.eq("state", UserType.SHOPMANAGER.getState())).add(Restrictions.eq("shopid", StaticKey.ZERO));
		Order order=Order.desc("updatetime");
		List<UserT>list=usertService.findByCriteria(UserT.class, criterion, order);
		if(!list.isEmpty()){
			this.setUser(list);
			this.setSucflag(true);
		}
		return JSON;
	}

}