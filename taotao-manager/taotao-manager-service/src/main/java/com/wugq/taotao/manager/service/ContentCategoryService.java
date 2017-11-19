package com.wugq.taotao.manager.service;

import java.util.List;

import com.wugq.taotao.common.pojo.EUTreeNode;
import com.wugq.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
