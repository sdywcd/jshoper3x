package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.QuestionnaireTDao;
import com.jshop.entity.QuestionnaireT;
import com.jshop.service.QuestionnaireTService;

@Service("questionnaireTService")
@Scope("prototype")
public class QuestionnaireTServiceImpl implements QuestionnaireTService {
	@Resource
	private QuestionnaireTDao questionnaireTDao;

	public QuestionnaireTDao getQuestionnaireTDao() {
		return questionnaireTDao;
	}

	public void setQuestionnaireTDao(QuestionnaireTDao questionnaireTDao) {
		this.questionnaireTDao = questionnaireTDao;
	}

	@Override
	public int addQuestionnaireT(QuestionnaireT qt) {
		return this.getQuestionnaireTDao().addQuestionnaireT(qt);
	}

	@Override
	public List<QuestionnaireT> findAllQuestionnaireT(int currentPage, int lineSize) {
		return this.getQuestionnaireTDao().findAllQuestionnaireT(currentPage, lineSize);
	}

	@Override
	public int countfindAllQuestionnaireT() {
		return this.getQuestionnaireTDao().countfindAllQuestionnaireT();
	}

	@Override
	public int updateQuestionnaireT(QuestionnaireT qt) {
		return this.getQuestionnaireTDao().updateQuestionnaireT(qt);
	}

	@Override
	public List<QuestionnaireT> findQuestionnaireTBytitle(String title) {
		return this.getQuestionnaireTDao().findQuestionnaireTBytitle(title);
	}

	@Override
	public int delQuestionnaireTByqid(String[] strs) {
		return this.getQuestionnaireTDao().delQuestionnaireTByqid(strs);
	}

	@Override
	public QuestionnaireT findQuestionnaireTByqid(String qid) {
		return this.getQuestionnaireTDao().findQuestionnaireTByqid(qid);
	}

}
