package com.iccardapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PbmsgResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PBMSG_RESOURCE", schema = "ehmuser")
public class PbmsgResource implements java.io.Serializable {

	// Fields

	private String id;
	private String resourceSort;
	private String resourceName;
	private String resourceUrl;
	private String resourceContent;
	private String resourceIcon;
	private String resourcePid;
	private String resourceStatus;
	private String resourceType;
	private String resourceCtime;

	// Constructors

	/** default constructor */
	public PbmsgResource() {
	}

	/** minimal constructor */
	public PbmsgResource(String id, String resourceName) {
		this.id = id;
		this.resourceName = resourceName;
	}

	/** full constructor */
	public PbmsgResource(String id, String resourceSort, String resourceName, String resourceUrl,
			String resourceContent, String resourceIcon, String resourcePid, String resourceStatus,
			String resourceType, String resourceCtime) {
		this.id = id;
		this.resourceSort = resourceSort;
		this.resourceName = resourceName;
		this.resourceUrl = resourceUrl;
		this.resourceContent = resourceContent;
		this.resourceIcon = resourceIcon;
		this.resourcePid = resourcePid;
		this.resourceStatus = resourceStatus;
		this.resourceType = resourceType;
		this.resourceCtime = resourceCtime;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 12)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "RESOURCE_SORT", length = 12)
	public String getResourceSort() {
		return this.resourceSort;
	}

	public void setResourceSort(String resourceSort) {
		this.resourceSort = resourceSort;
	}

	@Column(name = "RESOURCE_NAME", nullable = false, length = 32)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "RESOURCE_URL")
	public String getResourceUrl() {
		return this.resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	@Column(name = "RESOURCE_CONTENT")
	public String getResourceContent() {
		return this.resourceContent;
	}

	public void setResourceContent(String resourceContent) {
		this.resourceContent = resourceContent;
	}

	@Column(name = "RESOURCE_ICON")
	public String getResourceIcon() {
		return this.resourceIcon;
	}

	public void setResourceIcon(String resourceIcon) {
		this.resourceIcon = resourceIcon;
	}

	@Column(name = "RESOURCE_PID", length = 12)
	public String getResourcePid() {
		return this.resourcePid;
	}

	public void setResourcePid(String resourcePid) {
		this.resourcePid = resourcePid;
	}

	@Column(name = "RESOURCE_STATUS", length = 3)
	public String getResourceStatus() {
		return this.resourceStatus;
	}

	public void setResourceStatus(String resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	@Column(name = "RESOURCE_TYPE", length = 3)
	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@Column(name = "RESOURCE_CTIME", length = 12)
	public String getResourceCtime() {
		return this.resourceCtime;
	}

	public void setResourceCtime(String resourceCtime) {
		this.resourceCtime = resourceCtime;
	}

}