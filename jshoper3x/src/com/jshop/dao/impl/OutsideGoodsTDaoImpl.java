package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.OutsideGoodsTDao;
import com.jshop.entity.OutsideGoodsT;
@Repository("outsideGoodsTDao")
public class OutsideGoodsTDaoImpl extends HibernateDaoSupport implements OutsideGoodsTDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<OutsideGoodsT> findAllOutsideGoodsT(final int lineSize,
			final int currentPage) {
			
		try {
			final String queryString="from OutsideGoodsT";
			List<OutsideGoodsT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize );
					query.setMaxResults(lineSize);
					List list =query.list();
					
					return list;
				}
			});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public int countAllOutsideGoodsT() {
		try {
			String queryString="select count(*) from OutsideGoodsT";
			List list = this.getHibernateTemplate().find(queryString);
			if(list.size()>0){
				Object o = list.get(0);
				long l=(Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public int addOutsideGoodsT(OutsideGoodsT ogt) {
		try {
			this.getHibernateTemplate().save(ogt);
			return 1;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	

//	@Override
//	public int updateOutsideGoodsT(final OutsideGoodsT ogt) {
//		try {
//			final String queryString="update OutsideGoodsT as ogt set ogt.id=:id,ogt.goodsname=:goodsname,ogt.createtime=:createtime,ogt.creatorid=:creatorid,ogt.fname=:fname" +
//					"ogt.linkUrl=:linkUrl,ogt.lname=:lname,ogt.ltypeid=:ltypeid,ogt.navid=:navid,ogt.nname=:nname,ogt.pictureurl=:pictureurl" +
//					"ogt.salestate=:salestate,ogt.sname=:sname,ogt.sort=:sort,ogt.stypeid=:stypeid,ogt.updatetime=:updatetime,ogt.versiont=:versiont where ogt.id=:id";
//			Integer ineger=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {
//				
//				@Override
//				public Object doInHibernate(Session session) throws HibernateException,
//						SQLException {
//					int i=0;
//					Query query =session.createQuery(queryString);
//					query.setParameter("goodsname",ogt.getGoodsname());
//					query.setParameter("id",ogt.getId());
//					query.setParameter("createtime",ogt.getCreatetime());
//					query.setParameter("creatorid",ogt.getCreatorid());
//					query.setParameter("fname",ogt.getFname());
//					query.setParameter("linkUrl",ogt.getLinkUrl());
//					query.setParameter("lname",ogt.getLname());
//					query.setParameter("ltypeid",ogt.getLtypeid());
//					query.setParameter("navid",ogt.getNavid());
//					query.setParameter("nname",ogt.getNname());
//					query.setParameter("pictureurl",ogt.getPictureurl());
//					query.setParameter("salestate",ogt.getSalestate());
//					query.setParameter("sname",ogt.getSname());
//					query.setParameter("sort",ogt.getSort());
//					query.setParameter("stypeid",ogt.getStypeid());
//					query.setParameter("updatetime",ogt.getUpdatetime());
//					query.setParameter("versiont",ogt.getVersiont());					
//					i=query.executeUpdate();
//					return i;
//				}
//			});
//			return ineger;
//		} catch (RuntimeException e) {
//			throw e;
//		}
//		
//	}

	@Override
	public OutsideGoodsT findOutsideGoodsTById(String id) {
		try {
			String queryString="from OutsideGoodsT as ogt where ogt.id=:id";
			List<OutsideGoodsT> ogt=  this.getHibernateTemplate().findByNamedParam(queryString, "id", id);
			if(ogt!=null&&!ogt.isEmpty()){
				return ogt.get(0);
			}
			return null;
		} catch (RuntimeException e) {
			throw e;
		}
		
	}

	@Override
	public int delOutsideGoodsT(final String[] id) {
		try {
			final String queryString="delete from OutsideGoodsT as ogt where ogt.id=:id";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query =session.createQuery(queryString);
					int i=0;
					for(String s : id){
						query.setParameter("id", s);
						i=query.executeUpdate();
						i++;
					}
					if(id.length==i){
						return i;
					}else{
						return 0;
					}
				}
			});
		} catch (RuntimeException e) {
			throw e;
		}
		
		return 0;
	}

	@Override
	public int updateOutsideGoodsT(OutsideGoodsT ogt) {
		try {
			this.getHibernateTemplate().update(ogt);
			return 1;
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
