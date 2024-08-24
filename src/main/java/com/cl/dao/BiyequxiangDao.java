package com.cl.dao;

import com.cl.entity.BiyequxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BiyequxiangView;


/**
 * 毕业去向
 * 
 * @author 
 * @email 
 * @date 2024-03-20 12:00:33
 */
public interface BiyequxiangDao extends BaseMapper<BiyequxiangEntity> {
	
	List<BiyequxiangView> selectListView(@Param("ew") Wrapper<BiyequxiangEntity> wrapper);

	List<BiyequxiangView> selectListView(Pagination page,@Param("ew") Wrapper<BiyequxiangEntity> wrapper);
	
	BiyequxiangView selectView(@Param("ew") Wrapper<BiyequxiangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BiyequxiangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BiyequxiangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BiyequxiangEntity> wrapper);



}
