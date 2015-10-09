package com.iccardapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.iccardapp.entity.PbmsgPos;
import com.iccardapp.impl.PosDevImpl;
import com.iccardapp.service.ICommonService;

@Controller
@RequestMapping("/sys/manage/posDev")
public class PosDevController {

	@Autowired
	private AjaxResponse ajaxResponse;

	@Autowired
	private @Qualifier("posDevImpl") ICommonService posdevService;
	
	@Autowired
	private PosDevImpl posDevImpl;

	/**
	 * 设备新增与设备信息修改
	 * 
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public AjaxResponse addOrModify(PbmsgPos pbmsgPos, HttpServletRequest req) throws ParseException {
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	       
        String signDate = req.getParameter("signDate1");
        pbmsgPos.setSignDate(sf.parse(signDate));
		
			Boolean flag = null;
			SessionInfo sessionInfo = (SessionInfo) req.getSession().getAttribute(GlobalConstant.SESSION_INFO);
			if (sessionInfo != null) {
				flag = posdevService.saveOrUpdate(pbmsgPos);
			}
			if (flag) {
				ajaxResponse.setCode(AjaxResponse.SUCCESS);
				ajaxResponse.setMsg("设备信息保存成功！！");
			} else {
				ajaxResponse.setCode(AjaxResponse.FAILURE);
				ajaxResponse.setMsg("设备信息保存失败！！");
			}
		/*} catch (Exception e) {
			ajaxResponse.setCode(AjaxResponse.EXCEPTION);
			ajaxResponse.setMsg("商户信息保存异常！");
		}*/
		return ajaxResponse;
	}
	
	@RequestMapping(value = "/page")
	@ResponseBody
	public Grid page(int start, int limit, HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		String devCode = (String) request.getParameter("qname");
		params.put("devCode", devCode);
		return this.posdevService.page(start, limit, params);
	}
	
	/**
	 * 返回设备信息详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/details")
	@ResponseBody
	public PbmsgPos detail(HttpServletRequest request) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		String devCode = (String) request.getParameter("qid");
		params.put("devCode", devCode);
		return this.posDevImpl.detail(params);
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public AjaxResponse delete(PbmsgPos pbmsgPos){
		
		Boolean flag = posdevService.delete(pbmsgPos);
		AjaxResponse ajaxResponse = new AjaxResponse();
		if(flag){
			ajaxResponse.setCode(AjaxResponse.SUCCESS);
			
		}else{
			ajaxResponse.setCode(AjaxResponse.EXCEPTION);
		}
		return ajaxResponse;
	}
	
	
	
}
