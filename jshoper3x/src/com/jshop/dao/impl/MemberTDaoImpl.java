package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.MemberTDao;
import com.jshop.entity.MemberT;
import com.jshop.entity.ProductT;
import com.jshop.entity.TemplateT;
import com.jshop.entity.UserT;

@Repository("memberTDao")
public class MemberTDaoImpl extends BaseTDaoImpl<MemberT> implements MemberTDao {
	private static final Logger log = LoggerFactory.getLogger(MemberTDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberT> findAllMemberT(final int currentPage, final int lineSize) {
		log.debug("find all MemberT");
		try {
			List<MemberT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberT as mt order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all MemberT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllMemberT() {
		log.debug("count all MemberT");
		try {
			String queryString = "select count(*) from MemberT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all MemberT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberT> findAllMemberT(final int currentPage,
			final int lineSize, final String creatorid) {
		log.debug("find all MemberT");
		try {
			List<MemberT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberT as mt where mt.creatorid=:creatorid order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all MemberT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllMemberT(String creatorid) {
		log.debug("countfindAllMemberT");
		try {
			String queryString = "select count(*) from MemberT as mt where mt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllMemberT error", re);
			throw re;
		}
	}

	@Override
	public void updateMemberT(MemberT mt) {
		log.debug("update MemberT");
		try {
			this.getHibernateTemplate().update(mt);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	

	@Override
	public MemberT findMemberTById(String id) {
		log.debug("findMemberTById");
		try {
			String queryString = "from MemberT as mt where mt.id=:id";
			List<MemberT> list = this.getHibernateTemplate().findByNamedParam(queryString, "id", id);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findMemberTById error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int delMemberT(final String[] strs) {
		log.debug("delMemberT");
		try {
			final String queryString = "delete from MemberT as mt where mt.id=:id";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("id", s);
						i = query.executeUpdate();
					}
					if (strs.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("delMemberT", re);
			throw re;
		}
		return 0;
	}

	@Override
	public List<MemberT> findMemberTByloginname(String loginname) {
		log.debug("findMemberTByloginname");
		try {
			String queryString = "from MemberT as mt where mt.loginname=:loginname";
			List<MemberT> list = this.getHibernateTemplate().findByNamedParam(queryString, "loginname", loginname);
			return list;
		} catch (RuntimeException re) {
			log.error("findMemberTByloginname error", re);
			throw re;
		}
	}

	@Override
	public List<MemberT> findMemberTByemail(String email) {
		log.debug("findMemberTByemail");
		try {
			String queryString = "from MemberT as mt where mt.email=:email";
			List<MemberT> list = this.getHibernateTemplate().findByNamedParam(queryString, "email", email);
			return list;
		} catch (RuntimeException re) {
			log.error("findMemberTByemail error", re);
			throw re;
		}
	}

	@Override
	public List<MemberT> findMemberTymid(String mid) {
		log.debug("findMemberTymid");
		try {
			String queryString = "from MemberT as mt where mt.mid=:mid";
			List<MemberT> list = this.getHibernateTemplate().findByNamedParam(queryString, "mid", mid);
			return list;
		} catch (RuntimeException re) {
			log.error("findMemberTymid error", re);
			throw re;
		}
	}

	@Override
	public List<MemberT> findMemberByQA(String loginname, String question,
			String answer) {
		log.debug("findMemberByQA");
		try {
			String queryString = "from MemberT as mt where mt.loginname=:loginname and mt.question=:question and mt.answer=:answer";
			List<MemberT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"loginname","question","answer"}, new Object[]{loginname,question,answer});
			return list;
		} catch (RuntimeException re) {
			log.error("findMemberByQA error", re);
			throw re;
		}
	}

	@Override
	public List<MemberT> login(MemberT m) {
		log.debug("login MemberT");
		try {
			String queryString = "from MemberT as mt where mt.loginname=:loginname and mt.loginpwd=:loginpwd and mt.memberstate=:memberstate";
			List<MemberT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "loginname", "loginpwd", "memberstate" }, new Object[] { m.getLoginname(),m.getLoginpwd(),m.getMemberstate()});
			return list;
		} catch (RuntimeException re) {
			log.error("login user error", re);
			throw re;
		}
	}

	@Override
	public int updateMemberHeadpathByid(final MemberT m) {
		try {
			final String queryString="update MemberT as mt set mt.headpath=:headpath where mt.id=:id";
			@SuppressWarnings("unchecked")
			Integer integer=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query= session.createQuery(queryString);
					query.setParameter("headpath", m.getHeadpath());
					query.setParameter("id", m.getId());
					return query.executeUpdate();
				}
			});
			return integer;
		} catch (RuntimeException e) {
			throw e;
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updateMemberPwdProctection(final String id,final String question, final String answer) {
		log.debug("update updateMemberPwdProctection");
		try {
			final String queryString = "update MemberT as mt set mt.question=:question,mt.answer=:answer where mt.id=:id";
			Integer integer=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("id",id);
					query.setParameter("question", question);
					query.setParameter("answer",answer);
					return query.executeUpdate();
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("update  updateMemberPwdProctection error", re);
			throw re;
		}
	}

	@Override
	public List<MemberT> findMemberLikeLoginname(final String loginname) {
		log.debug("findMemberLikeLoginname");
		try {
			List<MemberT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from MemberT as mt where mt.loginname like :loginname order by mt.createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("loginname", "%"+loginname+"%");
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findMemberLikeLoginname error", re);
			throw re;
		}
	}

}
