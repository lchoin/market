package com.jzf.market.service;
import com.jzf.market.dao.TbGoodsMapper;
import com.jzf.market.pojo.auto.TbGoods;
import com.jzf.market.pojo.auto.TbGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
@Transactional
@Service
public class TbGoodsService {
    @Autowired
    private TbGoodsMapper TbGoodsMapper;

    public int insert(TbGoods tbGoods) {
        tbGoods.setgCreateDate(new Date());
        tbGoods.setgUpdateDate(new Date());
        tbGoods.setgMonthSales(0L);
        return TbGoodsMapper.insertSelective(tbGoods);

    }

    public int updateById(TbGoods tbGoods) {
        tbGoods.setgUpdateDate(new Date());
        return TbGoodsMapper.updateByPrimaryKeySelective(tbGoods);
    }

    public List<TbGoods> selectAll() {
        TbGoodsExample tbGoodsExample = new TbGoodsExample();
        tbGoodsExample.setOrderByClause("g_create_date desc");
        List<TbGoods> tbGoodss = TbGoodsMapper.selectByExample(tbGoodsExample);
        if(tbGoodss == null){
            tbGoodss = new ArrayList<TbGoods>();
        }
        return tbGoodss;
    }

    public TbGoods selectById(Long gId) {
        return TbGoodsMapper.selectByPrimaryKey(gId);
    }


    public int deleteById(Long piId) {
        return TbGoodsMapper.deleteByPrimaryKey(piId);
    }
}
