package com.wanglei.graempinf_core.graempinf_core.Enum;

public enum MesageEnum {
	MESSAGE_SUCCESS("oper_success","操作成功！");
	private String messageName;
	private String message;
	public String getMessageName() {
		return messageName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private MesageEnum(String messageName, String message) {
		this.messageName = messageName;
		this.message = message;
	}
	
	
}
