package com.wanglei.graempinf_core.graempinf_core.Enum;

public enum ChannelType {
	NAV_CHANNEL_TITLE("导航标题"),NAV_CHANNEL_URL("导航子菜单");
	private String name;
	
	private ChannelType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
