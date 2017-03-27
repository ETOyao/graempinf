package com.wanglei;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.easymock.EasyMock.*;

import com.wanglei.graempinf.service.IUserService;
import com.wanglei.graempinf.service.UserService;
import com.wanglei.graempinf_core.graempinf_core.dao.IGroupDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IRoleDao;
import com.wanglei.graempinf_core.graempinf_core.dao.IUserDao;
import com.wanglei.graempinf_core.graempinf_core.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestUserService {
	@Inject
	private IUserService uservice ;
	@Inject
	private IRoleDao roleDao;
	@Inject
	private IUserDao userDao;
	@Inject
	private IGroupDao groupDao;
	
	public void testDelete(){
		reset(userDao);
		String uid ="4028b88159c1d4a80159c1d4aa640000";
		userDao.deleteUserRole(uid);
		expectLastCall();
		userDao.deleteUserGroup(uid);
		expectLastCall();
		userDao.delete(uid);
		expectLastCall();
		replay(userDao);
		uservice.delete(uid);
	}
	
	public void testupdateStatus(){
		reset(userDao);
		Timestamp t = new Timestamp(new Date().getTime());
		String uid ="4028b88159c1d4a80159c1d4aa640000";
		User u = new User();
		u.setCreateDate(t);
		u.setUserEmail("admin@qq.com");
		u.setUserName("admin");
		u.setUserNickName("管理员");
		u.setUserPassWord("1");
		u.setUserPhone("123456920");
		u.setUserStatus(0);
		expect(userDao.load(uid)).andReturn(u);
		userDao.update(u);
		expectLastCall();
		replay(userDao);
		uservice.updateStatus(uid);
		Assert.assertEquals(u.getUserStatus(), 1);
		verify(userDao);
	}
	@Test
	public void testAdd(){
		String []rids = {"402881e65a98aa04015a98aa0bf20000"};
		String []gids = {"402881e65a98ac79015a98ac7b4300012"};
		Timestamp t = new Timestamp(new Date().getTime());
		User u = new User();
		u.setCreateDate(t);
		u.setUserEmail("admin@qq.com");
		u.setUserName("admin");
		u.setUserNickName("管理员");
		u.setUserPassWord("1");
		u.setUserPhone("123456920");
		u.setUserStatus(0);
		uservice.add(u, rids, gids);
	}
	
}
