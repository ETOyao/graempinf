package com.wanglei.graempinf.dwr;

import javax.servlet.http.HttpSession;

public interface IDwrService {
	/**
	 * 添加GroupChannel对象
	 * @param group
	 * @param channel
	 */
	public void addGroupChannel(String gid,int cid,HttpSession session);
	
	/**
	 * 删除用户栏目
	 * @param gid
	 * @param cid
	 */
	public void deleteGroupChannel(String gid,int cid,HttpSession session);
}
