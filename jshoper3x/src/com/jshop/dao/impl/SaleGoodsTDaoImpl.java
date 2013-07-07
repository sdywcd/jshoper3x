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

import com.jshop.dao.SaleGoodsTDao;
import com.jshop.entity.SalegoodsT;

/**
 * @author 郭建波 拍卖实现
 * 
 */

@Repository("saleGoodsTDao")
public class SaleGoodsTDaoImpl extends HibernateDaoSupport implements SaleGoodsTDao {
	private static final Logger log = LoggerFactory
			.getLogger(SaleGoodsTDaoImpl.class);

	// 制定日志
	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#addsalegoods(com.jshop.entity.SalegoodsT)
	 */
	@Override
	public int addsalegoods(SalegoodsT salegoodst) {
		log.debug("add SalegoodsT");// 添加日志信息
		try {
			this.getHibernateTemplate().save(salegoodst);// 把salegoodst对象存进去
			log.debug("add SalegoodsT Success");
			return 1;
		} catch (DataAccessException e) {
			log.debug("add SalegoodsT failed");
			throw e;
		}
	

	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#updatesalegoods(com.jshop.entity.SalegoodsT)
	 */
	@Override
	public int updatesalegoods(final SalegoodsT salegoodst) {
		log.debug("update SalegoodsT");
		final String queryString = "update SalegoodsT as salegoodst set salegoodst.salegoodsname=:salegoodsname,salegoodst.salegoodsnumber=:salegoodsnumber,salegoodst.salegoodspictureurl=:salegoodspictureurl,salegoodst.salegoodsinformation=:salegoodsinformation,salegoodst.salegoodsstate=:salegoodsstate,salegoodst.begingtime=:begingtime,salegoodst.endingtime=:endingtime,salegoodst.salepeople=:salepeople,salegoodst.salestartingprice=:salestartingprice,salegoodst.salejoinpeople=:salejoinpeople,salegoodst.salebudget=:salebudget,salegoodst.realname=:realname,salegoodst.userid=:userid,salegoodst.saleprice=:saleprice,salegoodst.marketprice=:marketprice,salegoodst.newornot=:newornot,salegoodst.salegoodsmessage=:salegoodsmessage,salegoodst.lowprice=:lowprice,salegoodst.place=:place,salegoodst.manufacturer=:manufacturer where salegoodst.salegoodsid=:salegoodsid";
		try {
			Integer integer = (Integer) this.getHibernateTemplate().execute(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)throws HibernateException, SQLException {
							int i = 0;
							Query query = session.createQuery(queryString);
							query.setParameter("salegoodsid",salegoodst.getSalegoodsid());
							query.setParameter("salegoodsname",salegoodst.getSalegoodsname());
							query.setParameter("salegoodsnumber",salegoodst.getSalegoodsnumber());
							query.setParameter("salegoodspictureurl",salegoodst.getSalegoodspictureurl());
							query.setParameter("salegoodsinformation",salegoodst.getSalegoodsinformation());
							query.setParameter("salegoodsstate",salegoodst.getSalegoodsstate());
							query.setParameter("begingtime",salegoodst.getBegingtime());
							query.setParameter("endingtime",salegoodst.getEndingtime());
							query.setParameter("salepeople",salegoodst.getSalepeople());
							query.setParameter("salestartingprice",salegoodst.getSalestartingprice());
							query.setParameter("salejoinpeople",salegoodst.getSalejoinpeople());
							query.setParameter("salebudget",salegoodst.getSalebudget());
							query.setParameter("realname",salegoodst.getRealname());
							query.setParameter("userid", salegoodst.getUserid());
							query.setParameter("saleprice",salegoodst.getSaleprice());
							query.setParameter("marketprice",salegoodst.getMarketprice());
							query.setParameter("newornot", salegoodst.getNewornot());
							query.setParameter("salegoodsmessage", salegoodst.getSalegoodsmessage());
							query.setParameter("lowprice", salegoodst.getLowprice());
							query.setParameter("place", salegoodst.getPlace());
							query.setParameter("manufacturer", salegoodst.getManufacturer());
							i = query.executeUpdate();

							return i;
						}
					});

			return integer;
		} catch (DataAccessException e) {
			log.debug("update SalegoodsT field");
			throw e;
		}
		/*try{
			this.getHibernateTemplate().update(salegoodst);
			log.debug("update salegoodst success");
			return 1;
			
		}catch(RuntimeException e){
			throw e;
		}*/
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findallsalegoods(int, int)
	 */
	@Override
	public List<SalegoodsT> findallsalegoods(final int currentPage,
			final int lineSize) {
		log.debug("select * findallsalegoods");
		try {
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						String queryString = "select count(*) from SaleGoodsT";

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							List<SalegoodsT> list = query.list();
							return list;
						}
					});

			log.debug("already find SalegoodsT");
			return list;
		} catch (DataAccessException e) {
			log.debug("not find SalegoodsT");
			throw e;
		}

	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findsalegoodsById(java.lang.String)
	 */
	@Override
	public SalegoodsT findsalegoodsById(String salegoodsid) {
		log.debug("find SalegoodsT byId");

		try {
			String queryString = " from SalegoodsT s where s.salegoodsid=:salegoodsid";
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate()
					.findByNamedParam(queryString, "salegoodsid", salegoodsid);
			if(!list.isEmpty()){
				return  list.get(0);
			}
			return null;
		} catch (DataAccessException e) {
			log.debug("not find SalegoodsT byId");
			throw e;

		}
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findsalegoodsByNumber(java.lang.String)
	 */
	@Override
	public List<SalegoodsT> findsalegoodsByNumber(String salegoodsnumber) {
		log.debug("find SalegoodsT byNumber");

		try {
			String queryString = "from SalegoodsT as sale where s.salegoodsnumber=:salegoodsnumber";
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate()
					.findByNamedParam(queryString, "salegoodsnumber",
							salegoodsnumber);
			if (!list.isEmpty()) {
				return list;
			}
			return list;

		} catch (DataAccessException e) {
			log.debug("not find SalegoodsT byNumber");
			throw e;

		}
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#deletesalegoods(java.lang.String)
	 */
	@Override
	public int deletesalegoods(final String salegoodsnumber) {
		log.debug("delete SalegoodsByNumber");
		final String queryString = "delete from SalegoofdT as sale where sale.salegoodsnumber=:salegoodsnumber";
	this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(queryString);
						query.setParameter("salegoodsnumber", salegoodsnumber);
						int i = 0;
						i = query.executeUpdate();

						return i;
					}
				});

		return 0;
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#deletesalegoodsById(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.aaaa#deletesalegoodsT(java.lang.String[])
	 */
	@Override
	public int deletesalegoodsT(final String[] list) {
		log.debug("delete salegoods list");
		final String queryString = "delete from SalegoodsT as sale where salegoodsid=:salegoodsid";
		 try {
			this.getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("salegoodsid", s);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						log.debug(" delete success");
						return i;
					} else {
						return 0;
					}

				}
			});
		} catch (DataAccessException e) {
			// TODO: handle exception
			log.debug("delete field");
			throw e;
		}
		return 0;

	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findsalegoodsByBegintime(java.util.Date)
	 */
	@Override
	public List<SalegoodsT> findsalegoodsByBegintime(java.util.Date begingtime) {
		// TODO Auto-generated method stub
		return null;
	}



	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.jhk#countAllSalegoodsT()
	 */
	@Override
	public int countAllSalegoodsT() {
		log.debug("countAll SalegoodsT");
		try {
			String queryString = "select count(*) from SalegoodsT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 1;
		} catch (DataAccessException e) {
			// TODO: handle exception
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.jhk#sortAllSalegoods(int, int, java.lang.String)
	 */

	@Override
	public List<SalegoodsT> sortAllSalegoods(final int currentPage, final int lineSize,
			final String queryString) {
		log.debug("sortAllSalegoods");
		try {
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

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
			log.debug("error in sortAllSalegoods");
			throw e;
		
		}
	}

	@Override
	public List<SalegoodsT> findBysalegoodsState(final String salegoodsstate) {
		log.debug("find SalegoodsT salegoodsstate");

		try {
			String queryString = "from SalegoodsT as sgt where sgt.salegoodsstate=:salegoodsstate";
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate()
					.findByNamedParam(queryString, "salegoodsstate",
							salegoodsstate);
			if (!list.isEmpty()) {
				return list;
			}
			return list;

		} catch (DataAccessException e) {
			log.debug("not find SalegoodsT salegoodsstate");
			throw e;

		}
	}

	@Override
	public int updateSalegoodsHtmlPath(final String htmlpath, final String salegoodsid) {
		try{
			final String queryString="update SalegoodsT as sgt set sgt.htmlpath=:htmlpath where sgt.salegoodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i=0;
					Query query=session.createQuery(queryString);
					query.setParameter("htmlpath", htmlpath);
					query.setParameter("salegoodsid", salegoodsid);
					
					return i;
				}
			});
		}catch(DataAccessException e)
		{
			throw e;
			
		}
		
		return 0;
	}

	@Override
	public List<SalegoodsT> findAllSalegoods(final String salegoodsstate){
		log.debug("find BY salegoodsid");
		try {
			final String queryString = "from SalegoodsT s where s.salegoodsstate=:salegoodsstate ";
	
			final List<SalegoodsT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query=session.createQuery(queryString);
					query.setParameter("salegoodsstate", salegoodsstate);
					List list=query.list();
					return list;
				}
			});
			return list;
		} catch (DataAccessException e) {
			log.debug("not find that salegoodsid");
			throw e;
		}
		
	
			}
}
