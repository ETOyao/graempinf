package com.wanglei.graempinf_core.graempinf_core.Enum;

public enum OrgEnum {
	ORG_SCHOOL("学校",0),
	ORG_XUEYUAN("学院",1),
	ORG_DEPARTMENT("院系",2),
	ORG_CLASS("班级",3);
	private String name;
	private Integer index;
	public String getName() {
		return name;
	}
	public Integer getIndex() {
		return index;
	}
	private OrgEnum(String name, Integer index) {
		this.name = name;
		this.index = index;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
}
