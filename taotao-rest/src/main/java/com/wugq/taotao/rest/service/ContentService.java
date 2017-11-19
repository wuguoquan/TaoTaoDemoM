package com.wugq.taotao.rest.service;

import java.util.List;

import com.wugq.taotao.manager.pojo.TbContent;

public interface ContentService {

	List<TbContent> getContentList(long contentCid);
}
