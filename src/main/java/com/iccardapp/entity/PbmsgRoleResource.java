package com.iccardapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PbmsgRoleResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PBMSG_ROLE_RESOURCE", schema = "ehmuser")
public class PbmsgRoleResource implements java.io.Serializable {

	// Fields

	private PbmsgRoleResourceId id;
	private String remarks;

	// Constructors

	/** default constructor */
	public PbmsgRoleResource() {
	}

	/** minimal constructor */
	public PbmsgRoleResource(PbmsgRoleResourceId id) {
		this.id = id;
	}

	/** full constructor */
	public PbmsgRoleResource(PbmsgRoleResourceId id, String remarks) {
		this.id = id;
		this.remarks = remarks;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false, length = 12)),
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false, length = 12)),
			@AttributeOverride(name = "resourceId", column = @Column(name = "RESOURCE_ID", nullable = false, length = 12)) })
	public PbmsgRoleResourceId getId() {
		return this.id;
	}

	public void setId(PbmsgRoleResourceId id) {
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