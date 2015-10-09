package com.iccardapp.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PbmsgUserRoleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PbmsgUserRoleId implements java.io.Serializable {

	// Fields

	private String userId;
	private String roleId;

	// Constructors

	/** default constructor */
	public PbmsgUserRoleId() {
	}

	/** full constructor */
	public PbmsgUserRoleId(String userId, String roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	// Property accessors

	@Column(name = "USER_ID", nullable = false, length = 12)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "ROLE_ID", nullable = false, length = 12)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PbmsgUserRoleId))
			return false;
		PbmsgUserRoleId castOther = (PbmsgUserRoleId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

}