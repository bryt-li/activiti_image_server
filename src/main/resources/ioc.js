var ioc={
	// 读取配置文件
	config : {
		type : "org.nutz.ioc.impl.PropertiesProxy",
		fields : {
			ignoreResourceNotFound : "true",
			paths : [
			         //production
			         "conf/application-prod.properties",
			         //staging
			         "conf/application-staging.properties",
			         //dev
			         "conf/application-dev.properties",
			         //local
			         "conf/application-local.properties"
			        ]
		}
	},
	dataSource:{
		type:"com.alibaba.druid.pool.DruidDataSource",
		events:{depose:"close"},
		fields:{
			driverClassName : {java :"$config.get('jdbc.driver')"},
			url             : {java :"$config.get('jdbc.url')"},
			username        : {java :"$config.get('jdbc.username')"},
			password        : {java :"$config.get('jdbc.password')"},
			//配置初始化大小、最小、最大
			initialSize     : 1,
			minIdle         : {java :"$config.get('druid.minIdle')"},
			maxActive       : {java :"$config.get('druid.maxActive')"} ,
			//配置获取连接等待超时的时间
			maxWait         : 60000,
			//配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
			timeBetweenEvictionRunsMillis : 60000,
			//配置一个连接在池中最小生存的时间，单位是毫秒 -->
			minEvictableIdleTimeMillis    : 300000,
			validationQuery : "SELECT 'x'",
			testWhileIdle   : true,
			testOnBorrow    : false,
			testOnReturn    : false,
			filters         : "mergeStat,wall",
			dbType			: "mysql"
		}
	},
	activiti : {
		type : "org.nutz.ioc.impl.PropertiesProxy",
		fields : {
			ignoreResourceNotFound : "true",
			paths : [
					"activiti.properties"
			        ]
		}
	}
};