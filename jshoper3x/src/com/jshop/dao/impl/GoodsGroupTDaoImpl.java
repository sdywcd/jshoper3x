package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsGroupTDao;
import com.jshop.entity.GoodsGroupT;
@Repository("goodsGroupTDao")
public class GoodsGroupTDaoImpl extends BaseTDaoImpl<GoodsGroupT> implements GoodsGroupTDao {
	private static final Logger log = LoggerFactory.getLogger(GoodsGroupTDaoImpl.class);
	


	@Override
	public int updateGoodsGroupT(final GoodsGroupT group) {
		log.debug("update goodsGroupT");
		final String queryString="update GoodsGroupT as ggt set ggt.memberprice=:memberprice, ggt.groupprice=:groupprice, ggt.pictureurl=:pictureurl, ggt.sendpoint=:sendpoint,ggt.detail=:detail,ggt.endtime=:endtime,ggt.begintime=:begintime, ggt.goodsname=:goodsname,ggt.cashstate=:cashstate,ggt.cashlimit=:cashlimit,ggt.limitbuy=:limitbuy,ggt.salequantity=:salequantity where ggt.groupid=:groupid";
		try {
			Integer integer = (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("groupid", group.getGroupid());
					query.setParameter("cashstate", group.getCashstate());
					query.setParameter("cashlimit", group.getCashlimit());
					query.setParameter("limitbuy", group.getLimitbuy());
					query.setParameter("salequantity", group.getSalequantity());
					query.setParameter("goodsname", group.getGoodsname());
					query.setParameter("begintime", group.getBegintime());
					query.setParameter("endtime",group.getEndtime());
					query.setParameter("detail", group.getDetail());
					query.setParameter("sendpoint", group.getSendpoint());
					query.setParameter("pictureurl", group.getPictureurl());
					query.setParameter("groupprice", group.getGroupprice());
					query.setParameter("memberprice", group.getMemberprice());
//					query.setParameter("totalordercount", group.getTotalOrderCount());
//					query.setParameter("sordercount", group.getSOrderCount());
					i= query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (DataAccessException e) {
			log.debug("update goodsgroupT failed");
			throw e;
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsGroupT> findAllGoodsGroupT(final int currentPage, final int lineSize) {
		log.debug("find all goodsGroupT");
		try {
			List<GoodsGroupT> list =this.getHibernateTemplate().executeFind(new HibernateCallback() {
				String queryString="from GoodsGroupT order by createtime";
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list=query.list();
					
					return list;
				}
			});
			if(list.size()>0&&list!=null){
				log.debug("find all success");
				return list;
			}			
			return null;
		} catch (DataAccessException e) {
			log.debug("find all failed");
			throw e;
		}
	}

	@Override
	public int delGoodsGroupT(final String[] list) {	
		log.debug("del goodsgroupt");
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				String queryString="delete from GoodsGroupT as ggt where ggt.groupid=:groupid";
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query =  session.createQuery(queryString);
					int i = 0;
					for(String s : list){
						query.setParameter("groupid", s);
						i=query.executeUpdate();
						i++;
					}
					if(list.length==i){
						log.debug("del success");
						return i;
					}else{
						return 0;
					}					
				}
			});
		} catch (DataAccessException e) {
			log.debug("del failed");
			throw e;
		}
		return 0;		
		
	}

	@Override
	public int countAllGoodsGroupT() {
		log.debug("countAll GoodsGroupT");
		try {
			String queryString="select count(*) from GoodsGroupT ";
			List list= this.getHibernateTemplate().find(queryString);
			if(list.size()>0){
				Object o =list.get(0);
				long l =(Long) o;
				return (int)l;
			}			
			return 0;
		} catch (DataAccessException e) {
			log.debug("countAll failed");
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsGroupT> sortAllGoodsGroup(final int currentPage, final int lineSize,
			 final String queryString) {
		try {
			List<GoodsGroupT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);					
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (DataAccessException e) {
			throw e;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public GoodsGroupT findGoodsGroupById(String groupid) {
		try {
			String queryString="from GoodsGroupT as ggt where ggt.groupid=:groupid ";
			List<GoodsGroupT> list =this.getHibernateTemplate().findByNamedParam(queryString, "groupid", groupid);
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public int updateState(final GoodsGroupT ggt) {
		try {
			final String queryString="update GoodsGroupT as ggt set ggt.state=:state where ggt.groupid=:groupid";
			Integer integer = (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					 int i = 0;
					 Query query = session.createQuery(queryString);
					 query.setParameter("groupid", ggt.getGroupid());
					 query.setParameter("state", ggt.getState());
					 i=query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsGroupT> findGoodsGroupByState(String state) {
		try {
			String queryString="from GoodsGroupT as ggt where ggt.state=:state order by begintime desc";
			List<GoodsGroupT> list = this.getHibernateTemplate().findByNamedParam(queryString, "state", state);
			if(!list.isEmpty()){
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			throw e;
		}
		
	}

	@Override
	public int updateGoodsGroupHtmlPath(final String htmlpath, final String groupid) {
		try {
			final String queryString="update GoodsGroupT as ggt set ggt.htmlpath=:htmlpath where  ggt.groupid=:groupid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i=0;
					Query query = session.createQuery(queryString);
					query.setParameter("htmlpath", htmlpath);
					query.setParameter("groupid",groupid);
					i=query.executeUpdate();
					return i;
				}
			});
		} catch (DataAccessException e) {
			throw e;
		}
		return 0;
	}

}
