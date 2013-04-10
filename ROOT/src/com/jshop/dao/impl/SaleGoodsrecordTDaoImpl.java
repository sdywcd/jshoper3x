package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

import com.jshop.dao.SaleGoodsrecordTDao;
import com.jshop.entity.SaleGoodsrecordT;
@Repository("saleGoodsrecordTDao")
public class SaleGoodsrecordTDaoImpl extends HibernateDaoSupport implements SaleGoodsrecordTDao {
	private static final Logger log=LoggerFactory.getLogger(SaleGoodsrecordTDaoImpl.class);
	
	@Override
	public int addSaleGoodsrecord(SaleGoodsrecordT salegoodsrecordt) {
			log.debug("add SaleGoodsrecordT");
			try {
				this.getHibernateTemplate().save(salegoodsrecordt);
				log.debug("add SaleGoodsrecordT SUCCESS");
				return 1;
			} catch (DataAccessException e) {
				// TODO: handle exception
				log.debug("add SaleGoodsrecordT fail");
				throw e;
			}
			
			
	}
	@Override
	public int updateSaleGoodsrecord(final SaleGoodsrecordT salegoodsrecordt) {
	log.debug("update SaleGoodsrecordT");
	try{
		this.getHibernateTemplate().update(salegoodsrecordt);
		log.debug("update salegoodsrecordt success");
		return 1;
		
	}catch(RuntimeException e){
		log.debug("update salegoodsrecordt fail");
		throw e;
	}
	
	/*final String queryString="update SaleGoodsrecordT as record set record.username=:username,record.realname=:realname,record.salegoodsnumber=:salegoodsnumber,record.salegoodsname=:salegoodsname,record.salestartingprice=:salestartingprice,record.saletradetime=:saletradetime,record.saleprice=:saleprice,record.salepeople=:salepeople,record.telno=:telno,record.mobile=:mobile,record.sex=:sex,record.email=:email,record.hiprice=:hiprice,record.joinnumber=:joinnumber,record.marketprice=:marketprice,record.salegoodspictureurl=:salegoodspictureurl,record.salegoodsinformation=:salegoodsinformation,record.begingtime=:begingtime,record.endingtime=:endingtime,record.salegoodsmessage=:salegoodsmessage,record.lowprice=:lowprice,record.place=:place,record.manufacturer=:manufacturer where record.salerecordid=:salerecordid";
	try{
	Integer integer=(Integer)getHibernateTemplate().execute(new HibernateCallback() {
		
		@Override
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			int i=0;
			Query query=session.createQuery(queryString);
			query.setParameter("salerecordid", salegoodsrecordt.getSalegoodsid());
			query.setParameter("username", salegoodsrecordt.getUsername());
			query.setParameter("realname", salegoodsrecordt.getRealname());
			query.setParameter("salegoodsnumber", salegoodsrecordt.getSalegoodsnumber());
			query.setParameter("salegoodsname", salegoodsrecordt.getSalegoodsname());
			query.setParameter("salestartingprice", salegoodsrecordt.getSalestartingprice());
			query.setParameter("saletradetime", salegoodsrecordt.getSaletradetime());
			query.setParameter("saleprice", salegoodsrecordt.getSaleprice());
			query.setParameter("salepeople", salegoodsrecordt.getSalepeople());
			query.setParameter("telno", salegoodsrecordt.getTelno());
			query.setParameter("mobile", salegoodsrecordt.getMobile());
			query.setParameter("sex", salegoodsrecordt.getSex());
			query.setParameter("email", salegoodsrecordt.getEmail());
			query.setParameter("points", salegoodsrecordt.getPoints());
			query.setParameter("hiprice", salegoodsrecordt.getHiprice());
			query.setParameter("joinnumber", salegoodsrecordt.getJoinnumber());
			query.setParameter("marketprice", salegoodsrecordt.getMarketprice());
		query.setParameter("salegoodspictureurl", salegoodsrecordt.getSalegoodspictureurl());
			query.setParameter("salegoodsinformation", salegoodsrecordt.getSalegoodsinformation());
			query.setParameter("begingtime", salegoodsrecordt.getBegingtime());
			query.setParameter("endingtime", salegoodsrecordt.getEndingtime());
			query.setParameter("salegoodsmessage", salegoodsrecordt.getSalegoodsmessage());
			query.setParameter("lowprice", salegoodsrecordt.getLowprice());
			query.setParameter("place", salegoodsrecordt.getPlace());
			query.setParameter("manufacturer", salegoodsrecordt.getManufacturer());
			i=query.executeUpdate();
			return i;
		}
	});
	return integer;
	}catch(RuntimeException e){
	log.debug("update salegoodsrecordt field");
	throw e;
	}*/
	}
	@Override
	public int deleteSaleGoodsrecord(final String[] list) {
		log.debug("delete SaleGoodrecord list");
		try {
			final String queryString = "delete from SaleGoodsrecordT as record where record.salerecordid=:salerecordid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("salerecordid", s);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						log.debug("delete success");
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (DataAccessException e) {
			// TODO: handle exception
			log.debug("delete SaleGoodsrecordT fail");
			throw e;
		}
		return 0;
	}

	
	@Override
	public List<SaleGoodsrecordT> findallSaleGoodsrecord(final int currentPage,
			final int lineSize) {
		log.debug("findallSaleGoodsrecord");
		try {
		final String queryString="select count(*) from SaleGoodsrecordT";
			@SuppressWarnings("unchecked")
			final List<SaleGoodsrecordT> list = this.getHibernateTemplate()
					.executeFind(new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							List list = query.list();
							log.debug("findallSaleGoodsrecord SUCCESS");
							return list;
							

						}
					});
			return list;
		} catch (DataAccessException e) {
			// TODO: handle exception
			log.debug("findallSaleGoodsrecord Fail");
			throw e;
		}
	}

	@Override
	public List<SaleGoodsrecordT> sortAllSaleGoodsrecord(final int currentPage,
		final	int lineSize, final String queryString) {
		log.debug("sortAllSaleGoodsrecord");
		try {
			@SuppressWarnings("unchecked")
			final List<SaleGoodsrecordT> list = this.getHibernateTemplate()
					.executeFind(new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							List list = query.list();
							return list;

						}
					});
			return list;
		} catch (DataAccessException e) {
			// TODO: handle exception
			log.debug("sortAllSaleGoodsrecordT Fail");
			throw e;
		}
	}
	@Override
	public int countAllSaleGoodsrecordT() {
		log.debug("countALL SaleGoodsrecordT");
		try {
			String queryString = "select count(*) from SaleGoodsrecordT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 1;
		} catch (DataAccessException e) {
			// TODO: handle exception
			log.debug("countAll SaleGoodsrecordT fail");
			throw e;
		}
	}
	@Override
	public SaleGoodsrecordT findSaleGoodsrecordByid(String salerecordid) {
		log.debug("find BY id");
		try {
			String queryString = "from SaleGoodsrecordT s where s.salerecordid=:salerecordid";
			@SuppressWarnings("unchecked")
			List<SaleGoodsrecordT> list = this
					.getHibernateTemplate()
					.findByNamedParam(queryString, "salerecordid", salerecordid);
			if (!list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (DataAccessException e) {
			log.debug("not find that salerecordid");
			throw e;
		}
		
	}
	@Override
	public int updateSaleGoodsrecordByHiprice( final SaleGoodsrecordT salegoodsrecordt) {
	log.debug("update SaleGoodsrecordBy Hiprice");

	try {
		final String queryString = "update SaleGoodsrecordT as record set record.hiprice=:hipeice where record.salerecordid=:salerecordid";
		Integer integer = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						int i = 0;
						/*	 record.username=:username,record.realname=:realname,record.salegoodsnumber=:salegoodsnumber,record.salegoodsname=:salegoodsname,record.salestartingprice=:salestartingprice,record.saletradetime=:saletradetime,record.salepeople=:salepeople,record.telno=:telno,record.mobile=:mobile,record.sex=:sex,record.email=:email,record.points=:points where record.hiprice=:hiprice*/
						Query query = session.createQuery(queryString);
						/*	query.setParameter("username", salegoodsrecordt.getUsername());
						 query.setParameter("realname", salegoodsrecordt.getRealname());
						 query.setParameter("salegoodsnumber", salegoodsrecordt.getSalegoodsnumber());
						 query.setParameter("salegoodsname", salegoodsrecordt.getSalegoodsname());
						 query.setParameter("salestartingprice", salegoodsrecordt.getSalestartingprice());
						 query.setParameter("saletradetime", salegoodsrecordt.getSaletradetime());
						 query.setParameter("saleprice", salegoodsrecordt.getSaleprice());
						 query.setParameter("salepeople", salegoodsrecordt.getSalepeople());
						 query.setParameter("telno", salegoodsrecordt.getTelno());
						 query.setParameter("mobile", salegoodsrecordt.getMobile());
						 query.setParameter("sex", salegoodsrecordt.getSex());
						 query.setParameter("email", salegoodsrecordt.getEmail());*/
						query.setParameter("hiprice",
								salegoodsrecordt.getHiprice());
						query.setParameter("salerecordid",
								salegoodsrecordt.getSalerecordid());
						i = query.executeUpdate();
						return i;
					}
				});
		return integer;
	} catch (DataAccessException e) {
		// TODO: handle exception
		log.debug(" update SaleGoodsrecordt field");
		throw e;
	}
	
	}
	@Override
	public int addSaleGoodsrecordBystate(SaleGoodsrecordT salegoodsrecordt) {
		log.debug("add SaleGoodsrecordTBy state");
		try {
			this.getHibernateTemplate().save(salegoodsrecordt);
			log.debug("add SaleGoodsrecordT SUCCESS");
		} catch (DataAccessException e) {
			// TODO: handle exception
			log.debug("add SaleGoodsrecordTBy state fail");
			throw e;
		}
		return 1;
		
	}
	

	
	@Override
	public int updateSaleGoodsrecordHtmlPath(final String htmlpath,
			final String salerecordid) {
		try {
			final String queryString = "update SaleGoodsrecordT as record set record.htmlpath=:htmlpath where record.salerecordid=:salerecordid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("htmlpath", htmlpath);
					query.setParameter("salerecordid", salerecordid);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		}
		return 0;
	}
	@Override
	public SaleGoodsrecordT findrecordbysalegoodsid(String salegoodsid) {
		log.debug("find BY id");
		try {
			String queryString = "from SaleGoodsrecordT s where s.salegoodsid=:salegoodsid";
			@SuppressWarnings("unchecked")
			List<SaleGoodsrecordT> list =
			this.getHibernateTemplate().findByNamedParam(queryString, "salegoodsid", salegoodsid);
			if (!list.isEmpty()) {
			
				return list.get(0);
			}
			return null;
		} catch (DataAccessException e) {
			log.debug("not find that salegoodsid");
			throw e;
		}
	}
	@Override
	public int addrecordByhiprice(SaleGoodsrecordT salegoodsrecordt) {
		log.debug("add SalegoodsrecordByhiprice");
		try{
			this.getHibernateTemplate().save(salegoodsrecordt);
			log.debug("add SalegoodsrecordByhiprice success");
			return 1;
		}catch(RuntimeException e){
			log.debug("add SalegoodsrecordByhiprice fail");
			throw e;
		}

	
	}
	@Override
	public  double hiprice(String salegoodsid) {
		log.debug("find hiprice");
		List hiprice=new ArrayList();
		try{
			String QueryString="select max(hiprice)from SaleGoodsrecordT s where s.salegoodsid=:salegoodsid";
			List max=this.getHibernateTemplate().findByNamedParam(QueryString, "salegoodsid",salegoodsid);
			Double l=(Double) max.get(0);
			if(l==null){
				l=0.0;
				return l;
			}
 			
 			System.out.println("sfdddddddddddddddddd"+l);
 			return l;
 				
		}catch(RuntimeException e){
			throw e;
		}
		
		
	
		
	}
	@Override
	public List<SaleGoodsrecordT> findAllSaleGoodsrecordT() {
		log.debug("find BY salegoodsid");
		try {
			 String queryString = "from SalegoodsT";
			 List<SaleGoodsrecordT> list=this.getHibernateTemplate().find(queryString);
			 if(list!=null){
				 return list;
			 }
			 return null;
		} catch (DataAccessException e) {
			log.debug("not find that salegoodsid");
			throw e;
		}
	}
	@Override
	public int findjoinnumber(String salegoodsid) {
		log.debug("find all joinnumber");
		try{
				String queryString="select distinct username from SaleGoodsrecordT where salegoodsid=:salegoodsid ";
				List list=this.getHibernateTemplate().findByNamedParam(queryString,"salegoodsid",salegoodsid);
				if(list==null){
			int i=list.size();
			i=0;
			return i;
				}
				log.debug("findjoinnumber success");
				return list.size();
		}catch(RuntimeException e){
			log.debug("findjoinnumber fail");
			throw e;
			
		}
	}
	@Override
	public List<SaleGoodsrecordT> findbyEndingtime(Date endingtime) {
		log.debug("find by endingtime");
		try{
			String queryString="from SaleGoodsrecordT s where s.endingtime=:endingtime ";
			List list=this.getHibernateTemplate().findByNamedParam(queryString, "endingtime", endingtime);
			if(list!=null){
				return list;
			}
			return null;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
