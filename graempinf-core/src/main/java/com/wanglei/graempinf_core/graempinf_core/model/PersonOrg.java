package com.wanglei.graempinf_core.graempinf_core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 人员组织岗位对应关系表，这张表里面存储了人员和组织和岗位的对应关系
 * @author KongHao
 *
 */
@Entity
@Table(name="t_person_org_pos")
public class PersonOrg {
	/**
	 * 关系标识
	 */
	private String id;
	/**
	 * 人员id
	 */
	private String personId;
	/**
	 * 组织的id
	 */
	private int orgId;

	@Column(name="org_id")
	public int getOrgId() {
		return orgId;
	}
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	@Column(name="person_id")
	public String getPersonId() {
		return personId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
}
