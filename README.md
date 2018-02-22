# README #

Deploy BPMN model from http URL and render image.

Requires JDK1.8

	mvn tomcat7:run
	# http://localhost:9000/activiti_image_server/version
	
	mvn jetty:run
	@ http://localhost:8080/version
	
	mvn tomcat7:deploy
	mvn tomcat7:undeploy
	mvn tomcat7:redeploy


	mvn test
		
```
![Activiti Example](http://uml.oriente.com.ph/activiti_image_server/proxy?name=FooProcess.bpmn&src=https://bryt-li.github.io/bpmn/FooProcess.bpmn)
```

![Activiti Example](http://uml.oriente.com.ph/activiti_image_server/proxy?name=FooProcess.bpmn&src=https://bryt-li.github.io/bpmn/FooProcess.bpmn)
