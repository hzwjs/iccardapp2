package com.iccardapp.entity;


/**
 * 报表实体类
 * 该实体不对应数据库中的任何表
 * @author 志文
 *
 */
public class ReportEntity {

	private String companyName; // 公司名称
	private String month; // 月份
	private int count; // 消费人次
	private double xlsamount;// excel表格中的金额必须是数字，否则无法做合计等操作
	private String amount; // 金额
	private String date; // 日期
	private String time; //消费时间
	private String department; // 部门
	private String stime; // 起始日期
	private String etime; // 结束日期
	private String terminator; // 终端号
	private String cardno;// 卡号
	
	
	
	public double getXlsamount() {
		return xlsamount;
	}

	public void setXlsamount(double xlsamount) {
		this.xlsamount = xlsamount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name; //户名
	
	
	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getTerminator() {
		return terminator;
	}

	public void setTerminator(String terminator) {
		this.terminator = terminator;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
