package com.wugq.taotao.rest.service.impl;

import java.util.List;

import com.wugq.taotao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugq.taotao.manager.mapper.TbContentMapper;
import com.wugq.taotao.manager.pojo.TbContent;
import com.wugq.taotao.manager.pojo.TbContentExample;
import com.wugq.taotao.manager.pojo.TbContentExample.Criteria;


/**
 * 内容管理
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	
	@Override
	public List<TbContent> getContentList(long contentCid) {
		
		//根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		
		return list;
	}

}
