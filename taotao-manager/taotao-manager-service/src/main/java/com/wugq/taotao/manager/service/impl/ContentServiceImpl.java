package com.wugq.taotao.manager.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugq.taotao.common.pojo.TaotaoResult;
import com.wugq.taotao.manager.mapper.TbContentMapper;
import com.wugq.taotao.manager.pojo.TbContent;
import com.wugq.taotao.manager.service.ContentService;

/**
 * 内容管理
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper  contentMapper;

	@Override
	public TaotaoResult insertContent(TbContent content) {
		//补全pojo内容
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		
		//添加缓存同步逻辑
		return TaotaoResult.ok();
	}
}
