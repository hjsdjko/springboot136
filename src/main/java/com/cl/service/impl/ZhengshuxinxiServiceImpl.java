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


import com.cl.dao.ZhengshuxinxiDao;
import com.cl.entity.ZhengshuxinxiEntity;
import com.cl.service.ZhengshuxinxiService;
import com.cl.entity.view.ZhengshuxinxiView;

@Service("zhengshuxinxiService")
public class ZhengshuxinxiServiceImpl extends ServiceImpl<ZhengshuxinxiDao, ZhengshuxinxiEntity> implements ZhengshuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhengshuxinxiEntity> page = this.selectPage(
                new Query<ZhengshuxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhengshuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhengshuxinxiEntity> wrapper) {
		  Page<ZhengshuxinxiView> page =new Query<ZhengshuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhengshuxinxiView> selectListView(Wrapper<ZhengshuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhengshuxinxiView selectView(Wrapper<ZhengshuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
