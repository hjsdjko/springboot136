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


import com.cl.dao.RongyuxinxiDao;
import com.cl.entity.RongyuxinxiEntity;
import com.cl.service.RongyuxinxiService;
import com.cl.entity.view.RongyuxinxiView;

@Service("rongyuxinxiService")
public class RongyuxinxiServiceImpl extends ServiceImpl<RongyuxinxiDao, RongyuxinxiEntity> implements RongyuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RongyuxinxiEntity> page = this.selectPage(
                new Query<RongyuxinxiEntity>(params).getPage(),
                new EntityWrapper<RongyuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RongyuxinxiEntity> wrapper) {
		  Page<RongyuxinxiView> page =new Query<RongyuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RongyuxinxiView> selectListView(Wrapper<RongyuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RongyuxinxiView selectView(Wrapper<RongyuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
