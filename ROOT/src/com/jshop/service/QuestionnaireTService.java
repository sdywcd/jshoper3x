package com.jshop.service;

import java.util.List;

import com.jshop.entity.QuestionnaireT;

public interface QuestionnaireTService {
	/**
	 * 增加问卷内容
	 * @param qt
	 * @return
	 */
	public abstract int addQuestionnaireT(QuestionnaireT qt);
	/**
	 * 查看所有问卷列表
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<QuestionnaireT>findAllQuestionnaireT(final int currentPage,final int lineSize);
	/**
	 * 统计查看所有问卷系统
	 * @return
	 */
	public abstract int countfindAllQuestionnaireT();
	/**
	 * 更新问卷内容
	 * @param qt
	 * @return
	 */
	public abstract int updateQuestionnaireT(QuestionnaireT qt);
	/**
	 * 根据标题查询问卷内容
	 * @param title
	 * @return
	 */
	public abstract List<QuestionnaireT>findQuestionnaireTBytitle(String title);
	/**
	 * 根据qid删除问卷内容
	 * @param strs
	 * @return
	 */
	public abstract int delQuestionnaireTByqid(String []strs);
	/**
	 * 根据qid获取问答内容
	 * @param qid
	 * @return
	 */
	public abstract QuestionnaireT findQuestionnaireTByqid(String qid);
	
	
}
