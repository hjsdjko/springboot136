package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShenzaoxinxiDao;
import com.cl.entity.ShenzaoxinxiEntity;
import com.cl.service.ShenzaoxinxiService;
import com.cl.entity.view.ShenzaoxinxiView;

@Service("shenzaoxinxiService")
public class ShenzaoxinxiServiceImpl extends ServiceImpl<ShenzaoxinxiDao, ShenzaoxinxiEntity> implements ShenzaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenzaoxinxiEntity> page = this.selectPage(
                new Query<ShenzaoxinxiEntity>(params).getPage(),
                new EntityWrapper<ShenzaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenzaoxinxiEntity> wrapper) {
		  Page<ShenzaoxinxiView> page =new Query<ShenzaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShenzaoxinxiView> selectListView(Wrapper<ShenzaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenzaoxinxiView selectView(Wrapper<ShenzaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
