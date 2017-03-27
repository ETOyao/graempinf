package com.wanglei.graempinf_core.graempinf_core.model;

public class SelectUtils {
	private String name;
	private String value;
	private Integer id;
	
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public SelectUtils(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SelectUtils() {
		super();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
