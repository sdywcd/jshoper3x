package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsCardsPasswordTDao;
import com.jshop.entity.ArticleT;
import com.jshop.entity.GoodsCardsPasswordT;
@Repository("goodsCardsPasswordTDao")
public class GoodsCardsPasswordTDaoImpl extends BaseTDaoImpl<GoodsCardsPasswordT> implements GoodsCardsPasswordTDao{

	private static final Logger log = LoggerFactory.getLogger(GoodsCardsPasswordTDaoImpl.class);

	
	@Override
	public List<GoodsCardsPasswordT> findGoodsCardsPasswordByGoodsCardsId(
			final int currentPage, final int lineSize, final String goodsCardsId) {
		log.debug("findGoodsCardsPasswordByGoodsCardsId");
		try {
			List<GoodsCardsPasswordT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from GoodsCardsPasswordT as gcp  where gcp.goodsCardsId=:goodsCardsId  order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("goodsCardsId", goodsCardsId);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsCardsPasswordByGoodsCardsId error", re);
			throw re;
		}
	}


	@Override
	public int countfindGoodsCardsPasswordByGoodsCardsId(String goodsCardsId) {
		log.debug("countfindGoodsCardsPasswordByGoodsCardsId");
		try {
			String queryString = "select count(*) from GoodsCardsPasswordT as gcp where  gcp.goodsCardsId=:goodsCardsId";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsCardsId", goodsCardsId);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindGoodsCardsPasswordByGoodsCardsId error", re);
			throw re;
		}
	}

}
