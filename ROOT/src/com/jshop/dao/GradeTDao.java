package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GradeT;

public interface GradeTDao {

	/**
	 * 增加用户等级
	 * @param gt
	 * @return
	 */
	public abstract int addGradet(GradeT gt);

	/**
	 * 删除用户等级
	 * @param list
	 * @return
	 */
	public abstract int delGradet(String[]list);

	/**
	 * 查询所有用户等级信息
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract  List<GradeT>findAllGrade(final int currentPage,final int lineSize);
	/**
	 * 统计查询所有用户等级信息
	 * @return
	 */
	public abstract int countfindAllGrade();
	/**
	 * 根据会员类型判断会员重复
	 * @param gradevalue
	 * @return
	 */
	public abstract List<GradeT>findAllGradeByValue(String gradevalue);

	/**
	 * 根据用户等级获取等级设置信息
	 * @param gradeid
	 * @return
	 */
	public abstract GradeT findGradeById(String gradeid);

	/**
	 * 更新用户等级
	 * @param gt
	 * @return
	 */
	public abstract int updateGradeById(GradeT gt);
	/**
	 * 查询所有用户等级信息
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract  List<GradeT>findAllGrade();







}
