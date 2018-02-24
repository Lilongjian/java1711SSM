package com.situ.ssm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.ssm.dao.BanjiDao;
import com.situ.ssm.entity.Banji;
import com.situ.ssm.entity.BanjiSearchCondition;
import com.situ.ssm.entity.Student;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.vo.PageBean;
@Service
public class BanjiServiceImpl implements IBanjiService {
	@Autowired
	private BanjiDao banjiDao;
	
	
	@Override
	public List<Banji> findAll() {
		return banjiDao.findAll();
	}



	@Override
	public PageBean<Banji> searchByCondition(BanjiSearchCondition condition) {
		PageBean<Banji> pageBean = new PageBean<>();
		pageBean.setPageNo(condition.getPageNo());
		pageBean.setPageSzie(condition.getPageSize());
		int totalCount = banjiDao.getTotalCountByCondition(condition);
		System.out.println("总记录数" + totalCount);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil((double)totalCount/condition.getPageSize());
		System.out.println("总页数" + totalPage);
		pageBean.setTotalPage(totalPage);
		int offset = (condition.getPageNo()-1)*(condition.getPageSize());
		List<Banji> banjis =  banjiDao.findPageBeanListByCondition(condition,offset);
		pageBean.setList(banjis);
		for (Banji banji : banjis) {
			System.out.println(banji);
		}
		return pageBean;
	}

}
