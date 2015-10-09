package com.iccardapp.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iccardapp.common.vo.AjaxResponse;
import com.iccardapp.common.vo.Grid;
import com.iccardapp.dao.service.IBaseDao;
import com.iccardapp.entity.PbmsgRole;
import com.iccardapp.entity.PbmsgRoleResource;
import com.iccardapp.entity.PbmsgRoleResourceId;
import com.iccardapp.entity.PbmsgUserRole;
import com.iccardapp.entity.PbmsgUserRoleId;
import com.iccardapp.service.ICommonService;
import com.iccardapp.service.IRoleService;

@Service
public class RoleSysImpl implements ICommonService, IRoleService {

	@Autowired
	private IBaseDao<PbmsgRole> roleDao;

	@Autowired
	private IBaseDao<PbmsgRoleResource> roleResourceDao;
	
	@Autowired
	private IBaseDao<PbmsgUserRole> userRoleDao;

	public Grid page(int page, int rows, Map<String, Object> params) {
		Grid grid = new Grid();
		String hql = "from PbmsgRole t where 1=1";
		grid.setRows(this.roleDao.find(hql, page, rows));
		grid.setTotal(this.roleDao
				.count("select count(*) from PbmsgRole t where 1=1"));

		return grid;
	}

	@Transactional
	public Boolean saveOrUpdate(Object obj) {
		try {
			roleDao.saveOrUpdate((PbmsgRole) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean delete(Object obj) {
		Map<String, Object> param = new HashMap<String, Object>();
		PbmsgRole role = (PbmsgRole) obj;
		param.put("roleid", role.getRoleId());
		String sql = "delete PBMSG_ROLE where role_id=:roleid";
		roleDao.executeSql(sql, param);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public AjaxResponse grant(String roleId, String resources) {
		String[] res = resources.split(",");
		
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setCode(AjaxResponse.FAILURE);

		// 先删除数据库中的原有权限
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		String sql = "delete from PBMSG_ROLE_RESOURCE where role_id=:roleId";
		roleResourceDao.executeSql(sql, param);

		// 将新的权限信息写入数据库
		for (String r : res) {
			// 每次必需重新创建对象，否则Hibernate只会保存最后一个。
			PbmsgRoleResourceId roleResourceId = new PbmsgRoleResourceId();
			PbmsgRoleResource roleResource = new PbmsgRoleResource();
			roleResourceId.setRoleId(roleId);
			roleResourceId.setResourceId(r);
			roleResource.setId(roleResourceId);
			roleResourceDao.save(roleResource);
		}
		ajaxResponse.setCode(AjaxResponse.SUCCESS);
		return ajaxResponse;
	}

	public int queryByDate(String date) {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("date", "%" + date + "%");
		String sql = "select count(*) from PBMSG_ROLE t where t.role_id like :date";
		Integer count = roleDao.countBySql(sql, param);

		return count.intValue();
	}

	public void tree(Writer w) {
		ObjectMapper mapper = new ObjectMapper();
		List<PbmsgRole> list = new ArrayList<PbmsgRole>();
		String hql = "from PbmsgRole where 1=1 order by roleId asc";
		list = roleDao.find(hql);
		try {
			mapper.writeValue(w, list);
			mapper.writeValue(System.out, list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void roleByUserid(String userId, Writer w) {
		ObjectMapper mapper = new ObjectMapper();
		List<PbmsgRole> list = new ArrayList<PbmsgRole>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userId);
		String sql = "select * from pbmsg_role pr,pbmsg_user_role pur where trim(pur.user_id)=:userid and pr.role_id=pur.role_id order by pr.role_id asc";
		list = roleDao.findBySql(sql, params, PbmsgRole.class);
		try {
			mapper.writeValue(w, list);
			mapper.writeValue(System.out, list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Transactional
	public AjaxResponse roleToUser(String userId, String roles) {
		String[] role = roles.split(",");
		
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setCode(AjaxResponse.FAILURE);

		// 先删除数据库中的原有角色
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		String sql = "delete from PBMSG_user_role where user_id=:userId";
		roleResourceDao.executeSql(sql, param);

		// 将新的角色信息写入数据库
		for (String r : role) {
			// 每次必需重新创建对象，否则Hibernate只会保存最后一个。
			PbmsgUserRoleId userRoleId = new PbmsgUserRoleId();
			PbmsgUserRole userRole = new PbmsgUserRole();
			userRoleId.setUserId(userId);
			userRoleId.setRoleId(r);
			userRole.setId(userRoleId);
			userRoleDao.save(userRole);
		}
		ajaxResponse.setCode(AjaxResponse.SUCCESS);
		return ajaxResponse;
		

	}

}
