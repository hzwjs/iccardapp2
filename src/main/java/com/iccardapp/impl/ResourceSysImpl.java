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

import com.iccardapp.dao.service.IBaseDao;
import com.iccardapp.entity.Operators;
import com.iccardapp.entity.PbmsgResource;
import com.iccardapp.service.IResourceService;

@Service
@Transactional
public class ResourceSysImpl implements IResourceService {
	@Autowired
	private IBaseDao<PbmsgResource> resourceDao;
	@Autowired
	private IBaseDao<Operators> operatorDao;

	/*
	 * @see com.iccardapp.service.IResourceService#tree(java.lang.String,
	 * java.io.Writer)
	 */
	public void tree(String userId, Writer w) {
		Map<String, Object> params = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		// 用户的所有资源
		Operators user = operatorDao.get(Operators.class, userId);

		List<PbmsgResource> list = new ArrayList<PbmsgResource>();
		// 如果是超级用户显示所有功能节点
		if (Integer.parseInt(user.getLev().trim()) >= 20) {
			String hql = "from PbmsgResource where 1=1 order by resourceSort asc";
			list = resourceDao.find(hql);
		} else {// 非超级用户根据角色来显示功能节点
			params.put("userId", userId.trim());
			String sql = "SELECT pr.* FROM pbmsg_resource pr LEFT JOIN pbmsg_role_resource prr ON pr.id = prr.resource_id LEFT JOIN pbmsg_user_role pur ON prr.role_id = pur.role_id where trim(pur.user_id) = :userId ORDER BY pr.resource_sort";
			list = resourceDao.findBySql(sql, params, PbmsgResource.class);
		}
		try {

			mapper.writeValue(w, list);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tree(Writer w) {

		ObjectMapper mapper = new ObjectMapper();
		List<PbmsgResource> list = new ArrayList<PbmsgResource>();
		String hql = "from PbmsgResource where 1=1 order by resourceSort asc";
		list = resourceDao.find(hql);
		try {
			mapper.writeValue(w, list);
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

	public void treeByRole(String roleId, Writer w) {

		ObjectMapper mapper = new ObjectMapper();
		List<PbmsgResource> list = new ArrayList<PbmsgResource>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		String sql = "select * from PBMSG_RESOURCE r,PBMSG_ROLE_RESOURCE rr where r.id = rr.RESOURCE_ID and rr.ROLE_ID = :roleId";
		list = resourceDao.findBySql(sql, params, PbmsgResource.class);
		try {
			mapper.writeValue(w, list);
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
}
