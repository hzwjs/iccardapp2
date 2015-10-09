package com.iccardapp.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iccardapp.dao.service.IBaseDao;
import com.iccardapp.entity.Operators;
import com.iccardapp.service.ILoginService;

/**
 * @author huangzhiwen 登录验证
 */
@Service
@Transactional
public class LoginSysImpl implements ILoginService {
	
	
	@Autowired
	private IBaseDao<Operators> baseDao;
	
	/*BaseDaoImpl baseDaoImpl = new BaseDaoImpl();*/

	@Transactional(readOnly = true)
	public Operators login(Operators operators) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operator", operators.getOperator());
		params.put("pwd", operators.getPwd());
		// operator在Oracle数据库总为char(10)类型，在位数不足是会自动以空格补齐。RTRIM函数可以去除空格。
		String hql = "from Operators t where RTRIM(t.operator) = :operator and t.pwd = :pwd";
		Operators operator = baseDao.get(hql, params); 
		return operator;
	}

}
