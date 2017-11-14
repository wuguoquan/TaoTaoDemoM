package com.wugq.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wugq.taotao.manager.mapper.TbItemMapper;
import com.wugq.taotao.manager.pojo.EUDataGridResult;
import com.wugq.taotao.manager.pojo.TaotaoResult;
import com.wugq.taotao.manager.pojo.TbItem;
import com.wugq.taotao.manager.pojo.TbItemExample;
import com.wugq.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //查询商品列表
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult createItem(TbItem item) {
        //item补全
        //生成商品ID
        Long itemId = genItemId();
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除',
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入到数据库
        itemMapper.insert(item);
        return TaotaoResult.ok();
    }

    /**
     * 商品id生成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
}