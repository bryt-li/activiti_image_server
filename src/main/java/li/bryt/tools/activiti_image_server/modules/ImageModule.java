package li.bryt.tools.activiti_image_server.modules;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;

import li.bryt.tools.activiti_image_server.modules.utils.baseModule;
import li.bryt.tools.activiti_image_server.services.ImageService;

@IocBean
@Ok("json")
@Fail("http:500")
public class ImageModule extends baseModule {

	@Inject
	private ImageService imageService;

	@At("/proxy")
	@Ok("raw:png")
	public Object getImage(String name, String src) throws Exception {
		return imageService.deployFromUrlReturnImage(name, src);
	}

}
