package com.wanglei.graempinf_core.graempinf_core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Title:问题和反馈 </p>
 * <p>Description: 该实体类描述系统反馈问题和处理结果</p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年3月21日
 */
@Entity
@Table(name="T_FEEDBACK")
public class Feedback {
	/**
	 * 问题反馈标示
	 */
	private String feedbackUuid;

	/**
	 * 反馈人姓名
	 */
	private String feedbackPerson;
	/**
	 * 反馈主要问题
	 */
	private String feedbackContent;
	/**
	 * 反馈时间
	 */
	private String feedbackTime;
	/**
	 * 答复内容
	 */
	private String responseContent;
	/**
	 * 答复人
	 */
	private String responsePerson;
	/**
	 * 答复时间
	 */
	private String responseTime;
	/**
	 * 状态 0：default 1：已答复 2： 未答复
	 */
	private Integer feedbackStatus;
	/**
	 * 状态名
	 */
	private String feedbackStatusName;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getFeedbackUuid() {
		return feedbackUuid;
	}
	public void setFeedbackUuid(String feedbackUuid) {
		this.feedbackUuid = feedbackUuid;
	}
	public String getFeedbackPerson() {
		return feedbackPerson;
	}
	public void setFeedbackPerson(String feedbackPerson) {
		this.feedbackPerson = feedbackPerson;
	}
	public String getFeedbackContent() {
		return feedbackContent;
	}
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	public String getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(String feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	public String getResponseContent() {
		return responseContent;
	}
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}
	public String getResponsePerson() {
		return responsePerson;
	}
	public void setResponsePerson(String responsePerson) {
		this.responsePerson = responsePerson;
	}
	public String getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}
	public Integer getFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(Integer feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	public String getFeedbackStatusName() {
		return feedbackStatusName;
	}
	public void setFeedbackStatusName(String feedbackStatusName) {
		this.feedbackStatusName = feedbackStatusName;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackUuid=" + feedbackUuid + ", feedbackPerson="
				+ feedbackPerson + ", feedbackContent=" + feedbackContent
				+ ", feedbackTime=" + feedbackTime + ", responseContent="
				+ responseContent + ", responsePerson=" + responsePerson
				+ ", responseTime=" + responseTime + ", feedbackStatus="
				+ feedbackStatus + ", feedbackStatusName=" + feedbackStatusName
				+ "]";
	}
	public Feedback() {
		super();
	}
	
	
}
