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
	SOURCE_TYPE_COUTRY("农村",2),
	//招聘会状态-已发布
	CARIFREE_STATE_APPY_YES("已发布",1),
	//招聘会状态-未发布
	CARIFREE_STATE_ADUIT_WAIT("待审核",0),
	//招聘会状态-未发布
	CARIFREE_STATE_ADUIT_YES("审核同意",2),
	//招聘会状态-未发布
	CARIFREE_STATE_ADUIT_NO("审核不同意",3),
	//招聘会状态-已举行
	CARIFREE_STATE_APPY_HAVED("已举行",1),
	//招聘会预约状态-已预约
    CAP_STATE_APPY_APOINTMENT("已预约",1),
	//招聘会状态-已参加
	CAP_STATE_APPY_ENTER("已参加",2),
	//招聘会状态-已逾期
	CAP_STATE_APPY_MORE("逾期",3),
	//招聘会状态-已取消
    CAP_STATE_APPY_CANCEL("已取消",0),
    //反馈问题处理
    QUESTION_ANSWER_YES("已处理",1),
  //反馈问题处理
    QUESTION_ANSWER_NO("未处理",0);
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
