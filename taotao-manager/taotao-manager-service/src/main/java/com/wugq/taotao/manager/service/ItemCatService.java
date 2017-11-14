package com.wugq.taotao.manager.service;

import java.util.List;

import com.wugq.taotao.common.pojo.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
