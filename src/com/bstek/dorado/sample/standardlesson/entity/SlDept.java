package com.bstek.dorado.sample.standardlesson.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * sl_dept:
 */
@Entity
@Table(name = "sl_dept")
public class SlDept implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * dept_id:
	 */
	private int deptId;

	/**
	 * dept_name:
	 */
	private String deptName;

	/**
	 * sl_dept:
	 */
	private SlDept slDept;

	/**
	 * sl_company:
	 */
	private SlCompany slCompany;

	/**
	 * sl_dept:
	 */
	private Set<SlDept> slDeptSet = new HashSet<SlDept>(0);

	/**
	 * sl_employee:
	 */
	private Set<SlEmployee> slEmployeeSet = new HashSet<SlEmployee>(0);

	public SlDept() {
		super();
	}

	public SlDept(int deptId, String deptName, SlDept slDept,
			SlCompany slCompany, Set<SlDept> slDeptSet,
			Set<SlEmployee> slEmployeeSet) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.slDept = slDept;
		this.slCompany = slCompany;
		this.slDeptSet = slDeptSet;
		this.slEmployeeSet = slEmployeeSet;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id", nullable = false)
	public int getDeptId() {
		return deptId;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "dept_name", length = 50)
	public String getDeptName() {
		return deptName;
	}

	public void setSlDept(SlDept slDept) {
		this.slDept = slDept;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public SlDept getSlDept() {
		return slDept;
	}

	public void setSlCompany(SlCompany slCompany) {
		this.slCompany = slCompany;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	public SlCompany getSlCompany() {
		return slCompany;
	}

	public void setSlDeptSet(Set<SlDept> slDeptSet) {
		this.slDeptSet = slDeptSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "slDept")
	public Set<SlDept> getSlDeptSet() {
		return slDeptSet;
	}

	public void setSlEmployeeSet(Set<SlEmployee> slEmployeeSet) {
		this.slEmployeeSet = slEmployeeSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "slDept")
	public Set<SlEmployee> getSlEmployeeSet() {
		return slEmployeeSet;
	}

	public String toString() {
		return "SlDept [deptId=" + deptId + ",deptName=" + deptName
				+ ",slDept=" + slDept + ",slCompany=" + slCompany
				+ ",slDeptSet=" + slDeptSet + ",slEmployeeSet=" + slEmployeeSet
				+ "]";
	}

}
