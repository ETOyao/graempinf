package com.wanglei.basic.hibernate.dao;

import java.util.List;
import java.util.Map;

import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.hibernate.model.User;


public interface IUserDao extends IBaseDao<User> {

	List<User> listUserByhqlWithParams(String string, Object[] objects);

	List<User> listUserByhqlWithAliasAndParams(String string, Object[] objects, Map<String, Object> ails);

	Pager<User> findUserByhqlWithParams(String string, Object[] objects);

	Pager<User> findUserByHqlWithParamsAndalias(String string, Object[] objects, Map<String, Object> ails);

	List<User> listUserBysqlWithParams(String string, Object[] objects, Class<User> class1, boolean b);

	List<User> listUserBysqlWithParamsAndalias(String string, Object[] objects, Map<String, Object> ails, Class<User> class1, boolean b);

	Pager<User> findUserBysqlWithParams(String string, Object[] objects, Class<User> class1, boolean b);

	Pager<User> findUserBysqlWithParamsAndalias(String string, Object[] objects, Map<String, Object> ails, Class<User> class1, boolean b);

}
