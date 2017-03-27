package com.wanglei.graempinf_core.graempinf_core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wanglei.basic.hibernate.dao.BaseDao;
import com.wanglei.basic.hibernate.model.Pager;
import com.wanglei.basic.util.BasicSysKit;
import com.wanglei.graempinf_core.graempinf_core.model.Org;
import com.wanglei.graempinf_core.graempinf_core.model.SelectUtils;
@Repository("orgDao")
public class OrgDao extends BaseDao<Org> implements IOrgDao{

	@Override
	public Pager<Org> findByParent(Integer pid, Integer typeId) {
		String hql = "select org from Org org where";
		if(pid==null) {
			hql+=" org.parent is null";
		} else {
			hql+=" org.parent.id="+pid;
		}
		if(typeId!=null&&typeId>0) {
			hql+=" and org.typeId="+typeId;
		}
		hql+=" order by org.orderNum";
		return super.findByhql(hql);
	}
	public static void initTreeNode(List<Tree> cts) {
		cts.add(0,new Tree(Org.ROOT_ID,Org.ROOT_NAME,-1));
		for(Tree ct:cts) {
			if(ct.getPid()==null)ct.setPid(0);
		}
	}
	@Override
	public List<Tree> tree() {
		String sql = "select id,name,pid from t_org";
		List<Tree> tds = super.listBysql(sql, Tree.class, false);
		initTreeNode(tds);
		return tds;
	}

	@Override
	public int loadNumByType(Integer pid, int typeId) {
		String hql = "select count(*) from Org where typeId=?";
		if(pid==null) {
			hql+=" and parent is null";
		} else {
			hql+=" and parent.id="+pid;
		}
		return ((Long)(super.queryObjectByHqlWithParam(hql, typeId))).intValue();
	}

	

	@Override
	public List<Integer> listAllChildIdsByOrg(int id) {
		List<Integer> orgIds = new ArrayList<Integer>();
		orgIds = listChildIdsByOrg(id);
	   return orgIds;
	}

	@Override
	public List<Integer> listChildIdsByOrg(int id) {
		/*
		 * 获取某个组织机构下面的所有组织的子节点，通常使用的是递归，使用递归会反复的查询数据库，效率不高
		 * 可以考虑使用map来替代反复查询数据库的递归操作。
		 */
		//1、取出所有的数据
		List<Org> orgs = listAllOrg();
		//2、格式化为一个map
		Map<Integer,List<Org>> corgs = org2map(orgs);
		//3、通过map来获取所有的子节点数据
		List<Org> rorgs = new ArrayList<Org>();
		rorgs.add(this.load(id));
		getOrgByMap(corgs,id,rorgs);
		List<Integer> orgIds = orgs2OrgIds(rorgs);
		return orgIds;
	}
	private void getOrgByMap(Map<Integer,List<Org>> orgs,int id,List<Org> corgs) {
		if(!orgs.containsKey(id)) return;
		List<Org> torgs = orgs.get(id);
		for(Org o:torgs) {
			corgs.add(o);
			//org的子节点中如果还是orgs的key，就说明该子节点中依然是某个父节点，此时就通过递归获取数据
			if(orgs.containsKey(o.getId())) {
				getOrgByMap(orgs,o.getId(),corgs);
			}
		}
	}
	private Map<Integer, List<Org>> org2map(List<Org> orgs) {
		Map<Integer,List<Org>> maps = new HashMap<Integer,List<Org>>();
		List<Org> os = null;
		for(Org o:orgs ) {
			if(o.getParent()==null) {
				os = new ArrayList<Org>();
				maps.put(o.getId(), os);
			} else {
				if(maps.containsKey(o.getParent().getId())) {
					maps.get(o.getParent().getId()).add(o);
				} else {
					os = new ArrayList<Org>();
					if(!os.contains(o))
						os.add(o);
					maps.put(o.getParent().getId(), os);
				}
			}
		}
		return maps;
	}
	private List<Integer> orgs2OrgIds(List<Org> orgs) {
		List<Integer> orgIds = new ArrayList<Integer>();
		for(Org to:orgs) {
			orgIds.add(to.getId());
		}
		return orgIds;
	}
	private List<Org> listAllOrg() {
		String hql = "select org from Org org left join fetch org.parent order by org.id";
		List<Org> orgs = super.listByhql(hql);
		return orgs;
	}
	@Override
	public List<Org> listAllChildByOrg(int id) {
		List<Org> orgs = new ArrayList<Org>();
		orgs = listChildByOrg(id);
		return orgs;
     }

	@Override
	public List<Org> listChildByOrg(int id) {
		/*
		 * 获取某个组织机构下面的所有组织的子节点，通常使用的是递归，使用递归会反复的查询数据库，效率不高
		 * 可以考虑使用map来替代反复查询数据库的递归操作。
		 */
		//1、取出所有的数据
		List<Org> orgs = listAllOrg();
		//2、格式化为一个map
		Map<Integer,List<Org>> corgs = org2map(orgs);
		//3、通过map来获取所有的子节点数据
		List<Org> rorgs = new ArrayList<Org>();
		rorgs.add(this.load(id));
		getOrgByMap(corgs,id,rorgs);
		return rorgs;	
	}

	@Override
	public List<Tree> listChildTreeByOrg(int id) {
		List<Org> orgs = listChildByOrg(id);
		return orgs2Trees(orgs);
	}
	private List<Tree> orgs2Trees(List<Org> orgs) {
		List<Tree> tds = new ArrayList<Tree>();
		Tree td = null;
		for(Org org:orgs) {
			if(!BasicSysKit.isEmpty(org.getParent())) {
				td = new Tree(org.getId(), org.getName(),org.getParent().getId());
			} else {
				td = new Tree(org.getId(),org.getName(),-1);
			}
			tds.add(td);
		}
		return tds;
	}
	@Override
	public List<Tree> listAllChildTreeByOrg(int id) {
		List<Tree> tds = new ArrayList<Tree>();
		tds = listChildTreeByOrg(id);
		return tds;
	}

	@Override
	public List<Tree> listChildTreeByOrgs(List<Integer> ids) {
		List<Org> orgs = this.listChildOrgByIds(ids);
		return orgs2Trees(orgs);
	}

	@Override
	public List<Tree> listParentTreeByOrgType(String sn) {
		String hql = "select org from Org org,OrgType ot,OrgTypeRule otr where ot.sn=? and ot.id=otr.cid and otr.pid=org.typeId";
		List<Org> orgs= super.listByhqlWithParam(hql, sn);
		return orgs2Trees(orgs);
	}
	/**
	 * 通过几个ids获取相应的组织机构的节点
	 * @param ids
	 * @return
	 */
	private List<Org> listChildOrgByIds(List<Integer> ids) {
		List<Org> orgs = listAllOrg();
		Map<Integer,List<Org>> corgs = org2map(orgs);
		List<Org> rorgs = new ArrayList<Org>();
		for(Integer id:ids) {
			rorgs.add(this.load(id));
			getOrgByMap(corgs,id,rorgs);
		}
		return rorgs;
	}
	@Override
	public int getMaxOrder(Integer pid) {
		return super.getMaxOrder(pid, "Org");
	}

	@Override
	public int getOrgNumsByType(int typeId) {
		String hql = "select count(*) from Org org where org.typeId=?";
		Long c = (Long)super.queryObjectByHqlWithParam(hql, typeId);
		return c.intValue();
	}


	@Override
	public List<Org> listPersonOrg(int pid) {
		String hql = "select new Org(org.id,org.name) from Org org,PersonOrgPos pop " +
				"where org.id=pop.orgId and pop.personId=?";
		return super.listByhqlWithParam(hql, pid);
	}

	@Override
	public List<Org> listChilds(int pid) {
		String hql = "select org from Org org where pid =?";
		return this.listByhqlWithParam(hql, pid);
	}
	@Override
	public List<SelectUtils> createOrForSelect(Integer id,Integer typeId) {
		String sql = "select name,id FROM t_org where pid is not null";
		if(id!=null && id>0){
			sql +=" and pid ="+id;
		}
		if(id!=null){
			sql +=" and typeId ="+typeId;
		}
		return this.listBysql(sql, SelectUtils.class, false);
	}
	@Override
	public Org getOrgNameById(Integer id) {
		String hql = "select new Org (org.name ,org.orgCode)FROM Org org where org.id="+id;
		List<Org> os = listByhql(hql);
		if(os!=null & os.size()>0){
			return listByhql(hql).get(0);
		}
		return null;
	}
	
}
