package com.situ.ssm.service;

import java.util.List;

import com.situ.ssm.entity.Banji;
import com.situ.ssm.entity.BanjiSearchCondition;
import com.situ.ssm.vo.PageBean;

public interface IBanjiService {
	List<Banji> findAll();

	PageBean<Banji> searchByCondition(BanjiSearchCondition condition);
	

}
