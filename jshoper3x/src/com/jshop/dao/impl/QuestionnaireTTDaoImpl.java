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

import com.jshop.dao.QuestionnaireTDao;
import com.jshop.entity.QuestionnaireT;
@Repository("questionnaireTDao")
public class QuestionnaireTTDaoImpl extends HibernateDaoSupport implements QuestionnaireTDao {
	private static final Logger log = LoggerFactory.getLogger(QuestionnaireTTDaoImpl.class);
	@Override
	public int addQuestionnaireT(QuestionnaireT qt) {
		log.debug("save QuestionnaireT");
		try {
			this.getHibernateTemplate().save(qt);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public List<QuestionnaireT> findAllQuestionnaireT(final int currentPage,
			final int lineSize) {
		log.debug("findAllQuestionnaireT");
		try {
			@SuppressWarnings("unchecked")
			List<QuestionnaireT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from QuestionnaireT as qt order by createtime desc";

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
			log.error("findAllQuestionnaireT error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllQuestionnaireT() {
		log.debug("countfindAllQuestionnaireT");
		try {
			String queryString = "select count(*) from QuestionnaireT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllQuestionnaireT error", re);
			throw re;
		}
	}

	@Override
	public int updateQuestionnaireT(QuestionnaireT qt) {
		log.debug("updateQuestionnaireT");
		try {
			this.getHibernateTemplate().update(qt);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("updateQuestionnaireT failed", re);
			throw re;
		}
	}

	@Override
	public List<QuestionnaireT> findQuestionnaireTBytitle(String title) {
		log.debug("findQuestionnaireTBytitle");
		try {
			String queryString = "from QuestionnaireT as qt where tt.title=:title";
			List<QuestionnaireT> list = this.getHibernateTemplate().findByNamedParam(queryString,"title", title);
			return list;
		} catch (RuntimeException re) {
			log.error("findQuestionnaireTBytitle error", re);
			throw re;
		}
	}

	@Override
	public int delQuestionnaireTByqid(final String[] strs) {
		log.debug("delQuestionnaireTByqid");
		try {

			final String queryString = "delete from QuestionnaireT as qt where qt.qid=:qid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : strs) {
						query.setParameter("qid", s);
						i = query.executeUpdate();
						i++;
					}
					if (strs.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("delQuestionnaireTByqid failed", re);
			throw re;
		}
		return 0;
	}

	@Override
	public QuestionnaireT findQuestionnaireTByqid(String qid) {
		log.debug("findQuestionnaireTByqid");
		try {
			QuestionnaireT instance = (QuestionnaireT) this.getHibernateTemplate().get("com.jshop.entity.QuestionnaireT", qid);
			return instance;
		} catch (RuntimeException re) {
			log.error("findQuestionnaireTByqid failed", re);
			throw re;
		}
	}

}
