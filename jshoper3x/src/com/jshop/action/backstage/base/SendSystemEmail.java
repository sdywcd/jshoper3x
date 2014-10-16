package com.jshop.action.backstage.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

import com.jshop.action.backstage.staticspage.CreateHtml;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.CartT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.UserT;
import com.jshop.service.CartTService;
import com.jshop.service.GoodsTService;

import freemarker.template.TemplateException;
@Namespace("")
@ParentPackage("jshop")
public class SendSystemEmail extends BaseTAction {
	private static final long serialVersionUID = 1L;
	private TaskExecutor taskExecutor;
	private CreateHtml createHtml;
	private CartTService cartTService;
	private GoodsTService goodsTService;
	private String username;
	private String sysSendmail;
	private String sysMailSmtp;
	private String sysMailPort;
	private String smtpusername;
	private String smtppwd;
	private String orderid;
	private String email;
	private boolean flag;
	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	@JSON(serialize = false)
	public CartTService getCartTService() {
		return cartTService;
	}

	public void setCartTService(CartTService cartTService) {
		this.cartTService = cartTService;
	}

	@JSON(serialize = false)
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getSysSendmail() {
		return sysSendmail;
	}

	public void setSysSendmail(String sysSendmail) {
		this.sysSendmail = sysSendmail;
	}

	public String getSysMailSmtp() {
		return sysMailSmtp;
	}

	public void setSysMailSmtp(String sysMailSmtp) {
		this.sysMailSmtp = sysMailSmtp;
	}

	public String getSysMailPort() {
		return sysMailPort;
	}

	public void setSysMailPort(String sysMailPort) {
		this.sysMailPort = sysMailPort;
	}

	public String getSmtpusername() {
		return smtpusername;
	}

	public void setSmtpusername(String smtpusername) {
		this.smtpusername = smtpusername;
	}

	public String getSmtppwd() {
		return smtppwd;
	}

	public void setSmtppwd(String smtppwd) {
		this.smtppwd = smtppwd;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取网站根目录
	 * 
	 * @param map
	 * @throws UnknownHostException
	 */
	public String getBasePath() throws UnknownHostException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		InetAddress inet = InetAddress.getLocalHost();
		return request.getScheme() + "://" + inet.getHostAddress() + ":" + request.getServerPort() + path + "/";
	}

	/**
	 * 发送激活邮件
	 * 
	 * @param user
	 * @throws MessagingException
	 * @throws IOException
	 * @throws TemplateException
	 */

	public void sendTextMail(final UserT user) throws MessagingException, IOException, TemplateException {
		String emailcontent = "<a href='" + getBasePath() + "html/default/shop/useractivatescallback.html?uid=" + user.getUid() + "'>点击激活</a>";
		final String htmlText = this.getCreateHtml().buildEmail(emailcontent);
		this.getTaskExecutor().execute(new Runnable() {
			public void run() {
				InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email.properties");
				Properties p = new Properties();
				try {
					p.load(inputStream);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//				JavaMailSender sender = (JavaMailSender) ctx.getBean("javamailsenderimpl");
//				MimeMessage msg = sender.createMimeMessage();
//				MimeMessageHelper helper = null;
//				try {
//					helper = new MimeMessageHelper(msg, false, "UTF-8");
//				} catch (MessagingException e1) {
//					e1.printStackTrace();
//				}
//				try {
//					helper.setTo(user.getEmail());
//					helper.setFrom(p.getProperty("email.username"));
//					helper.setSubject("ostocy会员激活邮件");
//					helper.setText(htmlText, true);
//				} catch (MessagingException e) {
//					e.printStackTrace();
//				}
//				sender.send(msg);

			}
		});

	}
	
	public String getVirtualinfo(List glist){
		GoodsT gt=new GoodsT();
		String mailcontent = "";
		for(int i=0;i<glist.size();i++){
			gt=this.getGoodsTService().findGoodsById(glist.get(i).toString());
			//mailcontent+=gt.getVirtualresults()+"   ";
		}
		return mailcontent;
	}
	
	
	/**
	 * 根据orderid查询到商品数据并发送邮件
	 * @param orderid
	 */
	@Action(value="sendEmailVirtualMovieGoodsinfo")
	public void sendEmailVirtualMovieGoodsinfo(){
		String orderid="";
		final String email=this.getEmail();
		if(Validate.StrNotNull(this.getOrderid())){
			orderid=this.getOrderid().trim();
		}
	
		List<CartT>list=this.getCartTService().findCartGoodsByOrderid(orderid);
		List<String> glist=new ArrayList<String>();
		if(!list.isEmpty()){
			for (Iterator<CartT> it = list.iterator(); it.hasNext();) {
				CartT cart=(CartT)it.next();
				if(!list.contains(cart.getGoodsid())){
					glist.add(cart.getGoodsid());
				}
			}
		}
		final String mailcontent=getVirtualinfo(glist);
		this.getTaskExecutor().execute(new Runnable() {

			public void run() {
				InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email.properties");
				Properties p = new Properties();
				try {
					p.load(inputStream);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//				JavaMailSender sender = (JavaMailSender) ctx.getBean("javamailsenderimpl");
//				MimeMessage msg = sender.createMimeMessage();
//				MimeMessageHelper helper = null;
//				try {
//					helper = new MimeMessageHelper(msg, false, "UTF-8");
//				} catch (MessagingException e1) {
//					e1.printStackTrace();
//				}
//				try {
//					helper.setTo(email);
//					helper.setFrom(p.getProperty("email.username"));
//					helper.setSubject("ostocy会员激活邮件");
//					helper.setText(mailcontent, true);
//				} catch (MessagingException e) {
//					e.printStackTrace();
//				}
//				sender.send(msg);

			}
		});
		
	}

	

	
}
