package com.bstek.dorado.sample.standardlesson.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * sl_company:
 */
@Entity
@Table(name = "sl_company")
public class SlCompany implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * company_id:
	 */
	private int companyId;

	/**
	 * company_name:
	 */
	private String companyName;

	/**
	 * full_name:
	 */
	private String fullName;

	/**
	 * web:
	 */
	private String web;

	/**
	 * address:
	 */
	private String address;

	/**
	 * postcode:
	 */
	private String postcode;

	/**
	 * phone:
	 */
	private String phone;

	/**
	 * email:
	 */
	private String email;

	/**
	 * sl_dept:
	 */
	private Set<SlDept> slDeptSet = new HashSet<SlDept>(0);

	public SlCompany() {
		super();
	}

	public SlCompany(int companyId, String companyName, String fullName,
			String web, String address, String postcode, String phone,
			String email, Set<SlDept> slDeptSet) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.fullName = fullName;
		this.web = web;
		this.address = address;
		this.postcode = postcode;
		this.phone = phone;
		this.email = email;
		this.slDeptSet = slDeptSet;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id", nullable = false)
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "company_name", length = 50)
	public String getCompanyName() {
		return companyName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "full_name", length = 100)
	public String getFullName() {
		return fullName;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Column(name = "web", length = 45)
	public String getWeb() {
		return web;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return address;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "postcode", length = 45)
	public String getPostcode() {
		return postcode;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return email;
	}

	public void setSlDeptSet(Set<SlDept> slDeptSet) {
		this.slDeptSet = slDeptSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "slCompany")
	public Set<SlDept> getSlDeptSet() {
		return slDeptSet;
	}

	public String toString() {
		return "SlCompany [companyId=" + companyId + ",companyName="
				+ companyName + ",fullName=" + fullName + ",web=" + web
				+ ",address=" + address + ",postcode=" + postcode + ",phone="
				+ phone + ",email=" + email + ",slDeptSet=" + slDeptSet + "]";
	}

}
