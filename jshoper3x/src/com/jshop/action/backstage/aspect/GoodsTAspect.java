package com.jshop.action.backstage.aspect;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.jshop.action.backstage.goods.GoodsTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.entity.GoodsBelinkedT;
import com.jshop.entity.GoodsT;
import com.jshop.service.impl.Serial;


@Aspect
public class GoodsTAspect {
	
	/**
	 * 在商品增加后增加规格值关系
	 * @param joinPoint
	 * @throws IOException
	 */
	@After("execution(String com.jshop.action.GoodsTNAction.addGoods())")
	public void afteraddSpecificationGoods(JoinPoint joinPoint) throws IOException{
		GoodsTAction gtn=(GoodsTAction) joinPoint.getThis();
		if (gtn.getIsSpecificationsOpen().equals("1")) {
			if(gtn.getSpecificationsid()!=null ){
//				GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
//				gsrt.getId().setSpecidicationsId(gtn.getSpecificationsid());
//				gsrt.getId().setGoodsSetId(gtn.getBean().getGoodsid());
//				gtn.getGoodsSpecificationsRelationshipTService().addGoodsAssociatedProductById(gsrt);
			}
		}
	}
	/**
	 * 在商品更新后更新规格值关系
	 * @param joinPoint
	 * @throws IOException
	 */
	@After("execution(String com.jshop.action.GoodsTNAction.updateGoods())")
	public void afterupdateSpecificationGoods(JoinPoint joinPoint) throws IOException{
		GoodsTAction gtn=(GoodsTAction) joinPoint.getThis();
		//当修改商品规格时关闭规格操作将删除该商品的规格值
		if("2".equals(gtn.getIsSpecificationsOpen())||"0".equals(gtn.getIsSpecificationsOpen())){
//			List<GoodsSpecificationsRelationshipT> list = gtn.getGoodsSpecificationsRelationshipTService().checkSpecificationRelationshipBygoodssetid(gtn.getBean().getGoodsid());
//			if(!list.isEmpty()){
//				gtn.getGoodsSpecificationsRelationshipTService().delGoodsAssociatedProductById(gtn.getBean().getGoodsid());			
//			}			
		}
		if("1".equals(gtn.getIsSpecificationsOpen())&&gtn.getSpecificationsid() != null){
//			List<GoodsSpecificationsRelationshipT> list = gtn.getGoodsSpecificationsRelationshipTService().checkSpecificationRelationshipBygoodssetid(gtn.getBean().getGoodsid());
//			if(list.isEmpty()){
//				GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
//				gsrt.getId().setSpecidicationsId(gtn.getSpecificationsid());
//				gsrt.getId().setGoodsSetId(gtn.getBean().getGoodsid());
//				gtn.getGoodsSpecificationsRelationshipTService().addGoodsAssociatedProductById(gsrt);			
//			}else{	
//				GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
//				gsrt.getId().setSpecidicationsId(gtn.getSpecificationsid());
//				gsrt.getId().setGoodsSetId(gtn.getBean().getGoodsid());
//				gtn.getGoodsSpecificationsRelationshipTService().updateGoodsAssociatedProductById(gsrt);
//			}
		}
	}
	
	/**
	 * 在商品增加时增加关联商品
	 */
	@After("execution(String com.jshop.action.GoodsTNAction.addGoods())")
	public void aftergoodsIaddGoodsBelinkedT(JoinPoint joinPoint){
		GoodsTAction gtn=(GoodsTAction) joinPoint.getThis();
		if(Validate.StrNotNull(gtn.getBelinkedgoodsid())){
			//组装json格式的关联商品串
			String belinkedgoodsid=gtn.getBelinkedgoodsid().trim();
			String []strs=StringUtils.split(belinkedgoodsid, ',');
			GoodsT gt=new GoodsT();
			StringBuilder belinkedjson=new StringBuilder(); 
			belinkedjson.append("[");
			for(String s:strs){
				gt=gtn.getGoodsTService().findGoodsById(s);
				String temp[]=StringUtils.split(gt.getPictureurl(), ',');
				belinkedjson.append("{");
				belinkedjson.append("\"goodsid\":\"").append(gt.getGoodsid()).append("\",");
				belinkedjson.append("\"goodsname\":\"").append(gt.getGoodsname()).append("\",");
				belinkedjson.append("\"htmlpath\":\"").append(gt.getHtmlPath()).append("\",");
				belinkedjson.append("\"memberprice\":\"").append(gt.getMemberprice()).append("\",");
				belinkedjson.append("\"price\":\"").append(gt.getPrice()).append("\",");
				belinkedjson.append("\"pictureurl\":\"").append(temp[0]).append("\"");
				belinkedjson.append("},");
			}
			belinkedjson.deleteCharAt(belinkedjson.length()-1);
			belinkedjson.append("]");
			GoodsBelinkedT gbl=new GoodsBelinkedT();
			gbl.setId(gtn.getSerial().Serialid(Serial.GOODSBELINKED));
			gbl.setMaingoodsid(gtn.getBean().getGoodsid());
			gbl.setBelinkedproductinfo(belinkedjson.toString());
			gbl.setMode("1");//默认单向模式
			gbl.setState("1");//开启关联
			gbl.setCreatorid(BaseTools.getAdminCreateId());
			gbl.setCreatetime(BaseTools.systemtime());
			gbl.setUpdatetime(BaseTools.systemtime());
			gbl.setVersiont(0);
			gbl.setSxlinkedgoodsid("0");
			gtn.getGoodsBelinkedTService().save(gbl);
		}
	}
	/**
	 * 在商品增加时增加关联商品
	 */
	@After("execution(String com.jshop.action.GoodsTNAction.updateGoods())")
	public void aftergoodsUaddGoodsBelinkedT(JoinPoint joinPoint){
		GoodsTAction gtn=(GoodsTAction) joinPoint.getThis();
		if(Validate.StrNotNull(gtn.getBelinkedgoodsid())){
			//组装json格式的关联商品串
			String belinkedgoodsid=gtn.getBelinkedgoodsid().trim();
			String []strs=StringUtils.split(belinkedgoodsid, ',');
			GoodsT gt=new GoodsT();
			StringBuilder belinkedjson=new StringBuilder(); 
			belinkedjson.append("[");
			for(String s:strs){
				gt=gtn.getGoodsTService().findGoodsById(s);
				String temp[]=StringUtils.split(gt.getPictureurl(), ',');
				belinkedjson.append("{");
				belinkedjson.append("\"goodsid\":\"").append(gt.getGoodsid()).append("\",");
				belinkedjson.append("\"goodsname\":\"").append(gt.getGoodsname()).append("\",");
				belinkedjson.append("\"htmlpath\":\"").append(gt.getHtmlPath()).append("\",");
				belinkedjson.append("\"memberprice\":\"").append(gt.getMemberprice()).append("\",");
				belinkedjson.append("\"price\":\"").append(gt.getPrice()).append("\",");
				belinkedjson.append("\"pictureurl\":\"").append(temp[0]).append("\"");
				
				belinkedjson.append("},");
			}
			belinkedjson.deleteCharAt(belinkedjson.length()-1);
			belinkedjson.append("]");
			GoodsBelinkedT gbl=new GoodsBelinkedT();
			List<GoodsBelinkedT>list=gtn.getGoodsBelinkedTService().findGoodsBelinkedBymaingoodsid(gtn.getBean().getGoodsid());
			if(!list.isEmpty()){
				gbl.setId(list.get(0).getId());
				gbl.setMaingoodsid(gtn.getBean().getGoodsid());
				gbl.setBelinkedproductinfo(belinkedjson.toString());
				gbl.setMode("1");//默认单向模式
				gbl.setState("1");//开启关联
				gbl.setCreatorid(BaseTools.getAdminCreateId());
				gbl.setCreatetime(list.get(0).getCreatetime());
				gbl.setUpdatetime(BaseTools.systemtime());
				gbl.setVersiont(0);
				gbl.setSxlinkedgoodsid("0");
				@SuppressWarnings("unused")
				int i=gtn.getGoodsBelinkedTService().updateGoodsBelinked(gbl);
			}else{
				gbl.setId(gtn.getSerial().Serialid(Serial.GOODSBELINKED));
				gbl.setMaingoodsid(gtn.getBean().getGoodsid());
				gbl.setBelinkedproductinfo(belinkedjson.toString());
				gbl.setMode("1");//默认单向模式
				gbl.setState("1");//开启关联
				gbl.setCreatorid(BaseTools.getAdminCreateId());
				gbl.setCreatetime(BaseTools.systemtime());
				gbl.setUpdatetime(BaseTools.systemtime());
				gbl.setVersiont(0);
				gbl.setSxlinkedgoodsid("0");
				gtn.getGoodsBelinkedTService().save(gbl);
			}
		}
	}
	
	
    

}
