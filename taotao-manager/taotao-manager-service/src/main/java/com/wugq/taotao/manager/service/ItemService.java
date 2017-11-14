package com.wugq.taotao.manager.service;

import com.wugq.taotao.manager.pojo.EUDataGridResult;
import com.wugq.taotao.manager.pojo.TaotaoResult;
import com.wugq.taotao.manager.pojo.TbItem;

public interface ItemService {

    EUDataGridResult getItemList(int page, int rows);

    TaotaoResult createItem(TbItem item);
}