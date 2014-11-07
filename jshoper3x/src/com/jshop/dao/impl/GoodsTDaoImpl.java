package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsTDao;
import com.jshop.entity.GoodsAttributeT;
import com.jshop.entity.GoodsT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.GoodsT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsTDao")
public class GoodsTDaoImpl extends BaseTDaoImpl<GoodsT> implements GoodsTDao {

	private static final Log log = LogFactory.getLog(GoodsTDaoImpl.class);

	public int countAllGoods(String creatorid) {
		log.debug("count all GoodsT");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all GoodsT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public int delGoods(final String[] list, final String creatorid) {
		log.debug("del GoodsT");
		try {

			final String queryString = "delete from GoodsT as gt where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("goodsid", s);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del GoodsT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findAllGoods(final int currentPage, final int lineSize,
			final String creatorid) {
		log.debug("find all GoodsT");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.creatorid=:creatorid order by createtime desc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
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
			log.error("find all GoodsT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findAllGoodsBysql(final int currentPage,
			final int lineSize, final String queryString) {
		log.debug("findAllGoodsBysql");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
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
		} catch (RuntimeException re) {
			log.error("findAllGoodsBysql error", re);
			throw re;

		}
	}

	@SuppressWarnings("unchecked")
	public GoodsT findGoodsById(String goodsid) {
		log.debug("find by id GoodsT");
		try {
			String queryString = "from GoodsT as gt where gt.goodsid=:goodsid";
			List<GoodsT> list = this.getHibernateTemplate().findByNamedParam(
					queryString, "goodsid", goodsid);
			if (!list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id GoodsT error", re);
			throw re;
		}
	}

	public List<GoodsT> findGoodsBybrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findGoodsByGoodsname(final int currentPage,
			final int lineSize, final String salestate,final String goodsname) {
		log.debug("find all GoodsT by goodsname");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as g where g.goodsname like ? and g.salestate=:salestate order by createtime desc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("salestate", salestate);
							query.setParameter(0, "%" + goodsname + "%");
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("find all GoodsT by goodname error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findGoodsByKeyword(final String keywordid,
			final int currentPage, final int lineSize) {
		log.debug("find all findGoodsByKeyword");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1'and gt.keywordid=:keywordid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("keywordid", keywordid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findGoodsByKeyword error", re);
			throw re;
		}
	}

	public int countfindGoodsByKeyword(String keywordid) {
		log.debug("count all countfindGoodsByKeyword");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate='1' and gt.keywordid=:keywordid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "keywordid", keywordid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindGoodsByKeyword error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findGoodsByLtypeid(final String ltypeid,
			final String salestate, final int currentPage, final int lineSize) {
		log.debug("find all findGoodsByLtypeid");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate=:salestate and gt.ltypeid=:ltypeid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("ltypeid", ltypeid);
							query.setParameter("salestate", salestate);
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsByLtypeid error", re);
			throw re;
		}
	}

	public int countfindGoodsByLtypeid(String ltypeid, String salestate) {
		log.debug("count all countfindGoodsByLtypeid");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate=:salestate and gt.ltypeid=:ltypeid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "salestate", "ltypeid" },
					new Object[] { salestate, ltypeid });
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindGoodsByLtypeid error", re);
			throw re;
		}
	}

	public List<GoodsT> findGoodsBymodel(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GoodsT> findGoodsByNavid(final String navid,
			final String salestate, final int currentPage, final int lineSize) {
		log.debug("find all findGoodsByLtypeid");
		try {
			@SuppressWarnings("unchecked")
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate=:salestate and gt.navid=:navid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("navid", navid);
							query.setParameter("salestate", salestate);
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsByLtypeid error", re);
			throw re;
		}
	}

	public int countfindGoodsByNavid(String navid, String salestate) {
		log.debug("count all countfindGoodsByNavid");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate=:salestate and gt.navid=:navid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "salestate", "navid" },
					new Object[] { salestate, navid });
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindGoodsByNavid error", re);
			throw re;
		}
	}

	public List<GoodsT> findGoodsByprice(String price) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GoodsT> findGoodsByStypeid(String stypeid, String salestate) {
		log.debug("findGoodsByStypeid");
		try {
			String queryString = "from GoodsT as gt where gt.salestate=:salestate and gt.stypeid=:stypeid";
			List<GoodsT> list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "salestate", "stypeid" },
					new Object[] { salestate, stypeid });
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsByStypeid error", re);
			throw re;
		}
	}

	public List<GoodsT> findGoodsByusersetnum(String usersetnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateGoods(final GoodsT g) {
		log.debug("update GoodsT");
		try {
			this.getHibernateTemplate().update(g);
		} catch (RuntimeException re) {
			log.error("update  updateGoods error", re);
			throw re;
		}
	}

	public int updateGoodsbargainprice(final String[] goodsid,
			final String bargainprice, final String creatorid) {
		log.debug("update updateGoodsbargainprice");
		try {

			final String queryString = "update GoodsT as gt set gt.bargainprice=:bargainprice where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("bargainprice", bargainprice);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("update updateGoodsbargainprice failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public int updateGoodshotsale(final String[] goodsid, final String hotsale,
			final String creatorid) {
		log.debug("updateGoodshotsale");
		try {

			final String queryString = "update GoodsT as gt set gt.hotsale=:hotsale where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			Integer integer=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("hotsale", hotsale);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodshotsale failed", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsreadcount(final String goodsid) {
		log.debug("update GoodsT readcount");
		try {
			final String queryString = "update GoodsT as gt set gt.readcount=readcount+1 where gt.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  GoodsT readcount error", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsrecommended(final String[] goodsid,
			final String recommended, final String creatorid) {
		log.debug("update updateGoodsrecommended");
		try {

			final String queryString = "update GoodsT as gt set gt.recommended=:recommended where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("recommended", recommended);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("update UpdateGoodsrecommended failed", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsisNew(final String[] goodsid, final String isNew,
			final String creatorid) {
		log.debug("updateGoodsisNew");
		try {

			final String queryString = "update GoodsT as gt set gt.isNew=:isNew where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("isNew", isNew);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsisNew failed", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsismobileplatformgoods(final String[] goodsid,
			final String ismobileplatformgoods, final String creatorid) {
		log.debug("updateGoodsismobileplatformgoods");
		try {

			final String queryString = "update GoodsT as gt set gt.ismobileplatformgoods=:ismobileplatformgoods where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("ismobileplatformgoods",
								ismobileplatformgoods);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsismobileplatformgoods failed", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsrelatedfit(String goodsid, String list) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateGoodsrelatedgoods(final String goodsid, final String list) {
		log.debug("update GoodsT RELATEDGOODSID");
		try {
			final String queryString = "update GoodsT as gt set gt.relatedgoodsid=:relatedgoodsid where gt.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("relatedgoodsid", list);

					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  GoodsT RELATEDGOODSID error", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsreplycount(String goodsid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateGoodsSaleState(final String[] goodsid,
			final String salestate, final String creatorid) {
		log.debug("update UpdateGoodsSaleState");
		try {

			final String queryString = "update GoodsT as gt set gt.salestate=:salestate where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("salestate", salestate);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("update UpdateGoodsSaleState failed", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsSaleState(final String goodsTypeId,
			final String salestate) {
		log.debug("update UpdateGoodsSaleState");
		try {
			final String queryString = "update GoodsT as gt set gt.salestate=:salestate where gt.goodsTypeId=:goodsTypeId";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					query.setParameter("salestate", salestate);
					query.setParameter("goodsTypeId", goodsTypeId);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update UpdateGoodsSaleState failed", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodssortid(String goodsid, String goodsortid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateGoodssortname(String goodsid, String goodssortname) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateSort(String goodsid, Integer sort) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateFiveGoodsState(final String[] goodsid,
			final String recommended, final String hotsale,
			final String bargainprice, final String isNew,
			final String ismobileplatformgoods) {
		log.debug("updateFiveGoodsState");
		try {

			final String queryString = "update GoodsT as gt set gt.bargainprice=:bargainprice,gt.recommended=:recommended,gt.hotsale=:hotsale,gt.isNew=:isNew,gt.ismobileplatformgoods=:ismobileplatformgoods where gt.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("bargainprice", bargainprice);
						query.setParameter("recommended", recommended);
						query.setParameter("hotsale", hotsale);
						query.setParameter("isNew", isNew);
						query.setParameter("ismobileplatformgoods",
								ismobileplatformgoods);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateFiveGoodsState failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findGoodsForoptiontransferselect(final String navid,
			final String ltypeid, final String stypeid, final String goodsname) {
		log.debug("find all GoodsT");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT  as gt where gt.salestate='1' and gt.navid=:navid and gt.ltypeid=:ltypeid and gt.stypeid=:stypeid and gt.goodsname like :goodsname order by createtime desc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setParameter("navid", navid);
							query.setParameter("ltypeid", ltypeid);
							query.setParameter("stypeid", stypeid);
							query.setParameter("goodsname", "%" + goodsname
									+ "%");
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all GoodsT error", re);
			throw re;
		}
	}

	public List<GoodsT> findAllGoodstWithoutSplitpage() {
		log.debug(" all GoodsT");
		try {
			String queryString = "from GoodsT as gt where gt.salestate='1'";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" all GoodsT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findGoodsLimitByGoodsType(final String nlstypeid,
			final int limit) {
		log.debug("find all GoodsT nlstypeid��limit");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT  as gt where gt.salestate='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid  order by createtime desc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setMaxResults(limit);
							query.setParameter("nlstypeid", nlstypeid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all GoodsT nlstypeid��limit", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findSamepriceGoods(final int limit,
			final double minprice, final double maxprice, final String goodsid) {
		log.debug("find all GoodsT Sameprice��limit");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT  as gt where gt.memberprice between :minprice and :maxprice and gt.goodsid!=:goodsid and gt.salestate='1' order by createtime desc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setMaxResults(limit);
							query.setParameter("minprice", minprice);
							query.setParameter("maxprice", maxprice);
							query.setParameter("goodsid", goodsid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all GoodsT Sameprice��limit", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findMoreGoodsByGoodsType(final String nlstypeid,
			final int currentPage, final int lineSize) {
		log.debug("find all findMoreGoodsByGoodsTyp");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1'and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("nlstypeid", nlstypeid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find allfindMoreGoodsByGoodsType error", re);
			throw re;
		}
	}

	public int countfindMoreGoodsByGoodsType(String nlstypeid) {
		log.debug("count all countfindMoreGoodsByGoodsType");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate='1'and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreGoodsByGoodsType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public int countfindSearchGoods(final String goodsname) {
		log.debug("find all findSearchGoods");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1'and gt.goodsname like ? order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setParameter(0, "%" + goodsname + "%");
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				int i = list.size();
				return i;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("find findSearchGoods error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findSearchGoods(final String goodsname,
			final int currentPage, final int lineSize) {
		log.debug("find all findSearchGoods");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1'and gt.goodsname like ? order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter(0, "%" + goodsname + "%");
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findSearchGoods error", re);
			throw re;
		}
	}

	public int countfindAllGoodslistMore(String salestate) {
		log.debug("count all countfindAllGoodslistMore");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "salestate", salestate);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllGoodslistMore error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findAllGoodslistMore(final int currentPage,
			final int lineSize, final String salestate) {
		log.debug("find all findSearchGoods");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate=:salestate order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("salestate", salestate);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findSearchGoods error", re);
			throw re;
		}
	}

	public int countfindMoreBargainPriceGoods() {
		log.debug("count all countfindMoreBargainPriceGoods");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate='1' and gt.bargainprice='1'";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreBargainPriceGoods error", re);
			throw re;
		}
	}

	public int countfindMoreBargainPriceGoodsByGoodsType(String nlstypeid) {
		log.debug("count all countfindMoreBargainPriceGoodsByGoodsType");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate='1'and gt.bargainprice='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error(
					"count all countfindMoreBargainPriceGoodsByGoodsType error",
					re);
			throw re;
		}
	}

	public int countfindMoreHotSaleGoodsByGoodsType(String nlstypeid) {
		log.debug("count all countfindMoreHotSaleGoodsByGoodsType");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate='1'and gt.hotsale='1'and  gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreHotSaleGoodsByGoodsType error",
					re);
			throw re;
		}
	}

	public int countfindMoreRecommendedGoodsByGoodsType(String nlstypeid) {
		log.debug("count all countfindMoreRecommendedGoodsByGoodsType");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate='1'and gt.recommended='1'and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error(
					"count all countfindMoreRecommendedGoodsByGoodsType error",
					re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findMoreBargainPriceGoods(final int currentPage,
			final int lineSize) {
		log.debug("find all findMoreBargainPriceGoods");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1' and gt.bargainprice='1' order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findMoreBargainPriceGoods error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findMoreBargainPriceGoodsByGoodsType(
			final String nlstypeid, final int currentPage, final int lineSize) {
		log.debug("find all findMoreBargainPriceGoodsByGoodsType");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1' and gt.bargainprice='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("nlstypeid", nlstypeid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findMoreBargainPriceGoodsByGoodsType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findMoreHotSaleGoodsByGoodsType(final String nlstypeid,
			final int currentPage, final int lineSize) {
		log.debug("find all findMoreHotSaleGoodsByGoodsType");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1' and gt.hotsale='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("nlstypeid", nlstypeid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findMoreHotSaleGoodsByGoodsType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findMoreRecommendedGoodsByGoodsType(
			final String nlstypeid, final int currentPage, final int lineSize) {
		log.debug("find all findMoreHotSaleGoodsByGoodsType");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1' and gt.recommended='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("nlstypeid", nlstypeid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findMoreHotSaleGoodsByGoodsType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findAllGoodsByismobileplatformgoods(
			final int currentPage, final int lineSize, final String creatorid) {
		log.debug("findAllGoodsByismobileplatformgoods");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate='1' and gt.ismobileplatformgoods='1' and gt.creatorid=:creatorid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("creatorid", creatorid);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllGoodsByismobileplatformgoods error", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findAllGoodsByismobileplatformgoodsBynavid(
			final String navid, final String salestate,
			final String ismobileplatformgoods) {
		log.debug("findAllGoodsByismobileplatformgoods");
		try {
			@SuppressWarnings("unchecked")
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						String queryString = "from GoodsT as gt where gt.salestate=:salestate and gt.ismobileplatformgoods=:ismobileplatformgoods and gt.navid=:navid order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setParameter("navid", navid);
							query.setParameter("ismobileplatformgoods",
									ismobileplatformgoods);
							query.setParameter("salestate", salestate);
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("findAllGoodsByismobileplatformgoods error", re);
			throw re;
		}
	}

	public int countfindAllGoodsByismobileplatformgoods(String creatorid) {
		log.debug("count all countfindAllGoodsByismobileplatformgoods");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.salestate='1'and gt.ismobileplatformgoods='1' and gt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error(
					"count all countfindAllGoodsByismobileplatformgoods error",
					re);
			throw re;
		}
	}

	public List<GoodsT> findAllGoodsForImgT() {
		log.debug(" all GoodsT");
		try {
			String queryString = "from GoodsT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" all GoodsT error", re);
			throw re;
		}
	}

	public List<GoodsT> findAllGoodsBynavid(String navid, String salestate) {
		log.debug("findAllGoodsBynavid");
		try {
			String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate";
			List<GoodsT> list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "navid", "salestate" },
					new Object[] { navid, salestate });
			return list;
		} catch (RuntimeException re) {
			log.error(" findAllGoodsBynaviderror", re);
			throw re;
		}
	}

	public List<GoodsT> findGoodsByLtypeid(String ltypeid, String salestate) {
		log.debug("findGoodsByLtypeid");
		try {
			String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, new String[] { "ltypeid", "salestate" },
					new Object[] { ltypeid, salestate });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" findGoodsByLtypeid", re);
			throw re;
		}
	}

	public int updateHtmlPath(final String goodsid, final String htmlPath) {
		log.debug("updateHtmlPath");
		try {

			final String queryString = "update GoodsT as gt set gt.htmlPath=:htmlPath where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("htmlPath", htmlPath);

					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateHtmlPath(final String goodsid, final String htmlPath,
			final Date updatetime) {
		log.debug("updateHtmlPath");
		try {

			final String queryString = "update GoodsT as gt set gt.htmlPath=:htmlPath, gt.updatetime=:updatetime where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("htmlPath", htmlPath);
					query.setParameter("updatetime", updatetime);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
	}

	public List<GoodsT> finaAllGoodsT(String salestate) {
		log.debug("finaAllGoodsT");
		try {
			String queryString = "from GoodsT as gt where gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "salestate", salestate);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" finaAllGoodsT", re);
			throw re;
		}
	}

	public int updatecommentsumBygoodsid(final String goodsid,
			final int totalcomment) {
		log.debug("updatetotalcomment");
		try {

			final String queryString = "update GoodsT as gt set gt.totalcomment=:totalcomment  where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("totalcomment", totalcomment);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updatecommentsum error", re);
			throw re;
		}
		return 0;
	}

	public int updatestarsumBygoodsid(final String goodsid, final int star) {
		log.debug("updatestarsumBygoodsid");
		try {

			final String queryString = "update GoodsT as gt set gt.star=:star  where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("star", star);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();

					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updatestarsumBygoodsid error", re);
			throw re;
		}
		return 0;
	}

	public int updatestarusersumBygoodsid(final String goodsid,
			final int staruser) {
		log.debug("updatestarusersum");
		try {

			final String queryString = "update GoodsT as gt set gt.staruser=:staruser  where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("staruser", staruser);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updatestarusersum error", re);
			throw re;
		}
		return 0;
	}

	public List<GoodsT> findAllGoodsBynavidorderbyParams(String navid,
			String salestate, String sales, String memberprice,
			String totalcomment, String bargainprice, String hotsale,
			String recommended, String isNew, String value) {
		log.debug("findAllGoodsBynavidorderbyParams");
		try {
			if (sales != null) {
				String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate order by sales asc";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString, new String[] { "navid", "salestate" },
						new Object[] { navid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (memberprice != null) {
				String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate order by memberprice asc";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString, new String[] { "navid", "salestate" },
						new Object[] { navid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (totalcomment != null) {
				String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate order by totalcomment asc";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString, new String[] { "navid", "salestate" },
						new Object[] { navid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (bargainprice != null) {
				String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.bargainprice=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "navid", "salestate", "value" },
						new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (hotsale != null) {
				String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.hotsale=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "navid", "salestate", "value" },
						new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;

			}
			if (recommended != null) {
				String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.recommended=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "navid", "salestate", "value" },
						new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (isNew != null) {
				String queryString = "from GoodsT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.isNew=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "navid", "salestate", "value" },
						new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" findAllGoodsBynavidorderbyParams", re);
			throw re;
		}
	}

	public List<GoodsT> findAllGoodsByLtypeidorderbyParams(String ltypeid,
			String salestate, String sales, String memberprice,
			String totalcomment, String bargainprice, String hotsale,
			String recommended, String isNew, String value) {
		log.debug("findGoodsByLtypeidorderbyParams");
		try {
			if (sales != null) {
				String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate order by sales asc";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString, new String[] { "ltypeid", "salestate" },
						new Object[] { ltypeid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (memberprice != null) {
				String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate order by memberprice asc";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString, new String[] { "ltypeid", "salestate" },
						new Object[] { ltypeid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (totalcomment != null) {
				String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate order by totalcomment asc";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString, new String[] { "ltypeid", "salestate" },
						new Object[] { ltypeid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (bargainprice != null) {
				String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.bargainprice=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "ltypeid", "salestate", "value" },
						new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (hotsale != null) {
				String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.hotsale=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "ltypeid", "salestate", "value" },
						new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;

			}
			if (recommended != null) {
				String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.recommended=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "ltypeid", "salestate", "value" },
						new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (isNew != null) {
				String queryString = "from GoodsT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.isNew=:value";
				List list = this.getHibernateTemplate().findByNamedParam(
						queryString,
						new String[] { "ltypeid", "salestate", "value" },
						new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findGoodsByLtypeidorderbyParams", re);
			throw re;
		}

	}

	public int updateGoodsTypeNameBygoodsTypeId(final String goodsTypeName,
			final String goodsTypeId) {
		log.debug("updateGoodsTypeNameBygoodsTypeId");
		try {
			final String queryString = "update GoodsT as gt set gt.goodsTypeName=:goodsTypeName  where gt.goodsTypeId=:goodsTypeId ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsTypeName", goodsTypeName);
					query.setParameter("goodsTypeId", goodsTypeId);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsTypeNameBygoodsTypeId error", re);
			throw re;
		}
		return 0;
	}

	public int updateGoodsCategoryBynlsid(final String queryString) {
		log.debug("updateGoodsCategoryBynlsid");
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateGoodsCategoryBynlsid error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findshuffleGoods(final int currentPage,
			final int lineSize, final String salestate, final String recommended) {
		log.debug("findshuffleGoods");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate=:salestate and gt.recommended=:recommended order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("salestate", salestate);
							query.setParameter("recommended", recommended);
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("findshuffleGoods error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsT> findGoodsByattrs(final int currentPage,
			final int lineSize, final String attr, final String salestate) {
		log.debug("findGoodsByattrs");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT as gt where gt.salestate=:salestate and gt.goodsAttrVal0=:attr or gt.goodsAttrVal1=:attr or gt.goodsAttrVal2=:attr or gt.goodsAttrVal3=:attr or gt.goodsAttrVal4=:attr or gt.goodsAttrVal5=:attr or gt.goodsAttrVal6=:attr or gt.goodsAttrVal7=:attr or gt.goodsAttrVal8=:attr or gt.goodsAttrVal9=:attr or gt.goodsAttrVal10=:attr or gt.goodsAttrVal11=:attr or gt.goodsAttrVal12=:attr or gt.goodsAttrVal13=:attr or gt.goodsAttrVal14=:attr or gt.goodsAttrVal15=:attr or gt.goodsAttrVal16=:attr or gt.goodsAttrVal17=:attr or gt.goodsAttrVal18=:attr or gt.goodsAttrVal19=:attr or gt.goodsAttrVal20=:attr or gt.goodsAttrVal21=:attr or gt.goodsAttrVal22=:attr or gt.goodsAttrVal23=:attr or gt.goodsAttrVal24=:attr or gt.goodsAttrVal25=:attr or gt.goodsAttrVal26=:attr or gt.goodsAttrVal27=:attr or gt.goodsAttrVal28=:attr or gt.goodsAttrVal29=:attr  order by createtime asc";

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("attr", attr);
							query.setParameter("salestate", salestate);
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("findGoodsByattrs error", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findGoodsByNavid(String navid, String salestate,
			String ismobileplatformgoods) {
		log.debug("findGoodsByNavidforandroid");
		try {
			String queryString = "from GoodsT as gt where gt.navid=:navid and gt.ismobileplatformgoods=:ismobileplatformgoods and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString,
					new String[] { "navid", "ismobileplatformgoods",
							"salestate" },
					new Object[] { navid, ismobileplatformgoods, salestate });
			return list;
		} catch (RuntimeException re) {
			log.error(" findGoodsByNavidforandroid", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findAllGoodsBynavid(String navid, String salestate,
			String isSpecificationsOpen) {
		log.debug("findGoodsByNavidforandroid");
		try {
			String queryString = "from GoodsT as gt where gt.navid=:navid and gt.isSpecificationsOpen=:isSpecificationsOpen and gt.salestate=:salestate";
			List list = this.getHibernateTemplate()
					.findByNamedParam(
							queryString,
							new String[] { "navid", "isSpecificationsOpen",
									"salestate" },
							new Object[] { navid, isSpecificationsOpen,
									salestate });
			return list;
		} catch (RuntimeException re) {
			log.error(" findGoodsByNavidforandroid", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findAllGoodsBynavidandltypeid(String navid,
			String ltypeid, String salestate, String isSpecificationsOpen) {
		log.debug("findAllGoodsBynavidandltypeid");
		try {
			String queryString = "from GoodsT as gt where gt.navid=:navid and gt.ltypeid=:ltypeid and gt.isSpecificationsOpen=:isSpecificationsOpen and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString,
					new String[] { "navid", "ltypeid", "isSpecificationsOpen",
							"salestate" },
					new Object[] { navid, ltypeid, isSpecificationsOpen,
							salestate });
			return list;
		} catch (RuntimeException re) {
			log.error(" findAllGoodsBynavidandltypeid error ", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findAllGoodsBynavidandltypeidandstypeid(String navid,
			String ltypeid, String stypeid, String salestate,
			String isSpecificationsOpen) {
		log.debug("findAllGoodsBynavidandltypeidandstypeid");
		try {
			String queryString = "from GoodsT as gt where gt.navid=:navid and gt.ltypeid=:ltypeid and gt.stypeid=:stypeid and gt.isSpecificationsOpen=:isSpecificationsOpen and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString,
					new String[] { "navid", "ltypeid", "stypeid",
							"isSpecificationsOpen", "salestate" },
					new Object[] { navid, ltypeid, stypeid,
							isSpecificationsOpen, salestate });
			return list;
		} catch (RuntimeException re) {
			log.error(" findAllGoodsBynavidandltypeidandstypeid error ", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findAllGoods() {

		try {
			final String queryString = "from GoodsT";
			@SuppressWarnings("unchecked")
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							List list = query.list();
							return list;
						}
					});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException e) {
			throw e;
		}

	}

	@Override
	public int countAllGoodsBysql(String queryString) {
		log.debug("countAllGoodsBysql");
		try {
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countAllGoodsBysql error", re);
			throw re;
		}
	}

	@Override
	public int countAllGoods() {
		log.debug("countAllGoods");
		try {
			String queryString = "select count(*) from GoodsT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countAllGoods error", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findAllGoods(final int currentPage, final int lineSize) {
		log.debug("find all GoodsT");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						String queryString = "from GoodsT  order by createtime desc";

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
		} catch (RuntimeException re) {
			log.error("find all GoodsT error", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findAllGoodsByattribute(final int currentPage,
			final int lineSize, final String queryString) {
		log.debug("findAllGoodsByattribute");
		try {
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
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
		} catch (RuntimeException re) {
			log.error("findAllGoodsByattribute error", re);
			throw re;
		}
	}

	@Override
	public int countfindAllGoodsByattribute(String queryString) {
		log.debug("countfindAllGoodsByattribute");
		try {
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindAllGoodsByattribute error", re);
			throw re;
		}
	}

	@Override
	public int updateGoodsQuantityByGoodsId(final int oldQuantity,final int newQuantity, final String goodsid) {
		log.debug("updateGoodsQuantityByGoodsId");
		try {
			final String queryString = "update GoodsT as gt set gt.quantity=gt.quantity-:oldQuantity+:newQuantity where gt.goodsid=:goodsid";
			int i=this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("oldQuantity", oldQuantity);
					query.setParameter("newQuantity", newQuantity);
					return query.executeUpdate();
				}
			});
			return i;
		} catch (RuntimeException re) {
			log.error("updateGoodsQuantityByGoodsId failed", re);
			throw re;
		}
	
	}

	@Override
	public List<GoodsT> findrecommendedGoodsT(final String salestate,
			final String recommended, final int lineSize) {
		log.debug("findrecommendedGoodsT");
		try {
			final String queryString = "from GoodsT as gt where gt.salestate=:salestate and gt.recommended=:recommended order by gt.createtime desc";
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setParameter("salestate", salestate);
							query.setParameter("recommended", recommended);
							query.setMaxResults(lineSize);
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("findrecommendedGoodsT error", re);
			throw re;
		}
	}

	@Override
	public List<GoodsT> findvirtualsaleGoodsT(final int currentPage, final int lineSize,
			final String isvirtualsale) {
		log.debug("findvirtualsaleGoodsT");
		try {
			final String queryString = "from GoodsT as gt where gt.isvirtualsale=:isvirtualsale order by gt.createtime desc";
			List<GoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							query.setParameter("isvirtualsale", isvirtualsale);
							List list = query.list();
							return list;
						}
					});
			return list;
		} catch (RuntimeException re) {
			log.error("findvirtualsaleGoodsT error", re);
			throw re;
		}
	}

	@Override
	public int countfindvirtualsaleGoodsT(String isvirtualsale) {
		log.debug("countfindvirtualsaleGoodsT");
		try {
			String queryString = "select count(*) from GoodsT as gt where gt.isvirtualsale=:isvirtualsale";
			List list = this.getHibernateTemplate().findByNamedParam(
					queryString, "isvirtualsale", isvirtualsale);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("countfindvirtualsaleGoodsT error", re);
			throw re;
		}
	}

}