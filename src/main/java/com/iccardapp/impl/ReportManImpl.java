package com.iccardapp.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iccardapp.common.vo.Grid;
import com.iccardapp.dao.service.IBaseDao;
import com.iccardapp.entity.ReportEntity;
import com.iccardapp.service.IReportService;
import com.iccardapp.util.ExcelUtil;

/**
 * 报表相关的操作
 * 
 * @author hzw-pc
 */
@Service
public class ReportManImpl implements IReportService {

	@Autowired
	private IBaseDao<ReportEntity> reportDao;

	/*
	 * 公司每月报表
	 * 
	 * @see com.iccardapp.service.IReportService#page1(int, int, java.util.Map)
	 */
	public Grid page1(int page, int rows, Map<String, Object> params) {

		Map<String, Object> p = new HashMap<String, Object>();
		Grid grid = new Grid();
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String month = (String) params.get("month");
		String yyyyMM = sf.format(date.getTime());
		// 组装查询条件
		if ("".equals(month) || month == null) {
			month = yyyyMM;
			p.put("month", yyyyMM + "%");
		} else {
			if (month.length() == 2) {
				month = yyyyMM.substring(0, 4) + month;
				p.put("month", month + "%");
			} else {
				month = yyyyMM.substring(0, 4) + "0" + month;
				p.put("month", month + "%");
			}
		}
		String sql = "select pei.company,sum(ct.amount) as amount ,count(ct.trade_date) as countno from CUPS_TRACE ct, PBMSG_EMPLOYEE_INFO pei WHERE trim(ct.out_card) = trim(pei.remark1) and trade_date like :month group by pei.company ";

		List<Object[]> obj = this.reportDao.findBySql(sql, p);
		if(obj.size()!=0){
			List<ReportEntity> rep = new ArrayList<ReportEntity>();
			// 组装实体
			for (Object[] o : obj) {
				ReportEntity repEntity = new ReportEntity();
				if ("1001".equals(o[0].toString().trim())) {
					repEntity.setCompanyName("张家港农村商业银行");
				}
				if ("1002".equals(o[0].toString().trim())) {
					repEntity.setCompanyName("新长乐物业公司");
				}
				double amount = Long.parseLong(o[1].toString().trim())/100.00 ;
				repEntity.setXlsamount(amount);
				NumberFormat nf = new DecimalFormat(",###0.00");
				String sAmount = nf.format(amount);
				repEntity.setAmount(sAmount);
				repEntity.setCount(Integer.parseInt(o[2].toString()));
				SimpleDateFormat sf3 = new SimpleDateFormat("yyyy年MM月");
				repEntity.setMonth(sf3.format(date));
				repEntity.setDate(sf2.format(date.getTime()));
				rep.add(repEntity);
			}
			grid.setRows(rep);
			grid.setTotal((long) obj.size());
			// 将报表导出为Excel
			expExcel(rep, null, "com_mon_temp.xlsx", "公司每月报表.xlsx");
		}
		
		return grid;
	}

	public Grid page2(int page, int rows, Map<String, Object> params) {
		Map<String, Object> p = new HashMap<String, Object>();
		Grid grid = new Grid();
		Date date = new Date();
		String stime = params.get("stime").toString().replace("-", "");
		String etime = params.get("etime").toString().replace("-", "");
		p.put("stime", stime);
		p.put("etime", etime);
		//remark2--部门名称，department--部门编号
		String sql = "select pei.remark2,sum(ct.amount) as amount "
				+ "from CUPS_TRACE ct, PBMSG_EMPLOYEE_INFO pei "
				+ "WHERE trim(ct.out_card) = trim(pei.remark1) and to_date(trim(ct.trade_date),'yyyymmdd') between to_date(:stime,'yyyymmdd') and to_date(:etime,'yyyyMMdd') group by pei.remark2 ";
		List<Object[]> obj = this.reportDao.findBySql(sql, p);
		if(obj.size()!=0){
			List<ReportEntity> rep = new ArrayList<ReportEntity>();
			// 组装实体
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Object[] o : obj) {
				ReportEntity repEntity = new ReportEntity();
				repEntity.setDepartment(o[0].toString());
				double amount = Long.parseLong(o[1].toString().trim())/100.00 ;
				repEntity.setXlsamount(amount);
				NumberFormat nf = new DecimalFormat(",###0.00");
				String sAmount = nf.format(amount);
				repEntity.setAmount(sAmount);

				rep.add(repEntity);
			}
			grid.setRows(rep);
			grid.setTotal((long) obj.size());
			// 将报表的次要信息放在report实体中
			ReportEntity report = new ReportEntity();
			report.setStime(params.get("stime").toString());
			report.setEtime(params.get("etime").toString());
			report.setDate(sf.format(date));
			expExcel(rep, report, "dep_sum_temp.xlsx", "消费刷卡汇总表.xlsx");
		}
		
		return grid;
	}

	public Grid page3(int page, int rows, Map<String, Object> params) {
		Map<String, Object> p = new HashMap<String, Object>();
		Grid grid = new Grid();
		Date date = new Date();
		String stime = params.get("stime").toString().replace("-", "");
		String etime = params.get("etime").toString().replace("-", "");
		p.put("stime", stime);
		p.put("etime", etime);
		String sql = "select cast(ct.term_id as varchar2(9)),sum(ct.amount) as amount,count(ct.trade_date) "
				+ "from CUPS_TRACE ct "
				+ "WHERE to_date(trim(ct.trade_date),'yyyymmdd') between to_date(:stime,'yyyymmdd') and to_date(:etime,'yyyyMMdd') group by ct.term_id ";
		List<Object[]> obj = this.reportDao.findBySql(sql, p);
		if(obj.size()!=0){
			List<ReportEntity> rep = new ArrayList<ReportEntity>();
			// 组装实体
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Object[] o : obj) {
				ReportEntity repEntity = new ReportEntity();
				repEntity.setCount(Integer.parseInt(o[2].toString()));
				double amount = Long.parseLong(o[1].toString().trim())/100.00 ;
				repEntity.setXlsamount(amount);
				NumberFormat nf = new DecimalFormat(",###0.00");
				String sAmount = nf.format(amount);
				repEntity.setAmount(sAmount);
				repEntity.setTerminator(o[0].toString());

				rep.add(repEntity);
			}
			grid.setRows(rep);
			grid.setTotal((long) obj.size());
			// 将报表的次要信息放在report实体中
			ReportEntity report = new ReportEntity();
			report.setStime(params.get("stime").toString());
			report.setEtime(params.get("etime").toString());
			report.setDate(sf.format(date));
			expExcel(rep, report, "terminator_sum_reprot.xlsx", "食堂应用汇总报表.xlsx");
		}
		
		return grid;
	}

	public Grid page4(int start, int limit, Map<String, Object> params) {
		Map<String, Object> p = new HashMap<String, Object>();
		Grid grid = new Grid();
		String stime = params.get("stime").toString().replace("-", "");
		p.put("tradedate", stime);
		String sql = "select trim(ct.out_card), pei.name, pei.remark2 ,count(ct.trade_date) as countno,sum(ct.amount) as amount, cast(ct.term_id as varchar2(9))  "
				+ "from CUPS_TRACE ct, PBMSG_EMPLOYEE_INFO pei "
				+ "WHERE trim(ct.out_card) = trim(pei.remark1) and trim(trade_date) =:tradedate group by ct.out_card,pei.name,pei.remark2,ct.term_id";

		List<Object[]> obj = this.reportDao.findBySql(sql, p);
		if(obj.size()!=0){
			List<ReportEntity> rep = new ArrayList<ReportEntity>();
			// 组装实体
			for (Object[] o : obj) {
				ReportEntity repEntity = new ReportEntity();
				repEntity.setCardno(o[0].toString().trim());
				repEntity.setName(o[1].toString().trim());
				repEntity.setDepartment(o[2].toString().trim());
				repEntity.setCount(Integer.parseInt(o[3].toString()));
				double amount = Long.parseLong(o[4].toString().trim())/100.00 ;
				repEntity.setXlsamount(amount);
				NumberFormat nf = new DecimalFormat(",###0.##");
				String sAmount = nf.format(amount);
				repEntity.setAmount(sAmount);
				repEntity.setTerminator(o[5].toString().trim());
				rep.add(repEntity);
			}
			grid.setRows(rep);
			grid.setTotal((long)obj.size());
			// 将报表的次要信息放在report实体中
			ReportEntity report = new ReportEntity();
			report.setStime(params.get("stime").toString());
			// 将报表导出为Excel
			expExcel(rep, report, "detials_reprot.xlsx", "食堂IC卡应用明细表.xlsx");

		}
		
		return grid;
	}

	public Grid page5(int start, int limit, Map<String, Object> params) {
		Map<String, Object> p = new HashMap<String, Object>();
		Grid grid = new Grid();
		String qname = params.get("qname").toString().trim();
		p.put("name", qname);
		String sql = "select trim(ct.out_card), pei.name ,CAST(ct.trade_date as varchar2(9)) ,cast(ct.amount as varchar2(15)), cast(ct.term_id as varchar2(9)), CAST(ct.trade_time as varchar2(9)) "
				+ "from CUPS_TRACE ct, PBMSG_EMPLOYEE_INFO pei "
				+ "WHERE trim(ct.out_card) = trim(pei.remark1) and trim(pei.name)=:name order by ct.trade_date desc, trade_time desc";

		List<Object[]> obj = this.reportDao.findBySql(sql, p);
		if(obj.size()!=0){
			List<ReportEntity> rep = new ArrayList<ReportEntity>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("hhmmss");
			SimpleDateFormat sdf3 = new SimpleDateFormat("hh:mm:ss");
			// 组装实体
			for (Object[] o : obj) {
				ReportEntity repEntity = new ReportEntity();
				repEntity.setCardno(o[0].toString().trim());
				repEntity.setName(o[1].toString().trim());
				try {
					repEntity.setDate(sdf1.format(sdf.parse(o[2].toString().trim())));
					repEntity.setTime(sdf3.format(sdf2.parse(o[5].toString().trim())));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double amount = Long.parseLong(o[3].toString().trim())/100.00 ;
				repEntity.setXlsamount(amount);
				NumberFormat nf = new DecimalFormat(",###0.00");
				String sAmount = nf.format(amount);
				repEntity.setAmount(sAmount);
				repEntity.setTerminator(o[4].toString().trim());
				rep.add(repEntity);
			}
			grid.setRows(rep);
			grid.setTotal((long)obj.size());
			// 将报表的次要信息放在report实体中
			ReportEntity report = new ReportEntity();
			report.setDate(sdf1.format((new Date())));
			report.setCardno(obj.get(0)[0].toString().trim());
			report.setName(obj.get(0)[1].toString().trim());
			// 将报表导出为Excel
			expExcel(rep, report, "detials2_reprot.xlsx", "食堂IC卡应用明细表2.xlsx");

		}

		return grid;
	}
	
	/**
	 * 将报表导出为excel
	 */
	public void expExcel(List<?> rep, ReportEntity report,
			String templateFileName, String resultFileName) {
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.createExcel(templateFileName, rep, report, resultFileName);
	}


}
