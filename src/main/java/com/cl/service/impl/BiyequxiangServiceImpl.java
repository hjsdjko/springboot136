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


import com.cl.dao.BiyequxiangDao;
import com.cl.entity.BiyequxiangEntity;
import com.cl.service.BiyequxiangService;
import com.cl.entity.view.BiyequxiangView;

@Service("biyequxiangService")
public class BiyequxiangServiceImpl extends ServiceImpl<BiyequxiangDao, BiyequxiangEntity> implements BiyequxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BiyequxiangEntity> page = this.selectPage(
                new Query<BiyequxiangEntity>(params).getPage(),
                new EntityWrapper<BiyequxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BiyequxiangEntity> wrapper) {
		  Page<BiyequxiangView> page =new Query<BiyequxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BiyequxiangView> selectListView(Wrapper<BiyequxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BiyequxiangView selectView(Wrapper<BiyequxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<BiyequxiangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<BiyequxiangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<BiyequxiangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
