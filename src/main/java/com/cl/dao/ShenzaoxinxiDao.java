package com.cl.dao;

import com.cl.entity.ShenzaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenzaoxinxiView;


/**
 * 深造信息
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface ShenzaoxinxiDao extends BaseMapper<ShenzaoxinxiEntity> {
	
	List<ShenzaoxinxiView> selectListView(@Param("ew") Wrapper<ShenzaoxinxiEntity> wrapper);

	List<ShenzaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShenzaoxinxiEntity> wrapper);
	
	ShenzaoxinxiView selectView(@Param("ew") Wrapper<ShenzaoxinxiEntity> wrapper);
	

}
