package com.iccardapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PbmsgRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PBMSG_ROLE", schema = "ehmuser")
public class PbmsgRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName;
	private String roleCode;
	private String isAllot;

	// Constructors

	/** default constructor */
	public PbmsgRole() {
	}

	/** full constructor */
	public PbmsgRole(String roleId, String roleName, String roleCode, String isAllot) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.isAllot = isAllot;
	}

	// Property accessors
	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false, length = 12)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_NAME", nullable = false, length = 32)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "ROLE_CODE", nullable = false, length = 32)
	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Column(name = "IS_ALLOT", nullable = false, length = 3)
	public String getIsAllot() {
		return this.isAllot;
	}

	public void setIsAllot(String isAllot) {
		this.isAllot = isAllot;
	}

}