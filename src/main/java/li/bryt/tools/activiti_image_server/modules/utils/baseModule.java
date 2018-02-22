package li.bryt.tools.activiti_image_server.modules.utils;

import org.nutz.json.Json;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

public abstract class baseModule {

	protected final Log LOG = Logs.getLog(this.getClass());

	protected RESTfulResponse ok(NutMap data) {
		LOG.debugf("return ok='%s'", Json.toJson(data));
		return new RESTfulResponse(true, data);
	}
		
	protected RESTfulResponse err(String errmsg){
		LOG.debugf("return err='%s'", errmsg);
		return new RESTfulResponse(false, new NutMap().setv("errmsg", errmsg));
	}
	
	protected RESTfulResponse err(Exception e){
		String errmsg = e.getMessage();
		LOG.debugf("return err='%s'", errmsg);
		return new RESTfulResponse(false, new NutMap().setv("errmsg", errmsg));
	}

}
