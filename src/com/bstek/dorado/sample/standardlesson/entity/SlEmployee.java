package com.bstek.dorado.sample.standardlesson.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * sl_employee:
 */
@Entity
@Table(name = "sl_employee")
public class SlEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * EMPLOYEE_ID:
	 */
	private int employeeId;

	/**
	 * EMPLOYEE_CODE:
	 */
	private String employeeCode;

	/**
	 * USER_NAME:
	 */
	private String userName;

	/**
	 * EMPLOYEE_NAME:
	 */
	private String employeeName;

	/**
	 * SEX:
	 */
	private boolean sex;

	/**
	 * BIRTHDAY:
	 */
	private Date birthday;

	/**
	 * MARRIED:
	 */
	private boolean married;

	/**
	 * SALARY:
	 */
	private BigDecimal salary;

	/**
	 * DEGREE:
	 */
	private String degree;

	/**
	 * EMAIL:
	 */
	private String email;

	/**
	 * WEB:
	 */
	private String web;

	/**
	 * CMNT:
	 */
	private String cmnt;

	/**
	 * IMAGE:
	 */
	private String image;

	/**
	 * PASSWORD:
	 */
	private String password;

	/**
	 * ANIMAL:
	 */
	private String animal;

	/**
	 * PHONE:
	 */
	private String phone;

	/**
	 * MOBILE:
	 */
	private String mobile;

	/**
	 * POSITION:
	 */
	private String position;

	/**
	 * sl_dept:
	 */
	private SlDept slDept;

	/**
	 * sl_message:
	 */
	private Set<SlMessage> slMessageSet = new HashSet<SlMessage>(0);

	public SlEmployee() {
		super();
	}

	public SlEmployee(int employeeId, String employeeCode, String userName,
			String employeeName, boolean sex, Date birthday, boolean married,
			BigDecimal salary, String degree, String email, String web,
			String cmnt, String image, String password, String animal,
			String phone, String mobile, String position, SlDept slDept,
			Set<SlMessage> slMessageSet) {
		super();
		this.employeeId = employeeId;
		this.employeeCode = employeeCode;
		this.userName = userName;
		this.employeeName = employeeName;
		this.sex = sex;
		this.birthday = birthday;
		this.married = married;
		this.salary = salary;
		this.degree = degree;
		this.email = email;
		this.web = web;
		this.cmnt = cmnt;
		this.image = image;
		this.password = password;
		this.animal = animal;
		this.phone = phone;
		this.mobile = mobile;
		this.position = position;
		this.slDept = slDept;
		this.slMessageSet = slMessageSet;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID", nullable = false)
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Column(name = "EMPLOYEE_CODE", length = 20)
	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_NAME", length = 20)
	public String getUserName() {
		return userName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "EMPLOYEE_NAME", length = 16)
	public String getEmployeeName() {
		return employeeName;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Column(name = "SEX", nullable = false)
	public boolean isSex() {
		return sex;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	@Column(name = "MARRIED", nullable = false)
	public boolean isMarried() {
		return married;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Column(name = "SALARY")
	public BigDecimal getSalary() {
		return salary;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "DEGREE", length = 30)
	public String getDegree() {
		return degree;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return email;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Column(name = "WEB", length = 50)
	public String getWeb() {
		return web;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	@Column(name = "CMNT", length = 255)
	public String getCmnt() {
		return cmnt;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "IMAGE", length = 50)
	public String getImage() {
		return image;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "PASSWORD", length = 45)
	public String getPassword() {
		return password;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	@Column(name = "ANIMAL", length = 45)
	public String getAnimal() {
		return animal;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PHONE", length = 45)
	public String getPhone() {
		return phone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "MOBILE", length = 45)
	public String getMobile() {
		return mobile;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "POSITION", length = 45)
	public String getPosition() {
		return position;
	}

	public void setSlDept(SlDept slDept) {
		this.slDept = slDept;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID")
	public SlDept getSlDept() {
		return slDept;
	}

	public void setSlMessageSet(Set<SlMessage> slMessageSet) {
		this.slMessageSet = slMessageSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "slEmployee")
	public Set<SlMessage> getSlMessageSet() {
		return slMessageSet;
	}

	public String toString() {
		return "SlEmployee [employeeId=" + employeeId + ",employeeCode="
				+ employeeCode + ",userName=" + userName + ",employeeName="
				+ employeeName + ",sex=" + sex + ",birthday=" + birthday
				+ ",married=" + married + ",salary=" + salary + ",degree="
				+ degree + ",email=" + email + ",web=" + web + ",cmnt=" + cmnt
				+ ",image=" + image + ",password=" + password + ",animal="
				+ animal + ",phone=" + phone + ",mobile=" + mobile
				+ ",position=" + position + ",slDept=" + slDept
				+ ",slMessageSet=" + slMessageSet + "]";
	}

}
