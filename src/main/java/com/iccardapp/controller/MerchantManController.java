
package com.iccardapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iccardapp.common.vo.AjaxResponse;
import com.iccardapp.common.vo.GlobalConstant;
import com.iccardapp.common.vo.Grid;
import com.iccardapp.common.vo.SessionInfo;
import com.iccardapp.entity.PbmsgMerch;
import com.iccardapp.impl.MerchantManImpl;
import com.iccardapp.service.ICommonService;
import com.iccardapp.service.IMerchantService;

@Controller
@RequestMapping("/sys/manage/merchant")
public class MerchantManController {

    @Autowired
    private AjaxResponse ajaxResponse;

    @Autowired
    private @Qualifier("merchantManImpl")
    ICommonService merchantService;
    
    @Autowired
    private @Qualifier("merchantManImpl")
    IMerchantService merchantService2;

    @Autowired
    private MerchantManImpl merchantManImpl;

    /**
     * 商户新增与商户信息修改
     * 
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value="/modify")
    @ResponseBody
    public AjaxResponse addOrModify(PbmsgMerch pbmsgMerch, HttpServletRequest req) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
       
        String approvedate = req.getParameter("approveDate1");
        if(approvedate!=""){
        	
        	pbmsgMerch.setApproveDate(sf.parse(approvedate));
        }
        
        String rateDiscountDateBegin = req.getParameter("rateDiscountDateBegin1");
        if(rateDiscountDateBegin!=""){
            pbmsgMerch.setRateDiscountDateBegin(sf.parse(rateDiscountDateBegin));
        }
        
        String rateDiscountDateEnd = req.getParameter("rateDiscountDateEnd1");
        if(rateDiscountDateEnd!=""){
            pbmsgMerch.setRateDiscountDateEnd(sf.parse(rateDiscountDateEnd));
        }
        
        // 生成ID
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String date = df.format(new Date());
        int index = merchantService2.queryByDate(date) + 1;
        //若不存在rowId，则生成
        String erowId = req.getParameter("rowId");
        if(null == erowId){
            String rowId = date + index;
            pbmsgMerch.setRowId(rowId);
        }
        String emerchcode = req.getParameter("merchCode");
        if(null == emerchcode){
            String merchCode = date + index;
            pbmsgMerch.setMerchCode(merchCode);
        }
      
        Boolean flag = null;
        SessionInfo sessionInfo = (SessionInfo) req.getSession().getAttribute(GlobalConstant.SESSION_INFO);
        if (sessionInfo != null) {
            flag = merchantService.saveOrUpdate(pbmsgMerch);
        }
        if (flag) {
            ajaxResponse.setCode(AjaxResponse.SUCCESS);
            ajaxResponse.setMsg("商户信息保存成功！！");
        } else {
            ajaxResponse.setCode(AjaxResponse.FAILURE);
            ajaxResponse.setMsg("商户信息保存失败！！");
        }
        /*
         * } catch (Exception e) { ajaxResponse.setCode(AjaxResponse.EXCEPTION); ajaxResponse.setMsg("商户信息保存异常！"); }
         */
        return ajaxResponse;
    }

    @RequestMapping(value = "/page")
    @ResponseBody
    public Grid page(int start, int limit, HttpSession session, HttpServletRequest request) {

        Map<String, Object> params = new HashMap<String, Object>();
        String merchantName = (String) request.getParameter("qname");
        params.put("merchantName", merchantName);
        return this.merchantService.page(start, limit, params);
    }

    /**
     * 返回商户信息详情
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/details")
    @ResponseBody
    public PbmsgMerch detail(HttpServletRequest request) {

        Map<String, Object> params = new HashMap<String, Object>();
        String merchantId = (String) request.getParameter("qid");
        params.put("merchantId", merchantId);
        return this.merchantManImpl.detail(params);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public AjaxResponse delete(PbmsgMerch pbmsgMerch) {

        Boolean flag = merchantService.delete(pbmsgMerch);
        AjaxResponse ajaxResponse = new AjaxResponse();
        if (flag) {
            ajaxResponse.setCode(AjaxResponse.SUCCESS);

        } else {
            ajaxResponse.setCode(AjaxResponse.EXCEPTION);
        }
        return ajaxResponse;
    }

}
