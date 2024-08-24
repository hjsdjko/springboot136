package com.cl.dao;

import com.cl.entity.ZhengshuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhengshuxinxiView;


/**
 * 证书信息
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface ZhengshuxinxiDao extends BaseMapper<ZhengshuxinxiEntity> {
	
	List<ZhengshuxinxiView> selectListView(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);

	List<ZhengshuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
	
	ZhengshuxinxiView selectView(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
	

}
