package com.iccardapp.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PbmsgUserRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PBMSG_USER_ROLE", schema = "ehmuser")
public class PbmsgUserRole implements java.io.Serializable {

	// Fields

	private PbmsgUserRoleId id;
	private String remarks;

	// Constructors

	/** default constructor */
	public PbmsgUserRole() {
	}

	/** minimal constructor */
	public PbmsgUserRole(PbmsgUserRoleId id) {
		this.id = id;
	}

	/** full constructor */
	public PbmsgUserRole(PbmsgUserRoleId id, String remarks) {
		this.id = id;
		this.remarks = remarks;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, length = 12)),
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false, length = 12)) })
	public PbmsgUserRoleId getId() {
		return this.id;
	}

	public void setId(PbmsgUserRoleId id) {
		this.id = id;
	}

	@Column(name = "REMARKS", length = 200)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}