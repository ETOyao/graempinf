package com.wanglei.graempinf_core.graempinf_core;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.wanglei.basic.util.SecurityUtil;
import com.wanglei.graempinf_core.graempinf_core.Enum.RoleType;
import com.wanglei.graempinf_core.graempinf_core.dao.IGroupDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IRoleDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IUserDao;
import com.wanglei.graempinf_core.graempinf_core.model.Group;
import com.wanglei.graempinf_core.graempinf_core.model.Role;
import com.wanglei.graempinf_core.graempinf_core.model.User;
import com.wanglei.graempinf_core.graempinf_core.model.UserGroup;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
@SuppressWarnings("unused")
public class UserRoleGroupTest {
	 @Inject
	private SessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));

       }
	@After
	public void tearDown() throws Exception {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
	} 
	@Inject
	private IUserDao userDao;

	@Inject
	private IRoleDao roleDao;
	@Inject
	private IGroupDao groupDao;
	@Test
	public void testAdd(){
		Timestamp t = new Timestamp(new Date().getTime());
		User u = new User();
		u.setCreateDate(t);
		u.setUserEmail("admin@qq.com");
		u.setUserName("admin");
		u.setUserNickName("管理员");
		try {
			u.setUserPassWord(SecurityUtil.md5(u.getUserName(),"1"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u.setUserPhone("123456920");
		u.setUserStatus(0);
		userDao.add(u);
		Group g = new Group();
		g.setGroupCode(1);
		g.setGroupDesc("财务处");
		g.setGroupName("财务处");
		g.setParentGroupCode(1);
		groupDao.add(g);
		//g.setGruopUuid("4028b88159c1d4a80159c1d4aa6e0001");
		Role role = new Role();
//		role.setRoleCode(1);
//		role.setRoleDesc("管理员");
//		role.setRoleName("管理员");
//		role.setRoleType(RoleType.ROLE_ADMIN);
//		roleDao.add(role);
		role.setRoleUuid("402881e65a98aa04015a98aa0bf20000");
		UserGroup ug = new UserGroup();
		ug.setGroup(g);
		ug.setUser(u);
		userDao.adduserGroup(u, g);
	userDao.addUserRole(u, role);
		
	}
	public void testLoad(){
      	System.out.println("1"+userDao.findUser());
//		System.out.println("2"+userDao.listUserRoleIdS("4028b88159c1d4a80159c1d4aa640000"));
		//System.out.println("3"+userDao.listUserGroups("4028b88159c1d4a80159c1d4aa640000"));
//		System.out.println("4"+userDao.listuserGroupIdS("4028b88159c1d1b10159c1d1b3290000"));
		//System.out.println("5"+userDao.loadUserRole("4028b88159c1d4a80159c1d4aa640000", "4028b88159c1d4a80159c1d4aa6f0002"));
		//System.out.println("6"+userDao.loadUserGroup("4028b88159c1d4a80159c1d4aa640000", "4028b88159c1d4a80159c1d4aa6e0001"));
//		System.out.println("7"+userDao.loadByUserName("admin"));
//		System.out.println("8"+userDao.listRoleUsers(RoleType.ROLE_ADMIN));
//		System.out.println("9"+userDao.listRoleUsers("4028b88159c1d4a80159c1d4aa6e0001"));
//		System.out.println("10"+userDao.listGroupUsers("4028b88159c1d4a80159c1d4aa6e0001"));
	}
	
	public void deleteUserRoel(){
		userDao.deleteUserGroup("4028b88159c1d4a80159c1d4aa640000");
		userDao.deleteUserRole("4028b88159c1d4a80159c1d4aa640000");
	}
}
