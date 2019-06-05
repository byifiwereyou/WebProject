package com.osyunge.service;

import com.osyunge.mapper.TbItemMapper;
import com.osyunge.pojo.TbItem;
import com.osyunge.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements  ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem findItemInfoByItemId(Long id) {
        System.out.println("到这啦！！！！！ ");
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbItem> itemList=itemMapper.selectByExample(example);
        TbItem item=null;
        if(itemList.size()>0){
            item=itemList.get(0);
        }
        return item;
    }
}
