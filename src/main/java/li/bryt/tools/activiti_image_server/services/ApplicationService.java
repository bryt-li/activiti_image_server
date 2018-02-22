package li.bryt.tools.activiti_image_server.services;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;


@IocBean
public class ApplicationService {

	protected final Log LOG;
	public ApplicationService() {
		this.LOG = Logs.get();
	}

	@Inject("java:$config.get('version')")
	private String version;
	
	@Inject("java:$config.get('buildType')")
	private String buildType;
	
	public void init(NutConfig config) {
		LOG.info("init");
	}

	public void destroy(NutConfig config) {
		LOG.info("destroy");
	}
	
	public String getVersion() {
		return version + "_" + buildType;
	}
	
	public String getFooUrl() {
		return "http://foo.oriente.com";
	}
}
