
package com.iccardapp.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iccardapp.common.vo.Grid;
import com.iccardapp.dao.service.IBaseDao;
import com.iccardapp.entity.PbmsgMerch;
import com.iccardapp.service.ICommonService;
import com.iccardapp.service.IMerchantService;

/**
 * 商户管理相关的操作
 * 
 * @author hzw-pc
 */
@Service
public class MerchantManImpl implements ICommonService,IMerchantService {

    @Autowired
    private IBaseDao<PbmsgMerch> merchantDao;

    public Grid page(int page, int rows, Map<String, Object> params) {

        Grid grid = new Grid();
        String merchantName = (String) params.get("merchantName");
        String hql = "from PbmsgMerch t ";
        if (!"".equals(merchantName) && merchantName != null) {
            hql = hql + "where merchName="  + "'" + merchantName + "'";
        }
        grid.setRows(this.merchantDao.find(hql, page, rows));
        grid.setTotal(this.merchantDao.count("select count(*) from PbmsgMerch t"));
        return grid;
    }

    /*
     * 商户新增与信息修改
     * 
     * @see com.iccardapp.service.ICommonService#saveOrUpdate(java.lang.Object)
     */
    public Boolean saveOrUpdate(Object obj) {
        PbmsgMerch merch = (PbmsgMerch) obj;
        merchantDao.saveOrUpdate(merch);
        return true;
        /*
         * try { } catch (Exception e) { return false; }
         */
    }

    public int queryByDate(String date) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("date", "%" + date + "%");
        String sql = "select count(*) from PBMSG_MERCH t where t.ROW_ID like :date";
        Integer count = merchantDao.countBySql(sql, param);

        return count.intValue();
    }

    /*
     * 删除商户信息
     * 
     * @see com.iccardapp.service.ICommonService#delete(java.lang.Object)
     */
    public Boolean delete(Object obj) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            PbmsgMerch merch = (PbmsgMerch) obj;
            params.put("row_id", merch.getRowId());
            String sql = "delete PBMSG_MERCH WHERE ROW_ID=:row_id";
            merchantDao.executeSql(sql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PbmsgMerch detail(Map<String, Object> param) {

        String merchCode = (String) param.get("merchantId");
        String hql = "from PbmsgMerch t ";
        if (!"".equals(merchCode) && merchCode != null) {
            hql = hql + "where merchCode=" + "'" + merchCode + "'";
        }
        PbmsgMerch pbmsgMerch = this.merchantDao.find(hql).get(0);
        return pbmsgMerch;

    }

}
