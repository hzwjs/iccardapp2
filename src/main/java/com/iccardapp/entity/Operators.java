package com.iccardapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Operators entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "OPERATORS", schema = "ehmuser")
public class Operators implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String operator;
	private String name;
	private String pwd;
	private String lev;
	private String areadigit;
	private String note;
	private String areaCode;
	private String telNo;
	private String branchCode;
	private String forbid;

	// Constructors

	/** default constructor */
	public Operators() {
	}

	/** minimal constructor */
	public Operators(String operator) {
		this.operator = operator;
	}

	/** full constructor */
	public Operators(String operator, String name, String pwd, String lev, String areadigit,
			String note, String areaCode, String telNo, String branchCode, String forbid) {
		this.operator = operator;
		this.name = name;
		this.pwd = pwd;
		this.lev = lev;
		this.areadigit = areadigit;
		this.note = note;
		this.areaCode = areaCode;
		this.telNo = telNo;
		this.branchCode = branchCode;
		this.forbid = forbid;
	}

	// Property accessors
	@Id
	@Column(name = "OPERATOR", unique = true, nullable = false, length = 10)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "NAME", length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PWD", length = 64)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "LEV", length = 10)
	public String getLev() {
		return this.lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	@Column(name = "AREADIGIT", length = 4)
	public String getAreadigit() {
		return this.areadigit;
	}

	public void setAreadigit(String areadigit) {
		this.areadigit = areadigit;
	}

	@Column(name = "NOTE", length = 256)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "AREA_CODE", length = 4)
	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "TEL_NO", length = 16)
	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	@Column(name = "BRANCH_CODE", length = 4)
	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name = "FORBID", length = 1)
	public String getForbid() {
		return this.forbid;
	}

	public void setForbid(String forbid) {
		this.forbid = forbid;
	}

}