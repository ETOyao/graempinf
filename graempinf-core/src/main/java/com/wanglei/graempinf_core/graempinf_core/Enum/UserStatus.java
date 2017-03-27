package com.wanglei.graempinf_core.graempinf_core.Enum;

public enum UserStatus {
	USER_STATUS_STOP("停止",0),
	USER_STATUS_START("启动",1);
	private String name;
	private Integer index;
	
	private UserStatus(String name,Integer index){
		this.name=name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public Integer getIndex() {
		return index;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
}
