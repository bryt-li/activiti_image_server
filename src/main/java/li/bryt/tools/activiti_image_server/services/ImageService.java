package li.bryt.tools.activiti_image_server.services;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

@IocBean
public class ImageService {
	protected final Log LOG;
	
	@Inject
	private ApplicationService appService;
	
	public ImageService() {
		this.LOG = Logs.get();
	}
	
	public Object deployFromUrlReturnImage(String name, String src) {
		try {
			LOG.debugf("name=%s&src=%s",name,src);
			RepositoryService repositoryService = this.appService.getEngine().getRepositoryService();
			URL website = new URL(src);
			InputStream in = website.openStream();
			Deployment deploy = repositoryService.createDeployment().addInputStream(name, in).deploy();
			ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
			BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinition.getId());
			InputStream imageStream = new DefaultProcessDiagramGenerator().generatePngDiagram(bpmnModel);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int reads = imageStream.read();

			while (reads != -1) {
				baos.write(reads);
				reads = imageStream.read();
			}
			repositoryService.deleteDeployment(deploy.getId(), true);
			return baos.toByteArray();
		}catch(Exception e) {
			LOG.error(e);
			return null;			
		}		
	}
}
