package com.example.demo.factory.activiti.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.factory.activiti.service.ActivityConsumerService;

@Service("activityService")
public class ActivityConsumerServiceImpl implements ActivityConsumerService {
	  // 得到运行时服务组件 
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	  // 得到历史服务组件 
	@Autowired
	HistoryService historyService;
	public String startActivityDemo() {
		System.out.println("method startActivityDemo begin....");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("apply", "zhangsan");
		map.put("approve", "lisi");
		// 流程启动
		ExecutionEntity pi1 = (ExecutionEntity) runtimeService.startProcessInstanceByKey("leave", map);
		String processId = pi1.getId();
		System.out.println("pi1----"+processId);

		Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
		String taskId2 = task.getId();
		map.put("pass", false);
		taskService.complete(taskId2, map);// 驳回申请
		System.out.println("method startActivityDemo end....");
		 // 查询没有完成的流程实例  
		List<HistoricDetail>  datas=historyService.createHistoricDetailQuery()    
                .activityInstanceId(task.getId()).list();    
        System.out.println("使用unfinished方法： " + datas.size());  
		return "驳回申请";
	}
  
	      
}