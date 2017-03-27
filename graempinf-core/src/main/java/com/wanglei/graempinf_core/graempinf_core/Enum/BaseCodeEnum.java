package com.wanglei.graempinf_core.graempinf_core.Enum;

public enum BaseCodeEnum {
	//贫困等级
	POVERTYLEVEl_DEFAULT("请选择",0),
	POVERTYLEVEl_NO("无贫困档案",3),
	POVERTYLEVEl_ORDINARY("一般贫困",1),
	//贫困等级
	POVERTYLEVEl_SPECAIL("特别贫困",2),
	//x性别 男
	GENDER_MALE("男",1),
	//是否转入 是
	IS_TRAN_YES("是",1),
	//是否转入 否
	IS_TRAN_NO("否",2),
	IS_TRAN_DEFAULT("请选择",0),
	//是否完成
	IS_FINSH_YES("已完善",9),
	//是否完成
	IS_FINSH_NO("未完善",0),
	//待审核状态
	IS_FINSH_WAIT_ADUIT("待审核",1),
	//审核通过
	IS_FINSH_WAIT_ADUIT_ACC("待审核",1),
	//x性别 女
	GENDER_FEMALE("女",0),
	//是否低保  默认
      LOW_PRO_DEFAULT("请选择",0),
	//是否低保  是
	IS_LOW_PRO("是",1),
	//是否低保 否
	NO_LOW_PRO("否",2),
	//生源地类型  城市
       SOURCE_TYPE_DEFAULT("请选择",0),
	//生源地类型  城市
	SOURCE_TYPE_CITY("城市",1),
	//生源地类型 农村
	SOURCE_TYPE_COUTRY("农村",2);
	private String name;
	private Integer index;
	
	private BaseCodeEnum(String name,Integer index){
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
