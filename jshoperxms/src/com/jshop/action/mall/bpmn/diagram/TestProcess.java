package com.jshop.action.mall.bpmn.diagram;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.DeploymentBuilder;

public class TestProcess {

	public static void main(String[]args){
		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService=processEngine.getRepositoryService();
		DeploymentBuilder builder=repositoryService.createDeployment();
		builder.addClasspathResource("mall/bpmn/diagram/HelloProcess.bpmn");
		builder.deploy();
		RuntimeService runtimeService=processEngine.getRuntimeService();
		runtimeService.startProcessInstanceByKey("helloProcess");
		
	}
}
