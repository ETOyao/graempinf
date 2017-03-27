package com.wanglei.graempinf_core.graempinf_core.model;

/**
 * 系统栏目树对象
 * @author Administrator
 *
 */
public class ChannelTree {
	
	private Integer id;
	private String name;
	private Integer pid;
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public ChannelTree() {
	}

	@Override
	public String toString() {
		return "ChannelTree [id=" + id + ", name=" + name + ", pid=" + pid + ", url=" + url + "]";
	}

	public ChannelTree(Integer id, String name, Integer pid, String url) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.url = url;
	}

	
	
}
