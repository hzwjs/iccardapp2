package com.iccardapp.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PbmsgMerch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PBMSG_MERCH", schema = "ehmuser")
public class PbmsgMerch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowId;
	private String merchBank;
	private String branchName;
	private String branch1;
	private String branch2;
	private String branch3;
	private String branch4;
	private String branch5;
	private String merchType;
	private String merchCode;
	private String rebateType;
	private Double rebateRate;
	private String merchName;
	private String merchDesc;
	private String postCode;
	private String tradeType;
	private String forgnFlag;
	private String qcAcct;
	private String bhAcct;
	private String thAcct;
	private String telNo;
	private String manager;
	private String regCode;
	private String taxNo;
	private String mainItem;
	private String operator;
	private Date operTime;
	private String signAcct;
	private Double rebateMix;
	private Double rebateMax;
	private String isReal;
	private String shortName;
	private String areaCode;
	private String state;
	private String merchZl;
	private String fxjb;
	private String approveOper;
	private Date approveDate;
	private Date signDate;
	private String unsignDate;
	private Double atmDayTotl;
	private Double cshDayTotl;
	private Double tsfDayTotl;
	private Double atmLmt;
	private Double cshLmt;
	private Double tsfLmt;
	private String thsxf;
	private String frRate;
	private String isthk;
	private String isrealth;
	private String thcardacctname;
	private String frratebu;
	private String syncFlag;
	private String cfee1;
	private String cfee2;
	private String setAcctName;
	private String branch;
	private String rateDiscount;
	private String orgNo;
	private String busScope;
	private String legalPersonName;
	private String legalPersonId;
	private String terminalMobileNo;
	private String terminalFixedNo;
	private String custManager;
	private String custManagerNo;
	private String custManagerPhone;
	private String depRedn;
	private Date rateDiscountDateBegin;
	private Date rateDiscountDateEnd;
	private Date registrationDate;
	private String depAmount;
	private String serial;
	private String depdate;
	private String bindphone;
	private String poscode;
	private String merchregidate;
	private String isCollect;
	private Double rate;
	private Double rebateMost;
	private String addDepdate;

	// Constructors

	/** default constructor */
	public PbmsgMerch() {
	}

	/** minimal constructor */
	public PbmsgMerch(String rowId, String merchBank, String merchZl, Double atmDayTotl,
			Double cshDayTotl, Double tsfDayTotl, Double atmLmt, Double cshLmt, Double tsfLmt) {
		this.rowId = rowId;
		this.merchBank = merchBank;
		this.merchZl = merchZl;
		this.atmDayTotl = atmDayTotl;
		this.cshDayTotl = cshDayTotl;
		this.tsfDayTotl = tsfDayTotl;
		this.atmLmt = atmLmt;
		this.cshLmt = cshLmt;
		this.tsfLmt = tsfLmt;
	}

	/** full constructor */
	public PbmsgMerch(String rowId, String merchBank, String branchName, String branch1,
			String branch2, String branch3, String branch4, String branch5, String merchType,
			String merchCode, String rebateType, Double rebateRate, String merchName,
			String merchDesc, String postCode, String tradeType, String forgnFlag, String qcAcct,
			String bhAcct, String thAcct, String telNo, String manager, String regCode,
			String taxNo, String mainItem, String operator, Date operTime, String signAcct,
			Double rebateMix, Double rebateMax, String isReal, String shortName, String areaCode,
			String state, String merchZl, String fxjb, String approveOper, Date approveDate,
			Date signDate, String unsignDate, Double atmDayTotl, Double cshDayTotl,
			Double tsfDayTotl, Double atmLmt, Double cshLmt, Double tsfLmt, String thsxf,
			String frRate, String isthk, String isrealth, String thcardacctname, String frratebu,
			String syncFlag, String cfee1, String cfee2, String setAcctName, String branch,
			String rateDiscount, String orgNo, String busScope, String legalPersonName,
			String legalPersonId, String terminalMobileNo, String terminalFixedNo,
			String custManager, String custManagerNo, String custManagerPhone, String depRedn,
			Date rateDiscountDateBegin, Date rateDiscountDateEnd, Date registrationDate,
			String depAmount, String serial, String depdate, String bindphone, String poscode,
			String merchregidate, String isCollect, Double rate, Double rebateMost,
			String addDepdate) {
		this.rowId = rowId;
		this.merchBank = merchBank;
		this.branchName = branchName;
		this.branch1 = branch1;
		this.branch2 = branch2;
		this.branch3 = branch3;
		this.branch4 = branch4;
		this.branch5 = branch5;
		this.merchType = merchType;
		this.merchCode = merchCode;
		this.rebateType = rebateType;
		this.rebateRate = rebateRate;
		this.merchName = merchName;
		this.merchDesc = merchDesc;
		this.postCode = postCode;
		this.tradeType = tradeType;
		this.forgnFlag = forgnFlag;
		this.qcAcct = qcAcct;
		this.bhAcct = bhAcct;
		this.thAcct = thAcct;
		this.telNo = telNo;
		this.manager = manager;
		this.regCode = regCode;
		this.taxNo = taxNo;
		this.mainItem = mainItem;
		this.operator = operator;
		this.operTime = operTime;
		this.signAcct = signAcct;
		this.rebateMix = rebateMix;
		this.rebateMax = rebateMax;
		this.isReal = isReal;
		this.shortName = shortName;
		this.areaCode = areaCode;
		this.state = state;
		this.merchZl = merchZl;
		this.fxjb = fxjb;
		this.approveOper = approveOper;
		this.approveDate = approveDate;
		this.signDate = signDate;
		this.unsignDate = unsignDate;
		this.atmDayTotl = atmDayTotl;
		this.cshDayTotl = cshDayTotl;
		this.tsfDayTotl = tsfDayTotl;
		this.atmLmt = atmLmt;
		this.cshLmt = cshLmt;
		this.tsfLmt = tsfLmt;
		this.thsxf = thsxf;
		this.frRate = frRate;
		this.isthk = isthk;
		this.isrealth = isrealth;
		this.thcardacctname = thcardacctname;
		this.frratebu = frratebu;
		this.syncFlag = syncFlag;
		this.cfee1 = cfee1;
		this.cfee2 = cfee2;
		this.setAcctName = setAcctName;
		this.branch = branch;
		this.rateDiscount = rateDiscount;
		this.orgNo = orgNo;
		this.busScope = busScope;
		this.legalPersonName = legalPersonName;
		this.legalPersonId = legalPersonId;
		this.terminalMobileNo = terminalMobileNo;
		this.terminalFixedNo = terminalFixedNo;
		this.custManager = custManager;
		this.custManagerNo = custManagerNo;
		this.custManagerPhone = custManagerPhone;
		this.depRedn = depRedn;
		this.rateDiscountDateBegin = rateDiscountDateBegin;
		this.rateDiscountDateEnd = rateDiscountDateEnd;
		this.registrationDate = registrationDate;
		this.depAmount = depAmount;
		this.serial = serial;
		this.depdate = depdate;
		this.bindphone = bindphone;
		this.poscode = poscode;
		this.merchregidate = merchregidate;
		this.isCollect = isCollect;
		this.rate = rate;
		this.rebateMost = rebateMost;
		this.addDepdate = addDepdate;
	}

	// Property accessors
	@Id
	@Column(name = "ROW_ID", unique = true, nullable = false, length = 32)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "MERCH_BANK", nullable = false, length = 32)
	public String getMerchBank() {
		return this.merchBank;
	}

	public void setMerchBank(String merchBank) {
		this.merchBank = merchBank;
	}

	@Column(name = "BRANCH_NAME", length = 512)
	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "BRANCH1", length = 32)
	public String getBranch1() {
		return this.branch1;
	}

	public void setBranch1(String branch1) {
		this.branch1 = branch1;
	}

	@Column(name = "BRANCH2", length = 32)
	public String getBranch2() {
		return this.branch2;
	}

	public void setBranch2(String branch2) {
		this.branch2 = branch2;
	}

	@Column(name = "BRANCH3", length = 32)
	public String getBranch3() {
		return this.branch3;
	}

	public void setBranch3(String branch3) {
		this.branch3 = branch3;
	}

	@Column(name = "BRANCH4", length = 32)
	public String getBranch4() {
		return this.branch4;
	}

	public void setBranch4(String branch4) {
		this.branch4 = branch4;
	}

	@Column(name = "BRANCH5", length = 32)
	public String getBranch5() {
		return this.branch5;
	}

	public void setBranch5(String branch5) {
		this.branch5 = branch5;
	}

	@Column(name = "MERCH_TYPE", length = 32)
	public String getMerchType() {
		return this.merchType;
	}

	public void setMerchType(String merchType) {
		this.merchType = merchType;
	}

	@Column(name = "MERCH_CODE", length = 32)
	public String getMerchCode() {
		return this.merchCode;
	}

	public void setMerchCode(String merchCode) {
		this.merchCode = merchCode;
	}

	@Column(name = "REBATE_TYPE", length = 1)
	public String getRebateType() {
		return this.rebateType;
	}

	public void setRebateType(String rebateType) {
		this.rebateType = rebateType;
	}

	@Column(name = "REBATE_RATE", precision = 5)
	public Double getRebateRate() {
		return this.rebateRate;
	}

	public void setRebateRate(Double rebateRate) {
		this.rebateRate = rebateRate;
	}

	@Column(name = "MERCH_NAME", length = 128)
	public String getMerchName() {
		return this.merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	@Column(name = "MERCH_DESC", length = 128)
	public String getMerchDesc() {
		return this.merchDesc;
	}

	public void setMerchDesc(String merchDesc) {
		this.merchDesc = merchDesc;
	}

	@Column(name = "POST_CODE", length = 6)
	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "TRADE_TYPE", length = 4)
	public String getTradeType() {
		return this.tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@Column(name = "FORGN_FLAG", length = 1)
	public String getForgnFlag() {
		return this.forgnFlag;
	}

	public void setForgnFlag(String forgnFlag) {
		this.forgnFlag = forgnFlag;
	}

	@Column(name = "QC_ACCT", length = 32)
	public String getQcAcct() {
		return this.qcAcct;
	}

	public void setQcAcct(String qcAcct) {
		this.qcAcct = qcAcct;
	}

	@Column(name = "BH_ACCT", length = 32)
	public String getBhAcct() {
		return this.bhAcct;
	}

	public void setBhAcct(String bhAcct) {
		this.bhAcct = bhAcct;
	}

	@Column(name = "TH_ACCT", length = 32)
	public String getThAcct() {
		return this.thAcct;
	}

	public void setThAcct(String thAcct) {
		this.thAcct = thAcct;
	}

	@Column(name = "TEL_NO", length = 32)
	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	@Column(name = "MANAGER", length = 64)
	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Column(name = "REG_CODE", length = 32)
	public String getRegCode() {
		return this.regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	@Column(name = "TAX_NO", length = 32)
	public String getTaxNo() {
		return this.taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	@Column(name = "MAIN_ITEM", length = 128)
	public String getMainItem() {
		return this.mainItem;
	}

	public void setMainItem(String mainItem) {
		this.mainItem = mainItem;
	}

	@Column(name = "OPERATOR", length = 32)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPER_TIME", length = 7)
	public Date getOperTime() {
		return this.operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	@Column(name = "SIGN_ACCT", length = 32)
	public String getSignAcct() {
		return this.signAcct;
	}

	public void setSignAcct(String signAcct) {
		this.signAcct = signAcct;
	}

	@Column(name = "REBATE_MIX", precision = 16)
	public Double getRebateMix() {
		return this.rebateMix;
	}

	public void setRebateMix(Double rebateMix) {
		this.rebateMix = rebateMix;
	}

	@Column(name = "REBATE_MAX", precision = 16)
	public Double getRebateMax() {
		return this.rebateMax;
	}

	public void setRebateMax(Double rebateMax) {
		this.rebateMax = rebateMax;
	}

	@Column(name = "IS_REAL", length = 1)
	public String getIsReal() {
		return this.isReal;
	}

	public void setIsReal(String isReal) {
		this.isReal = isReal;
	}

	@Column(name = "SHORT_NAME", length = 64)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "AREA_CODE", length = 32)
	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "STATE", length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "MERCH_ZL", nullable = false, length = 1)
	public String getMerchZl() {
		return this.merchZl;
	}

	public void setMerchZl(String merchZl) {
		this.merchZl = merchZl;
	}

	@Column(name = "FXJB", length = 1)
	public String getFxjb() {
		return this.fxjb;
	}

	public void setFxjb(String fxjb) {
		this.fxjb = fxjb;
	}

	@Column(name = "APPROVE_OPER", length = 32)
	public String getApproveOper() {
		return this.approveOper;
	}

	public void setApproveOper(String approveOper) {
		this.approveOper = approveOper;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVE_DATE", length = 7)
	public Date getApproveDate() {
		return this.approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SIGN_DATE", length = 7)
	public Date getSignDate() {
		return this.signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	@Column(name = "UNSIGN_DATE", length = 16)
	public String getUnsignDate() {
		return this.unsignDate;
	}

	public void setUnsignDate(String unsignDate) {
		this.unsignDate = unsignDate;
	}

	@Column(name = "ATM_DAY_TOTL", nullable = false, precision = 14)
	public Double getAtmDayTotl() {
		return this.atmDayTotl;
	}

	public void setAtmDayTotl(Double atmDayTotl) {
		this.atmDayTotl = atmDayTotl;
	}

	@Column(name = "CSH_DAY_TOTL", nullable = false, precision = 14)
	public Double getCshDayTotl() {
		return this.cshDayTotl;
	}

	public void setCshDayTotl(Double cshDayTotl) {
		this.cshDayTotl = cshDayTotl;
	}

	@Column(name = "TSF_DAY_TOTL", nullable = false, precision = 14)
	public Double getTsfDayTotl() {
		return this.tsfDayTotl;
	}

	public void setTsfDayTotl(Double tsfDayTotl) {
		this.tsfDayTotl = tsfDayTotl;
	}

	@Column(name = "ATM_LMT", nullable = false, precision = 14)
	public Double getAtmLmt() {
		return this.atmLmt;
	}

	public void setAtmLmt(Double atmLmt) {
		this.atmLmt = atmLmt;
	}

	@Column(name = "CSH_LMT", nullable = false, precision = 14)
	public Double getCshLmt() {
		return this.cshLmt;
	}

	public void setCshLmt(Double cshLmt) {
		this.cshLmt = cshLmt;
	}

	@Column(name = "TSF_LMT", nullable = false, precision = 14)
	public Double getTsfLmt() {
		return this.tsfLmt;
	}

	public void setTsfLmt(Double tsfLmt) {
		this.tsfLmt = tsfLmt;
	}

	@Column(name = "THSXF", length = 1)
	public String getThsxf() {
		return this.thsxf;
	}

	public void setThsxf(String thsxf) {
		this.thsxf = thsxf;
	}

	@Column(name = "FR_RATE", length = 8)
	public String getFrRate() {
		return this.frRate;
	}

	public void setFrRate(String frRate) {
		this.frRate = frRate;
	}

	@Column(name = "ISTHK", length = 1)
	public String getIsthk() {
		return this.isthk;
	}

	public void setIsthk(String isthk) {
		this.isthk = isthk;
	}

	@Column(name = "ISREALTH", length = 1)
	public String getIsrealth() {
		return this.isrealth;
	}

	public void setIsrealth(String isrealth) {
		this.isrealth = isrealth;
	}

	@Column(name = "THCARDACCTNAME", length = 64)
	public String getThcardacctname() {
		return this.thcardacctname;
	}

	public void setThcardacctname(String thcardacctname) {
		this.thcardacctname = thcardacctname;
	}

	@Column(name = "FRRATEBU", length = 16)
	public String getFrratebu() {
		return this.frratebu;
	}

	public void setFrratebu(String frratebu) {
		this.frratebu = frratebu;
	}

	@Column(name = "SYNC_FLAG", length = 1)
	public String getSyncFlag() {
		return this.syncFlag;
	}

	public void setSyncFlag(String syncFlag) {
		this.syncFlag = syncFlag;
	}

	@Column(name = "CFEE1", length = 5)
	public String getCfee1() {
		return this.cfee1;
	}

	public void setCfee1(String cfee1) {
		this.cfee1 = cfee1;
	}

	@Column(name = "CFEE2", length = 5)
	public String getCfee2() {
		return this.cfee2;
	}

	public void setCfee2(String cfee2) {
		this.cfee2 = cfee2;
	}

	@Column(name = "SET_ACCT_NAME", length = 64)
	public String getSetAcctName() {
		return this.setAcctName;
	}

	public void setSetAcctName(String setAcctName) {
		this.setAcctName = setAcctName;
	}

	@Column(name = "BRANCH", length = 64)
	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Column(name = "RATE_DISCOUNT", length = 2)
	public String getRateDiscount() {
		return this.rateDiscount;
	}

	public void setRateDiscount(String rateDiscount) {
		this.rateDiscount = rateDiscount;
	}

	@Column(name = "ORG_NO", length = 32)
	public String getOrgNo() {
		return this.orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	@Column(name = "BUS_SCOPE", length = 128)
	public String getBusScope() {
		return this.busScope;
	}

	public void setBusScope(String busScope) {
		this.busScope = busScope;
	}

	@Column(name = "LEGAL_PERSON_NAME", length = 64)
	public String getLegalPersonName() {
		return this.legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	@Column(name = "LEGAL_PERSON_ID", length = 32)
	public String getLegalPersonId() {
		return this.legalPersonId;
	}

	public void setLegalPersonId(String legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	@Column(name = "TERMINAL_MOBILE_NO", length = 2)
	public String getTerminalMobileNo() {
		return this.terminalMobileNo;
	}

	public void setTerminalMobileNo(String terminalMobileNo) {
		this.terminalMobileNo = terminalMobileNo;
	}

	@Column(name = "TERMINAL_FIXED_NO", length = 2)
	public String getTerminalFixedNo() {
		return this.terminalFixedNo;
	}

	public void setTerminalFixedNo(String terminalFixedNo) {
		this.terminalFixedNo = terminalFixedNo;
	}

	@Column(name = "CUST_MANAGER", length = 64)
	public String getCustManager() {
		return this.custManager;
	}

	public void setCustManager(String custManager) {
		this.custManager = custManager;
	}

	@Column(name = "CUST_MANAGER_NO", length = 32)
	public String getCustManagerNo() {
		return this.custManagerNo;
	}

	public void setCustManagerNo(String custManagerNo) {
		this.custManagerNo = custManagerNo;
	}

	@Column(name = "CUST_MANAGER_PHONE", length = 32)
	public String getCustManagerPhone() {
		return this.custManagerPhone;
	}

	public void setCustManagerPhone(String custManagerPhone) {
		this.custManagerPhone = custManagerPhone;
	}

	@Column(name = "DEP_REDN", length = 2)
	public String getDepRedn() {
		return this.depRedn;
	}

	public void setDepRedn(String depRedn) {
		this.depRedn = depRedn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RATE_DISCOUNT_DATE_BEGIN", length = 7)
	public Date getRateDiscountDateBegin() {
		return this.rateDiscountDateBegin;
	}

	public void setRateDiscountDateBegin(Date rateDiscountDateBegin) {
		this.rateDiscountDateBegin = rateDiscountDateBegin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RATE_DISCOUNT_DATE_END", length = 7)
	public Date getRateDiscountDateEnd() {
		return this.rateDiscountDateEnd;
	}

	public void setRateDiscountDateEnd(Date rateDiscountDateEnd) {
		this.rateDiscountDateEnd = rateDiscountDateEnd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", length = 7)
	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Column(name = "DEP_AMOUNT", length = 12)
	public String getDepAmount() {
		return this.depAmount;
	}

	public void setDepAmount(String depAmount) {
		this.depAmount = depAmount;
	}

	@Column(name = "SERIAL", length = 128)
	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Column(name = "DEPDATE", length = 12)
	public String getDepdate() {
		return this.depdate;
	}

	public void setDepdate(String depdate) {
		this.depdate = depdate;
	}

	@Column(name = "BINDPHONE", length = 128)
	public String getBindphone() {
		return this.bindphone;
	}

	public void setBindphone(String bindphone) {
		this.bindphone = bindphone;
	}

	@Column(name = "POSCODE", length = 32)
	public String getPoscode() {
		return this.poscode;
	}

	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}

	@Column(name = "MERCHREGIDATE", length = 16)
	public String getMerchregidate() {
		return this.merchregidate;
	}

	public void setMerchregidate(String merchregidate) {
		this.merchregidate = merchregidate;
	}

	@Column(name = "IS_COLLECT", length = 2)
	public String getIsCollect() {
		return this.isCollect;
	}

	public void setIsCollect(String isCollect) {
		this.isCollect = isCollect;
	}

	@Column(name = "RATE", precision = 3)
	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Column(name = "REBATE_MOST", precision = 14)
	public Double getRebateMost() {
		return this.rebateMost;
	}

	public void setRebateMost(Double rebateMost) {
		this.rebateMost = rebateMost;
	}

	@Column(name = "ADD_DEPDATE", length = 12)
	public String getAddDepdate() {
		return this.addDepdate;
	}

	public void setAddDepdate(String addDepdate) {
		this.addDepdate = addDepdate;
	}

}