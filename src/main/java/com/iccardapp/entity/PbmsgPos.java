package com.iccardapp.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PbmsgPos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PBMSG_POS", schema = "ehmuser")
public class PbmsgPos implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String devCode;
	private String devType;
	private String devDesc;
	private String devBank;
	private String devIp;
	private String posMerch;
	private String merchType;
	private String merchName;
	private String funcList;
	private String devAcct;
	private String phoneNo;
	private String forgnFlag;
	private String psamNo;
	private Date signDate;
	private String unsignDate;
	private String bz;
	private String branch1;
	private String branch2;
	private String branch3;
	private String branch4;
	private String branch5;
	private String devModel;
	private String devState;
	private String syncFlag;
	private String menuType;
	private String oldmenuType;
	private String PMerchCode;
	private String devAcctName;
	private String reserve1;
	private String reserve2;
	private String tsfLmt;
	private String saleLmt;
	private String stRate;
	private String stRateLmt;
	private String yhRate;
	private String yhRateLmt;
	private String reserve3;
	private String reserve4;
	private String bindphone;
	private String keysn;
	private String possn;
	private String regidate;
	private String installdate;
	private String eachDepAmount;
	private String merchZl;

	// Constructors

	/** default constructor */
	public PbmsgPos() {
	}

	/** minimal constructor */
	public PbmsgPos(String devCode, String devType) {
		this.devCode = devCode;
		this.devType = devType;
	}

	/** full constructor */
	public PbmsgPos(String devCode, String devType, String devDesc, String devBank, String devIp,
			String posMerch, String merchType, String merchName, String funcList, String devAcct,
			String phoneNo, String forgnFlag, String psamNo, Date signDate, String unsignDate,
			String bz, String branch1, String branch2, String branch3, String branch4,
			String branch5, String devModel, String devState, String syncFlag, String menuType,
			String oldmenuType, String PMerchCode, String devAcctName, String reserve1,
			String reserve2, String tsfLmt, String saleLmt, String stRate, String stRateLmt,
			String yhRate, String yhRateLmt, String reserve3, String reserve4, String bindphone,
			String keysn, String possn, String regidate, String installdate, String eachDepAmount,
			String merchZl) {
		this.devCode = devCode;
		this.devType = devType;
		this.devDesc = devDesc;
		this.devBank = devBank;
		this.devIp = devIp;
		this.posMerch = posMerch;
		this.merchType = merchType;
		this.merchName = merchName;
		this.funcList = funcList;
		this.devAcct = devAcct;
		this.phoneNo = phoneNo;
		this.forgnFlag = forgnFlag;
		this.psamNo = psamNo;
		this.signDate = signDate;
		this.unsignDate = unsignDate;
		this.bz = bz;
		this.branch1 = branch1;
		this.branch2 = branch2;
		this.branch3 = branch3;
		this.branch4 = branch4;
		this.branch5 = branch5;
		this.devModel = devModel;
		this.devState = devState;
		this.syncFlag = syncFlag;
		this.menuType = menuType;
		this.oldmenuType = oldmenuType;
		this.PMerchCode = PMerchCode;
		this.devAcctName = devAcctName;
		this.reserve1 = reserve1;
		this.reserve2 = reserve2;
		this.tsfLmt = tsfLmt;
		this.saleLmt = saleLmt;
		this.stRate = stRate;
		this.stRateLmt = stRateLmt;
		this.yhRate = yhRate;
		this.yhRateLmt = yhRateLmt;
		this.reserve3 = reserve3;
		this.reserve4 = reserve4;
		this.bindphone = bindphone;
		this.keysn = keysn;
		this.possn = possn;
		this.regidate = regidate;
		this.installdate = installdate;
		this.eachDepAmount = eachDepAmount;
		this.merchZl = merchZl;
	}

	// Property accessors
	@Id
	@Column(name = "DEV_CODE", unique = true, nullable = false, length = 32)
	public String getDevCode() {
		return this.devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	@Column(name = "DEV_TYPE", nullable = false, length = 32)
	public String getDevType() {
		return this.devType;
	}

	public void setDevType(String devType) {
		this.devType = devType;
	}

	@Column(name = "DEV_DESC", length = 128)
	public String getDevDesc() {
		return this.devDesc;
	}

	public void setDevDesc(String devDesc) {
		this.devDesc = devDesc;
	}

	@Column(name = "DEV_BANK", length = 32)
	public String getDevBank() {
		return this.devBank;
	}

	public void setDevBank(String devBank) {
		this.devBank = devBank;
	}

	@Column(name = "DEV_IP", length = 15)
	public String getDevIp() {
		return this.devIp;
	}

	public void setDevIp(String devIp) {
		this.devIp = devIp;
	}

	@Column(name = "POS_MERCH", length = 32)
	public String getPosMerch() {
		return this.posMerch;
	}

	public void setPosMerch(String posMerch) {
		this.posMerch = posMerch;
	}

	@Column(name = "MERCH_TYPE", length = 32)
	public String getMerchType() {
		return this.merchType;
	}

	public void setMerchType(String merchType) {
		this.merchType = merchType;
	}

	@Column(name = "MERCH_NAME", length = 64)
	public String getMerchName() {
		return this.merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	@Column(name = "FUNC_LIST", length = 32)
	public String getFuncList() {
		return this.funcList;
	}

	public void setFuncList(String funcList) {
		this.funcList = funcList;
	}

	@Column(name = "DEV_ACCT", length = 32)
	public String getDevAcct() {
		return this.devAcct;
	}

	public void setDevAcct(String devAcct) {
		this.devAcct = devAcct;
	}

	@Column(name = "PHONE_NO", length = 32)
	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "FORGN_FLAG", length = 1)
	public String getForgnFlag() {
		return this.forgnFlag;
	}

	public void setForgnFlag(String forgnFlag) {
		this.forgnFlag = forgnFlag;
	}

	@Column(name = "PSAM_NO", length = 8)
	public String getPsamNo() {
		return this.psamNo;
	}

	public void setPsamNo(String psamNo) {
		this.psamNo = psamNo;
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

	@Column(name = "BZ", length = 128)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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

	@Column(name = "DEV_MODEL", length = 32)
	public String getDevModel() {
		return this.devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}

	@Column(name = "DEV_STATE", length = 1)
	public String getDevState() {
		return this.devState;
	}

	public void setDevState(String devState) {
		this.devState = devState;
	}

	@Column(name = "SYNC_FLAG", length = 1)
	public String getSyncFlag() {
		return this.syncFlag;
	}

	public void setSyncFlag(String syncFlag) {
		this.syncFlag = syncFlag;
	}

	@Column(name = "MENU_TYPE", length = 32)
	public String getMenuType() {
		return this.menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	@Column(name = "OLDMENU_TYPE", length = 32)
	public String getOldmenuType() {
		return this.oldmenuType;
	}

	public void setOldmenuType(String oldmenuType) {
		this.oldmenuType = oldmenuType;
	}

	@Column(name = "P_MERCH_CODE", length = 32)
	public String getPMerchCode() {
		return this.PMerchCode;
	}

	public void setPMerchCode(String PMerchCode) {
		this.PMerchCode = PMerchCode;
	}

	@Column(name = "DEV_ACCT_NAME", length = 64)
	public String getDevAcctName() {
		return this.devAcctName;
	}

	public void setDevAcctName(String devAcctName) {
		this.devAcctName = devAcctName;
	}

	@Column(name = "RESERVE1", length = 64)
	public String getReserve1() {
		return this.reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	@Column(name = "RESERVE2", length = 64)
	public String getReserve2() {
		return this.reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	@Column(name = "TSF_LMT", length = 64)
	public String getTsfLmt() {
		return this.tsfLmt;
	}

	public void setTsfLmt(String tsfLmt) {
		this.tsfLmt = tsfLmt;
	}

	@Column(name = "SALE_LMT", length = 64)
	public String getSaleLmt() {
		return this.saleLmt;
	}

	public void setSaleLmt(String saleLmt) {
		this.saleLmt = saleLmt;
	}

	@Column(name = "ST_RATE", length = 64)
	public String getStRate() {
		return this.stRate;
	}

	public void setStRate(String stRate) {
		this.stRate = stRate;
	}

	@Column(name = "ST_RATE_LMT", length = 64)
	public String getStRateLmt() {
		return this.stRateLmt;
	}

	public void setStRateLmt(String stRateLmt) {
		this.stRateLmt = stRateLmt;
	}

	@Column(name = "YH_RATE", length = 64)
	public String getYhRate() {
		return this.yhRate;
	}

	public void setYhRate(String yhRate) {
		this.yhRate = yhRate;
	}

	@Column(name = "YH_RATE_LMT", length = 64)
	public String getYhRateLmt() {
		return this.yhRateLmt;
	}

	public void setYhRateLmt(String yhRateLmt) {
		this.yhRateLmt = yhRateLmt;
	}

	@Column(name = "RESERVE3", length = 64)
	public String getReserve3() {
		return this.reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	@Column(name = "RESERVE4", length = 64)
	public String getReserve4() {
		return this.reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	@Column(name = "BINDPHONE", length = 128)
	public String getBindphone() {
		return this.bindphone;
	}

	public void setBindphone(String bindphone) {
		this.bindphone = bindphone;
	}

	@Column(name = "KEYSN", length = 32)
	public String getKeysn() {
		return this.keysn;
	}

	public void setKeysn(String keysn) {
		this.keysn = keysn;
	}

	@Column(name = "POSSN", length = 32)
	public String getPossn() {
		return this.possn;
	}

	public void setPossn(String possn) {
		this.possn = possn;
	}

	@Column(name = "REGIDATE", length = 16)
	public String getRegidate() {
		return this.regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Column(name = "INSTALLDATE", length = 16)
	public String getInstalldate() {
		return this.installdate;
	}

	public void setInstalldate(String installdate) {
		this.installdate = installdate;
	}

	@Column(name = "EACH_DEP_AMOUNT", length = 12)
	public String getEachDepAmount() {
		return this.eachDepAmount;
	}

	public void setEachDepAmount(String eachDepAmount) {
		this.eachDepAmount = eachDepAmount;
	}

	@Column(name = "MERCH_ZL", length = 1)
	public String getMerchZl() {
		return this.merchZl;
	}

	public void setMerchZl(String merchZl) {
		this.merchZl = merchZl;
	}

}