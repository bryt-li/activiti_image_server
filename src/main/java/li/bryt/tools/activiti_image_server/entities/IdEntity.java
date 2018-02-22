/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package li.bryt.tools.activiti_image_server.entities;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;

/**
 * 统一定义id的entity基类.
 *
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * Oracle需要每个Entity独立定义id的SEQUCENCE时，不继承于本类而改为实现一个Idable的接口。
 *
 * @author calvin
 */

public abstract class IdEntity {

	protected Long id;

	@Id
	@Column("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
