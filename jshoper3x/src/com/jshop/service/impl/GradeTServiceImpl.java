package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GradeTDao;
import com.jshop.dao.impl.GradeTDaoImpl;
import com.jshop.entity.GradeT;
import com.jshop.service.GradeTService;

@Service("gradeTService")
@Scope("prototype")
public class GradeTServiceImpl implements GradeTService {
	@Resource
	private GradeTDao gradeTDao;

	public GradeTDao getGradeTDao() {
		return gradeTDao;
	}

	public void setGradeTDao(GradeTDao gradeTDao) {
		this.gradeTDao = gradeTDao;
	}

	public int delGradet(String[] list) {
		return this.getGradeTDao().delGradet(list);
	}

	public int addGradet(GradeT gt) {
		return this.getGradeTDao().addGradet(gt);
	}

	public int countfindAllGrade() {
		return this.getGradeTDao().countfindAllGrade();
	}

	public List<GradeT> findAllGrade(int currentPage, int lineSize) {
		return this.getGradeTDao().findAllGrade(currentPage, lineSize);
	}

	public List<GradeT> findAllGradeByValue(String gradevalue) {
		return this.getGradeTDao().findAllGradeByValue(gradevalue);
	}

	public GradeT findGradeById(String gradeid) {
		return this.getGradeTDao().findGradeById(gradeid);
	}

	public int updateGradeById(GradeT gt) {
		return this.getGradeTDao().updateGradeById(gt);
	}

	@Override
	public List<GradeT> findAllGrade() {
		return this.getGradeTDao().findAllGrade();
	}

}
