package com.wanglei.graempinf_core.graempinf_core.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="t_student")
public class Student {
	
	/**
	 * 学生唯一标示
	 */
	private String stuUuid;
	
	/**
	 * 考生号
	 */
	private String examineeNum;
	
	/**
	 * 学号
	 */
	private String stuNum;
	
	/**
	 * 学生姓名
	 */
	private String sutName;
	
	/**
	 * 身份证号
	 */
	private String idCardNum;
	
	/**
	 * 系编号
	 */
	private String deptNnum;
	
	/**
	 * 系名称
	 */
	private String deptName;
	private Integer deptid;
	
	/**
	 *   学院编号
	 */
	private String collegeNum;
	private Integer collegeid;
	
	/**
	 * 所在学院名称
	 */
	private String collegeName;;
	/**
	 * 班级编号
	 */
	private String stuTeamNum;
	private Integer stuTeamid;

	
	/**
	 * 班级名称
	 */
	private String stuTeam;
	
	/**
	 * 性别
	 */
	private Integer gender;
	
	/**
	 * 民族
	 */
	private String nation;
	
	/**
	 * 政治面貌
	 */
	private String politicalStatus;
	
	/**
	 * 学历
	 */
	private String education;
	
	/**
	 * 专业
	 */
	private String major;
	
	/**
	 * 专业方向
	 */
	private String majordirection;
	
	/**
	 * 培养方式
	 */
	private String trainingMethod;
	
	/**
	 * 学制
	 */
	private String eductionalSystme;
	
	/**
	 * 入学时间
	 */
	 @DateTimeFormat(pattern = "yyyy-MM-dd")   
	private Date enterTime;
	
	/**
	 * 毕业时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")   
	private Date graduateTime;
	
	/**
	 * 贫困等级
	 */
	private Integer povertyLevel;
	
	/**
	 * 出生日期
	 */
	 @DateTimeFormat(pattern = "yyyy-MM-dd")   
	private Date birthDate;
	
	/**
	 * 入学前档案地址
	 */
	private String beforerecordaddr;
	
	
	/**
	 * 入学前档案是否转入
	 */
	private Integer recordIsTranSchool;
	
	/**
	 * 入学前户籍是否转入
	 */
	private Integer censusIsTranSchool;
	
	
	/**
	 *入学期户籍地址 
	 */
	private String beforecensusaddr;
	
	/**
	 * 电话
	 */
	private String phone;
	
	/**
	 * QQ号码
	 */
	private String qqNum;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 信息状态
	 */
	private Integer finshStatus;
	
	/**
	 *学生头像地址
	 */
	private String imgurl;
	
	/**
	 * 扩展字段
	 */
	private String attr1;
	private String attr2;
	private String attr3;
	
	public String getAttr1() {
		return attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getStuUuid() {
		return stuUuid;
	}
	@NotNull(message="考生号不能为空！")
	public String getExamineeNum() {
		return examineeNum;
	}
	@NotNull(message="学号不能为空！")
	public String getStuNum() {
		return stuNum;
	}
	@NotNull(message="学生姓名不能为空！")
	public String getSutName() {
		return sutName;
	}
	@NotNull(message="身份证号不能为空！")
	public String getIdCardNum() {
		return idCardNum;
	}

	public String getDeptNnum() {
		return deptNnum;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getStuTeam() {
		return stuTeam;
	}

	

	public String getNation() {
		return nation;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public String getEducation() {
		return education;
	}

	public String getMajor() {
		return major;
	}

	public String getMajordirection() {
		return majordirection;
	}

	public String getTrainingMethod() {
		return trainingMethod;
	}

	public String getEductionalSystme() {
		return eductionalSystme;
	}

	public Date getEnterTime() {
		return enterTime;
	}

	public Date getGraduateTime() {
		return graduateTime;
	}


	public Date getBirthDate() {
		return birthDate;
	}

	public Integer getDeptid() {
		return deptid;
	}
	public Integer getCollegeid() {
		return collegeid;
	}
	public Integer getStuTeamid() {
		return stuTeamid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}
	public void setStuTeamid(Integer stuTeamid) {
		this.stuTeamid = stuTeamid;
	}

	public String getPhone() {
		return phone;
	}

	public String getQqNum() {
		return qqNum;
	}
	@Email(message="邮件格式不正确！")
	public String getEmail() {
		return email;
	}


	public void setStuUuid(String stuUuid) {
		this.stuUuid = stuUuid;
	}

	public void setExamineeNum(String examineeNum) {
		this.examineeNum = examineeNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public void setSutName(String sutName) {
		this.sutName = sutName;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public void setDeptNnum(String deptNnum) {
		this.deptNnum = deptNnum;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setStuTeam(String stuTeam) {
		this.stuTeam = stuTeam;
	}

	

	public void setNation(String nation) {
		this.nation = nation;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setMajordirection(String majordirection) {
		this.majordirection = majordirection;
	}

	public void setTrainingMethod(String trainingMethod) {
		this.trainingMethod = trainingMethod;
	}

	public void setEductionalSystme(String eductionalSystme) {
		this.eductionalSystme = eductionalSystme;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	public void setGraduateTime(Date graduateTime) {
		this.graduateTime = graduateTime;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Student() {
		super();
	}
	public String getStuTeamNum() {
		return stuTeamNum;
	}
	public void setStuTeamNum(String stuTeamNum) {
		this.stuTeamNum = stuTeamNum;
	}
	
	public String getCollegeNum() {
		return collegeNum;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeNum(String collegeNum) {
		this.collegeNum = collegeNum;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Integer getGender() {
		return gender;
	}
	public Integer getPovertyLevel() {
		return povertyLevel;
	}
	public Integer getRecordIsTranSchool() {
		return recordIsTranSchool;
	}
	public Integer getCensusIsTranSchool() {
		return censusIsTranSchool;
	}
	public Integer getFinshStatus() {
		return finshStatus;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public void setPovertyLevel(Integer povertyLevel) {
		this.povertyLevel = povertyLevel;
	}
	public void setRecordIsTranSchool(Integer recordIsTranSchool) {
		this.recordIsTranSchool = recordIsTranSchool;
	}
	public void setCensusIsTranSchool(Integer censusIsTranSchool) {
		this.censusIsTranSchool = censusIsTranSchool;
	}
	public void setFinshStatus(Integer finshStatus) {
		this.finshStatus = finshStatus;
	}
	public String getBeforecensusaddr() {
		return beforecensusaddr;
	}
	public void setBeforecensusaddr(String beforecensusaddr) {
		this.beforecensusaddr = beforecensusaddr;
	}
	public String getBeforerecordaddr() {
		return beforerecordaddr;
	}
	public void setBeforerecordaddr(String beforerecordaddr) {
		this.beforerecordaddr = beforerecordaddr;
	}
	
	public Student (String stuUuid,String examineeNum,String stuNum,String sutName,String stuTeam,String idCardNum,String collegeName,String deptName,Integer gender,Integer finshStatus) {
		this.stuUuid = stuUuid;
		this.examineeNum = examineeNum;
		this.stuNum = stuNum;
		this.sutName = sutName;
		this.idCardNum = idCardNum;
		this.deptName = deptName;
		this.collegeName = collegeName;
		this.stuTeam = stuTeam;
		this.gender = gender;
		this.finshStatus = finshStatus;
	}
	@Override
	public String toString() {
		return "Student [stuUuid=" + stuUuid + ", examineeNum=" + examineeNum + ", stuNum=" + stuNum + ", sutName=" + sutName + ", idCardNum=" + idCardNum + ", deptNnum=" + deptNnum
				+ ", deptName=" + deptName + ", collegeNum=" + collegeNum + ", collegeName=" + collegeName + ", stuTeamNum=" + stuTeamNum + ", stuTeam=" + stuTeam + ", gender=" + gender
				+ ", nation=" + nation + ", politicalStatus=" + politicalStatus + ", education=" + education + ", major=" + major + ", majordirection=" + majordirection + ", trainingMethod="
				+ trainingMethod + ", eductionalSystme=" + eductionalSystme + ", enterTime=" + enterTime + ", graduateTime=" + graduateTime + ", povertyLevel=" + povertyLevel + ", birthDate="
				+ birthDate + ", beforerecordaddr=" + beforerecordaddr + ", recordIsTranSchool=" + recordIsTranSchool + ", censusIsTranSchool=" + censusIsTranSchool + ", beforecensusaddr="
				+ beforecensusaddr + ", phone=" + phone + ", qqNum=" + qqNum + ", email=" + email + ", finshStatus=" + finshStatus + ", imgurl=" + imgurl + ", attr1=" + attr1 + ", attr2="
				+ attr2 + ", attr3=" + attr3 + "]";
	}
	
	
}
