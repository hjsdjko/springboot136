package com.cl.dao;

import com.cl.entity.RongyuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RongyuxinxiView;


/**
 * 荣誉信息
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface RongyuxinxiDao extends BaseMapper<RongyuxinxiEntity> {
	
	List<RongyuxinxiView> selectListView(@Param("ew") Wrapper<RongyuxinxiEntity> wrapper);

	List<RongyuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<RongyuxinxiEntity> wrapper);
	
	RongyuxinxiView selectView(@Param("ew") Wrapper<RongyuxinxiEntity> wrapper);
	

}
