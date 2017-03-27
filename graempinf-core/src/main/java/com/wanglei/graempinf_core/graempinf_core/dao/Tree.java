package com.wanglei.graempinf_core.graempinf_core.dao;

public class Tree {
	private int id;
	private String name;
	private Integer pid;
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tree(int id, String name, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	public Tree() {
		super();
	}
	@Override
	public String toString() {
		return "Tree [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Tree td = (Tree)obj;
		return td.getId()==this.id;
	}
}
