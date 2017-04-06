package com.wanglei.graempinf_core.graempinf_core.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_QUESTION")
public class Question {
	/**
	 * 问题唯一标示
	 */
	private String questionUuid;
	/**
	 * 问题内容
	 */
	private String questionContent;
	/**
	 * 问题答复内容
	 */
	private String questionAnswer;
	/**
	 * 学生id
	 */
	private String stuuuid;
	/**
	 * 学号
	 */
	private String stunum;
	/**
	 * 学生姓名
	 */
	private String stuName;
	/**
	 * 答复人
	 */
	private String answerPerson;
	/**
	 * 反馈时间
	 */
	private Timestamp createTime;
	/**
	 * 答复时间
	 */
	private Timestamp answertime;
	/**
	 * 状态 0：未答复 1：已答复
	 */
	private Integer finshStatus;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getQuestionUuid() {
		return questionUuid;
	}
	public void setQuestionUuid(String questionUuid) {
		this.questionUuid = questionUuid;
	}
	@NotNull(message="提问内容不能为空！")
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public String getStuuuid() {
		return stuuuid;
	}
	public void setStuuuid(String stuuuid) {
		this.stuuuid = stuuuid;
	}
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getAnswerPerson() {
		return answerPerson;
	}
	public void setAnswerPerson(String answerPerson) {
		this.answerPerson = answerPerson;
	}
	
	public Integer getFinshStatus() {
		return finshStatus;
	}
	public void setFinshStatus(Integer finshStatus) {
		this.finshStatus = finshStatus;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getAnswertime() {
		return answertime;
	}
	public void setAnswertime(Timestamp answertime) {
		this.answertime = answertime;
	}
	@Override
	public String toString() {
		return "Qusetion [qusetionUuid=" + questionUuid + ", questionContent="
				+ questionContent + ", questionAnswer=" + questionAnswer
				+ ", stuuuid=" + stuuuid + ", stunum=" + stunum + ", stuName="
				+ stuName + ", answerPerson=" + answerPerson + ", finshStatus="
				+ finshStatus + "]";
	}
	public Question() {
		super();
	}
	
}
