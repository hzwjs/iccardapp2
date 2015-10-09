package com.iccardapp.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iccardapp.common.vo.Grid;
import com.iccardapp.dao.service.IBaseDao;
import com.iccardapp.entity.PbmsgPos;
import com.iccardapp.service.ICommonService;

/**
 * 设备管理相关的操作
 * 
 * @author hzw-pc
 */
@Service
public class PosDevImpl implements ICommonService {

	@Autowired
	private IBaseDao<PbmsgPos> posDevDao;

	public Grid page(int page, int rows, Map<String, Object> params) {
		
		Grid grid = new Grid();
		String devCode = (String) params.get("devCode");
		String hql = "from PbmsgPos t ";
		if(!"".equals(devCode) && devCode !=null){
			hql = hql + "where devCode=" + devCode;
		}
		grid.setRows(this.posDevDao.find(hql, page, rows));
		grid.setTotal(this.posDevDao.count("select count(*) from PbmsgPos t"));
		return grid;
	}

	/* 设备新增与信息修改
	 * @see com.iccardapp.service.ICommonService#saveOrUpdate(java.lang.Object)
	 */
    public Boolean saveOrUpdate(Object obj) {
        PbmsgPos merch = (PbmsgPos) obj;

        posDevDao.saveOrUpdate(merch);
        return true;
        /*
         * try { } catch (Exception e) { return false; }
         */
    }

	/* 
	 * 删除设备信息
	 * @see com.iccardapp.service.ICommonService#delete(java.lang.Object)
	 */
	public Boolean delete(Object obj) {
		try {
		    Map<String, Object> params = new HashMap<String, Object>();
		    PbmsgPos pos = (PbmsgPos)obj;
		    // 根据主键进行数据删除
		    params.put("poscode", pos.getDevCode());
		    String sql = "delete PBMSG_POS WHERE DEV_CODE=:poscode";
		    posDevDao.executeSql(sql, params);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public PbmsgPos detail(Map<String, Object> param){
		
		String devCode = (String) param.get("devCode");
		String hql = "from PbmsgPos t ";
		if(!"".equals(devCode) && devCode !=null){
			hql = hql + "where devCode=" + devCode;
		}
		PbmsgPos pbmsgPos = this.posDevDao.find(hql).get(0);
		return pbmsgPos;
		
	}

}
