package com.wanglei.graempinf.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.wanglei.basic.hibernate.model.SystemContext;
import com.wanglei.basic.util.StringUtils;

public class SystemContextFilter implements Filter {
	private Integer pageSize ;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Integer offset = 0;
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
		}
		try {
			SystemContext .setOrder(req.getParameter("pager.order"));
			SystemContext.setPageOffset(offset);
			String _pageSize = req.getParameter("pageSize");
			String pager_pageSize = req.getParameter("size");
			if(StringUtils.isNotNull(_pageSize)){
				pager_pageSize =_pageSize;
			}if(StringUtils.isNotNull(pager_pageSize)){
				SystemContext.setPageSize(Integer.parseInt(pager_pageSize));
			}else{
				SystemContext.setPageSize(pageSize);
			} 
			SystemContext.setSort(req.getParameter("sort"));
			chain.doFilter(req, res);
		} finally{
			SystemContext.removeOrder();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeSort();
			
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 10;
		}
	}

}
